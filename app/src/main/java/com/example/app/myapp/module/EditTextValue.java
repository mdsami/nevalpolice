package com.example.app.myapp.module;

/**
 * Created by stccon on 9/25/2017.
 */

public class EditTextValue {

    public String valueText = "";

    public EditTextValue(String valueText)
    {
        this.valueText = valueText;
    }

    public String getValueText() {
        return valueText;
    }

    public void setValueText(String valueText) {
        this.valueText = valueText;
    }

    public String toString()
    {
        return( valueText );
    }

}
