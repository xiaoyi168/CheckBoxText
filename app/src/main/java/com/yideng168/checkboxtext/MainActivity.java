package com.yideng168.checkboxtext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.yideng168.checkboxtextlibrary.CheckBoxTexView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /*   CheckBoxTexView checkBoxTexView= (CheckBoxTexView) findViewById(R.id.id_checkbox_textview);
        checkBoxTexView.setOnCheckedChangeListener(new CheckBoxTexView.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(boolean isChecked) {

                Log.d("MainActivity", "isChecked:" + isChecked);

            }
        });*/
    }
}
