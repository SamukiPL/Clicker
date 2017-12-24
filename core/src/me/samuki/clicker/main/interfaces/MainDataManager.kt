package me.samuki.clicker.main.interfaces

import me.samuki.clicker.base.interfaces.BaseDataManager
import me.samuki.clicker.models.ActorModel


interface MainDataManager : BaseDataManager {
    fun getClickUpgradeShop(): List<ActorModel>
}