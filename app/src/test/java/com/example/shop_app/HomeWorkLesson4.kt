package com.example.shop_app

import org.junit.Test

class HomeWorkLesson4 {
    @Test
    fun example() {

        val iphoneCase = com.example.shop_app.domain.model.Product(
            id = 20,
            price = 123.0,
            salePercent = 10,
            productName = "iphoneCase"
        )

        val pricePrinterInRubles: PricePrinter = PricePrinterInRubles()
        val pricePrinterInDollars: PricePrinter = PricePrinterInDollars()

        val discountIphoneCasePrice = iphoneCase.calcDiscountPrice()
        pricePrinterInRubles.print(discountIphoneCasePrice)
        pricePrinterInDollars.print(discountIphoneCasePrice)
    }
}

class Product (
    /**
     * Must be positive
     */
    private val price: Double,
    private val salePercent: Int = 0
) {
    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 than product will have negative price
     * If [salePercent] less than 0 product price will be increased
     */
    fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)
}

interface PricePrinter {
    /**
     * Accepts the price in rubles.
     * Outputs price in <PRICE> <currency> format.
     * If price have not fractional part than it will be printed as integer.
     * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    fun print(price: Double)
}

class PricePrinterInRubles : PricePrinter{
    override fun print(price: Double) {
        val stringPrice: String = if (price % 1 == 0.0) {
            price.toInt().toString()
        } else {
            String.format("%.2f", price)
        }
        println("$stringPrice P")
    }
}

class PricePrinterInDollars : PricePrinter{
    override fun print(price: Double) {
        val dollars = price*0.013
        val stringPrice:String = if (dollars % 1 == 0.0) {
            dollars.toInt().toString()
        } else {
            String.format("%.2f", dollars)
        }
        println("$stringPrice $")
    }
}