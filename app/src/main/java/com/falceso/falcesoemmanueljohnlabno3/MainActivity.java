package com.falceso.falcesoemmanueljohnlabno3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Button btn_save, btn_next;
    private EditText et_0, et_1, et_2,et_3, et_5, et_6, et_7, et_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_0 = findViewById(R.id.et_0);
        et_1 = findViewById(R.id.et_1);
        et_2 = findViewById(R.id.et_2);
        et_3 = findViewById(R.id.et_3);
        et_4 = findViewById(R.id.et_4);
        et_6 = findViewById(R.id.et_6);
        et_7 = findViewById(R.id.et_7);
        et_5 = findViewById(R.id.et_5);

        btn_save = findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer data = new StringBuffer();
                data.append(et_0.getText().toString() + ",");
                data.append(et_1.getText().toString() + ",");
                data.append(et_2.getText().toString() + ",");
                data.append(et_3.getText().toString() + ",");
                data.append(et_4.getText().toString() + ",");
                data.append(et_5.getText().toString() + ",");
                data.append(et_6.getText().toString() + ",");
                data.append(et_7.getText().toString());

                FileOutputStream writer = null;
                try {
                    writer = openFileOutput("data1.txt", MODE_PRIVATE);
                    writer.write(data.toString().getBytes());
                    Log.d("nigger",data.toString());
                    Toast.makeText(MainActivity.this, "File saved", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    Toast.makeText(MainActivity.this, "File not found.", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "IO Exception", Toast.LENGTH_SHORT).show();
                } finally {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity();
            }
        });
    }

    public void nextActivity(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
