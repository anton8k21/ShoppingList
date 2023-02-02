package com.example.stepikcourse.domain

import androidx.lifecycle.LiveData

interface RepositoryShopList {

    fun getShopList(): LiveData<List<ShopItem>>
    fun addShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemId: Long): ShopItem
    fun removeShopItem(shopItem: ShopItem)
}