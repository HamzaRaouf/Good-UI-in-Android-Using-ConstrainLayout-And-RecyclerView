package com.example.myuitask.fragmens;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myuitask.R;
import com.example.myuitask.activities.ProfileActivity;
import com.example.myuitask.models.Transaction;
import com.example.myuitask.databinding.FragmentHomeBinding;
import com.example.myuitask.fragmens.viewModels.HomeViewModel;
import com.example.myuitask.models.Bills;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    public static final String TAG = HomeFragment.class.getName();

    List<Bills> list;
    List<Transaction> list2;
    private LinearLayoutManager linearLayoutManager;
    private LinearLayoutManager linearLayoutManager2;


    HomeViewModel viewModel;
    FragmentHomeBinding binding;
    private BillsAdaptor adapter;
    private MonthlyAdaptor adaptor2;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false);

        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        binding.setLifecycleOwner(this);
        binding.setHomeViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        startObserver();

        list.add(new Bills("18 Jun 2023","5,898"));
        list.add(new Bills("18 Jun 2023","5,898"));
        list.add(new Bills("18 Jun 2023","5,898"));
        list.add(new Bills("18 Jun 2023","5,898"));

        adapter = new BillsAdaptor(requireActivity(),this,list);
        linearLayoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.recyclerview.setLayoutManager(linearLayoutManager);
        binding.recyclerview.setAdapter(adapter);

        list2.add(new Transaction("Online Pay","18.6.2023","1500"));
        list2.add(new Transaction("Shopping","18.7.2023","1500"));
        list2.add(new Transaction("Online Pay","18.6.2023","1500"));
        list2.add(new Transaction("Design Pay","18.9.2023","1500"));
        list2.add(new Transaction("Shopping","18.11.2023","1500"));
        list2.add(new Transaction("Utility Bill","18.4.2023","1500"));

        adaptor2 = new MonthlyAdaptor(requireActivity(),this,list2);
        linearLayoutManager2 = new LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false);
        binding.rec.setLayoutManager(linearLayoutManager2);
        binding.rec.setAdapter(adaptor2);


    }

    private void startObserver() {
        viewModel.getClickActionMutableLiveData().observe(requireActivity(), clickActionObserver);
    }

    Observer<Integer> clickActionObserver = viewId -> {
        if(viewId == R.id.iv_photo) {
            Intent i = new Intent(getActivity(), ProfileActivity.class);
            startActivity(i);
        }
    };


}