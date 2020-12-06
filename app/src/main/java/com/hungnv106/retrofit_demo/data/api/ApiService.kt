package com.hungnv106.retrofit_demo.data.api

import com.hungnv106.retrofit_demo.data.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}