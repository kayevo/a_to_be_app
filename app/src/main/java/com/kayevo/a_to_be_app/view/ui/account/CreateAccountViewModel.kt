package com.kayevo.a_to_be_app.view.ui.account

import androidx.lifecycle.ViewModel
import com.kayevo.a_to_be_app.domain.account.isValidEmail
import com.kayevo.a_to_be_app.domain.account.isValidName
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CreateAccountViewModel() : ViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _isValidEmail = MutableStateFlow(false)
    val isValidEmail: StateFlow<Boolean> = _isValidEmail

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _isValidName = MutableStateFlow(false)
    val isValidName: StateFlow<Boolean> = _isValidName

    fun changeEmail(email: String) {
        _email.value = email
        _isValidEmail.value = email.isValidEmail()
    }

    fun changeName(name: String) {
        _name.value = name
        _isValidName.value = name.isValidName()
    }
}