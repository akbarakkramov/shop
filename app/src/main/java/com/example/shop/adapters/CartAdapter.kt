package com.example.shop.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.shop.R
import com.example.shop.model.Cart
import com.example.shop.model.CartProduct
import com.example.shop.model.Product
import com.google.android.material.button.MaterialButton

class CartAdapter(var cartList:MutableList<CartProduct>) : RecyclerView.Adapter<CartAdapter.CartHolder>(){

    class CartHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var name:TextView = itemView.findViewById(R.id.name)
        var delete:ImageView = itemView.findViewById(R.id.delete)
        var price:TextView = itemView.findViewById(R.id.cart_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {
        return CartHolder(LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false))
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    @SuppressLint("NotifyDataSetChanged", "SetTextI18n")
    override fun onBindViewHolder(holder: CartHolder, position: Int) {
        var cart = cartList[position]
        holder.name.text = cart.title
        holder.price.text = cart.total.toString()
        holder.delete.setOnClickListener {
            cartList.remove(cart)
            notifyDataSetChanged()
        }

    }

}