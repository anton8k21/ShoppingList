package com.example.stepikcourse.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.stepikcourse.domain.RepositoryShopList
import com.example.stepikcourse.domain.ShopItem
import kotlin.random.Random

object RepositoryShopListImpl: RepositoryShopList {

    private val dataShopList = MutableLiveData<List<ShopItem>>()
    private val shopList = sortedSetOf<ShopItem>({o1,o2 -> o1.id.compareTo(o2.id)})
    private var autoIncrementId: Long = 0

    init {
        for (i in 0..1000) {
            val item = ShopItem(
                name = "name $i",
                count = 3,
                enabled = Random.nextBoolean(),
                id = i.toLong()
            )
            shopList.add(item)
            updateShopList()
        }
    }


    override fun getShopList(): LiveData<List<ShopItem>> {
        return dataShopList
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateShopList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Long): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun removeShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
       updateShopList()
    }

    private fun updateShopList(){
        dataShopList.value = shopList.toList()
    }
}