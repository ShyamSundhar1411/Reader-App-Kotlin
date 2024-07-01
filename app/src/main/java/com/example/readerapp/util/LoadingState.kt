package com.example.readerapp.util

import android.net.http.UrlRequest.Status

data class LoadingState(val status: Status, val message: String? = null){
    companion object{
        val IDLE = LoadingState(Status.IDLE)
        val LOADING = LoadingState(Status.LOADING)
        val SUCCESS = LoadingState(Status.SUCCESS)
        val FAILED = LoadingState(Status.FAILED)
        fun error(message: String?) = LoadingState(Status.FAILED, message)
    }
    enum class Status{
        SUCCESS,
        FAILED,
        LOADING,
        IDLE
    }
}
