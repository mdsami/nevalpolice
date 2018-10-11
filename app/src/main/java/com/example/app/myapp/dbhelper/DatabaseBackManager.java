package com.example.app.myapp.dbhelper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by mdsami on 10/11/2018.
 */

public class DatabaseBackManager {
    public static void setBackUp(Context context){
        try {
            // File sd = Environment.getDataDirectory();
            File data = Environment.getDataDirectory();
            //File file = new File(context.getFilesDir(), filename);
//		    if (sd.mkdirs()) {
            String currentDBPath = "//data//"+ context.getPackageName() +"//databases//"+"suchana_db";
            String backupDBPath = "suchana_db";
            File currentDB = new File(data, currentDBPath);
            File backupDB = new File(context.getCacheDir().getPath(), backupDBPath);

            FileChannel src = new FileInputStream(currentDB).getChannel();
            FileChannel dst = new FileOutputStream(backupDB).getChannel();
            dst.transferFrom(src, 0, src.size());
            src.close();
            dst.close();
            // Toast.makeText(context, backupDB.getAbsolutePath().toString(), Toast.LENGTH_LONG).show();
            setEmail( backupDB,context);
//		    }
        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public static void setEmail(File backupDB, Context context){

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);



        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"mdsami.diu@gmail.com","f.ssssss@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Suchana backup database");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "User Name : "+prefs.getString("UserName", "NO PREFERENCE"));

        emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://" + CachedFileProvider.AUTHORITY + "/" + "suchana_db"));
        emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        context.startActivity(Intent.createChooser(emailIntent, "Pick an Email provider"));
    }



}
