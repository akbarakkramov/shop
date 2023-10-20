package com.example.shop.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.shop.R
import com.example.shop.model.Product

class PhonesAdapter(var phoneList:List<Product>) : RecyclerView.Adapter<PhonesAdapter.PhoneHolder>(){

    class PhoneHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var name:TextView = itemView.findViewById(R.id.phone_name)
        var favorite:ImageView = itemView.findViewById(R.id.yurakcha)
        var img:ImageView = itemView.findViewById(R.id.phone_img)
        var reyting:TextView = itemView.findViewById(R.id.reyting)
        var price:TextView = itemView.findViewById(R.id.phone_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneHolder {
        return PhoneHolder(LayoutInflater.from(parent.context).inflate(R.layout.phone_item, parent, false))
    }

    override fun getItemCount(): Int {
        return phoneList.size
    }

    override fun onBindViewHolder(holder: PhoneHolder, position: Int) {
        var phone = phoneList[position]
        holder.name.text = phone.title
        holder.reyting.text = phone.rating.toString()
        holder.price.text = phone.price.toString()
        holder.img.load(phone.thumbnail)
//        holder.itemView.setOnClickListener {
//            productPressed.onPressed(phone)
//        }
    }


//    interface ProductPressed{
//        fun onPressed(product: Product)
//    }

}