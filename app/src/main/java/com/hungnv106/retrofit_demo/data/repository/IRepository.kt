package com.hungnv106.retrofit_demo.data.repository

import com.hungnv106.retrofit_demo.data.model.User

interface IRepository {
    suspend fun getUsers() : List<User>
}