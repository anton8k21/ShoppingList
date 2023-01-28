package com.example.stepikcourse.domain.useCase

import com.example.stepikcourse.domain.RepositoryShopList
import com.example.stepikcourse.domain.ShopItem

class EditShopItemUseCase(private val repositoryShopList: RepositoryShopList) {

    fun editShopItem(shopItem: ShopItem){
        repositoryShopList.editShopItem(shopItem)
    }
}