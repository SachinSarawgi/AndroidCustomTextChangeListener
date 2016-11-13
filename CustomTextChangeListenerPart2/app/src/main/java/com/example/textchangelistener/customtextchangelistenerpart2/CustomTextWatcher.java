package com.example.textchangelistener.customtextchangelistenerpart2;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by SachinSarawgi on 13-11-2016.
 */

public class CustomTextWatcher implements TextWatcher {

    private EditText editText;
    private TextView textView;
    private String previous = "";
    private String actualText = "";

    public CustomTextWatcher(EditText editText, TextView textView){

        this.editText = editText;
        this.textView = textView;
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        String temp = editText.getText().toString();
        if(temp.length()>previous.length()){
            if(temp.charAt(temp.length()-1)=='\n'){
                actualText = actualText + "EN,";
            }else{
                actualText = actualText + temp.charAt(temp.length()-1)+",";
            }
        }else if(temp.length()==previous.length()) {

        }else{
            actualText = actualText + "BS,";
        }
        previous = temp;
        textView.setText(actualText);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
