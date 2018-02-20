package com.example.jayvee.hmpgrub;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    TextView txtForgotPass;
    EditText txtUsername, pwdPassword;
    HMPGrubDatabase mDatabase;
    ArrayList<Customer> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.mDatabase = new HMPGrubDatabase(this);
        this.list = mDatabase.getAllCustomer();

        this.btnLogin = this.findViewById(R.id.button);
        this.txtUsername = this.findViewById(R.id.editText);
        this.pwdPassword = this.findViewById(R.id.editText1);
        this.txtForgotPass = this.findViewById(R.id.textView);

        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean isNotBlank = false;
                Boolean isEqualToUsername = false;

                if(!txtUsername.getText().toString().trim().equals("") && !pwdPassword.getText().toString().equals("")) {
                    isNotBlank = true;

                    for(int index=0; index<list.size(); index++) {
                        if(list.get(index).getCustomer_username().toLowerCase().equals(txtUsername.getText().toString().toLowerCase())) {
                            isEqualToUsername = true;

                            if(list.get(index).getCustomer_password().equals(pwdPassword.getText().toString())) {
                                txtUsername.setText("");
                                pwdPassword.setText("");

                                mDatabase.deleteAllLoggedInCustomer();
                                mDatabase.addLoggedInCustomer(list.get(index).getCustomer_fname(), list.get(index).getCustomer_lname(), list.get(index).getCustomer_gender(), list.get(index).getCustomer_bday(), list.get(index).getCustomer_email(), list.get(index).getCustomer_contact(), list.get(index).getCustomer_username().toLowerCase(), list.get(index).getCustomer_password(), list.get(index).getCust_state());
                                Toast.makeText(LoginActivity.this, "Hello " + list.get(index).getCustomer_fname() + " " + list.get(index).getCustomer_lname(), Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this, NavigationDrawer.class);
                                startActivity(intent);
                                break;
                            } else {
                                Toast.makeText(LoginActivity.this, "Password Incorrect", Toast.LENGTH_LONG).show();
                                break;
                            }
                        }
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Fill all fields", Toast.LENGTH_LONG).show();
                }

                if(!isEqualToUsername && isNotBlank) {
                    Toast.makeText(LoginActivity.this, "Username not registered", Toast.LENGTH_LONG).show();
                }
            }
        });

        this.txtForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Sorry for Inconvenience! Under Construction", Toast.LENGTH_LONG).show();
            }
        });
    }
}