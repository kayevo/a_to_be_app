package com.kayevo.a_to_be_app.view.ui.product

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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kayevo.a_to_be_app.domain.product.Product
import com.kayevo.a_to_be_app.view.theme.A_to_be_AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProductsScreen(navController: NavHostController) {
    val viewModel = koinViewModel<ProductsViewModel>()
    val products = viewModel.products.collectAsState()

    ProductsContent(products.value)
}

@Composable
fun ProductsContent(products: List<Product>) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Products",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Center,
            fontSize = 22.sp
        )
        LazyColumn {
            items(count = products.size) { index ->
                Text(text = "${index + 1}. ${products[index]}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsScreenPreview() {
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
                val mockedItems = mutableListOf<Product>()
                for(element in 0..50) mockedItems.add(Product(id = 0, title = "Abc"))

                ProductsContent(mockedItems)
            }
        }
    }
}