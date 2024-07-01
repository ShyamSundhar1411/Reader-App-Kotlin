package com.example.readerapp.models

import android.view.inspector.InspectionCompanion

data class MUser(
    val id: String?,
    val userId: String,
    val displayName: String,
    val avatarUrl: String,
    val quote: String
) {
    fun toMap(): MutableMap<String, Any> {
        return mutableMapOf(
            "userId" to this.userId,
            "displayName" to this.displayName,
            "avatarUrl" to this.avatarUrl,
            "quote" to this.quote
        )
    }
}
