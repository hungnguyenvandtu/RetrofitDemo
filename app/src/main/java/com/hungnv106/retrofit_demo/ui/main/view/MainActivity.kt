package com.hungnv106.retrofit_demo.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hungnv106.retrofit_demo.R
import com.hungnv106.retrofit_demo.data.api.ApiHelper
import com.hungnv106.retrofit_demo.data.api.RetrofitBuilder
import com.hungnv106.retrofit_demo.data.model.User
import com.hungnv106.retrofit_demo.databinding.ActivityMainBinding
import com.hungnv106.retrofit_demo.ui.base.ViewModelFactory
import com.hungnv106.retrofit_demo.ui.main.adapter.MainAdapter
import com.hungnv106.retrofit_demo.ui.main.viewmodel.MainViewModel
import com.hungnv106.retrofit_demo.utils.Status

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupUI()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.getUsers().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        println("Load data thành công")
                        binding.recyclerView.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        resource.data?.let { users -> retrieveList(users) }
                    }
                    Status.ERROR -> {
                        binding.recyclerView.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun setupUI() {
//        binding.recyclerView.apply {
//            layoutManager = LinearLayoutManager(this.context)
//            addItemDecoration(DividerItemDecoration(this.context, LinearLayoutManager.VERTICAL))
//            adapter = MainAdapter(this.context, arrayListOf())
//        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.hasFixedSize()
        adapter = MainAdapter(this, arrayListOf())
        binding.recyclerView.adapter = adapter
    }


    private fun retrieveList(users: List<User>) {
        adapter.apply {
            addUsers(users)
            notifyDataSetChanged()
        }
    }
}