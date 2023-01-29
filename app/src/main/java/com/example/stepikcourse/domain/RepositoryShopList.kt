package com.example.stepikcourse.domain

interface RepositoryShopList {

    fun getShopList(): List<ShopItem>
    fun addShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemId: Long): ShopItem
    fun removeShopItem(shopItem: ShopItem)
}