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


        String CREATE_TRACKING_SERVICE = "CREATE TABLE IF NOT EXISTS " + "tracking_service_info" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "ben_id"+		" INTEGER,"+
                "trainingName" + " VARCHAR,"	+
                "training_no"+		" INTEGER,"+
                "date" + " VARCHAR,"	+
                "type" + " INTEGER,"	+
                "other" + " VARCHAR,"	+
                "receiver" + " INTEGER,"	+
                "comment" + " VARCHAR,"	+
                "measure" + " VARCHAR,"	+
                "status" + " VARCHAR,"	+
                "status_no" + " INTEGER,"	+

                "active" + " INTEGER"	+

                ")";
        db.execSQL(CREATE_TRACKING_SERVICE);

        String CREATE_TRACKING_SURVEY = "CREATE TABLE IF NOT EXISTS " + "TRACKING_SURVEY" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "ben_id"+		" VARCHAR,"+
                "trk_name" + " VARCHAR,"	+
                "trk_type" + " VARCHAR,"	+
                "trk_date" + " VARCHAR,"	+
                "discount_date" + " VARCHAR,"	+
                "dropout_4" + " VARCHAR,"	+
                "dropout_99" + " VARCHAR,"	+
                "bencondition_other" + " VARCHAR,"	+
                "status" + " VARCHAR,"	+
                "status_no" + " VARCHAR,"	+

                "active" + " INTEGER"	+

                ")";
        db.execSQL(CREATE_TRACKING_SURVEY);

        String CREATE_USER_INFO = "CREATE TABLE IF NOT EXISTS " + "user_info" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "Id"+		" VARCHAR,"+
                "UserID" + " VARCHAR,"	+
                "Email"+		" VARCHAR,"+
                "UserName" + " VARCHAR,"	+
                "Organization" + " VARCHAR,"	+
                "FullName" + " VARCHAR,"	+
                "Designation" + " VARCHAR,"	+
                "OldPassword" + " VARCHAR,"	+
                "PhoneNumber" + " VARCHAR"	+

                ")";
        db.execSQL(CREATE_USER_INFO);

        String CREATE_USER_GEOLOCATION = "CREATE TABLE IF NOT EXISTS " + "geolocation" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "UserID"+		" VARCHAR,"+
                "BenID" + " VARCHAR,"	+
                "BenNameEn"+		" VARCHAR,"+
                "BenNameBn" + " VARCHAR,"	+
                "DivisionCode" + " VARCHAR,"	+
                "DivisionName" + " VARCHAR,"	+
                "DivisionNameBangla" + " VARCHAR,"	+
                "DistrictCode" + " VARCHAR,"	+
                "DistrictName" + " VARCHAR,"	+
                "DistrictNameBangla" + " VARCHAR,"	+
                "UpazilaCode" + " VARCHAR,"	+
                "UpazilaName" + " VARCHAR,"	+
                "UpazilaNameBangla" + " VARCHAR,"	+
                "UnionCode" + " VARCHAR,"	+
                "UnionName" + " VARCHAR,"	+
                "UnionNameBangla" + " VARCHAR,"	+
                "VillageCode" + " VARCHAR,"	+
                "VillageName" + " VARCHAR,"	+
                "VillageNameBangla" + " VARCHAR,"	+
                "HusName" + " VARCHAR,"	+
                "FatName" + " VARCHAR"	+
                ")";
        db.execSQL(CREATE_USER_GEOLOCATION);


        String Create_UserGeoLocation = "CREATE TABLE IF NOT EXISTS " + "UserGeoLocation" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "ID"+		" VARCHAR,"+
                "UserID"+		" VARCHAR,"+
                "DivisionCode"+		" VARCHAR,"+
                "DistrictCode"+		" VARCHAR,"+
                "UpazilaCode" + " VARCHAR,"	+
                "UnionCode"+ " VARCHAR,"+
                "VillageCode"+ " VARCHAR"+
                ")";
        db.execSQL(Create_UserGeoLocation);

        String Create_IPGeolocation = "CREATE TABLE IF NOT EXISTS " + "IPGeolocation" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "ID"+		" VARCHAR,"+
                "IPCode"+		" VARCHAR,"+
                "IPName"+		" VARCHAR,"+
                "DistrictCode"+		" VARCHAR,"+
                "UpazilaCode" + " VARCHAR"	+
                ")";
        db.execSQL(Create_IPGeolocation);

        String Create_UserTrackingRegister = "CREATE TABLE IF NOT EXISTS " + "UserTrackingRegister" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "ben_id"+		" VARCHAR,"+
                "ben_name"+		" VARCHAR,"+
                "ben_type_code"+		" VARCHAR,"+
                "nutration_code"+		" VARCHAR,"+
                "sub_group_code"+		" VARCHAR,"+
                "sub_group_other"+		" VARCHAR,"+
                "suchana_year_code" + " VARCHAR,"	+
                "tr_reg_date"+ " VARCHAR,"+
