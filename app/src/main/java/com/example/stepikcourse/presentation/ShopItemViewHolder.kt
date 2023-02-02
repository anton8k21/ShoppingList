package com.example.stepikcourse.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stepikcourse.R

class ViewHolderShopList(view: View): RecyclerView.ViewHolder(view){
    val name: TextView = view.findViewById(R.id.text_name)
    val count:TextView = view.findViewById(R.id.text_count)
}