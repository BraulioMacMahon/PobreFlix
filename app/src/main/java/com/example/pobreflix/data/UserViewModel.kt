package com.example.pobreflix.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    private val _loginSuccess = MutableStateFlow<Boolean?>(null)
    val loginSuccess: StateFlow<Boolean?> = _loginSuccess

    private val _signUpSuccess = MutableStateFlow<Boolean?>(null)
    val signUpSuccess: StateFlow<Boolean?> = _signUpSuccess

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val user = repository.getUser(username)
            _loginSuccess.value = user?.password == password
        }
    }

    fun signUp(username: String, password: String) {
        viewModelScope.launch {
            val success = repository.register(UserEntity(username = username, password = password))
            _signUpSuccess.value = success
        }
    }

    fun clearLoginState() {
        _loginSuccess.value = null
    }

    fun clearSignUpState() {
        _signUpSuccess.value = null
    }

}

// Adicionando ViewModelFactory para corrigir o erro de criação
class UserViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
