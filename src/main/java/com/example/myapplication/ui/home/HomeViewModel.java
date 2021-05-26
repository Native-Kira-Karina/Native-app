package com.example.myapplication.ui.home;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<String> mText2;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText2 = new MutableLiveData<>();
        mText.setValue("This is home fragment");
        mText2.setValue("jjjj");
    }

    public LiveData<String> getText() {
        return mText;
    }
}