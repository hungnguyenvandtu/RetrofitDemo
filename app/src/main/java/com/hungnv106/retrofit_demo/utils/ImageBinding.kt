package com.hungnv106.retrofit_demo.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    Glide.with(imageView.context).load(
        "https://www.thewowstyle.com/wp-content/uploads/2015/02/Beautiful-Wallpapers-14.jpg"
    ).into(imageView)
}