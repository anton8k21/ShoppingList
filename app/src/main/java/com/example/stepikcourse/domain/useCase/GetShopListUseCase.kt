package com.example.stepikcourse.domain.useCase

import com.example.stepikcourse.domain.RepositoryShopList
import com.example.stepikcourse.domain.ShopItem

class GetShopListUseCase(private val repositoryShopList: RepositoryShopList) {

    fun getShopList(): List<ShopItem>{
        return repositoryShopList.getShopList()
    }
}