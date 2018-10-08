package com.example.app.myapp.module;

/**
 * Created by stccon on 8/21/2017.
 */

public class DataClass {


    public static String[] moulic_training_list_type_arr = {"মৌলিক প্রশিক্ষণ","রিফ্রেসার প্রশিক্ষণ","অন্যান্য\n" +
            "(প্রশিক্ষণ/মিটিং)","উঠান বৈঠকে অংশগ্রহন","ANC/PNC সেবা সম্পর্কিত তথ্য",
    "শিশুর পুষ্টি অবস্থা/Nutrition Status (WFA)","ইনপুট/IGA", "ইনপুট/IGA-এর ব্যবহার","মন্তব্য\n" +
            "(যদি থাকে)"};
    public static String[] moulic_training_type_arr = {"1 = Poultry- HKI","2 = VMF owner on HFP- HKI","3 = IGA- HKI","4 = Horticulture","5 = Aquaculture- WF", "6 = Demo Pond (DP) on fish culture- WF","7 = IGA- WF","8 = IGA- SC","9 = Financial literacy-SC","10 = Vaccinator training","11 = Not received basic training but received orientation","99 =  Other (Specify)"};
    public static int[] moulic_training_type_arr_no = {1,2,3,4,5,6,7,8,9,10,11,99};

    public static String[] input_iga_cover_flow_type = {"Vegetable seed", "Vegetable seedling", "OSP vine", "Fruit sapling",
    "Maringa sapling", "Poultry birds (1st installment) (tk.)", "Poultry birds (2nd installment) (tk.)", "Fish fingerling",
    "Chickens", "Duck", "Goat", "Sheep", "Rickshaw/Van", "Bamboo", "Vegetable business related", "Fish business related",
    "Pati(mat)making materials", "Handicraft making materials", "Vaccination kit box/tools/vaccines", "Other (specify)"};

    public static String[] other_training_type_arr = {"1= Adolescent life skills training","2= Linkage event on fish culture","3= Coaching on fish culture","4= Coaching on vegetable gardening","5= Coaching on poultry", "7= Community Need Assessment (CNA)","8= Community Risk Assessment (CRA)","9= IGA assignment meeting","99= Other (specify)"};
    public static int[] other_training_type_arr_no = {1,2,3,4,5,7,8,9,99};
    public static String[] moulic_training_receiver_type_arr = {"1= উপকারভোগী নিজে","2= অন্য কেউ (মহিলা)","3= অন্য কেউ (পুরুষ)"};
    public static int[] moulic_training_receiver_type_arr_no = {1,2,3};

    public static String[] moulic_training_type_no_arr = {"1st","2nd","3rd","4th","5th","6th","7th","8th","9th","10th"};
    public static int[] moulic_training_type_no_arr_no = {1,2,3,4,5,6,7,8,9,10};

    public static String[] courtyard_meeting_arr = {"1= হ্যাঁ (উপস্থিত ছিল)","2= না (উপস্থিত ছিল না)"};
    public static int[] courtyard_meeting_arr_no = {1,2};
    public static String[] empty_arr = {""};

    public static String[] anc_pnc_type_arr = {"1= ANC 1st check-up","2= ANC 2nd check-up","3= ANC 3rd check-up","4= ANC 4th check-up","5= ANC more than 4 check-up","6= Not received any ANC check-up","7= PNC 1st check-up","8= PNC 2nd check-up","9= PNC more than 2 check-up","10= Not received any PNC check-up"};
    public static int[] anc_pnc_type_arr_no = {1,2,3,4,5,6,7,8,9,10};

    public static SpinnerValue[] anc_pnc_type_arr_sp = new SpinnerValue[]{
            new SpinnerValue("--No Selected--", "0"),
            new SpinnerValue("ANC 1st check-up", "1"),
            new SpinnerValue("ANC 2nd check-up", "2"),
            new SpinnerValue("ANC 3rd check-up", "3"),
            new SpinnerValue("ANC 4th check-up", "4"),
            new SpinnerValue("ANC more than 4 check-up", "5"),
            new SpinnerValue("Not received any ANC check-up", "6"),
            new SpinnerValue("PNC 1st check-up", "7"),
            new SpinnerValue("PNC 2nd check-up", "8"),
            new SpinnerValue("PNC more than 2 check-up", "9"),
            new SpinnerValue("Not received any PNC check-up", "10")
    };

