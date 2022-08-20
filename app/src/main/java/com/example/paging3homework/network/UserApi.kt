package com.example.paging3homework.network

import com.example.paging3homework.model.UserInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {

    @GET("api/users")
    suspend fun getUsers(@Query("page") page: Int): Response<UserInfo>

}