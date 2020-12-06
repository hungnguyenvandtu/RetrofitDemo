package com.hungnv106.retrofit_demo.data.repository

import com.hungnv106.retrofit_demo.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getUsers()
}