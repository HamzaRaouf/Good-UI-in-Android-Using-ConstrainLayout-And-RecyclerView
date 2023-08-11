package com.example.myuitask.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.myuitask.R;
import com.example.myuitask.fragmens.HomeFragment;

public class MainActivity extends AppCompatActivity {
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragment = getSupportFragmentManager().findFragmentByTag(HomeFragment.TAG);
        if (fragment == null)
            fragment = Fragment.instantiate(this, HomeFragment.TAG, getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, HomeFragment.TAG).commit();

    }
}