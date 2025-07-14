package com.vahidmohtasham.globalstror.features.product.presentation

import com.vahidmohtasham.globalstror.features.product.domain.usecase.GetAllProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class ProductViewModel(
    private val getAllProductsUseCase: GetAllProductsUseCase
) {
    private val _uiState = MutableStateFlow<ProductUiState>(ProductUiState.Loading)
    val uiState: StateFlow<ProductUiState> = _uiState

    private val viewModelScope = CoroutineScope(Dispatchers.Default)

    fun loadProducts() {
        viewModelScope.launch {
            try {
                val products = getAllProductsUseCase().map { it.toUiModel() }
                _uiState.value = ProductUiState.Success(products)
            } catch (e: Exception) {
                _uiState.value = ProductUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