//                "smc_visit_date"+ " VARCHAR,"+
//                "ben_condition_date"+ " VARCHAR,"+
//                "ben_condition"+ " VARCHAR,"+
//                "ben_condition_other"+ " VARCHAR,"+
//                "vmf_dp_date"+ " VARCHAR,"+
//                "vmf_dp"+ " VARCHAR,"+
//                "vmf_dp_discontinue_date"+ " VARCHAR,"+
//                "skip_suchana_date"+ " VARCHAR,"+
//                "skip_suchana_value"+ " VARCHAR,"+
//                "skip_suchana_other"+ " VARCHAR,"+
//                "skip_suchana_not_present"+ " VARCHAR,"+
                "date"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_UserTrackingRegister);

        String Create_Monitoring104 = "CREATE TABLE IF NOT EXISTS " + "monitoring104" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "ques_no"+		" INTEGER,"+
                "value"+		" VARCHAR,"+
                "comment"+		" VARCHAR,"+
                "date"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_Monitoring104);


        String Create_Monitoring104_UnStructured = "CREATE TABLE IF NOT EXISTS " + "monitoring104_unstructured" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "ques_no"+		" INTEGER,"+
                "value"+		" VARCHAR,"+
                "comment"+		" VARCHAR,"+
                "date"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_Monitoring104_UnStructured);


        String Create_Monitoring104_Master = "CREATE TABLE IF NOT EXISTS " + "monitoring104_master" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "oname"+		" VARCHAR,"+
                "odesig"+		" VARCHAR,"+
                "odate"+		" VARCHAR,"+
                "ben_id"+ " VARCHAR,"+
                "bentype"+ " VARCHAR,"+
                "org"+ " VARCHAR,"+
                "date"+		" VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER,"	+
                "obserorg"+ " VARCHAR"+
                ")";
        db.execSQL(Create_Monitoring104_Master);


        String Create_Monitoring101 = "CREATE TABLE IF NOT EXISTS " + "monitoring101" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "ques_no"+		" VARCHAR,"+
                "value"+		" VARCHAR,"+
                "comment"+		" VARCHAR,"+
                "date"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_Monitoring101);


        String Create_Monitoring101_UnStructured = "CREATE TABLE IF NOT EXISTS " + "monitoring101_unstructured" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "ques_no"+		" INTEGER,"+
                "value"+		" VARCHAR,"+
                "comment"+		" VARCHAR,"+
                "date"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_Monitoring101_UnStructured);

        String Create_Monitoring101_Master = "CREATE TABLE IF NOT EXISTS " + "monitoring101_master" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "sub_name"+	" VARCHAR,"+
                "sub_no"+" VARCHAR,"+
                "session_name"+" VARCHAR,"+
                "session_desig"+" VARCHAR,"+
                "odate"+" VARCHAR,"+
                "oname"+" VARCHAR,"+
                "odesig"+" VARCHAR,"+
                "home_owner_name"+ " VARCHAR,"+
                "zila"+" VARCHAR,"+
                "upozila"+" VARCHAR,"+
                "unions"+" VARCHAR,"+
                "village"+ " VARCHAR,"+
                "session_no"+ " VARCHAR,"+
                "discuss_topic"+" VARCHAR,"+
                "session_start_date"+" VARCHAR,"+
                "org"+		" VARCHAR,"+ //16
                "date"+		" VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER,"	+
                "obserorg"+ " VARCHAR"+
                ")";
        db.execSQL(Create_Monitoring101_Master);


        String Create_Monitoring112 = "CREATE TABLE IF NOT EXISTS " + "monitoring112" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "ques_no"+		" INTEGER,"+
                "value"+		" VARCHAR,"+
                "comment"+		" VARCHAR,"+
                "date"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_Monitoring112);



        String Create_Monitoring112_UnStructured = "CREATE TABLE IF NOT EXISTS " + "monitoring112_unstructured" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "ques_no"+		" INTEGER,"+
                "value"+		" VARCHAR,"+
                "comment"+		" VARCHAR,"+
                "date"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_Monitoring112_UnStructured);


        String Create_Monitoring112_Master = "CREATE TABLE IF NOT EXISTS " + "monitoring112_master" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "oname"+		" VARCHAR,"+
                "odesig"+		" VARCHAR,"+
                "odate"+		" VARCHAR,"+
                "ben_id"+ " VARCHAR,"+
                "bentype"+ " VARCHAR,"+
                "org"+ " VARCHAR,"+
                "date"+		" VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER,"	+
                "obserorg"+ " VARCHAR"+
                ")";
        db.execSQL(Create_Monitoring112_Master);


        String Create_Monitoring105 = "CREATE TABLE IF NOT EXISTS " + "monitoring105" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "ques_no"+		" INTEGER,"+
                "value"+		" VARCHAR,"+
                "comment"+		" VARCHAR,"+
                "date"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_Monitoring105);

        String Create_Monitoring105_UnStructured = "CREATE TABLE IF NOT EXISTS " + "monitoring105_unstructured" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "ques_no"+		" INTEGER,"+
                "value"+		" VARCHAR,"+
                "comment"+		" VARCHAR,"+
                "date"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_Monitoring105_UnStructured);

        String Create_Monitoring105_Master = "CREATE TABLE IF NOT EXISTS " + "monitoring105_master" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "oname"+		" VARCHAR,"+
                "odesig"+		" VARCHAR,"+
                "odate"+		" VARCHAR,"+
                "ben_id"+ " VARCHAR,"+
                "bentype"+ " VARCHAR,"+
                "org"+ " VARCHAR,"+
                "date"+		" VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER,"	+
                "obserorg"+ " VARCHAR"+
                ")";
        db.execSQL(Create_Monitoring105_Master);




        //table for 102 //
        String Create_Monitoring102 = "CREATE TABLE IF NOT EXISTS " + "monitoring102" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "ques_no"+		" INTEGER,"+
                "value"+		" VARCHAR,"+
                "comment"+		" VARCHAR,"+
                "date"+ " VARCHAR,"+
                "orgname"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_Monitoring102);


        String Create_Monitoring102_UnStructured = "CREATE TABLE IF NOT EXISTS " + "monitoring102_unstructured" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "ques_no"+		" VARCHAR,"+
                "value"+		" VARCHAR,"+
                "comment"+		" VARCHAR,"+
                "date"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_Monitoring102_UnStructured);


        String Create_Monitoring102_Master = "CREATE TABLE IF NOT EXISTS " + "monitoring102_master" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "oname"+		" VARCHAR,"+
                "odesig"+		" VARCHAR,"+
                "orgname"+		" VARCHAR,"+
                "odate"+		" VARCHAR,"+
                "ddate"+ " VARCHAR,"+
                "dcenter"+ " VARCHAR,"+
                "org"+ " VARCHAR,"+
                "zila"+" VARCHAR,"+
                "upozila"+" VARCHAR,"+
                "unions"+" VARCHAR,"+
                "village"+ " VARCHAR,"+
                "date"+		" VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER,"	+
                "obserorg"+ " VARCHAR"+
                ")";
        db.execSQL(Create_Monitoring102_Master);

        //end of table 102

        //Table for 106
        String Create_Monitoring106 = "CREATE TABLE IF NOT EXISTS " + "monitoring106" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "ques_no"+		" INTEGER,"+
                "value"+		" VARCHAR,"+
                "comment"+		" VARCHAR,"+
                "date"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_Monitoring106);


        String Create_Monitoring106_UnStructured = "CREATE TABLE IF NOT EXISTS " + "monitoring106_unstructured" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "ques_no"+		" INTEGER,"+
                "value"+		" VARCHAR,"+
                "comment"+		" VARCHAR,"+
                "date"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_Monitoring106_UnStructured);


        String Create_Monitoring106_Master = "CREATE TABLE IF NOT EXISTS " + "monitoring106_master" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "oname"+		" VARCHAR,"+
                "odesig"+		" VARCHAR,"+
                "odate"+		" VARCHAR,"+
                "ben_id"+ " VARCHAR,"+
                "bentype"+ " VARCHAR,"+
                "org"+ " VARCHAR,"+
                "date"+		" VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER,"	+
                "obserorg"+ " VARCHAR"+
                ")";
        db.execSQL(Create_Monitoring106_Master);
        //end of table 106


        //Table for User Registration
        String Create_UserRegistration = "CREATE TABLE IF NOT EXISTS " + "user_registration" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+     " INTEGER,"+
                "Date"+      " VARCHAR,"+
                "IP"+      " VARCHAR,"+
                "DistrictCode"+      " VARCHAR,"+
                "UpazilaCode"+      " VARCHAR,"+
                "UnionCode"+      " VARCHAR,"+
                "WardNo"+      " VARCHAR,"+
                "VillageCode"+      " VARCHAR,"+
                "WRType"+      " VARCHAR,"+
                "KhanaCode"+      " VARCHAR,"+
                "WRNo"+      " VARCHAR,"+
                "KhanaNo"+      " VARCHAR,"+
                "BenType"+      " VARCHAR,"+
                "BenName"+      " VARCHAR,"+
                "HHHeadName"+      " VARCHAR,"+
                "BenAge"+      " VARCHAR,"+
                "BenRelWithHH"+      " VARCHAR,"+
                "HusbandName"+      " VARCHAR,"+
                "FatherName"+      " VARCHAR,"+
                "BenMobile"+      " VARCHAR,"+
                "FatherInLaw"+      " VARCHAR,"+
                "FamilyMobile"+      " VARCHAR,"+
                "HHLocation"+      " VARCHAR,"+
                "YoungerChildAgeYears"+      " VARCHAR,"+
                "YoungerChildAgeMonths"+      " VARCHAR,"+
                "BenMaritalAge"+      " VARCHAR,"+
                "IsBenPregnent"+      " VARCHAR,"+
                "IsBenSchoolGoing"+      " VARCHAR,"+
                "ClassName"+      " VARCHAR,"+
                "MonthlyIncome"+      " VARCHAR,"+
                "OhterMonthlyIncome"+      " VARCHAR,"+
                "LivingLandArea"+      " VARCHAR,"+
                "CultivableLandPresent"+      " VARCHAR,"+
                "CultivableLandArea"+      " VARCHAR,"+
                "HasPond"+      " VARCHAR,"+
                "PondOwnership"+      " VARCHAR,"+
                "DevelopmentProject"+      " VARCHAR,"+
                "InformerName"+      " VARCHAR,"+
                "InformerMobile"+      " VARCHAR,"+
                "InformerRel"+      " VARCHAR,"+
                "CollectedBy"+      " VARCHAR,"+
                "Comments"+      " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"  +
                ")";
        db.execSQL(Create_UserRegistration);


        String Create_UserRegistration_UnStructured = "CREATE TABLE IF NOT EXISTS " + "user_registration_unstructured" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "ques_no"+		" INTEGER,"+
                "value"+		" VARCHAR,"+
                "comment"+		" VARCHAR,"+
                "date"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_UserRegistration_UnStructured);

        String Create_Division = "CREATE TABLE IF NOT EXISTS " + "divisionTb" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "DivisionCode"+		" VARCHAR,"+
                "DivisionName"+		" VARCHAR,"+
                "DivisionNameBangla"+		" VARCHAR"+
                ")";
        db.execSQL(Create_Division);

        String Create_District = "CREATE TABLE IF NOT EXISTS " + "districtTb" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "DistrictCode"+		" VARCHAR,"+
                "DistrictName"+		" VARCHAR,"+
                "DistrictNameBangla"+		" VARCHAR,"+
                "DivisionCode"+		" VARCHAR"+
                ")";
        db.execSQL(Create_District);


        String Create_Upozila = "CREATE TABLE IF NOT EXISTS " + "upozilaTb" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "DistrictCode"+		" VARCHAR,"+
                "UpazilaCode"+		" VARCHAR,"+
                "UpazilaID"+		" VARCHAR,"+
                "UpazilaName"+		" VARCHAR,"+
                "UpazilaNameBangla"+ " VARCHAR"+
                ")";
        db.execSQL(Create_Upozila);

        String Create_Union = "CREATE TABLE IF NOT EXISTS " + "unionTb" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "DistrictCode"+		" VARCHAR,"+
                "UnionCode"+		" VARCHAR,"+
                "UnionID"+		" VARCHAR,"+
                "UnionName"+		" VARCHAR,"+
                "UnionNameBangla"+ " VARCHAR,"+
                "UpazilaCode"+ " VARCHAR"+
                ")";
        db.execSQL(Create_Union);

        String Create_Village = "CREATE TABLE IF NOT EXISTS " + "villageTb" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "DistrictCode"+		" VARCHAR,"+
                "UnionCode"+		" VARCHAR,"+
                "UpazilaCode"+		" VARCHAR,"+
                "VillageCode"+		" VARCHAR,"+
                "VillageName"+ " VARCHAR,"+
                "VillageNameBangla "+ " VARCHAR"+
                ")";
        db.execSQL(Create_Village);


        String Create_Monitoring103 = "CREATE TABLE IF NOT EXISTS " + "monitoring103" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "ques_no"+		" INTEGER,"+
                "value"+		" VARCHAR,"+
                "comment"+		" VARCHAR,"+
                "date"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_Monitoring103);

        String Create_Monitoring103_UnStructured = "CREATE TABLE IF NOT EXISTS " + "monitoring103_unstructured" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "ques_no"+		" INTEGER,"+
                "value"+		" VARCHAR,"+
                "comment"+		" VARCHAR,"+
                "date"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_Monitoring103_UnStructured);

        String Create_Monitoring103_Master = "CREATE TABLE IF NOT EXISTS " + "monitoring103_master" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "oname"+		" VARCHAR,"+
                "odesig"+		" VARCHAR,"+
                "odate"+		" VARCHAR,"+
                "ben_id"+ " VARCHAR,"+
                "bentype"+ " VARCHAR,"+
                "org"+ " VARCHAR,"+
                "date"+		" VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER,"	+
                "obserorg"+ " VARCHAR"+
                ")";
        db.execSQL(Create_Monitoring103_Master);

        String Create_Multiple_Survey_MasterRole = "CREATE TABLE IF NOT EXISTS " + "survey_master_role_master" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" VARCHAR,"+
                "anc_pnc_type"+		" VARCHAR,"+
                "input_nth"+		" VARCHAR,"+
                "input_type"+		" VARCHAR,"+
                "ben_condition"+		" VARCHAR,"+
                "vmf_type"+		" VARCHAR,"+
                "drop_cause"+		" VARCHAR,"+
                "isvita_child"+		" VARCHAR,"+
                "odate"+		" VARCHAR,"+
                "ben_id"+ " VARCHAR,"+
                "input_other"+		" VARCHAR,"+
                "input_measure"+		" VARCHAR,"+
                "ben_other"+		" VARCHAR,"+
                "vmf_date"+		" VARCHAR,"+
                "drop_other"+		" VARCHAR,"+
                "total_kid_boy"+		" VARCHAR,"+
                "total_kid_girl"+		" VARCHAR,"+
                "vita_total_kid_boy"+		" VARCHAR,"+
                "vita_total_kid_girl"+		" VARCHAR,"+
                "entry_date"+		" VARCHAR,"+
                "active" + " INTEGER,"	+
                "damage_count"+		" VARCHAR"+
                ")";
        db.execSQL(Create_Multiple_Survey_MasterRole);



        String Create_UserChildNutritionRegister = "CREATE TABLE IF NOT EXISTS " + "UserChildNutritionRegister" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "child_name"+		" VARCHAR,"+
                "child_dob"+		" VARCHAR,"+
                "ben_name"+		" VARCHAR,"+
                "ben_id"+		" VARCHAR,"+
                "village"+		" VARCHAR,"+
                "mobile"+		" VARCHAR,"+
                "child_gender"+		" VARCHAR,"+
                "entry_date"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER,"	+
                "center_name"+ " VARCHAR,"+
                "child_condition"+ " VARCHAR"+
                ")";
        db.execSQL(Create_UserChildNutritionRegister);


        String CREATE_UserChildNutritionRegisterDetails = "CREATE TABLE IF NOT EXISTS " + "UserChildNutritionRegisterDetails" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "ben_id"+		" VARCHAR,"+
                "odate" + " VARCHAR,"	+
                "weight"+		" VARCHAR,"+
                "height" + " VARCHAR,"	+
                "muak" + " VARCHAR,"	+
                "weight_nutrition" + " VARCHAR,"	+
                "height_nutrition" + " VARCHAR,"	+
                "muak_nutrition" + " VARCHAR,"	+
                "entry_date" + " DATE,"	+
                "active" + " INTEGER,"	+
                "ref_id"+		" INTEGER,"+
                "refared"+		" VARCHAR"+
                ")";
        db.execSQL(CREATE_UserChildNutritionRegisterDetails);


        //training table start
        String Create_trainingH = "CREATE TABLE IF NOT EXISTS " + "training_hazira" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "ben_name"+		" VARCHAR,"+
                "isBen"+		" VARCHAR,"+
                "benId"+		" VARCHAR,"+
                "p_ben"+		" VARCHAR,"+
                "gender"+		" VARCHAR,"+
                "vill"+		" VARCHAR,"+
                "date"+ " VARCHAR,"+
                "mobile"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_trainingH);


        String Create_training_Master = "CREATE TABLE IF NOT EXISTS " + "training_hazira_master" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "training_name"+		" VARCHAR,"+
                "suchana_year"+		" VARCHAR,"+
                "trainer_name"+		" VARCHAR,"+
                "traing_date"+		" VARCHAR,"+
                "traing_vanue"+		" VARCHAR,"+
                "vill"+		" VARCHAR,"+
                "un"+		" VARCHAR,"+
                "upozila"+ " VARCHAR,"+
                "zila"+ " VARCHAR,"+
                "active" + " INTEGER,"+
                "training_type" + " VARCHAR,"+
                "nth" + " VARCHAR,"+
                "type_no" + " VARCHAR,"+
                "traing_date_end" + " VARCHAR,"+
                "traingNameOther" + " VARCHAR"+
                ")";
        db.execSQL(Create_training_Master);
        //----------training_table _end------------


        //-----------yard_meeting table start---------
        String Create_YMeeting = "CREATE TABLE IF NOT EXISTS " + "YMeeting" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "benId"+		" VARCHAR,"+
                "benName"+		" VARCHAR,"+
                "p_ben"+		" VARCHAR,"+
                "date"+ " VARCHAR,"+
                "m_sub"+ " VARCHAR,"+
                "start_time"+ " VARCHAR,"+
                "end_time" + " VARCHAR,"	+
                "status"+ " VARCHAR,"+
                "condition"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_YMeeting);


        String Create_YMeeting_Master = "CREATE TABLE IF NOT EXISTS " + "YMeeting_master" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "team_name"+		" VARCHAR,"+
                "vill"+		" VARCHAR,"+
                "un"+		" VARCHAR,"+
                "upozila"+ " VARCHAR,"+
                "zila"+ " VARCHAR,"+
                "m_date"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_YMeeting_Master);
        //--------yard_meeting_table _end------------------
        String Create_IGA = "CREATE TABLE IF NOT EXISTS " + "iga" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "benId"+		" VARCHAR,"+
                "voucherNo"+		" VARCHAR,"+
                "benName"+ " VARCHAR,"+
                "g_name"+ " VARCHAR,"+
                "vill"+ " VARCHAR,"+
                "input_type"+ " VARCHAR,"+
                "input_type_other"+ " VARCHAR,"+
                "d_org"+ " VARCHAR,"+
                "units"+ " VARCHAR,"+
                "unit_type"+ " VARCHAR,"+
                "u_no"+ " VARCHAR,"+
                "date"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER,"	+
                "inputoriga" + " VARCHAR"	+
                ")";
        db.execSQL(Create_IGA);


        String Create_IGA_Master = "CREATE TABLE IF NOT EXISTS " + "iga_master" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "d_name"+		" VARCHAR,"+
                "d_designation"+		" VARCHAR,"+
                "d_date"+		" VARCHAR,"+
                "o_name"+		" VARCHAR,"+
                "organization"+		" VARCHAR,"+
                "s_year"+		" VARCHAR,"+
                "center_address"+		" VARCHAR,"+
                "vill"+		" VARCHAR,"+
                "un"+		" VARCHAR,"+
                "upozila"+ " VARCHAR,"+
                "zila"+ " VARCHAR,"+
                "active"+ " INTEGER"+
                ")";
        db.execSQL(Create_IGA_Master);


        /*Anindya check list 108*/
        String Create_Monitoring108_Master = "CREATE TABLE IF NOT EXISTS " + "monitoring108_master" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "oname" + " VARCHAR,"+
                "odesig" + " VARCHAR,"+
                "odate" + " VARCHAR,"+
                "formtype" + " VARCHAR,"+
                "ben_id" + " VARCHAR,"+
                "bentype" + " VARCHAR,"+
                "team_name"+ " VARCHAR,"+
                "team_location"+ " VARCHAR,"+
                "vill"+	" VARCHAR,"+
                "un"+ " VARCHAR,"+
                "upozila"+ " VARCHAR,"+
                "zila"+ " VARCHAR,"+
                "org"+ " VARCHAR,"+
                "date"+		" VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER,"	+
                "obserorg"+ " VARCHAR"+
                ")";
        db.execSQL(Create_Monitoring108_Master);

        String Create_Monitoring108 = "CREATE TABLE IF NOT EXISTS " + "monitoring108" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "ques_no"+		" INTEGER,"+
                "value"+		" VARCHAR,"+
                "comment"+		" VARCHAR,"+
                "date"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_Monitoring108);


        String Create_Monitoring108_UnStructured = "CREATE TABLE IF NOT EXISTS " + "monitoring108_unstructured" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "rec_id"+		" INTEGER,"+
                "ques_no"+		" INTEGER,"+
                "value"+		" VARCHAR,"+
                "comment"+		" VARCHAR,"+
                "date"+ " VARCHAR,"+
                "status"+ " VARCHAR,"+
                "active" + " INTEGER"	+
                ")";
        db.execSQL(Create_Monitoring108_UnStructured);


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
