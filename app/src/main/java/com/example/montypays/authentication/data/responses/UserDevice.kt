package com.example.montypays.authentication.data.responses

data class UserDevice(
    val appVersion: Any,
    val brand: Any,
    val deviceId: String,
    val fcmToken: Any,
    val id: String,
    val isLoggedIn: Boolean,
    val mcc: Any,
    val mnc: Any,
    val model: Any,
    val operatorName: Any,
    val os: Any,
    val osVersion: Any,
    val phoneName: Any,
    val systemInfo: Any,
    val user: User
)