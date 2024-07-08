package com.example.readerapp.network

import com.example.readerapp.data.Book
import com.example.readerapp.data.Item
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface BooksApi {
   @GET("volumes")
   suspend fun getAllBooks(@Query("q") query: String): Book

   @GET("volumes/{bookId}")
   suspend fun getBookInfo(@Query("id") bookId: String): Item
}