    public static SpinnerValue[] input_iga_nth_sp = new SpinnerValue[]{
            new SpinnerValue("1st", "1"),
            new SpinnerValue("2nd", "2"),
            new SpinnerValue("3rd", "3"),
            new SpinnerValue("4th", "4"),
            new SpinnerValue("5th", "5"),
            new SpinnerValue("6th", "6"),
            new SpinnerValue("7th", "7"),
            new SpinnerValue("8th", "8"),
            new SpinnerValue("9th", "9"),
            new SpinnerValue("10th", "10")
    };

    public static SpinnerValue[] t_moulic_training_type_arr = new SpinnerValue[]{
            new SpinnerValue("1= Poultry- HKI", "1"),
            new SpinnerValue("2= VMF owner on HFP- HKI", "2"),
            new SpinnerValue("3= IGA- HKI", "3"),
            new SpinnerValue("4= Horticulture", "4"),
            new SpinnerValue("5= Aquaculture- WF", "5"),
            new SpinnerValue("6= Demo Pond (DP) on fish culture- WF", "6"),
            new SpinnerValue("7= IGA- WF", "7"),
            new SpinnerValue("8= IGA- SC", "8"),
            new SpinnerValue("9= Financial literacy-SC", "9"),
            new SpinnerValue("10= Vaccinator training", "10"),
            new SpinnerValue("11= Not received basic training but received orientation", "11"),
            new SpinnerValue("99=  Other (Specify)", "99")
    };

    public static SpinnerValue[] t_other_training_type_arr = new SpinnerValue[]{
            new SpinnerValue("1= Adolescent life skills training", "1"),
            new SpinnerValue("2= Linkage event on fish culture", "2"),
            new SpinnerValue("3= Coaching on fish culture", "3"),
            new SpinnerValue("4= Coaching on vegetable gardening", "4"),
            new SpinnerValue("5= Coaching on poultry", "5"),
            new SpinnerValue("7= Community Need Assessment (CNA)", "7"),
            new SpinnerValue("8= Community Risk Assessment (CRA)", "8"),
            new SpinnerValue("9= IGA assignment meeting", "9"),
            new SpinnerValue("99= Other (specify)", "99"),
            new SpinnerValue("10= Vaccinator training", "10"),
            new SpinnerValue("11= Not received basic training but received orientation", "11"),
            new SpinnerValue("99=  Other (Specify)", "99")
    };

    public static String[] baby_nutation_arr = {"1= স্বাভাবিক (স্বাভা) + স্বল্প\n" +
            "(সবুজ বা হলুদ রং অংশ)\n","2= মাঝারি বা মাঝা\n" +
            "(কমলা রং অংশ)\n","3= মারাত্মক বা মারা\n" +
            "(লাল রং অংশ)\n","4= ক্লিনিক বা EPI সেন্টারে গিয়েছিল কিন্তু ওজন মাপা হয়নি বা উপকারভোগীর কাছে GMP কার্ড পাওয়া যায়নি",
            "5= ক্লিনিক বা EPI সেন্টারে যায়নি","6= বাড়ীটি GMP পরিচালিত ক্লিনিক বা EPI সেন্টারের আওতাধীন নয়"};
    public static int[] baby_nutation_arr_no = {1,2,3,4,5,6};

    public static String[] baby_gender_arr = {"1= মেয়ে শিশু [প্রতিবন্ধী নয়]","2= মেয়ে শিশু [প্রতিবন্ধী]","3= ছেলে শিশু [প্রতিবন্ধী নয়]","4= ছেলে শিশু [প্রতিবন্ধী]"};
    public static int[] baby_gender_arr_no = {1,2,3,4};

