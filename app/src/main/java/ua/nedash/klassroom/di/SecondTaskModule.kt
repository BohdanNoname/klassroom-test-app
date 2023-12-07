package ua.nedash.klassroom.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ua.nedash.klassroom.second_task.api.PostApiService
import ua.nedash.klassroom.second_task.api.repository.PostRepository
import ua.nedash.klassroom.second_task.api.repository.PostRepositoryImpl
import ua.nedash.klassroom.second_task.use_case.GetPosts
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SecondTaskModule {

    @Provides
    @Singleton
    fun providesPostRepository(apiService: PostApiService): PostRepository {
        return PostRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun providesGetPhotos(repository: PostRepository) = GetPosts(repository)

}