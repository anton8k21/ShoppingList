package com.example.stepikcourse.domain.useCase

import com.example.stepikcourse.domain.RepositoryShopList
import com.example.stepikcourse.domain.ShopItem

class AddShopItemUseCase(private val repositoryShopList: RepositoryShopList) {

    fun addShopItem(shopItem: ShopItem){
        repositoryShopList.addShopItem(shopItem)
    }
}