package com.example.shop_app.presenter

import com.example.shop_app.domain.ViewedProductDao
import com.example.shop_app.domain.model.Product
import moxy.MvpPresenter

class ProductPresenter(private val viewedProductDao: ViewedProductDao):
    MvpPresenter<ProductView>()  {
    fun onProductShow(product: Product) {
        viewedProductDao.addProduct(product.id)
    }
}