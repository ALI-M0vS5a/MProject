package com.example.montypays.authentication.data.authrepositories

import com.example.montypays.authentication.data.authnetwork.ApiInstance

class AuthRepository(
    private val api: ApiInstance
) : BaseRepository() {

    suspend fun login(userName: String, password: String) = safeApiCall {
        api.login(userName, password)

    }
}