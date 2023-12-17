package com.example.myapplication.domain.network

import com.example.myapplication.data.api.UserService
import retrofit2.Retrofit

class Retrofit {

     var retrofitHelper: Retrofit
     var userService:UserService;
   init {
       retrofitHelper=RetrofitHelper.getInstance();
       userService=retrofitHelper.create(UserService::class.java)
   }



   suspend fun getUsers(limit:Int,skip:Int)
    {
        userService.getUsers(limit,skip)

    }

    suspend fun getUserDetails(position:Int)
    {
        userService.getUsers(position)
    }
}