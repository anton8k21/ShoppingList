package com.example.stepikcourse.domain.useCase

import com.example.stepikcourse.domain.RepositoryShopList

class RemoveShopItemUseCase(private val repositoryShopList: RepositoryShopList) {

    fun removeShopItem(shopItemId: Long){
        repositoryShopList.removeShopItem(shopItemId)
    }
}