package com.example.readerapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.readerapp.data.DataOrException
import com.example.readerapp.data.Resource
import com.example.readerapp.models.MBook
import com.example.readerapp.repository.BookRepository
import com.example.readerapp.repository.FireRepository
import com.google.firebase.firestore.FirebaseFirestoreException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: FireRepository
): ViewModel() {
    val data: MutableState<DataOrException<List<MBook>, Boolean, Exception>> = mutableStateOf(
        DataOrException(listOf(),true,Exception(""))
    )
    init{
        getAllBooksForDatabase()
    }

    private fun getAllBooksForDatabase() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllBooksFromDatabase()
            if(!data.value.data.isNullOrEmpty()) data.value.loading = false

        }

    }
}