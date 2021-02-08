package com.example.safealert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class InMyAppIntro extends com.github.paolorotolo.appintro.AppIntro {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.newInstance("Welcome to Safe Alert", "Know the crime rate of your area",
                R.drawable.logo1, ContextCompat.getColor(getApplicationContext(),R.color.firstColor)));

        addSlide(AppIntroFragment.newInstance("Safer you safer the country", "Know the Police station",
                R.drawable.mlogo, ContextCompat.getColor(getApplicationContext(),R.color.secondColor)));

        addSlide(AppIntroFragment.newInstance("Use All features", "Get Started!",
                R.drawable.blackimg, ContextCompat.getColor(getApplicationContext(),R.color.thirdColor)));

        sharedPreferences = getApplicationContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if(sharedPreferences != null) {
            boolean checkshared = sharedPreferences.getBoolean("checkStated",false);

            if(checkshared == true) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        }

    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        editor.putBoolean("checkStated",false).commit();
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);

        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        editor.putBoolean("checkStated",true).commit();
        finish();
    }
}