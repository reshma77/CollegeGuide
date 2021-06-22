package com.example.dummy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class Dashboard extends AppCompatActivity {

    RecyclerView rcv;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        rcv = (RecyclerView) findViewById(R.id.recview);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MyAdapter(dataqueue(), getApplicationContext());
        rcv.setAdapter(adapter);

    }

    public ArrayList<Model> dataqueue()
    {
        ArrayList<Model> holder=new ArrayList<>();
        //InfoActivity ob = new InfoActivity();
        Model ob1=new Model();
        ob1.setHeader("Jawaharlal Nehru Technological University");
        ob1.setDesc("Kakinada\n" +
                "Hostel Availability : Yes\n" +
                "Branches : CE,CSE,IT,EEE,ECE,MEC, Chemical Engineering\n" +
                ",Bio-medical engineering, Elections and control engineering,\n" +
                " electronic and computer engineering, Mining , Automobile,\n" +
                " petroleum engineering, metallurgical,power and aircraft engineering.\n" +
                "Training programs : NIL\n" +
                "Placement % rate : 75%");
        //ob.link1(null);
        ob1.setImgname(R.drawable.c1);
        //ob1.setImgname2(R.drawable.info4);
        holder.add(ob1);

        Model ob3=new Model();
        ob3.setHeader("Andhra University");
        ob3.setDesc("Vishakapatnam\n" +
                "Hostel Availability : Yes\n" +
                "Branches : CE,CSE,IT,EEE,ECE,MEC, Chemical Engineering, \n" +
                "Biotechnology, Marine engineering, Metallurgical engineering,\n" +
                " Ceramic engineering,Geo-Informatics, Instrumentation engineering.\n" +
                "Training programs : NIL\n" +
                "Placement % rate : 75%");
        ob3.setImgname(R.drawable.c3);
        //ob1.setImgname2(R.drawable.info3);;
        holder.add(ob3);

        Model ob4=new Model();
        ob4.setHeader("Sri Venkateswara College of Engineering");
        ob4.setDesc("Tirupati\n" +
                "Hostel Availability : Yes\n" +
                "Branches : CE,CSE,IT,EEE,ECE,MEC,\n" +
                "Chemical Engineering, Biotechnology, Automobile engineering ,\n" +
                "marine engineering.\n" +
                "Training programs : NIL\n" +
                "Placement % rate : 96.20%");
        ob4.setImgname(R.drawable.c4);
        //ob1.setImgname2(R.drawable.info2);
        holder.add(ob4);

        Model ob5=new Model();
        ob5.setHeader("Shri Vishnu Engineering College for Women");
        ob5.setDesc("Bhimavaram\n" +
                "Hostel Availability : Yes\n" +
                "Branches:CSE,IT,CE,MEC,EEE,ECE\n" +
                "Training programs: WISE,CNDS,NASCOM,IOT,\n" +
                "ICT-DXC\n" +
                "Placement % rate : 120%");
        ob5.setImgname(R.drawable.c5);
        //ob1.setImgname2(R.drawable.info5);
        holder.add(ob5);

        Model ob7=new Model();
        ob7.setHeader("GVP College of Engineering");
        ob7.setDesc("Vishakapatnam\n" +
                "Hostel Availability : Yes\n" +
                "Branches : CE,CSE,IT,EEE,ECE,MEC, Chemical Engineering.\n" +
                "Training programs : Cse(AI,Data Science, Machine learning)\n" +
                "ME(Robotics)\n" +
                "Placement % rate : 80%\n");
        ob7.setImgname(R.drawable.c7);
        //ob1.setImgname2(R.drawable.info1);
        holder.add(ob7);

        /*
        Model ob6=new Model();
        ob6.setHeader("Aditya Engineering College");
        ob6.setDesc("Surampalem");
        ob6.setImgname(R.drawable.c6);
        holder.add(ob6);

        Model ob2=new Model();
        ob2.setHeader("KL University");
        ob2.setDesc("Guntur");
        ob2.setImgname(R.drawable.c2);
        holder.add(ob2);

        Model ob8=new Model();
        ob8.setHeader("SRKR Engineering College");
        ob8.setDesc("Bhimavaram");
        ob8.setImgname(R.drawable.c8);
        holder.add(ob8);

        Model ob9=new Model();
        ob9.setHeader("GMR Institute of Technology");
        ob9.setDesc("Rajam");
        ob9.setImgname(R.drawable.c9);
        holder.add(ob9);

        Model ob10=new Model();
        ob10.setHeader("Godavari Institute of Engineering and Technology");
        ob10.setDesc("Rajahmundry");
        ob10.setImgname(R.drawable.c10);
        holder.add(ob10);

        Model ob11=new Model();
        ob11.setHeader("Acharya Nagarjuna University");
        ob11.setDesc("Guntur");
        ob11.setImgname(R.drawable.c11);
        holder.add(ob11);
    */

        return holder;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    /*
    public void link1(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.jntuk.edu.in/"));
        startActivity(browserIntent);
    }
    public void link2(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.andhrauniversity.edu.in/"));
        startActivity(browserIntent);
    }
    public void link3(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.svcolleges.edu.in/"));
        startActivity(browserIntent);
    }
    public void link4(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gvpce.ac.in/"));
        startActivity(browserIntent);
    }
    public void link5(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.svecw.edu.in/"));
        startActivity(browserIntent);
    }*/
    public void logout(){
        //Log.d(TAG,"logOut: logging out...");
        //user.setValue(AuthResource.<~>logout());
        Toast.makeText(this,"Bye!!!",Toast.LENGTH_SHORT).show();
    }
}