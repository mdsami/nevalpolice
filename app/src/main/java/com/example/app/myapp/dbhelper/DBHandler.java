package com.example.app.myapp.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "nevalpolice_db";

    private static final String CREATE_EMPLOYEE_INFO="employee_info";
    String[] credit_collection_table_Columns = {"_id","outlet_id","date","memo_no","memo_value","collect_date","inst_type","due_amount","paid_amount"};

    public DBHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //.................................All table create into this method...........................................
//        String CREATE_EMPLOYEE_INFO = "CREATE TABLE IF NOT EXISTS " + "employee_info" + "("
//                + "_id" + " INTEGER PRIMARY KEY," +
//                "name"+		" VARCHAR,"+
//                "age" + " INTEGER,"	+
//                "salary" + " INTEGER"	+
//                ")";
//        db.execSQL(CREATE_EMPLOYEE_INFO);








        String CREATE_USER_GEOLOCATION = "CREATE TABLE IF NOT EXISTS " + "geolocation" + "("
                + "_id" + " INTEGER PRIMARY KEY," +

                "ThanaName" + " VARCHAR,"	+
                "FariName"+		" VARCHAR,"+
                "Oc" + " VARCHAR,"	+
                "Phone" + " VARCHAR,"	+
                "lat" + " VARCHAR,"	+
                "long" + " VARCHAR"	+
                ")";
        db.execSQL(CREATE_USER_GEOLOCATION);















    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop all table
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_EMPLOYEE_INFO);
        // Create tables again
        onCreate(db);

    }


    public void deleteAllRow(String tableName)
    {
        SQLiteDatabase db1 = this.getReadableDatabase();
        db1.execSQL("DELETE FROM " + tableName);

        Log.e("DELETED:",tableName);
    }

    public void deleteRow(String tableName, String row)
    {
        SQLiteDatabase db1 = this.getReadableDatabase();
        db1.execSQL("DELETE  FROM " + tableName+" where gift_issue_id='"+row+"'");

        Log.e("DELETED:",tableName);
    }

    public void deleteRowOFDraft(String tableName, String row)
    {
        SQLiteDatabase db1 = this.getReadableDatabase();
        db1.execSQL("DELETE  FROM " + tableName+" where outlet_id='"+row+"'");

        Log.e("DELETED:",tableName);
    }

    public void deleteRowOFSession(String tableName, String row)
    {
        SQLiteDatabase db1 = this.getReadableDatabase();
        db1.execSQL("DELETE  FROM " + tableName+" where session_id='"+row+"'");

        Log.e("DELETED:",tableName);
    }

    public void InsertTable(HashMap<String, String> data, String TableName) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        ContentValues values = new ContentValues();

        Iterator it = data.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<String, String> pair = (Map.Entry)it.next();
            values.put(pair.getKey(), pair.getValue()); // Contact Name
            it.remove();
        }
        Log.e(" Content values  :",values.toString());
        Log.e(TableName,":"+"INSERTED");

        db.insert(TableName, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();

    }



    public void InsertTableArray (ArrayList<HashMap<String, String>> data, String TableName) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        int io=0;

        for (HashMap<String, String> hashMap : data) {
            io++;
            System.out.println(hashMap.keySet());
            ContentValues values = new ContentValues();
            Iterator it = hashMap.entrySet().iterator();
            while(it.hasNext())
            {
                Map.Entry<String, String> pair = (Map.Entry)it.next();
                values.put(pair.getKey(), pair.getValue());
                it.remove();
            }
            db.insert(TableName, null, values);
            Log.e(TableName,"   :"+"INSERTED :"+io);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();

    }

    public Cursor SelectTable(String query) {



        ArrayList<HashMap<String, String>> Data= new ArrayList<HashMap<String, String>>();


        SQLiteDatabase db = this.getReadableDatabase();


        Cursor c = db.rawQuery(query, null);

        if (c != null) {
            if (c.moveToFirst()) {
                do {

                    HashMap<String, String> map= new HashMap<String, String>();

                    for(int itertor=0;itertor<credit_collection_table_Columns.length;itertor++)
                    {
                        String column_value = c.getString(c.getColumnIndex(credit_collection_table_Columns[itertor]));

                        map.put(credit_collection_table_Columns[itertor], column_value);
                    }

                    Data.add(map);




                } while (c.moveToNext());
            }
        }



        return c;
    }


    public void excQuery(String query) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(query);

    }



    public Cursor rawQuery(String query) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);

