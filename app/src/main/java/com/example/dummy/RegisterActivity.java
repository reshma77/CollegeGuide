package com.example.dummy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dummy.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    TextView tv;
    DatabaseReference databaseReference;
    Random random = new Random();
    Calendar calendar;
    String date;
    RadioGroup rg;
    RadioButton rb;
    EditText etDate;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_register);
        databaseReference = FirebaseDatabase.getInstance().getReference("Profile");
        rg = findViewById(R.id.rg1);
        auth = FirebaseAuth.getInstance();
        tv = findViewById(R.id.text);

        //DateOfBirth
        calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        binding.date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        RegisterActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                month =month+1;
                                date = day+"/"+month+"/"+year;/**/
                                binding.date.setText(date);
                            }
                        },year,month,day);
                datePickerDialog.show();
            }
        });
    }

    public void register(View view) {
        final String umail = binding.email.getText().toString();
        final String upass = binding.pass.getText().toString();
        final String fname = binding.fname.getText().toString();
        final String lname = binding.lname.getText().toString();
        final String mobile = binding.mobile.getText().toString();
        final String image = "https://www.vhv.rs/dpng/d/433-4336634_thumb-image-android-user-icon-png-transparent-png.png";
        if(umail.isEmpty() | upass.isEmpty()){
            Toast.makeText(this, "Fill all the details", Toast.LENGTH_SHORT).show();
        }
        else if(upass.length() < 6){
            Toast.makeText(this, "Password must be 6 digits", Toast.LENGTH_SHORT).show();
        }
        else{
            auth.createUserWithEmailAndPassword(umail,upass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        int id = rg.getCheckedRadioButtonId();
                        rb = findViewById(id);
                        String gender = rb.getText().toString();
                        MyModel myModel = new MyModel(fname,lname,umail,mobile,date,gender,image);
                        //year+fnamefirstletterand lastletter+random(5digits)
                        String uid = String.valueOf(calendar.get(Calendar.YEAR)).substring(2)+fname.charAt(0)+fname.charAt(fname.length()-1)+random.nextInt(100000);
                        databaseReference.child(uid).setValue(myModel);
                        Toast.makeText(RegisterActivity.this, "Successfull", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        finish();
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}