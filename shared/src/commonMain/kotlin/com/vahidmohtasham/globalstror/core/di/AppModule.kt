package com.vahidmohtasham.globalstror.core.di

import com.vahidmohtasham.globalstror.core.network.KtorClientFactory
import com.vahidmohtasham.globalstror.core.network.ProductApiImpl
import com.vahidmohtasham.globalstror.features.product.data.remote.ProductApi
import com.vahidmohtasham.globalstror.features.product.data.remote.ProductRemoteDataSource
import com.vahidmohtasham.globalstror.features.product.data.remote.repository.ProductRepositoryImpl
import com.vahidmohtasham.globalstror.features.product.domain.repository.ProductRepository
import com.vahidmohtasham.globalstror.features.product.domain.usecase.GetAllProductsUseCase
import com.vahidmohtasham.globalstror.features.product.presentation.ProductViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {
    // Network
    single { KtorClientFactory.create() }
    single<ProductApi> { ProductApiImpl(get()) }

    // Data sources
    single { ProductRemoteDataSource(get()) }

    // Repository
    single<ProductRepository> { ProductRepositoryImpl(get()) }

    // UseCase
    single { GetAllProductsUseCase(get()) }

    // ViewModel
    single { ProductViewModel(get()) }
}
