package com.example.jayvee.hmpgrub;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextView txtLogin;
    EditText txtUsername, pwdPassword, txtFname, txtLname, txtContact, txtEmail, txtBday;
    Button btnRegister;
    Spinner cboGender;
    Calendar calendar;

    String selected_gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.txtUsername = this.findViewById(R.id.editText);
        this.pwdPassword = this.findViewById(R.id.editText1);
        this.txtFname = this.findViewById(R.id.editText2);
        this.txtLname = this.findViewById(R.id.editText3);
        this.txtBday = this.findViewById(R.id.editTextBday);
        this.cboGender = this.findViewById(R.id.spinner);
        this.txtContact = this.findViewById(R.id.editText4);
        this.txtEmail = this.findViewById(R.id.editText5);
        this.txtLogin = this.findViewById(R.id.textView1);
        this.btnRegister = this.findViewById(R.id.button);

        calendar = Calendar.getInstance();

        this.txtBday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(RegisterActivity.this, RegisterActivity.this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });

        this.cboGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected_gender = cboGender.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        this.txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LogIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(LogIntent);
            }
        });

        this.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!txtUsername.getText().toString().trim().equalsIgnoreCase("") && !pwdPassword.getText().toString().trim().equalsIgnoreCase("") && !txtFname.getText().toString().trim().equalsIgnoreCase("") && !txtLname.getText().toString().trim().equalsIgnoreCase("") && !selected_gender.equals("")  && !txtBday.getText().toString().equals("") && !txtContact.getText().toString().trim().equalsIgnoreCase("") && !txtEmail.getText().toString().trim().equalsIgnoreCase("")) {
                    HMPGrubDatabase db = new HMPGrubDatabase(RegisterActivity.this);
                    ArrayList<Customer> list = db.getAllCustomer();

                    if(!list.isEmpty()) {
                        Boolean isEqualToUsername = false;

                        for(int index=0; index<list.size(); index++) {
                            if (list.get(index).getCustomer_username().toLowerCase().equals(txtUsername.getText().toString().toLowerCase())) {
                                isEqualToUsername = true;
                                break;
                            }
                        }

                        if(!isEqualToUsername) {
                            db.addCustomer(txtFname.getText().toString(), txtLname.getText().toString(), "customer_gender", "customer_bday", txtEmail.getText().toString(), txtContact.getText().toString(), txtUsername.getText().toString().toLowerCase(), pwdPassword.getText().toString(), "cust_state");
                            db.deleteAllLoggedInCustomer();
                            db.addLoggedInCustomer(txtFname.getText().toString(), txtLname.getText().toString(), "customer_gender", "customer_bday", txtEmail.getText().toString(), txtContact.getText().toString(), txtUsername.getText().toString().toLowerCase(), pwdPassword.getText().toString(), "cust_state");

                            Toast.makeText(RegisterActivity.this, "User Successfully Registered", Toast.LENGTH_LONG).show();
                            Intent regIntent = new Intent(RegisterActivity.this, NavigationDrawer.class);
                            startActivity(regIntent);
                        } else {
                            Toast.makeText(RegisterActivity.this, "Username " + txtUsername.getText().toString().toLowerCase() + " has already been taken", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        db.addCustomer(txtFname.getText().toString(), txtLname.getText().toString(), "customer_gender", "customer_bday", txtEmail.getText().toString(), txtContact.getText().toString(), txtUsername.getText().toString().toLowerCase(), pwdPassword.getText().toString(), "cust_state");
                        db.deleteAllLoggedInCustomer();
                        db.addLoggedInCustomer(txtFname.getText().toString(), txtLname.getText().toString(), "customer_gender", "customer_bday", txtEmail.getText().toString(), txtContact.getText().toString(), txtUsername.getText().toString().toLowerCase(), pwdPassword.getText().toString(), "cust_state");

                        Toast.makeText(RegisterActivity.this, "User Successfully Registered", Toast.LENGTH_LONG).show();
                        Intent regIntent = new Intent(RegisterActivity.this, NavigationDrawer.class);
                        startActivity(regIntent);
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Please Fill all fields", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        calendar.set(Calendar.YEAR, i);
        calendar.set(Calendar.MONTH, (i1+1));
        calendar.set(Calendar.DAY_OF_MONTH, i2);
        updateLabel();
    }

    private void updateLabel() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy", Locale.ENGLISH);

        txtBday.setText(sdf.format(calendar.getTime()));
    }
}
