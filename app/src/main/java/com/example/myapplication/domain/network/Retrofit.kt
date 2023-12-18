package com.example.myapplication.domain.network

import com.example.myapplication.data.api.UserService
import com.example.myapplication.data.model.ApiData
import com.example.myapplication.viewmodel.UserViewModel
import retrofit2.Retrofit

class Retrofit(var userViewModel: UserViewModel) {

    private var retrofitHelper: Retrofit = RetrofitHelper.getInstance()
    var userService: UserService = retrofitHelper.create(UserService::class.java);


    suspend fun getUsers(limit: Int, skip: Int) {
        try {
           var data:ApiData?= userService.getUsers(limit, skip).body()
            userViewModel.updateApiData(data)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    suspend fun getUserDetails(position: Int) {
        try {
            userViewModel.updateUserData(userService.getUsers(position).body())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}