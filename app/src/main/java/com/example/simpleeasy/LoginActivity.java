package com.example.simpleeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    ImageButton imageButton;
    EditText editText1,editText2;
    TextView textView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        imageButton = findViewById(R.id.logInbtn);
        editText1 = findViewById(R.id.emailtxt);
        editText2 = findViewById(R.id.passtxt);
        textView=findViewById(R.id.txt_registeractivity);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "OK", Toast.LENGTH_SHORT).show();
                intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText1.getText().toString().isEmpty()&&editText2.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please fill the field", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "OK", Toast.LENGTH_SHORT).show();
                    intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}