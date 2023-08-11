package com.example.myuitask.fragmens.viewModels;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class HomeViewModel extends AndroidViewModel {

    MutableLiveData<Integer> clickActionMutableLiveData;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        clickActionMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<Integer> getClickActionMutableLiveData() {
        return clickActionMutableLiveData;
    }

    public void onClick(View view) {
        clickActionMutableLiveData.setValue(view.getId());
    }

}
