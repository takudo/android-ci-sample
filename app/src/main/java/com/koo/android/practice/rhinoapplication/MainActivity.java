package com.koo.android.practice.rhinoapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        Button runBtn = (Button) findViewById(R.id.btn_run);
        runBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get Text
                EditText editText = (EditText) findViewById(R.id.edit_text);
                Editable editable = editText.getText();
                String scripts = editable.toString();

                //run js
                RhinoSample rhino = new RhinoSample();
                rhino.runJavaScript(scripts);
            }
        });
    }
}
