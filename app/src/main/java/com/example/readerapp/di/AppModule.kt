package com.example.readerapp.di

import com.example.readerapp.network.BooksApi
import com.example.readerapp.repository.BookRepository
import com.example.readerapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {
    @Singleton
    @Provides
    fun provideBookRepository(api:BooksApi) = BookRepository(api);
    @Singleton
    @Provides
    fun provideBookApi(): BooksApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BooksApi::class.java)

    }
}