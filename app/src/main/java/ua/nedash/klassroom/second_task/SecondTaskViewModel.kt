package ua.nedash.klassroom.second_task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ua.nedash.klassroom.second_task.api.model.PostDto
import ua.nedash.klassroom.second_task.use_case.GetPosts
import javax.inject.Inject

@HiltViewModel
class SecondTaskViewModel @Inject constructor(
    private val getPosts: GetPosts
) : ViewModel() {

    fun getPosts(): Flow<PagingData<PostDto.Post>> {
        return getPosts.invoke().map { pagingData ->
            pagingData.map { post -> post }
        }.cachedIn(viewModelScope)
    }
}