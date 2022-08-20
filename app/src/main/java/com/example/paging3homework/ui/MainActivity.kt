package com.example.paging3homework.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paging3homework.databinding.ActivityMainBinding
import com.example.paging3homework.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val userAdapter by lazy { UserAdapter() }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        observers()

    }

    private fun init() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter.withLoadStateFooter(
                footer = UserLoadStateAdapter()
            )
        }
    }

    private fun observers() {
        lifecycleScope.launch {
            viewModel.getUserInfo().collect {
                userAdapter.submitData(it)
            }
        }
    }

}