package com.example.shop_app.presenter

import com.example.shop_app.domain.model.Product
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface CatalogView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setProductNames(list: List<String>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setViewedProducts(products: List<Product>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun removeItem(position: Int)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showProductsIds(productIds: List<Long>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProductInfo(product: Product)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showError(error: String)
}