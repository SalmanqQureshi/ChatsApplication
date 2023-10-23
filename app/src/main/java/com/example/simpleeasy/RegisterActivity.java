package com.example.simpleeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {

    TextView textView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        textView=findViewById(R.id.txt_loginactivity);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "OK", Toast.LENGTH_SHORT).show();
                intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });

    }
}