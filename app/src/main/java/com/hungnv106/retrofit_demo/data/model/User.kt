package com.hungnv106.retrofit_demo.data.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("avatar")
    val image: String,
    @SerializedName("email")
    val userEmail: String,
    @SerializedName("id")
    val userId: String,
    @SerializedName("name")
    val userName: String
)
