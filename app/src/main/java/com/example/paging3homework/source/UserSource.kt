package com.example.paging3homework.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging3homework.model.UserInfo
import com.example.paging3homework.repository.MainRepository

class UserSource(
    private val mainRepository: MainRepository
) : PagingSource<Int, UserInfo.User>() {

    override fun getRefreshKey(state: PagingState<Int, UserInfo.User>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserInfo.User> {

        val page: Int = params.key ?: 1

        mainRepository.getUserInfo(page)?.let {
            return LoadResult.Page(
                it.data ?: emptyList(),
                if (page > 1) page - 1 else null,
                if (page < it.totalPages!!) page + 1 else null
            )
        }

        return LoadResult.Error(Exception())

    }
}