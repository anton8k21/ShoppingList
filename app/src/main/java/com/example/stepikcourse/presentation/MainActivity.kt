package com.example.stepikcourse.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.stepikcourse.R

class MainActivity : AppCompatActivity() {
    private lateinit var viewModelShopList: ViewModelShopList
    private lateinit var shopListAdapter: RecycleViewShopList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupShopListAdapter()

        viewModelShopList = ViewModelProvider(this)[ViewModelShopList::class.java]
        viewModelShopList.dataShopList.observe(this){ shopList ->
            shopListAdapter.submitList(shopList)

        }
    }

    private fun setupShopListAdapter(){
        val rvShopList = findViewById<RecyclerView>(R.id.rv_shop_list)
        with(rvShopList){
            shopListAdapter = RecycleViewShopList()
            adapter = shopListAdapter
            recycledViewPool.setMaxRecycledViews(
                RecycleViewShopList.VIEW_TYPE_ENABLED,
                RecycleViewShopList.MAX_PUL_SIZE)

            recycledViewPool.setMaxRecycledViews(
                RecycleViewShopList.VIEW_TYPE_DISABLED,
                RecycleViewShopList.MAX_PUL_SIZE)
        }
        onShopItemLongClickListener()
        onShopItemClickListener()
        setupSwipeListener(rvShopList)

    }

    private fun setupSwipeListener(rvShopList: RecyclerView) {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val shopItem = shopListAdapter.currentList[viewHolder.adapterPosition]
                viewModelShopList.removeShopItem(shopItem)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rvShopList)
    }

    private fun onShopItemClickListener() {
        shopListAdapter.onShopItemClickListener = {
            Log.d("ShopItem", it.toString())
        }
    }

    private fun onShopItemLongClickListener() {
        shopListAdapter.onShopItemLongClickListener = { shopItem ->
            viewModelShopList.changeEnableState(shopItem)
        }
    }
}