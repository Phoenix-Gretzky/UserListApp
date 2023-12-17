package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.model.ApiData
import com.example.myapplication.data.model.User

class UserViewModel (application: Application): AndroidViewModel(application) {

    lateinit var mutableApiData:  MutableLiveData<ApiData>
     var observableApiData:  LiveData<ApiData>
    lateinit var mutableUserData:  MutableLiveData<User>
     var observableUserData:  LiveData<User>

    init {
        observableUserData=mutableUserData
        observableApiData=mutableApiData
    }


    fun setApiData(apiData:  ApiData)
    {
        this.mutableApiData.value=apiData;
    }
    fun setUserData(userData:  User)
    {
        this.mutableUserData.value=userData;
    }
}
