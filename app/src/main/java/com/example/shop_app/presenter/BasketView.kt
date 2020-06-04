package com.example.shop_app.presenter

import com.example.shop_app.domain.model.Product
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface BasketView : MvpView{

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setProducts(list: List<Product>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun removeItem(position: Int)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProductDetails(product: Product)

}