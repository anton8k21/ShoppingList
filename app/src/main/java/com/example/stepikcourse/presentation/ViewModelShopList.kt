package com.example.stepikcourse.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stepikcourse.data.RepositoryShopListImpl
import com.example.stepikcourse.domain.ShopItem
import com.example.stepikcourse.domain.useCase.AddShopItemUseCase
import com.example.stepikcourse.domain.useCase.EditShopItemUseCase
import com.example.stepikcourse.domain.useCase.GetShopListUseCase
import com.example.stepikcourse.domain.useCase.RemoveShopItemUseCase

class ViewModelShopList: ViewModel() {

    private val repositoryShopList = RepositoryShopListImpl

    private val addShopListUseCase = AddShopItemUseCase(repositoryShopList)
    private val getShopListUseCase = GetShopListUseCase(repositoryShopList)
    private val removeShopItemUseCase = RemoveShopItemUseCase(repositoryShopList)
    private val editShopItemUseCase = EditShopItemUseCase(repositoryShopList)

    val dataShopList = getShopListUseCase.getShopList()


    fun addShopItem(shopItem: ShopItem){
        addShopListUseCase.addShopItem(shopItem)
    }

    fun removeShopItem(shopItem: ShopItem){
        removeShopItemUseCase.removeShopItem(shopItem)
    }

    fun editShopItem(shopItem: ShopItem){
        editShopItemUseCase.editShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem){
        val newShopItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newShopItem)
    }

}