package com.example.montypays.authentication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.montypays.authentication.data.authnetwork.Resource
import com.example.montypays.authentication.data.authrepositories.AuthRepository
import com.example.montypays.authentication.data.responses.LoginResponse
import kotlinx.coroutines.launch

class AuthenticationViewModel(
    private val repository: AuthRepository
) : ViewModel() {

    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>>
        get() = _loginResponse

    fun login(
        userName: String, password: String
    ) = viewModelScope.launch {
        _loginResponse.value = repository.login(userName, password)

    }
}

