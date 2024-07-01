package com.example.readerapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.readerapp.util.LoadingState
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel: ViewModel(){
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading
    fun createUserWithEmailAndPassword(email:String,password:String){
        try{
            auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        _loading.value = false
                    }else{
                        _loading.value = false
                    }
                }
        }catch(ex:Exception){

        }
    }
}