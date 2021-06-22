package com.example.dummy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class HomeActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sharedPreferences = getSharedPreferences("usertype",MODE_PRIVATE);
    }


    public void login(View view) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("type","login");
        editor.commit();

        startActivity(new Intent(HomeActivity.this, LoginActivity.class));
    }
    public void register(View view) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("type","register");
        editor.commit();

        startActivity(new Intent(HomeActivity.this, RegisterActivity.class));
    }
    /*
    public void admin(View view) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("type","admin");
        editor.commit();
        startActivity(new Intent(HomeActivity.this,AdminLogin.class));
    }
    public void learn(View view) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("type","learn");
        editor.commit();
        startActivity(new Intent(HomeActivity.this,Dashboard2.class));
    }

     */


}