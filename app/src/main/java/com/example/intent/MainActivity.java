package com.example.intent;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    Button btnAct2,btnAct3,btnAct4;
    TextView tvREsults;
    final int ACTIVITY3=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.etName);
        btnAct2=findViewById(R.id.btnAct2);
        btnAct3=findViewById(R.id.btnAct3);
        btnAct4=findViewById(R.id.btnAct4);
        tvREsults=findViewById(R.id.tvResults);

        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(etName.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this, "Please enter all the fields!", Toast.LENGTH_SHORT).show();
            }
            else{
                String name=etName.getText().toString().trim();
                Intent intent=new Intent(MainActivity.this,com.example.intent.Activity2.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
            }
        });
        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(MainActivity.this,com.example.intent.Activity3.class);
            startActivityForResult(intent,ACTIVITY3);
            }
        });
        btnAct4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,com.example.intent.activity4.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ACTIVITY3){
            if(resultCode==RESULT_OK){
                tvREsults.setText(data.getStringExtra("surname"));

            }
            if(resultCode==RESULT_CANCELED){
                tvREsults.setText("No data REceived");
            }
        }
    }
}
