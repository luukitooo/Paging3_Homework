package com.example.paging3homework.model

import com.google.gson.annotations.SerializedName

data class UserInfo(
    val page: Int?,
    @SerializedName("per_page")
    val perPage: Int?,
    val total: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    val data: List<User>?
) {
    data class User(
        val id: Int?,
        val email: String?,
        @SerializedName("first_name")
        val firstName: String?,
        @SerializedName("last_name")
        val lastName: String?,
        val avatar: String?
    )
}