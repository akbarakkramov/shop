package com.example.shop.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.model.Phone

class PhonesAdapter(var phoneList:MutableList<Phone>) : RecyclerView.Adapter<PhonesAdapter.PhoneHolder>(){

    class PhoneHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PhoneHolder, position: Int) {
        TODO("Not yet implemented")
    }
}