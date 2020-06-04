package com.example.shop_app.presenter

import com.example.shop_app.domain.model.Basket
import com.example.shop_app.domain.model.Product
import moxy.MvpPresenter

class BasketPresenter: MvpPresenter<BasketView>() {
    private val basket = Basket(
        mutableListOf(
            Product(
                1,
                "Assault rifle",
                7002.0,
                16
            ),
            Product(2,
                "Pump-action shotgun",
                4737.0,
                5
            ),
            Product(3,
                "Machine gun",
                8932.0,
                29
            ),
            Product(4,
                "Minigun",
                2839.0,
                25
            ),
            Product(5,
                "Revolver",
                2219.0,
                9
            ),
            Product(6,
                "Pistol",
                5115.0,
                18
            ),
            Product(7,
                "Sawed-off shotgun",
                7135.0,
                13
            ),
            Product(8,
                "Rocket launcher",
                9653.0,
                28
            ),
            Product(9,
                "Submachine gun",
                7124.0,
                20
            ),
            Product(10,
                "Rifle",
                2513.0,
                24

            ),
            Product(11,
                "Grenade",
                3399.0,
                15

            )
        )
    )

    fun setData(){
        viewState.setProducts(basket.products)
    }

    fun removeItem(productName: String){
        val position = basket.products.indexOf(
            basket.products.find { product -> product.productName == productName }
        )
        basket.products.removeAt(position)
        viewState.removeItem(position)
    }

    fun showProductDetails(product: Product) {
        viewState.showProductDetails(product)
    }

}