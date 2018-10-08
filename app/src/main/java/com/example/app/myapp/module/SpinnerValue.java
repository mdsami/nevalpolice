package com.example.app.myapp.module;

/**
 * Created by stccon on 9/24/2017.
 */

public class SpinnerValue {
    public String displayText = "";
    public String valueText = "";
    public SpinnerValue(String displayText, String valueText)
    {
        this.displayText = displayText;
        this.valueText = valueText;
    }
    public String toString()
    {
        return( displayText );
    }


}
