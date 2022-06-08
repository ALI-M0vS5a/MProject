package com.example.montypays.authentication.data.authnetwork

import com.example.montypays.authentication.data.responses.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface ApiInstance {

    @FormUrlEncoded
    @POST("signin")
    suspend fun login(
        @Field("userName") userName: String,
        @Field("password") password: String
    ): LoginResponse
}



