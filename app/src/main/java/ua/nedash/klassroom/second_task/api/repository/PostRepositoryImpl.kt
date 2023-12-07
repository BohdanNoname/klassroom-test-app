package ua.nedash.klassroom.second_task.api.repository

import ua.nedash.klassroom.second_task.api.PostApiService
import ua.nedash.klassroom.second_task.api.utils.makeApiRequest

class PostRepositoryImpl(
    private val postApiService: PostApiService
) : PostRepository {

    override suspend fun getPosts(page: Int) = makeApiRequest { postApiService.getPosts(page) }

}