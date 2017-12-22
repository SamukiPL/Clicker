package me.samuki.clicker.main

import com.badlogic.gdx.Screen
import me.samuki.clicker.main.interfaces.MainPresenter
import me.samuki.clicker.main.interfaces.MainView


class MainScreen : Screen, MainView {
    lateinit var presenter: MainPresenter<MainView>

    override fun hide() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun show() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun render(delta: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resize(width: Int, height: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dispose() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun start() {
        presenter = MainPresenterImpl()
        presenter.attachView(this)
    }

    override fun stop() {
        presenter.detachVIew()
    }
}