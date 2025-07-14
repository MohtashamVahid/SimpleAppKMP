package com.vahidmohtasham.globalstror.features.product.presentation

sealed class ProductUiState {
    object Loading : ProductUiState()
    data class Success(val products: List<ProductUiModel>) : ProductUiState()
    data class Error(val message: String) : ProductUiState()
}
