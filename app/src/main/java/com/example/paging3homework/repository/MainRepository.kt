package com.example.paging3homework.repository

import com.example.paging3homework.model.UserInfo
import com.example.paging3homework.network.RetrofitInstance

class MainRepository {

    suspend fun getUserInfo(page: Int): UserInfo? {
        val response = RetrofitInstance.getUserApi().getUsers(page)
        return if (response.isSuccessful && response.body() != null)
            response.body()!!
        else null
    }

}