package com.example.shop.model

data class Cart(
    val discountPercentage: Double,
    val discountedPrice: Int,
    val id: Int,
    val price: Int,
    val quantity: Int,
    val title: String,
    val total: Int
)