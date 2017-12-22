package me.samuki.clicker.main

import me.samuki.clicker.main.interfaces.MainPresenter


class MainPresenterImpl<T> : MainPresenter<T> {
    private var view: T? = null

    override fun attachView(view: T) {
        this.view = view
    }

    override fun detachVIew() {
        view = null
    }
}