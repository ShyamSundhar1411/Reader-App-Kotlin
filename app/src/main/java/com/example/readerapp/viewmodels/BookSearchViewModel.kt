package com.example.readerapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.readerapp.data.DataOrException
import com.example.readerapp.models.Item
import com.example.readerapp.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(private val repository: BookRepository): ViewModel() {
    val data: MutableState<DataOrException<List<Item>, Boolean, Exception>> = mutableStateOf(
        DataOrException(null, true, Exception(""))
    )
    init {
        searchBooks("flutter")
    }

    fun searchBooks(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (query.isEmpty()) return@launch
            data.value.loading = true
            data.value = repository.getBooks(query)
            if (data.value.data.toString().isNotEmpty()) data.value.loading = false
        }
    }
}