package com.example.shop.networking

import com.example.shop.model.Login
import com.example.shop.model.Product
import com.example.shop.model.ProductData
import com.example.shop.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {
    @GET("/products")
    fun getAllProducts(): Call<ProductData>

    @GET("/products/{id}")
    fun getProduct(@Path("id") id: Int): Call<Product>

    @GET("products/search")
    fun searchByName(@Query("q") name: String): Call<ProductData>

    @POST("/auth/login")
    fun login(@Body login: Login): Call<User>
}