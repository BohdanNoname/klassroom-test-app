package ua.nedash.klassroom.second_task.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ua.nedash.klassroom.second_task.api.model.PostDto
import ua.nedash.klassroom.second_task.api.repository.PostRepository

private const val STARTING_PAGE_INDEX = 1

class PostsPagingSource(
    private val repository: PostRepository
) : PagingSource<Int, PostDto.Post>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PostDto.Post> {
        val pageIndex = params.key ?: STARTING_PAGE_INDEX

        val response = repository.getPosts(page = pageIndex)

        val posts = response.data?.posts ?: emptyList()

        val nextKey =
            if (posts.isEmpty()) {
                null
            } else {
                pageIndex + 1
            }

        return LoadResult.Page(
            data = posts,
            prevKey = if (pageIndex == STARTING_PAGE_INDEX) null else pageIndex,
            nextKey = nextKey
        )
    }

    override fun getRefreshKey(state: PagingState<Int, PostDto.Post>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}