package me.samuki.clicker.base.interfaces


interface BasePresenter<T> {
    fun attachView(view: T)
    fun detachView()
    fun loadEverything()
}