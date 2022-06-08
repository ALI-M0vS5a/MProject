package com.example.montypays.authentication.data.responses

data class Data(
    val cardTypes: List<CardType>,
    val company: List<Company>,
    val connectors: List<Connector>,
    val countries: List<Country>,
    val currencies: List<Currency>,
    val email: String,
    val externalId: String,
    val firstName: String,
    val language: String,
    val lastName: String,
    val merchants: List<Merchant>,
    val mid: List<Mid>,
    val profileImage: String,
    val refreshToken: String,
    val refreshTokenExpiresIn: Int,
    val roleName: String,
    val status: List<String>,
    val token: String,
    val tokenExpiresIn: Int,
    val transactionsTypes: List<String>,
    val userDevice: UserDevice,
    val userName: String
)