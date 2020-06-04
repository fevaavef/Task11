package com.example.shop_app.ui
import android.os.Bundle
import android.util.Log
import com.example.shop_app.R
import com.example.shop_app.data.ViewedProductDaoImpl
import com.example.shop_app.domain.model.Product
import com.example.shop_app.presenter.ProductPresenter
import com.example.shop_app.presenter.ProductView
import com.example.myapplication.ui.BaseActivity
import kotlinx.android.synthetic.main.product_layout.*
import moxy.ktx.moxyPresenter


class ProductActivity: BaseActivity(), ProductView {
    private val presenter by moxyPresenter {
        ProductPresenter(
            ViewedProductDaoImpl(sharedPreferences)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_layout)
        val product = intent?.getParcelableExtra<Product>(PRODUCT_TAG) ?: return

        productBackBtn.setOnClickListener(){
            finish()
        }
        Log.d("productName", product.productName.toString())
        productNameTv.text = product.productName
        presenter.onProductShow(product)
    }

    companion object {
        const val PRODUCT_TAG = "PRODUCT_TAG"
    }

}