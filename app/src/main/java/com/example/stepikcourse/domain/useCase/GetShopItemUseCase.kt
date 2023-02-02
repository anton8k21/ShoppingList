package com.example.stepikcourse.domain.useCase

import com.example.stepikcourse.domain.RepositoryShopList
import com.example.stepikcourse.domain.ShopItem

class GetShopItemUseCase(private val repositoryShopList: RepositoryShopList) {

    fun getShopItem(shopItemId: Long): ShopItem{
        return repositoryShopList.getShopItem(shopItemId)
    }
}