    public static String[] iga_input_arr = {"1= Vegetable seed (no. packet)","2= Vegetable seedling (no.)",
            "3= OSP vine (no.)","4= Fruit sapling (no.)","5= Maringa sapling (no.)","6= Poultry shed (no.)"
            ,"7= Fish fingerling (no.)","8= Chickens (no.)","9= Duck (no.)","10= Goat (no.)",
            "11= Sheep (no.)","12= Rickshaw/Van (no.)","13= Bamboo (no.)","14= Vegetable business related",
            "15= Fish business related","16= Pati making materials","17= Handicraft making materials","99= Other (specify)"};
    public static int[] iga_input_arr_no = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,99};

    public static SpinnerValue[] input_iga_arr_type_sp = new SpinnerValue[]{
            new SpinnerValue("--No Selected--", "0"),
            new SpinnerValue("1= Vegetable seed (no. packet)", "1"),
            new SpinnerValue("2= Vegetable seedling (no.)", "2"),
            new SpinnerValue("3= OSP vine (no.)", "3"),
            new SpinnerValue("4= Fruit sapling (no.)", "4"),
            new SpinnerValue("5= Maringa sapling (no.)", "5"),
            new SpinnerValue("6= Poultry shed (no.)", "6"),
            new SpinnerValue("7= Fish fingerling (no.)", "7"),
            new SpinnerValue("8= Chickens (no.)", "8"),
            new SpinnerValue("9= Duck (no.)", "9"),
            new SpinnerValue("10= Goat (no.)", "10"),
            new SpinnerValue("11= Sheep (no.)", "11"),
            new SpinnerValue("12= Rickshaw/Van (no.)", "12"),
            new SpinnerValue("13= Bamboo (no.)", "13"),
            new SpinnerValue("14= Vegetable business related", "14"),
            new SpinnerValue("15= Fish business related", "15"),
            new SpinnerValue("16= Pati making materials", "16"),
            new SpinnerValue("17= Handicraft making materials", "17"),
            new SpinnerValue("99= Other (specify)", "99")
    };


    public static String[] iga_uses_arr = {"1= ব্যবহার করতে পারছে","2= মোটামোটি ব্যবহার করতে পারছে (কিছু নষ্ট বা মারা গিয়েছে, কিছু ভাল আছে)","3= ব্যবহার করতে পারছে না বা মারা গেছে বা নষ্ট হয়ে গেছে"};
    public static int[] iga_uses_arr_no = {1,2,3};

    public static String[] beneficiary_type_arr = {"1= Woman (15-40/45)\n[প্রতিবন্ধী নয়]\n","2= Woman (15-40/45)\n" +
            "[প্রতিবন্ধী]\n","3= Adolescent (15-19)\n" +
            "[প্রতিবন্ধী নয়]\n","4= Adolescent (15-19)\n" +
            "[প্রতিবন্ধী]\n" };
    public static int[] beneficiary_type_arr_no = {1,2,3,4};
    public static String[] suchanaYearCode_arr = {"0= Learning Phase (2016)","1= Year 1 (2017)","2= Year 2 (2018)","3= Year 3 (2019)","4= Year 4 (2020)"};
    public static int[] suchanaYearCode_arr_no = {0,1,2,3,4};

    public static String[] ipNameCode_arr = {"1=FIVDB","2= RDRS","3= CNRS"};
    public static int[] ipNameCode_arr_no = {1,2,3};

    public static String[] benCondition_arr = {"1= বর্তমানে গর্ভবতী নারী (১৫-৪০/৪৫)\n" +
            "[প্রতিবন্ধী নয়]\n","2= বর্তমানে গর্ভবতী নারী (১৫-৪০/৪৫)\n" +
            "[প্রতিবন্ধী]\n","3= ২ বছরের নিচে সন্তান আছে \n  এমন নারী (১৫-৪০/৪৫)[প্রতিবন্ধী নয়]\n",
            "4= ২ বছরের নিচে সন্তান আছে \n  এমন নারী (১৫-৪০/৪৫) [প্রতিবন্ধী]\n",
            "5= উভয়েই (বর্তমানে গর্ভবতী \n এবং ২ বছরের নিচে সন্তান এমন নারী [প্রতিবন্ধী নয়]",
            "6= উভয়েই (বর্তমানে গর্ভবতী এবং \n ২ বছরের নিচে সন্তান এমন নারী [প্রতিবন্ধী]"};
    public static int[] benCondition_arr_no = {1,2,3,4,5,6};

    public static SpinnerValue[] benCondition_arr_sp = new SpinnerValue[]{
            new SpinnerValue("--No Selected--", "0"),
            new SpinnerValue("1= বর্তমানে গর্ভবতী নারী (১৫-৪০/৪৫)\n" +
                    "[প্রতিবন্ধী নয়]\n", "1"),
            new SpinnerValue("2= বর্তমানে গর্ভবতী নারী (১৫-৪০/৪৫)\n" +
                    "[প্রতিবন্ধী]\n", "2"),
            new SpinnerValue("3= ২ বছরের নিচে সন্তান আছে \n  এমন নারী (১৫-৪০/৪৫)[প্রতিবন্ধী নয়]\n", "3"),
            new SpinnerValue("4= ২ বছরের নিচে সন্তান আছে \n  এমন নারী (১৫-৪০/৪৫) [প্রতিবন্ধী]\n", "4"),
            new SpinnerValue("5= উভয়েই (বর্তমানে গর্ভবতী \n এবং ২ বছরের নিচে সন্তান এমন নারী [প্রতিবন্ধী নয়]", "5"),
            new SpinnerValue("6= উভয়েই (বর্তমানে গর্ভবতী এবং \n ২ বছরের নিচে সন্তান এমন নারী [প্রতিবন্ধী]", "6")
    };

    public static String[] vmf_dp_arr = {"1= Village Model Farmer (VMF)","2= Demo Pond (DP)","3= Discontinue"};
    public static int[] vmf_dp_arr_no = {1,2,3};

    public static SpinnerValue[] vmf_dp_arr_sp = new SpinnerValue[]{
            new SpinnerValue("--No Selected--", "0"),
            new SpinnerValue("1= Village Model Farmer (VMF)", "1"),
            new SpinnerValue("2= Demo Pond (DP)", "2"),
            new SpinnerValue("3= Discontinue", "3")
    };

    public static String[] skipSuchana_arr = {"1= মৃত্যূ","2= অন্য জায়গায় চলে গেছে","3= বিয়ে হয়ে অন্য জায়গায় চলে গেছে",
            "4= সূচনা কার্যক্রমে অংশগ্রহনে আর আগ্রহী নয় (নির্দিষ্ট করুন)","99= অন্যান্য (নির্দিষ্ট করুন)"};
    public static int[] skipSuchana_no = {1,2,3,4,99};

    public static SpinnerValue[] skipSuchana_arr_sp = new SpinnerValue[]{
            new SpinnerValue("--No Selected--", "0"),
            new SpinnerValue("1= মৃত্যূ", "1"),
            new SpinnerValue("2= অন্য জায়গায় চলে গেছে", "2"),
            new SpinnerValue("3= বিয়ে হয়ে অন্য জায়গায় চলে গেছে", "3"),
            new SpinnerValue("4= সূচনা কার্যক্রমে অংশগ্রহনে আর আগ্রহী নয় (নির্দিষ্ট করুন)", "4"),
            new SpinnerValue("99= অন্যান্য (নির্দিষ্ট করুন)", "99")
    };

    public static String[] tracking_name_arr = {"SCM কর্তৃক খানা ভিজিটের মাস","উপকারভোগীর অবস্থা","VMF/DP","সূচনা থেকে ঝরে পড়ার কারন","Vitamin A Capsule"};
    public static int[] tracking_name_arr_no = {0,1,2,3,4};

    public static String[] string_arr = {""};
    public static String[] string_arr_no = {""};

    public static String[] tracking_ben_condition_arr = {"1= বর্তমানে গর্ভবতী নারী (১৫-৪০/৪৫)\n" +
            "[প্রতিবন্ধী নয়]\n","2= বর্তমানে গর্ভবতী নারী (১৫-৪০/৪৫)\n" +
            "[প্রতিবন্ধী]\n","3= ২ বছরের নিচে সন্তান আছে এমন নারী (১৫-৪০/৪৫) [প্রতিবন্ধী নয়]","4= ২ বছরের নিচে সন্তান আছে এমন নারী (১৫-৪০/৪৫) [প্রতিবন্ধী]","5= উভয়েই (বর্তমানে গর্ভবতী এবং ২ বছরের নিচে সন্তান এমন নারী [প্রতিবন্ধী নয়]","6= উভয়েই (বর্তমানে গর্ভবতী এবং ২ বছরের নিচে সন্তান এমন নারী [প্রতিবন্ধী]"};
    public static int[] tracking_ben_condition_arr_no = {1,2,3,4,5,6};

    public static String[] tracking_vmf_dp_arr = {"1= Village Model Framer (VMF)","2= Demo Pond (DP)","3= Discontinue",};
    public static int[] tracking_vmf_dp_arr_no = {1,2,3};

    public static String[] tracking_droupout_arr = {"1= মৃত্যূ","2= অন্য জায়গায় চলে গেছে","3= বিয়ে হয়ে অন্য জায়গায় চলে গেছে","4= সূচনা কার্যক্রমে অংশগ্রহনে আর আগ্রহী নয় (কেন আগ্রহী নয়, রেজিস্ট্রারের পিছনের পাতায় লিখুন)","99= অন্যান্য (নির্দিষ্ট করুন)"};

    public static int[] tracking_droupout_arr_no = {1,2,3,4,99};

    public static SpinnerValue[] spArrBenType = new SpinnerValue[]{
            new SpinnerValue("মহিলা (১৫-৪৫ বছর)", "1"),
            new SpinnerValue("কিশোরী (১৫-১৯ বছর)", "2")
    };

    public static SpinnerValue[] spArrOrg = new SpinnerValue[]{
            new SpinnerValue("FIVDB", "1"),
            new SpinnerValue("RDRS", "2"),
            new SpinnerValue("CNRS", "3")
    };

    public static SpinnerValue[] spArrOrgTp = new SpinnerValue[]{
            new SpinnerValue("--Select--", "0"),
            new SpinnerValue("SCI", "1"),
            new SpinnerValue("HKI", "2"),
            new SpinnerValue("WF", "3")
    };

    public static String[] input_iga_org_string = {"N/A", "SCI", "HKI", "WF"};

    public static SpinnerValue[] spArrIgaUnits = new SpinnerValue[]{
            new SpinnerValue("Kg", "0"),
            new SpinnerValue("Pac", "1"),
            new SpinnerValue("Tk", "2"),
            new SpinnerValue("No", "3")
    };

    public static SpinnerValue[] spArrMtype = new SpinnerValue[]{
            new SpinnerValue("Basic", "1"),
            new SpinnerValue("Refresher", "2"),
            new SpinnerValue("Others", "3")
    };

    public static SpinnerValue[] spArrYMtype = new SpinnerValue[]{
            new SpinnerValue("পুষ্টি ও যত্ন", "1"),
            new SpinnerValue("গর্ভবতী মায়ের পুষ্টি ও যত্ন ", "2"),
            new SpinnerValue("প্রসূতি ও দুগ্ধদানকারী  মায়ের পুষ্টি ও যত্ন ", "3"),
            new SpinnerValue("শিশুকে মায়ের দুধ খাওয়ানোর উপকারিতা ", "4"),
            new SpinnerValue("মায়ের দুধ খাওয়ানোর সঠিক উপায় ", "5"),
            new SpinnerValue("শিশুর বাড়তি খাবার", "6"),
            new SpinnerValue("শিশুর অপুষ্টির কারণ ও ধরণ", "7"),
            new SpinnerValue("গ্রোথ মনিটরিং এর প্রয়োজনীয়তা ", "8"),
            new SpinnerValue("অসুস্থ শিশুর খাবার ও যত্ন ", "9"),
            new SpinnerValue("কিশোর - কিশোরীদের পুষ্টি ", "10")
    };

    public static SpinnerValue[] spObsOrg = new SpinnerValue[]{
            new SpinnerValue("SCI", "1"),
            new SpinnerValue("HKI", "2"),
            new SpinnerValue("World Fish", "3"),
            new SpinnerValue("IDE", "4"),
            new SpinnerValue("FIVDB", "5"),
            new SpinnerValue("CNRS", "6"),
            new SpinnerValue("RDRS", "7")
    };
    public static SpinnerValue[] spArrYN = new SpinnerValue[]{
            new SpinnerValue("--No Selected--", "0"),
            new SpinnerValue("হ্যাঁ ", "1"),
            new SpinnerValue("না", "2")
    };

    public static SpinnerValue[] spArrGoodBad = new SpinnerValue[]{
            new SpinnerValue("১= খুব ভাল", "1"),
            new SpinnerValue("২= ভাল", "2"),
            new SpinnerValue("৩= মোটামুটি", "3"),
            new SpinnerValue("৪= দূর্বল", "4")
    };

    public static SpinnerValue[] sp_1_112 = new SpinnerValue[]{
            new SpinnerValue("১= একক ", "1"),
            new SpinnerValue("২= যৌথ ", "2")
    };
    public static SpinnerValue[] spArr_1_103 = new SpinnerValue[]{
            new SpinnerValue("জীবন্ত বেড়া ", "1"),
            new SpinnerValue("সাধারণ বেড়া", "2")
    };
    public static SpinnerValue[] spArr_2_103 = new SpinnerValue[]{
            new SpinnerValue("নিজ", "1"),
            new SpinnerValue("বর্গা", "2"),
            new SpinnerValue("খাস জমি", "3"),
            new SpinnerValue("অন্যের জমি", "4"),
            new SpinnerValue("অন্যান্য", "5")
    };

    public static SpinnerValue[] spArr_1_child_nutrition_master_role = new SpinnerValue[]{
            new SpinnerValue("১ = স্বাভাবিক/ সল্প খর্ব (N)", "1"),
            new SpinnerValue("২ = মাঝারী খর্ব (M)", "2"),
            new SpinnerValue("৩ = মারাত্মক খর্ব (S)", "3"),
            new SpinnerValue("৪ = বেশি লম্বা (H)", "4")
    };

    public static SpinnerValue[] spArr_2_child_nutrition_master_role = new SpinnerValue[]{
            new SpinnerValue("১ = স্বাভাবিক/ সল্প অপুষ্টি (N)", "1"),
            new SpinnerValue("২ = মাঝারি অপুষ্টি (M)", "2"),
            new SpinnerValue("৩ = মারাত্মক অপুষ্টি (S)", "3"),
            new SpinnerValue("৪ = বেশি ওজন (W)", "4")
    };

    public static SpinnerValue[] spArr_3_child_nutrition_master_role = new SpinnerValue[]{
            new SpinnerValue("১ = মুয়াক স্বাভাবিক (N)", "1"),
            new SpinnerValue("২ = ম্যাম (M)", "2"),
            new SpinnerValue("৩ = স্যাম (S)", "3")
    };

    public static SpinnerValue[] spArr_4_child_nutrition_master_role = new SpinnerValue[]{
            new SpinnerValue("ছেলে ", "1"),
            new SpinnerValue("মেয়ে", "2")
    };

    public static SpinnerValue[] spArr_household_child_condition = new SpinnerValue[]{
            new SpinnerValue("--Not Selected-- ", "0"),
            new SpinnerValue("Death", "1"),
            new SpinnerValue("Discontinue", "2"),
            new SpinnerValue("Complete", "3")
    };

    public static SpinnerValue[] spArrIgaType = new SpinnerValue[]{
            new SpinnerValue("Vegetable seedling (no.)", "1"),
            new SpinnerValue("Vegetable seedling (no.)", "2"),
            new SpinnerValue("OSP vine (no.)", "3"),
            new SpinnerValue("Fruit sapling (no.)", "4"),
            new SpinnerValue("Maringa sapling (no.)", "5"),
            new SpinnerValue("Poultry birds (1st installment) (tk.)", "6"),
            new SpinnerValue("Poultry birds (2nd installment) (tk.)", "7"),
            new SpinnerValue("Fish fingerling (no.)", "8"),
            new SpinnerValue("Chickens (no.)", "9"),
            new SpinnerValue("Duck (no.)", "10"),
            new SpinnerValue("Goat (no.)", "11"),
            new SpinnerValue("Sheep (no.)", "12"),
            new SpinnerValue("Rickshaw/Van (no.)", "13"),
            new SpinnerValue("Bamboo (no.)", "14"),
            new SpinnerValue(" Vegetable business related", "15"),
            new SpinnerValue(" Fish business related", "16"),
            new SpinnerValue(" Pati making materials", "17"),
            new SpinnerValue(" Handicraft making materials", "18"),
            new SpinnerValue(" Vaccination kit box/tools/vaccines", "19"),
            new SpinnerValue(" Other (specify)", "20"),
    };

    public static SpinnerValue[] spArrIgaNumber= new SpinnerValue[]{
            new SpinnerValue("1st", "1"),
            new SpinnerValue("2nd", "2"),
            new SpinnerValue("3rd", "3"),
            new SpinnerValue("4th", "4"),
            new SpinnerValue("5th", "5"),
            new SpinnerValue("6th", "6"),
            new SpinnerValue("7th", "7")

    };


    public static SpinnerValue[] spArr_3_iga_uses_arr = new SpinnerValue[]{
            new SpinnerValue("--No Selected--", "0"),
            new SpinnerValue("১ = ব্যবহার করতে পারছে", "1"),
            new SpinnerValue("২ = মোটামোটি ব্যবহার করতে পারছে (কিছু নষ্ট বা মারা গিয়েছে, কিছু ভাল আছে)", "2"),
            new SpinnerValue("৩ = ব্যবহার করতে পারছে না বা মারা গেছে বা নষ্ট হয়ে গেছে", "3")
    };


    /*Start Anindya Code*/
    public static SpinnerValue[] spArrFormType = new SpinnerValue[]{
            new SpinnerValue("BHHs selection", "1"),
            new SpinnerValue("Registration", "2"),
            new SpinnerValue("Group Formation", "3"),
    };

    public static SpinnerValue[] spArr108GoodToBad = new SpinnerValue[]{
            new SpinnerValue("খুব ভাল", "1"),
            new SpinnerValue("ভাল", "2"),
            new SpinnerValue("মাঝারি", "3"),
            new SpinnerValue("খারাপ", "4"),
            new SpinnerValue("খুব খারাপ", "5")
    };

    public static SpinnerValue[] spArrChildref = new SpinnerValue[]{
            new SpinnerValue("না", "2"),
            new SpinnerValue("হ্যাঁ ", "1")

    };

    public static SpinnerValue[] spArrMRTrainingArr = new SpinnerValue[]{
            new SpinnerValue("1= Adolescent life skills training", "1"),
            new SpinnerValue("2= Linkage event on fish culture", "2"),
            new SpinnerValue("3= Coaching on fish culture", "3"),
            new SpinnerValue("4= Coaching on vegetable gardening", "4"),
            new SpinnerValue("5= Coaching on poultry", "5"),
            new SpinnerValue("7= Community Need Assessment (CNA)", "7"),
            new SpinnerValue("8= Community Risk Assessment (CRA)", "8"),
            new SpinnerValue("9= IGA assignment meeting", "9"),
            new SpinnerValue("99= Other (specify)", "99")

    };
//


}
