package com.kayevo.a_to_be_app.domain.account

fun String.isValidEmail(): Boolean {
    val emailRegex = Regex(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
    )
    return emailRegex.matches(this)
}

fun String.isValidName(): Boolean = !this.isBlank()