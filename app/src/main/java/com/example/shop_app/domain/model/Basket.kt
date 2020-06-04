package com.example.shop_app.domain.model

class Basket (var products: MutableList<Product> = mutableListOf()) {
    val discountSum get() = products.map {product -> product.salePercent}.sum()
    val fullSum get() = products.map {product -> product.price}.sum()
}