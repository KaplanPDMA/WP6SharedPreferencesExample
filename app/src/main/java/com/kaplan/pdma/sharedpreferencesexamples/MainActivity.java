package com.kaplan.pdma.sharedpreferencesexamples;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextName = (EditText) findViewById(R.id.editTextName);
        final EditText editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        Button button = (Button) findViewById(R.id.button);
        final TextView textView = (TextView) findViewById(R.id.textView);

        final SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        //read data from phone storage
        String name = sp.getString("name", null);
        String phone = sp.getString("phone", null);
        if(name != null && phone != null) {
            textView.setText(name + ": " + phone);
        } else {
            textView.setText("user data not yet input");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                String phone = editTextPhone.getText().toString();
                if(name.length() > 0 && phone.length() > 0) {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("name", name);
                    editor.putString("phone", phone);
                    editor.commit();
                    textView.setText(name + ": " + phone);
                } else {
                    Toast.makeText(MainActivity.this, "please input name and phone",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
