package com.example.shop_app.data

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.shop_app.domain.ViewedProductDao
import com.example.shop_app.domain.model.Product

class ViewedProductDaoImpl(
    private val sharedPreferences: SharedPreferences
): ViewedProductDao {

    private var savedProductIds:List<Long>
        get() = sharedPreferences.getString(PRODUCT_TAG,null)?.split(",")
        ?.mapNotNull { it.toLongOrNull() } ?: emptyList()

        set(value) = sharedPreferences.edit {
            putString(PRODUCT_TAG, value.joinToString(","))
        }

    override fun addProduct(productID: Long) {
        val productIds: List<Long> = savedProductIds
        val newProductIds = mutableListOf<Long>().apply {
            add(productID)
            addAll(productIds.filter { it != productID })
        }
        savedProductIds = newProductIds
    }

    override fun getAllProducts(): List<Long> {
        return savedProductIds
    }

    override fun getProductById(productId: Long): Product {
        val products = listOf<Product>(
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
        return products.find{ it.id == productId } ?: products[0]
    }

    companion object{
        private const val PRODUCT_TAG = "PRODUCT_TAG"
    }
}