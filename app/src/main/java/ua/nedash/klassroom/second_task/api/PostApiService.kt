package ua.nedash.klassroom.second_task.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ua.nedash.klassroom.second_task.api.model.PostDto

interface PostApiService {

    @GET("main/test")
    suspend fun getPosts(@Query("page") page: Int = 1): Response<PostDto>

}