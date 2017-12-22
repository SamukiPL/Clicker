package me.samuki.clicker.base

import com.badlogic.gdx.Preferences
import me.samuki.clicker.base.interfaces.IncomeRefresher
import me.samuki.clicker.models.UpgradeModel


class IncomeHandler : IncomeRefresher {
    lateinit var upgrades: List<UpgradeModel>

    init {
        initUpgrades()
    }

    fun initUpgrades() {
        upgrades = ArrayList()
        var x: Int = 0
        Constants.upgrades_info.forEach {
            upgrade -> run {
                val path: String = Constants.paths.base_upgrade_texture_parh
                        .replace(Constants.replace_mark, x.toString())
                val prefsName: String = Constants.prefs.upgrades_bought
                        .replace(Constants.replace_mark, x.toString())
                upgrades.toMutableList().add(UpgradeModel(x, upgrade.name,
                        SharedPrefs.getInstance().prefs.getInteger(prefsName, 0), upgrade.income, path))
                x++
            }
        }

    }

    override fun getAmount() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refreshUpgrade(index: Int, amount: Int) {
        upgrades.get(index).amount = amount
        SharedPrefs.getInstance().prefs.putInteger(Constants.prefs.upgrades_bought
                .replace(Constants.replace_mark, index.toString()), amount)
    }
}