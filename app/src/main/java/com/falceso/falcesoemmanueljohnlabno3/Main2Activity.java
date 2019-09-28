package com.falceso.falcesoemmanueljohnlabno3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class Main2Activity extends AppCompatActivity {


    private LinearLayout ver_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        StringBuffer schools = new StringBuffer();
        FileInputStream fileInputStream = null;

        try{
            fileInputStream = openFileInput("data1.txt");
            int token;

            while((token=fileInputStream.read()) != -1){
                schools.append((char)token);
                Log.d("school",schools.toString());
            }
        } catch (FileNotFoundException e) {
            Toast.makeText(this, "File not Found", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "IOException found", Toast.LENGTH_SHORT).show();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ver_layout = findViewById(R.id.ver_layout);
        String str[] = schools.toString().split(",");
        for (int i = 0; i < str.length; i++){
            if(!str[i].equals("")){
                Button btnTag = new Button(this);
                btnTag.setText(str[i]);
                btnTag.setId(i);
                ver_layout.addView(btnTag);
            }
        }

        Button btn_prev = new Button(this);
        btn_prev.setText("Previous");
        ver_layout.addView(btn_prev);
        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prevActivity();
            }
        });



    }
    public void prevActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
