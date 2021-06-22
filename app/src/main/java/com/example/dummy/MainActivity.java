package com.example.dummy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences,preferences1,preferences2;
    ImageView ivLogo,ivBottom;
    TextView textView;
    CharSequence charSequence;
    int index;
    long delay = 2000;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        }, 5000);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.replace(R.id.frameLayout, new LogoutFragment()).commit();
        preferences=getSharedPreferences("dailog",MODE_PRIVATE);
        preferences1=getSharedPreferences("usertype",MODE_PRIVATE);
        preferences2=getSharedPreferences("Data",MODE_PRIVATE);
        String dailog = preferences.getString("dlg",null);
        String usertype = preferences1.getString("type",null);
        String profile = preferences2.getString("profile",null);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (dailog==null){
                    startActivity(new Intent(MainActivity.this, HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    finish();
                }
                else if (dailog.equals("1")){
                    if(usertype == null) {
                        startActivity(new Intent(MainActivity.this,HomeActivity.class));
                        finish();
                    }
                    else if(usertype.equals("register")) {
                        startActivity(new Intent(MainActivity.this,RegisterActivity.class));
                        finish();
                    }
                    else if(usertype.equals("login")) {
                        startActivity(new Intent(MainActivity.this,LoginActivity.class));
                        finish();
                    }
                    else {
                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    }
                }
            }
        }, 3000);

        ivLogo = findViewById(R.id.iv_logo);
        //ivBottom= findViewById(R.id.iv_bottom);
        textView = findViewById(R.id.text_view);

        //set fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                ,WindowManager.LayoutParams.FLAG_FULLSCREEN)  ;

        //start top animation
        //initialize object animator
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(
                ivLogo,
                PropertyValuesHolder.ofFloat("scaleX",1.2f),
                PropertyValuesHolder.ofFloat("scaleY",1.2f)
        );
        //set duration
        objectAnimator.setDuration(500);
        //set repeat count
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        //set repeat mode
        objectAnimator.setRepeatCount(ValueAnimator.REVERSE);
        //start animator
        objectAnimator.start();

        animateText("College Guide");
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            textView.setText(charSequence.subSequence(0,index++));
            if(index<=charSequence.length()){
                handler.postDelayed(runnable,delay);
            }
        }
    };
    public void animateText(CharSequence cs){
        charSequence = cs;
        index = 0;
        textView.setText("College Guide");
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable,delay);
    }
}