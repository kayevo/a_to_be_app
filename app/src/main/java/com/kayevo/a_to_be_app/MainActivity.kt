package com.kayevo.a_to_be_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kayevo.a_to_be_app.ui.home.HomeScreen
import com.kayevo.a_to_be_app.ui.navigation.Screen
import com.kayevo.a_to_be_app.ui.account.CreateAccountScreen
import com.kayevo.a_to_be_app.ui.product.ProductsScreen
import com.kayevo.a_to_be_app.ui.theme.A_to_be_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
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
                        val navController = rememberNavController()

                        NavHost(navController = navController, startDestination = Screen.HOME.toString()) {
                            composable(Screen.HOME.toString()) { HomeScreen(navController) }
                            composable(Screen.PRODUCTS.toString()) { ProductsScreen(navController) }
                            composable(Screen.FORM.toString()) { CreateAccountScreen(navController) }
                        }
                    }
                }
            }
        }
    }
}

