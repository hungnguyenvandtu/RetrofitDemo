package com.hungnv106.retrofit_demo.ui.main.adapter

import android.content.Context
import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hungnv106.retrofit_demo.R
import com.hungnv106.retrofit_demo.data.model.User
import com.hungnv106.retrofit_demo.databinding.ItemLayoutBinding
import java.util.Collections.addAll

class MainAdapter(private val context: Context, private val users: ArrayList<User>) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {
    class DataViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.user = user
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        println("onCreateViewHolder đang được gọi")
        val layoutInflater = LayoutInflater.from(context)
        val binding: ItemLayoutBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_layout, parent, false)
        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun addUsers(users: List<User>) {
        this.users.apply {
            clear()
            addAll(users)
        }
    }
}