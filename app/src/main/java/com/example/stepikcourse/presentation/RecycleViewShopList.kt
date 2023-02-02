package com.example.stepikcourse.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import com.example.stepikcourse.R
import com.example.stepikcourse.domain.ShopItem

class RecycleViewShopList:RecyclerView.Adapter<RecycleViewShopList.ViewHolderShopList>() {

    var list = listOf<ShopItem>()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderShopList {
        val layout = when(viewType){
            VIEW_TYPE_ENABLED -> R.layout.item_shop_enabled
            VIEW_TYPE_DISABLED -> R.layout.item_shop_disabled
            else -> throw RuntimeException("Unknown view type $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout,parent,false)
        return ViewHolderShopList(view)
    }

    override fun onBindViewHolder(holder: ViewHolderShopList, position: Int) {
        val item = list[position]
        holder.name.text = item.name
        holder.count.text = item.count.toString()
        holder.itemView.setOnLongClickListener{
            onShopItemLongClickListener?.invoke(item)
            true
        }
        holder.itemView.setOnClickListener {
            onShopItemClickListener?.invoke(item)
        }

    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        val item = list[position]
        return if (item.enabled){
            VIEW_TYPE_ENABLED
        }else
            VIEW_TYPE_DISABLED
    }

    class ViewHolderShopList(view: View): RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById(R.id.text_name)
        val count:TextView = view.findViewById(R.id.text_count)

    }

    companion object {
        const val VIEW_TYPE_ENABLED = 100
        const val VIEW_TYPE_DISABLED = 101

        const val MAX_PUL_SIZE = 25
    }
}

