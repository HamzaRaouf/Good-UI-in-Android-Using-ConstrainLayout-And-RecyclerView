package com.example.myuitask.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.myuitask.R;
import com.example.myuitask.databinding.ActivityProfileBinding;
import com.example.myuitask.fragmens.BillsAdaptor;
import com.example.myuitask.fragmens.GoalsAdaptor;
import com.example.myuitask.fragmens.viewModels.HomeViewModel;
import com.example.myuitask.fragmens.viewModels.ProfileViewModel;
import com.example.myuitask.models.Bills;
import com.example.myuitask.models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    RecyclerView rc;
    ProfileViewModel viewModel;
    ActivityProfileBinding binding;
    List<Bills> list;
    List<Transaction> list2;
    private GoalsAdaptor adapter;

    private LinearLayoutManager linearLayoutManager;
    private LinearLayoutManager linearLayoutManager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profile);

        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_profile, null, false);
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setProfileViewModel(viewModel);

//        rc = findViewById(R.id.recyclerview);
        list = new ArrayList<>();

        list.add(new Bills("Field visits are ideal for UX research even when carried out remotely","Doing Field Studies Remotly"));
        list.add(new Bills("Key design heuristics that every designer should know","10 design rules you must never beak "));
        list.add(new Bills("Field visits are ideal for UX research even when carried out remotely","Doing Field Studies Remotly"));
        list.add(new Bills("Key design heuristics that every designer should know","10 design rules you must never beak "));
        list.add(new Bills("Field visits are ideal for UX research even when carried out remotely","Doing Field Studies Remotly"));
        list.add(new Bills("Key design heuristics that every designer should know","10 design rules you must never beak "));

        adapter = new GoalsAdaptor(this,list);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.recyclerview.setLayoutManager(linearLayoutManager);
        binding.recyclerview.setAdapter(adapter);

        startObserver();

    }

    private void startObserver() {
        viewModel.getClickActionMutableLiveData().observe(this, clickActionObserver);
    }

    Observer<Integer> clickActionObserver = viewId -> {
        int colorwhite = ContextCompat.getColor(this, R.color.white);
        int black = ContextCompat.getColor(this, R.color.black);
        int orange = ContextCompat.getColor(this, R.color.orangebg);

        Drawable orangeDrawable = ContextCompat.getDrawable(this, R.drawable.orange_bg_new);
        Drawable lightOrangeDrawable = ContextCompat.getDrawable(this, R.drawable.light_orang_bg);


        // golas
        if(viewId == R.id.view4) {

         binding.view4.setBackground(orangeDrawable);
         binding.view7.setBackground(lightOrangeDrawable);
         binding.view6.setBackground(lightOrangeDrawable);

         binding.flagIcWhite.setColorFilter(colorwhite, PorterDuff.Mode.MULTIPLY);
         binding.goalsTxt.setTextColor(colorwhite);

         binding.courseIc.setColorFilter(orange, PorterDuff.Mode.MULTIPLY);
         binding.courseTxt.setTextColor(black);

         binding.testIc.setColorFilter(orange, PorterDuff.Mode.MULTIPLY);
         binding.testTxt.setTextColor(black);

        }  // course
        else if(viewId == R.id.view7) {

            binding.view4.setBackground(lightOrangeDrawable);
            binding.view7.setBackground(orangeDrawable);
            binding.view6.setBackground(lightOrangeDrawable);

            binding.flagIcWhite.setColorFilter(orange, PorterDuff.Mode.MULTIPLY);
            binding.goalsTxt.setTextColor(black);

            binding.courseIc.setColorFilter(colorwhite, PorterDuff.Mode.MULTIPLY);
            binding.courseTxt.setTextColor(colorwhite);

            binding.testIc.setColorFilter(orange, PorterDuff.Mode.MULTIPLY);
            binding.testTxt.setTextColor(black);

        }  // Test
        else if(viewId == R.id.view6) {

            binding.view4.setBackground(lightOrangeDrawable);
            binding.view7.setBackground(lightOrangeDrawable);
            binding.view6.setBackground(orangeDrawable);

            binding.flagIcWhite.setColorFilter(orange, PorterDuff.Mode.MULTIPLY);
            binding.goalsTxt.setTextColor(black);

            binding.courseIc.setColorFilter(orange, PorterDuff.Mode.MULTIPLY);
            binding.courseTxt.setTextColor(black);

            binding.testIc.setColorFilter(colorwhite, PorterDuff.Mode.MULTIPLY);
            binding.testTxt.setTextColor(colorwhite);

        }
    };
}