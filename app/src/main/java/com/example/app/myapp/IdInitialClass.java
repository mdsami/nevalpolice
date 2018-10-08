package com.example.app.myapp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.app.myapp.module.CheckboxValue;
import com.example.app.myapp.module.EditTextValue;
import com.example.app.myapp.module.SpinnerValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bappy on 9/22/2017.
 */

public class IdInitialClass {
    List<TextView> textview;
    List<EditText> editText;
    List<Spinner> spinners;
    List<CheckBox> checkBoxes;

    Context context;
    String pallet;
    int start_count;
    int end_count;
    String idName;
    String[] txt;

    ArrayAdapter dataAdapter;


    public IdInitialClass(){

    }


    public IdInitialClass(String pallet, Context context, int start_count, int end_count, String idName){
        this.context = context;
        this.pallet = pallet;
        this.start_count = start_count;
        this.end_count = end_count;
        this.idName = idName;

    }

    public void initial(){

        if(pallet.equalsIgnoreCase("TextView")){
            textview = new ArrayList<TextView>();
            TextView tmpTextView;
            int resourceId = 0;
            //String viewName = "my_textview_";
            for(int fieldPos=start_count; fieldPos<=end_count; fieldPos++)
            {
                resourceId = context.getResources().getIdentifier(idName + (fieldPos), "id", context.getPackageName());
                tmpTextView = (TextView) ((Activity)context).findViewById(resourceId);
                //Add/update the TextView here before adding to the array.

                textview.add(tmpTextView);
            }
        }else if(pallet.equalsIgnoreCase("Spinner")){
            spinners = new ArrayList<Spinner>();
            Spinner sp;
            int resourceId = 0;
            //String viewName = "my_textview_";
            for(int fieldPos=start_count; fieldPos<=end_count; fieldPos++)
            {
                resourceId = context.getResources().getIdentifier(idName + (fieldPos), "id", context.getPackageName());
                sp = (Spinner) ((Activity)context).findViewById(resourceId);
                //Add/update the TextView here before adding to the array.

                spinners.add(sp);
            }

        }else if(pallet.equalsIgnoreCase("CheckBox")){
            checkBoxes = new ArrayList<CheckBox>();
            CheckBox ck;
            int resourceId = 0;
            //String viewName = "my_textview_";
            for(int fieldPos=start_count; fieldPos<=end_count; fieldPos++)
            {
                resourceId = context.getResources().getIdentifier(idName + (fieldPos), "id", context.getPackageName());
                ck = (CheckBox) ((Activity)context).findViewById(resourceId);
                //Add/update the TextView here before adding to the array.

                checkBoxes.add(ck);
            }

        }else if(pallet.equalsIgnoreCase("EditText")){
            editText = new ArrayList<EditText>();
            EditText tmpEditText;
            int resourceId = 0;
            //String viewName = "my_textview_";
            for(int fieldPos=start_count; fieldPos<=end_count; fieldPos++)
            {
                resourceId = context.getResources().getIdentifier(idName + (fieldPos), "id", context.getPackageName());
                tmpEditText = (EditText) ((Activity)context).findViewById(resourceId);
                //Add/update the TextView here before adding to the array.

                editText.add(tmpEditText);
            }
        }


    }

