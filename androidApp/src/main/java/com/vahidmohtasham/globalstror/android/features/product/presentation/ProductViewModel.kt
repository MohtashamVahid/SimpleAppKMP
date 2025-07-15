package com.vahidmohtasham.globalstror.android.features.product.presentation

import com.vahidmohtasham.globalstror.features.product.domain.usecase.GetAllProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vahidmohtasham.globalstror.features.product.presentation.ProductUiState
import com.vahidmohtasham.globalstror.features.product.presentation.toUiModel

class ProductViewModel(
    private val getAllProductsUseCase: GetAllProductsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<ProductUiState>(ProductUiState.Loading)
    val uiState: StateFlow<ProductUiState> = _uiState

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
