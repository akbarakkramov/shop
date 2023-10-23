package com.example.shop.model

class CartData(
    var carts: List<Cart>,
    val limit: Int,
    val skip: Int,
    val total: Int
)