    public void setTextIntoInitial(String[] txt){
        this.txt = txt;
        if(pallet.equalsIgnoreCase("TextView")){
            TextView myTextView;
            for(int i = 0; i<textview.size();i++){
                myTextView = textview.get(i);
                myTextView.setText(txt[i]);
            }
        }else if(pallet.equalsIgnoreCase("Spinner")){

            Spinner sp;
            for(int i = 0; i<spinners.size();i++){
                sp = spinners.get(i);
                //sp.setText(txt[i]);
                dataAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item, txt);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp.setAdapter(dataAdapter);

            }


        }else if(pallet.equalsIgnoreCase("CheckBox")){

            CheckBox ck;
            for(int i = 0; i<checkBoxes.size();i++){
                ck = checkBoxes.get(i);
                //sp.setText(txt[i]);

                if(txt[i].equalsIgnoreCase("1")){
                    ck.setChecked(true);
                }

            }


        }


    }

    public List<String> getTextIntoInitial(){
        final List<String> data = new ArrayList<String>();
        if(pallet.equalsIgnoreCase("TextView")) {
            for (TextView myTextView : textview) {
                //Toast.makeText(getApplicationContext(), myTextView.getText().toString(), Toast.LENGTH_LONG).show();
                data.add(myTextView.getText().toString()+"");

            }
        }else  if(pallet.equalsIgnoreCase("Spinner")) {

            for (final Spinner sp : spinners) {
                //Toast.makeText(getApplicationContext(), myTextView.getText().toString(), Toast.LENGTH_LONG).show();
                data.add(SplitValue(sp.getSelectedItem().toString()));
//                sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                    @Override
//                    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
//                      // data.add(txt[pos]);
//                        data.add(view);
//                    }
//
//                    @Override
//                    public void onNothingSelected(AdapterView<?> adapterView) {
//
//                    }
//                });
            }
        }else if(pallet.equalsIgnoreCase("CheckBox")){
            for (CheckBox mCheck : checkBoxes) {
                //Toast.makeText(getApplicationContext(), myTextView.getText().toString(), Toast.LENGTH_LONG).show();
                if(mCheck.isChecked()){
                    data.add("1");
                }else{
                    data.add("0");
                }


            }

        }

        return data;
    }

    public void setSpinnerPreSelected(String[] dataArray, List<String> selectedSpinner){
        this.txt = dataArray;
        Spinner sp;
        for(int i = 0; i<spinners.size();i++){
            sp = spinners.get(i);
            //sp.setText(txt[i]);
            int selectedValue = Integer.parseInt(selectedSpinner.get(i));

            dataAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item, txt);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sp.setAdapter(dataAdapter);

            int position = getIndexForArray(txt, selectedValue+"");
            sp.setSelection(position);

        }

    }


    String SplitValue(String CurrentString){
        //String CurrentString = "Fruit: they taste good";
        String[] separated = CurrentString.split("=");
//        separated[0]; // this will contain "Fruit"
//        separated[1]; // this will contain " they taste good"

        return  separated[0];
    }

    int getIndex(int val, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

    static int getIndexFromObject(int val, SpinnerValue[] spinnerValue) {
        for (int i = 0; i < spinnerValue.length; i++) {

            if (Integer.parseInt(spinnerValue[i].valueText)== val) {
                return i;
            }
        }
        return -1;
    }
    static int getIndexFromObjectArrList(int val, ArrayList<SpinnerValue> spinnerValue) {
        for (int i = 0; i < spinnerValue.size(); i++) {

            if (Integer.parseInt(spinnerValue.get(i).valueText)== val) {
                return i;
            }
        }
        return -1;
    }
    int getIndexForArray(String[] dataArray, String value){

         int aPosition = 0;
        for(int i=0; i < dataArray.length; i++){
            if(dataArray[i].contains(value)){
                aPosition = i;
            }

        }
     return  aPosition;
    }


    public static Spinner getSpinner(Context c, String controlName, SpinnerValue[] spinnerValue) {
        int resID = c.getResources().getIdentifier(controlName, "id", c.getPackageName());
        Spinner spinner = (Spinner) ((Activity) c).findViewById(resID);

        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(c, R.layout.spinner, spinnerValue);
        spinner.setAdapter(spinnerArrayAdapter);
        return spinner;
    }

    public static Spinner getSpinner_bg(Context c, String controlName, SpinnerValue[] spinnerValue) {
        int resID = c.getResources().getIdentifier(controlName, "id", c.getPackageName());
        Spinner spinner = (Spinner) ((Activity) c).findViewById(resID);

        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(c, R.layout.spinner_drop, spinnerValue);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
        return spinner;
    }

    public static Spinner getSpinner_custom(Context c, String controlName, SpinnerValue[] spinnerValue) {
        int resID = c.getResources().getIdentifier(controlName, "id", c.getPackageName());
        Spinner spinner = (Spinner) ((Activity) c).findViewById(resID);

        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(c, R.layout.row_spinner, spinnerValue);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.row_spinners_dropdown);
        spinner.setAdapter(spinnerArrayAdapter);
        return spinner;
    }

    public static Spinner getSpinnerArrList(Context c, String controlName, ArrayList<SpinnerValue> spinnerValue) {
        int resID = c.getResources().getIdentifier(controlName, "id", c.getPackageName());
        Spinner spinner = (Spinner) ((Activity) c).findViewById(resID);

        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(c, R.layout.spinner, spinnerValue);
        spinner.setAdapter(spinnerArrayAdapter);
        return spinner;
    }

    public static Spinner getSpinnerSelected(Context c, String controlName, SpinnerValue[] spinnerValue, int poisition) {
        int resID = c.getResources().getIdentifier(controlName, "id", c.getPackageName());
        Spinner spinner = (Spinner) ((Activity) c).findViewById(resID);

        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(c, R.layout.spinner, spinnerValue);
        spinner.setAdapter(spinnerArrayAdapter);

        spinner.setSelection(getIndexFromObject(poisition,spinnerValue));

        return spinner;
    }
    public static Spinner getSpinnerSelected_bg(Context c, String controlName, SpinnerValue[] spinnerValue, int poisition) {
        int resID = c.getResources().getIdentifier(controlName, "id", c.getPackageName());
        Spinner spinner = (Spinner) ((Activity) c).findViewById(resID);

        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(c, R.layout.spinner_drop, spinnerValue);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);

        spinner.setSelection(getIndexFromObject(poisition,spinnerValue));

        return spinner;
    }

    public static Spinner getSpinnerSelectedArrList(Context c, String controlName, ArrayList<SpinnerValue> spinnerValues, int poisition) {
        int resID = c.getResources().getIdentifier(controlName, "id", c.getPackageName());
        Spinner spinner = (Spinner) ((Activity) c).findViewById(resID);

        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(c, R.layout.spinner, spinnerValues);
        spinner.setAdapter(spinnerArrayAdapter);

        spinner.setSelection(getIndexFromObjectArrList(poisition,spinnerValues));

        return spinner;
    }
    public static List<SpinnerValue> getSpinnerArrVlaue(Context c, String controlName, int startCount, int endCount) {
        List<SpinnerValue> spinnerValues = new ArrayList<SpinnerValue>();
        for (int i = startCount; i <= endCount; i++) {
            String cName = controlName + i;
            int resID = c.getResources().getIdentifier(cName, "id", c.getPackageName());
            Spinner spinner = (Spinner) ((Activity) c).findViewById(resID);
            SpinnerValue value = (SpinnerValue) spinner.getSelectedItem();
            spinnerValues.add(value);
        }
        return spinnerValues;
    }

    public static EditText getEditText(Context context, String controlName) {


            int resID= context.getResources().getIdentifier(controlName, "id", context.getPackageName());
            EditText tmpEditText = (EditText) ((Activity)context).findViewById(resID);
            tmpEditText.setText(" ");

        return tmpEditText;
    }

    public static EditText getEditTextTrim(Context context, String controlName) {


        int resID= context.getResources().getIdentifier(controlName, "id", context.getPackageName());
        EditText tmpEditText = (EditText) ((Activity)context).findViewById(resID);


        return tmpEditText;
    }

    public static EditText setEditText(Context context, String controlName, String value) {

        int resID = context.getResources().getIdentifier(controlName, "id", context.getPackageName());
        EditText tmpEditText = (EditText) ((Activity)context).findViewById(resID);
        tmpEditText.setText(value+" ");

        return tmpEditText;
    }

    public static EditText setEditTextTrim(Context context, String controlName, String value) {

        int resID = context.getResources().getIdentifier(controlName, "id", context.getPackageName());
        EditText tmpEditText = (EditText) ((Activity)context).findViewById(resID);
        tmpEditText.setText(value);

        return tmpEditText;
    }

    public static EditText setEditTextTrimDialog(View v, Context context, String controlName, String value) {

        int resID = context.getResources().getIdentifier(controlName, "id", context.getPackageName());
        EditText tmpEditText = (EditText) v.findViewById(resID);
        tmpEditText.setText(value);

        return tmpEditText;
    }

    public static List<EditTextValue> getEditTextVlaue(Context c, String controlName, int start_count, int end_count) {

        List<EditTextValue> etValues = new ArrayList<EditTextValue>();
        for (int i = start_count; i <= end_count; i++) {
            String cName = controlName + i;
            int resID = c.getResources().getIdentifier(cName, "id", c.getPackageName());
            EditText et = (EditText) ((Activity) c).findViewById(resID);
           // EditTextValue value = (EditTextValue) et.getText().toString();

           // Log.e("loop",i+"->"+et.getText().toString());
            EditTextValue value = new EditTextValue(et.getText().toString());
            etValues.add(value);
        }
        return etValues;
    }

    public static List<EditTextValue> getEditTextVlaueDialog(View v, Context c, String controlName, int start_count, int end_count) {

        List<EditTextValue> etValues = new ArrayList<EditTextValue>();
        for (int i = start_count; i <= end_count; i++) {
            String cName = controlName + i;
            int resID = c.getResources().getIdentifier(cName, "id", c.getPackageName());
            EditText et = (EditText) v.findViewById(resID);
            // EditTextValue value = (EditTextValue) et.getText().toString();

            // Log.e("loop",i+"->"+et.getText().toString());
            EditTextValue value = new EditTextValue(et.getText().toString());
            etValues.add(value);
        }
        return etValues;
    }



    public static CheckBox getCheckBox(Context context, String controlName) {

        int resID= context.getResources().getIdentifier(controlName, "id", context.getPackageName());
        CheckBox tmpCK = (CheckBox) ((Activity)context).findViewById(resID);

        return tmpCK;
    }

    public static CheckBox setCheckBox(Context context, String controlName, String value) {

        int resID = context.getResources().getIdentifier(controlName, "id", context.getPackageName());
        CheckBox tmpCk = (CheckBox) ((Activity)context).findViewById(resID);

        if(value.equalsIgnoreCase("1")){
            tmpCk.setChecked(true);
        }

        return tmpCk;
    }



    public static List<CheckboxValue> getCheckBoxVlaue(Context c, String controlName, int start_count, int end_count) {

        List<CheckboxValue> etValues = new ArrayList<CheckboxValue>();
        for (int i = start_count; i <= end_count; i++) {
            String cName = controlName + i;
            int resID = c.getResources().getIdentifier(cName, "id", c.getPackageName());
            CheckBox ck = (CheckBox) ((Activity) c).findViewById(resID);
            if(ck.isChecked()){
                CheckboxValue value = new CheckboxValue("1");
                etValues.add(value);
            }else{
                CheckboxValue value = new CheckboxValue("0");
                etValues.add(value);
            }

        }
        return etValues;
    }

    //Single value

    public static String getSingleSpinnerVlaue(List<SpinnerValue> sval){
        String data="";
        for (int j = 0; j < sval.size(); j++) {
            //Log.e("Spinner value", sval.get(j).displayText + "value is: " +sval.get(j).valueText);
            data = sval.get(j).valueText;
        }

        return data;
    }


    public static String getSingleEditTextVlaue(List<EditTextValue> etval){
        String data="";
        for (int i = 0; i < etval.size(); i++) {
            //Log.e("EditText value", etval.get(i).getValueText());
            data = etval.get(i).getValueText();
        }
        return data;
    }

    public static String getSingleCheckBoxVlaue(List<CheckboxValue> ckval){

        String data="";

        for (int i = 0; i < ckval.size(); i++) {
            //  Log.e("CheckBox value", ckval.get(i).getValueText());
            //Insert Unstructured DB
            data += ckval.get(i).getValueText()+",";

        }

        return data;
    }


    public static Spinner getSpinnerSelectedDialog(View v, Context c, String controlName, SpinnerValue[] spinnerValue, int poisition) {
        int resID = c.getResources().getIdentifier(controlName, "id", c.getPackageName());
        Spinner spinner = (Spinner) v.findViewById(resID);

        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(c, R.layout.spinner, spinnerValue);
        spinner.setAdapter(spinnerArrayAdapter);

        spinner.setSelection(getIndexFromObject(poisition,spinnerValue));

        return spinner;
    }

    public static Spinner getSpinnerSelectedDialog_bg(View v, Context c, String controlName, SpinnerValue[] spinnerValue, int poisition) {
        int resID = c.getResources().getIdentifier(controlName, "id", c.getPackageName());
        Spinner spinner = (Spinner) v.findViewById(resID);

        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(c, R.layout.spinner_drop, spinnerValue);
        spinner.setAdapter(spinnerArrayAdapter);

        spinner.setSelection(getIndexFromObject(poisition,spinnerValue));

        return spinner;
    }

    public static List<SpinnerValue> getSpinnerArrVlaueDialog(View v, Context c, String controlName, int startCount, int endCount) {
        List<SpinnerValue> spinnerValues = new ArrayList<SpinnerValue>();
        for (int i = startCount; i <= endCount; i++) {
            String cName = controlName + i;
            int resID = c.getResources().getIdentifier(cName, "id", c.getPackageName());
            Spinner spinner = (Spinner) v.findViewById(resID);
            SpinnerValue value = (SpinnerValue) spinner.getSelectedItem();
            spinnerValues.add(value);
        }
        return spinnerValues;
    }

}
