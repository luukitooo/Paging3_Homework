package com.example.paging3homework.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.RemoteMediator
import androidx.paging.cachedIn
import com.example.paging3homework.model.UserInfo
import com.example.paging3homework.repository.MainRepository
import com.example.paging3homework.source.UserSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {

    fun getUserInfo() = Pager(
        config = PagingConfig(pageSize = 1),
        pagingSourceFactory = { UserSource(MainRepository()) }
    ).flow

}