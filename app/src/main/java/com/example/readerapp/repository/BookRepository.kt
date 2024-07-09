package com.example.readerapp.repository

import com.example.readerapp.data.DataOrException
import com.example.readerapp.models.Item
import com.example.readerapp.network.BooksApi
import javax.inject.Inject

class BookRepository @Inject constructor(private val api: BooksApi){
    private val data = DataOrException<List<Item>,Boolean,Exception>()
    private val bookInfoData = DataOrException<Item,Boolean,Exception>()
    suspend fun getBooks(searchQuery: String): DataOrException<List<Item>,
            Boolean,Exception>{
            try{
                data.loading = true
                data.data = api.getAllBooks(searchQuery).items
                if(data.data.toString().isNotEmpty()){
                    data.loading = false
                }
            }catch(e:Exception){
                data.e = e
            }
        return data
    }
    suspend fun getBookInfo9(bookId: String): DataOrException<Item,Boolean,Exception>{
        val response = try{
            bookInfoData.loading = true
            bookInfoData.data = api.getBookInfo(bookId)
            if(bookInfoData.data.toString().isNotEmpty()){
                bookInfoData.loading = false
            } else {

            }
        }catch(e:Exception){
            bookInfoData.e = e
        }
        return bookInfoData
    }
}