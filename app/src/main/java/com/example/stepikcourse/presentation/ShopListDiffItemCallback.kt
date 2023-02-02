package com.example.stepikcourse.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.stepikcourse.domain.ShopItem

class ShopListDiffItemCallback: DiffUtil.ItemCallback<ShopItem>() {
    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem == newItem
    }


}