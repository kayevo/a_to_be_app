package com.kayevo.a_to_be_app.ui.products

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kayevo.a_to_be_app.ui.theme.A_to_be_AppTheme

@Composable
fun FormScreen(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Form",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Center,
            fontSize = 22.sp
        )
        Button(
            onClick = {},
            content = { Text("Submit") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FormScreenPreview() {
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
                FormScreen(rememberNavController())
            }
        }
    }
}