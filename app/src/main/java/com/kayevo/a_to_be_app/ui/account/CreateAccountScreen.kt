package com.kayevo.a_to_be_app.ui.account

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kayevo.a_to_be_app.ui.theme.A_to_be_AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun CreateAccountScreen(navController: NavHostController) {
    val viewModel: CreateAccountViewModel = koinViewModel()
    val email = viewModel.email.collectAsState()
    val name = viewModel.email.collectAsState()
    val changeEmail = viewModel::changeEmail
    val changeName = viewModel::changeName
    val isValidEmail = viewModel.isValidEmail.collectAsState()
    val isValidName = viewModel.isValidEmail.collectAsState()

    CreateAccountContent(
        email = email.value,
        changeEmail = changeEmail,
        isValidEmail = isValidEmail.value,
        name = name.value,
        changeName = changeName,
        isValidName = isValidName.value
    )
}

@Composable
fun CreateAccountContent(
    email: String,
    changeEmail: (String) -> Unit,
    isValidEmail: Boolean,
    name: String,
    changeName: (String) -> Unit,
    isValidName: Boolean
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Create account",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Center,
            fontSize = 22.sp
        )
        TextField(
            value = email,
            onValueChange = changeEmail,
            label = { Text("Email") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth(),
            isError = !isValidEmail
        )
        TextField(
            value = name,
            onValueChange = changeName,
            label = { Text("Name") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth(),
            isError = !isValidName
        )
        Button(
            onClick = {},
            content = { Text("Submit") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            enabled = isValidEmail && isValidName
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CreateAccountScreenPreview() {
    A_to_be_AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        WindowInsets.statusBars
                            .only(WindowInsetsSides.Top)
                            .asPaddingValues()
                    )
                    .padding(bottom = 32.dp)
                    .padding(top = 16.dp),
            ) {
                CreateAccountContent(
                    email = "",
                    changeEmail = {},
                    isValidEmail = true,
                    name = "",
                    changeName = {},
                    isValidName = true
                )
            }
        }
    }
}