package com.example.stepikcourse.domain

data class ShopItem(
    val name: String,
    val count: Int,
    val enabled: Boolean,
    var id: Long = UNDEFINED_ID
){
    companion object{
        const val UNDEFINED_ID: Long = -1
    }
}
