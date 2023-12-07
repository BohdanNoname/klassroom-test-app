package ua.nedash.klassroom.second_task.api.repository

import ua.nedash.klassroom.second_task.api.model.ApiResponse
import ua.nedash.klassroom.second_task.api.model.PostDto

interface PostRepository {
    suspend fun getPosts(page: Int): ApiResponse<PostDto>
}