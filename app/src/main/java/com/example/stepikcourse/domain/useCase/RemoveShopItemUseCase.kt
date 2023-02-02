package com.example.stepikcourse.domain.useCase

import com.example.stepikcourse.domain.RepositoryShopList
import com.example.stepikcourse.domain.ShopItem

class RemoveShopItemUseCase(private val repositoryShopList: RepositoryShopList) {

    fun removeShopItem(shopItemId: ShopItem){
        repositoryShopList.removeShopItem(shopItemId)
    }
}