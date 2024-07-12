package com.example.readerapp.repository

import android.util.Log
import com.example.readerapp.data.DataOrException
import com.example.readerapp.data.Resource
import com.example.readerapp.models.Item
import com.example.readerapp.network.BooksApi
import javax.inject.Inject

class BookRepository @Inject constructor(private val api: BooksApi){
    suspend fun getBooks(searchQuery: String): Resource<List<Item>> {
        return try {
            Resource.Loading(true)
            val itemList = api.getAllBooks(searchQuery).items
            if (itemList.isNotEmpty()) Resource.Loading(data = false)
            Resource.Success(itemList)

        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }

    suspend fun getBookInfo(bookId: String): Resource<Item>{
        val response = try{
            Resource.Loading(true)
            api.getBookInfo(bookId)

        }catch (e: Exception){
            Log.d("Network", "getBookInfo: ${e.message.toString()}")
            return Resource.Error(e.message.toString())
        }
        Resource.Loading(data = false)
       return  Resource.Success(response)
    }
}