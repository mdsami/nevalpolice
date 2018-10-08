package com.example.app.myapp.module;

/**
 * Created by stccon on 9/26/2017.
 */

public class CheckboxValue {

    public String valueText = "";

    public CheckboxValue(String valueText)
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
