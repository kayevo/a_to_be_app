package com.kayevo.a_to_be_app.domain.account

import org.junit.Test

import org.junit.Assert.*

class AccountUtilsTest {
    @Test
    fun `Given email is valid, Then return true`() {
        val validEmail = "abc@abc.com"
        assertTrue(validEmail.isValidEmail())
    }

    @Test
    fun `Given email is invalid, Then return false`() {
        val validEmail = "abc@"
        assertFalse(validEmail.isValidEmail())
    }

    @Test
    fun `Given email is blank, Then return false`() {
        val validEmail = "   "
        assertFalse(validEmail.isValidEmail())
    }

    @Test
    fun `Given name is not blank, Then return true`() {
        val validName = "Valid Name"
        assertTrue(validName.isValidName())
    }

    @Test
    fun `Given name is blank, Then return false`() {
        val validName = "   "
        assertTrue(validName.isValidName())
    }
}