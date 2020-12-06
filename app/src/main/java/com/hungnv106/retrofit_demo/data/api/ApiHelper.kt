package com.hungnv106.retrofit_demo.data.api

// Tạo một API Helper class để giúp chúng ta call api
class ApiHelper(private val apiService: ApiService) {
    suspend fun getUsers() = apiService.getUsers()
}