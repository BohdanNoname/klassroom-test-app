package ua.nedash.klassroom.second_task.use_case

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ua.nedash.klassroom.second_task.api.model.PostDto
import ua.nedash.klassroom.second_task.api.repository.PostRepository
import ua.nedash.klassroom.second_task.paging.PostsPagingSource

class GetPosts(
    private val repository: PostRepository
) {

    operator fun invoke(): Flow<PagingData<PostDto.Post>> {
        return Pager(
            config = PagingConfig(
                pageSize = 50,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                PostsPagingSource(repository = repository)
            }
        ).flow
    }
}