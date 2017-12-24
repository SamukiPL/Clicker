package me.samuki.clicker.base.interfaces

import me.samuki.clicker.base.enums.ModelTypes


abstract class BaseModel {
    abstract var type: ModelTypes
    var id: Int = 0
}