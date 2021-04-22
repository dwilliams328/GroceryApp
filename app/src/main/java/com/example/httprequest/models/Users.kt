package com.example.httprequest.models

import java.io.Serializable

data class User(
    var name: String,
    var email: String
): Serializable{
    companion object{
        const val KEY_USER = "user"
    }
}