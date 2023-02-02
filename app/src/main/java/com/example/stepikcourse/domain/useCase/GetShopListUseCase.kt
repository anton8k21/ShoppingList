package com.example.stepikcourse.domain.useCase

import androidx.lifecycle.LiveData
import com.example.stepikcourse.domain.RepositoryShopList
import com.example.stepikcourse.domain.ShopItem

class GetShopListUseCase(private val repositoryShopList: RepositoryShopList) {

    fun getShopList(): LiveData<List<ShopItem>>{
        return repositoryShopList.getShopList()
    }
}