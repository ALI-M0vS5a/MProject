package com.example.montypays.authentication.data.responses

data class Mid(
    val connector: Connector,
    val country: Country,
    val creationDate: String,
    val id: Int,
    val isActive: Boolean,
    val midId: String,
    val name: String
)