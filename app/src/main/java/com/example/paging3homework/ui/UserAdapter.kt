package com.example.paging3homework.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.paging3homework.R
import com.example.paging3homework.databinding.UserItemBinding
import com.example.paging3homework.model.UserInfo

class UserAdapter: PagingDataAdapter<UserInfo.User, UserAdapter.UserViewHolder>(UserItemCallback) {

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        UserItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    inner class UserViewHolder(private val binding: UserItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val user = getItem(bindingAdapterPosition)
            binding.apply {
                Glide.with(binding.root)
                    .load(user?.avatar ?: "")
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ivUser)
                tvIdentity.text = user?.firstName.plus(" ").plus(user?.lastName)
                tvEmail.text = user?.email
            }
        }
    }

    private object UserItemCallback: DiffUtil.ItemCallback<UserInfo.User>() {
        override fun areItemsTheSame(oldItem: UserInfo.User, newItem: UserInfo.User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserInfo.User, newItem: UserInfo.User): Boolean {
            return oldItem == newItem
        }
    }

}