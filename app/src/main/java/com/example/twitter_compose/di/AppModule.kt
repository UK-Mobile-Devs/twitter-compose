package com.example.twitter_compose.di

import com.example.twitter_compose.domain.repo.HomeRepository
import com.example.twitter_compose.domain.utils.SampleData
import com.example.twitter_compose.ui.home.HomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHomeRepository(sampleData: SampleData): HomeRepository =
        HomeRepositoryImpl(sampleData)

    @Provides
    fun provideSampleData() = SampleData

}
