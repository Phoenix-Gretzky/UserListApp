package com.example.myapplication.data.api

import com.example.myapplication.data.model.ApiData
import com.example.myapplication.data.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

public interface UserService {

    @GET("users")
     suspend fun getUsers(@Query ("limit") limit:Int,@Query("skip") skip:Int ) :Response<ApiData>
    @GET("{id}")
     suspend fun getUsers(@Path ("id") id:Int):Response<User>
}