//		db.close();
        return c;
    }



    public void update_table_with_id(String table_name, String table_id, String newID, String previousID)
    {		SQLiteDatabase db = this.getReadableDatabase();

        String queryUpdateTable="UPDATE "+table_name+" SET "+table_id+"='"+ newID + "'  WHERE "+ table_id +"='"+previousID+"'";
        db.execSQL(queryUpdateTable);
        Log.e("queryUpdateTable : "+table_name, queryUpdateTable);
    }



    public void UpdateTable(HashMap<String,String> map, String tableName, String updateCullumn, String UpdateCullumnValue)
    {
        String Query="UPDATE "+tableName+" SET ";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Query=Query+entry.getKey()+"= '"+entry.getValue()+"',";
        }
        Query=Query.substring(0,Query.length()-1)+" WHERE "+updateCullumn+"= "+UpdateCullumnValue;
        Log.e("Query", Query);
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(Query);

    }


    public void UpdateClaim(HashMap<String,String> map, String tableName, String updateCullumn, String UpdateCullumnValue)
    {
        String Query="UPDATE "+tableName+" SET ";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Query=Query+entry.getKey()+"= '"+entry.getValue()+"',";
        }
        Query=Query.substring(0,Query.length()-1)+" WHERE "+updateCullumn+"= '"+UpdateCullumnValue+"'";
        Log.e("Query", Query);
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(Query);

    }


    public void delete_table_with_id(String table_name, String table_id, String previousID)
    {			SQLiteDatabase db = this.getReadableDatabase();

        String queryDeleteTable="DELETE FROM "+table_name+"  WHERE "+ table_id +"='"+previousID+"'";
        db.execSQL(queryDeleteTable);
        Log.e("queryDelete : "+table_name, queryDeleteTable);
    }



    public void dropTable(String table_name)
    {

        SQLiteDatabase db = this.getReadableDatabase();
//		db =  this.openOrCreateDatabase("SMC_SALES_db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
//		db.setVersion(1);
//		db.setLocale(Locale.getDefault());
        db.execSQL("DROP TABLE IF EXISTS '" + table_name + "'");
    }




    public String GetUpdatedDate(String tableName, String tableFieldId)
    {
        String getDate = "";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM "+tableName+" ORDER BY "+tableFieldId+" DESC limit 1", null);
        if (c != null) {
            if (c.moveToFirst()) {
                do {

                    getDate = c.getString(c.getColumnIndex("updated_at"));
                } while (c.moveToNext());
            }
        }
        return getDate;
    }

    public String GetMemoNO(String memoNo)
    {
        String memo_no = "";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM memos where memo_no='"+memoNo+"'", null);
        if (c != null) {
            if (c.moveToFirst()) {
                do {

                    memo_no = c.getString(c.getColumnIndex("memo_no"));
                } while (c.moveToNext());
            }
        }
        return memo_no;
    }



    public boolean checkDuplicate(String tableName, String culumnName, String culumnValue)
    {
        String getDate = "";
        SQLiteDatabase db = this.getReadableDatabase();
        if(tableName.equalsIgnoreCase("sales_targets"))
            Log.e("Duplicate Check Query","SELECT * FROM "+tableName+" WHERE "+culumnName+"= '"+culumnValue+"'");

        Cursor c = db.rawQuery("SELECT * FROM "+tableName+" WHERE "+culumnName+"= '"+culumnValue+"'", null);
        if(c.getCount()>0)
            return true;
        else
            return false;
    }


    public boolean checkDuplicateForBonus(String tableName, String product_id, String outlet_id, String bonus_party_id)
    {
        String getDate = "";
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor c = db.rawQuery("SELECT * FROM "+tableName+" WHERE product_id='"+product_id+"' and outlet_id='"+outlet_id+"' and bonus_party_id='"+bonus_party_id+"'", null);
        if(c.getCount()>0)
            return true;
        else
            return false;
    }


    public void UpdateForBonus(HashMap<String,String> map, String tableName, String product_id, String outlet_id, String bonus_party_id)
    {

        String Query="UPDATE "+tableName+" SET ";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Query=Query+entry.getKey()+"= '"+entry.getValue()+"',";
        }
        Query=Query.substring(0,Query.length()-1)+" WHERE product_id='"+product_id+"' and outlet_id='"+outlet_id+"' and bonus_party_id='"+bonus_party_id+"'";
        Log.e("Query", Query);
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(Query);


    }



    public String checkDuplicateForTarget(String tableName, String culumnName, String culumnValue)
    {
        String GetValue = "";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM "+tableName+" WHERE "+culumnName+"= '"+culumnValue+"'", null);
        if (c != null) {
            if (c.moveToFirst()) {
                do {

                    GetValue = c.getString(c.getColumnIndex("culumnName"));
                } while (c.moveToNext());
            }
        }
        return GetValue;
    }


    public ArrayList<HashMap<String, String>> AllDataFromTable(String table_name)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from "+table_name,null);
        ArrayList<HashMap<String, String>> Data= new ArrayList<HashMap<String, String>>();

        try {

            if (cursor.moveToFirst()) {
                do {
                    HashMap<String, String> map= new HashMap<String, String>();
                    if(table_name.equalsIgnoreCase("doctor_table"))
                    {
                        map.put("id", cursor.getString(1));
                        map.put("name", cursor.getString(2));
                        map.put("type", cursor.getString(3));
                    }

                    if(table_name.equalsIgnoreCase("bank_banch"))
                    {
                        map.put("id", cursor.getString(2));
                        map.put("name", cursor.getString(3));
                    }

                    if(table_name.equalsIgnoreCase("instrument_type"))
                    {
                        map.put("id", cursor.getString(1));
                        map.put("name", cursor.getString(2));
                    }

                    if(table_name.equalsIgnoreCase("instrument_no"))
                    {
                        map.put("id", cursor.getString(1));
                        map.put("name", cursor.getString(2));
                    }
                    if(table_name.equalsIgnoreCase("sales_weeks"))
                    {
                        map.put("id", cursor.getString(1));
                        map.put("name", cursor.getString(2));
                    }



                    Data.add(map);
                } while (cursor.moveToNext());
            }

        } finally {
            try { cursor.close(); } catch (Exception ignore) {}
        }



        return Data;

    }





}
