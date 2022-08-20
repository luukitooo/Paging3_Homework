package com.example.paging3homework.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3homework.databinding.LoaderItemBinding

class UserLoadStateAdapter: LoadStateAdapter<UserLoadStateAdapter.LoadStateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState) = LoadStateViewHolder(
        LoaderItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    class LoadStateViewHolder(private val binding: LoaderItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(loadState: LoadState) {
            binding.root.isVisible = loadState is LoadState.Loading
        }
    }
}