package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.model.ApiData
import com.example.myapplication.data.model.User

public class UserViewModel (): ViewModel() {

     var mutableApiData:  MutableLiveData<ApiData?>?= MutableLiveData<ApiData?>()
    var observableApiData:  LiveData<ApiData?>?
    var mutableUserData:  MutableLiveData<User?>? =MutableLiveData<User?>()
     var observableUserData:  LiveData<User?>?

     init {
        observableUserData=mutableUserData
        observableApiData=mutableApiData
    }


    fun updateUserData(data: User?) {
        mutableUserData?.postValue( data)
    }


    fun updateApiData(data: ApiData?) {
        mutableApiData?.postValue(data)
    }

    override fun onCleared() {
        super.onCleared()
        mutableApiData?.value =null
        mutableUserData?.value =null
    }

}
