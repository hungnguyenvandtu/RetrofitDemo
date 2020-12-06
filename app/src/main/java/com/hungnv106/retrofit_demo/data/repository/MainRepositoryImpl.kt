package com.hungnv106.retrofit_demo.data.repository

import com.hungnv106.retrofit_demo.data.api.ApiHelper
import com.hungnv106.retrofit_demo.data.model.User

data class MainRepositoryImpl(private val apiHelper: ApiHelper) : IRepository {

    override suspend fun getUsers(): List<User> = apiHelper.getUsers()
}