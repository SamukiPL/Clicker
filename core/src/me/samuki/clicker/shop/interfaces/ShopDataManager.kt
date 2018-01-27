package me.samuki.clicker.shop.interfaces

import me.samuki.clicker.base.interfaces.BaseDataManager


interface ShopDataManager: BaseDataManager {
    fun loadBoughtItems()
}