package com.example.montypays.authentication.data.responses

data class LoginResponse(
    val data: Data,
    val developerMessage: String,
    val message: String,
    val responseCode: Int,
    val status: Boolean,
    val title: String,
    val totalCount: Any
)