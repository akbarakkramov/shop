package com.example.shop.networking

import com.example.shop.model.Cart
import com.example.shop.model.CartData
import com.example.shop.model.Login
import com.example.shop.model.Product
import com.example.shop.model.ProductData
import com.example.shop.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {
    @GET("/products")
    fun getAllProducts(): Call<ProductData>

    @GET("/products/{id}")
    fun getProduct(@Path("id") id: Int): Call<Product>

    @GET("/products/search")
    fun searchByName(@Query("q") name: String): Call<ProductData>

    @POST("/auth/login")
    fun login(@Body login: Login): Call<User>

    @GET("/carts/user/{id}")
    fun getCart(@Path("id") id: Int): Call<CartData>

    @PUT("/carts/{id}")
    fun updateCart(products: List<Product>)

    @GET("/products/categories")
    fun getCategories(): Call<List<String>>

    @GET("/products/category/{category}")
    fun getByCategory(@Path("category") category: String): Call<ProductData>


}