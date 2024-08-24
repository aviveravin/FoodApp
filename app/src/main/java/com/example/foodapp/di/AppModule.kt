package com.example.foodapp.di

import com.example.foodapp.repository.Repository
import com.example.foodapp.repository.RepositoryImpl
import com.example.foodapp.service.ApiService
import com.example.foodapp.usecase.GetDishesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideDishApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://fls8oe8xp7.execute-api.ap-south-1.amazonaws.com/") // Replace with actual base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideDishRepository(apiService: ApiService): Repository {
        return RepositoryImpl(apiService)
    }

    @Provides
    fun provideGetDishesUseCase(repository: Repository): GetDishesUseCase {
        return GetDishesUseCase(repository)
    }
}
