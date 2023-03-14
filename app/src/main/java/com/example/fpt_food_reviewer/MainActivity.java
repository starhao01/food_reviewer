package com.example.fpt_food_reviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fpt_food_reviewer.dbcontext.DBContext;

public class MainActivity extends AppCompatActivity {

    private EditText edtPassword, edtUsername;
    private Button btnLogin, btnRegister;
    private DBContext db;

    public void bindingView(){
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        db = new DBContext(this);
    }
    public void bindingAction(){
        btnLogin.setOnClickListener(this::onBtnLoginClicked);
        btnRegister.setOnClickListener(this::onBtnRegisterClicked);
    }

    private void onBtnRegisterClicked(View view) {

    }

    private void onBtnLoginClicked(View view) {
        String userName = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();
        if(userName.isEmpty() || password.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please fill username and password",Toast.LENGTH_SHORT).show();
        }else{
            if(db.login(userName,password) == true){
                Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_SHORT).show();
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username",userName);
                editor.apply();
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
            }else{
                Toast.makeText(getApplicationContext(),"Wrong account",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindingView();
        bindingAction();
    }
}