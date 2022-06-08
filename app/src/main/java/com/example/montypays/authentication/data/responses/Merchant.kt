package com.example.montypays.authentication.data.responses

data class Merchant(
    val accountManger: AccountManger,
    val company: Company,
    val creationDate: String,
    val email: String,
    val id: Int,
    val merchantKey: String,
    val merchant_id: String,
    val merchant_pass: String,
    val mrp: Mrp,
    val name: String,
    val phone: String,
    val status: String
)