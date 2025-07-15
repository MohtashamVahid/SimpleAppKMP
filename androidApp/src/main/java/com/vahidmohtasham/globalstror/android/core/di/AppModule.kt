package com.vahidmohtasham.globalstror.android.core.di



 import com.vahidmohtasham.globalstror.android.features.product.presentation.ProductViewModel
 import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
   viewModel { ProductViewModel(get()) }
}


