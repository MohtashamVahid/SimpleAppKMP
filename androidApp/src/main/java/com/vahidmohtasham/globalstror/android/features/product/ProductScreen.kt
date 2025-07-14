package com.vahidmohtasham.globalstror.android.features.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.vahidmohtasham.globalstror.features.product.presentation.ProductUiState
import com.vahidmohtasham.globalstror.features.product.presentation.ProductViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProductScreen(viewModel: ProductViewModel = koinViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadProducts()
    }

    when (uiState) {
        is ProductUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is ProductUiState.Success -> {
            val products = (uiState as ProductUiState.Success).products
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                items(products) { product ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(product.image),
                            contentDescription = product.title,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                        )
                        Text(
                            text = product.title,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                        Text(
                            text = product.price,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Divider(modifier = Modifier.padding(vertical = 8.dp))
                    }
                }
            }
        }
        is ProductUiState.Error -> {
            val message = (uiState as ProductUiState.Error).message
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "خطا: $message")
            }
        }
    }
}
