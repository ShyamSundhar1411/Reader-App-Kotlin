package com.example.readerapp.viewmodels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.readerapp.models.MUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AuthViewModel: ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading
    fun signInWithEmailAndPassword(email: String, password: String, home: () -> Unit) {
        try {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        _loading.value = false
                        home()
                    } else {
                        _loading.value = false
                    }
                }
        } catch (ex: Exception) {
            Log.e(TAG, ex.message.toString())
        }
    }

    fun createUserWithEmailAndPassword(email: String, password: String, home: () -> Unit) {
        if (_loading.value == false) {
            _loading.value = true
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    val displayName = it.result.user?.email?.split("@")?.get(0)
                    _loading.value = false
                    createUser(displayName)
                    home()
                } else {
                    _loading.value = false
                }

            }
        }
    }
    private fun createUser(displayName: String?){
        val userId = auth.currentUser?.uid
        val user = MUser(displayName = displayName.toString(),userId = userId.toString(), avatarUrl = "",quote = "Life is Great",id = null).toMap()
        FirebaseFirestore.getInstance().collection("users")
            .add(user)
    }
}