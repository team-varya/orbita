package com.example.orbita_android

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity

import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), MainActivityPresenter.View {

    private val presenter: MainActivityPresenter = MainActivityPresenter(this)
    // private val preference: SharedPreferences = this.getPreferences(Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val preference: SharedPreferences = this.getPreferences(Context.MODE_PRIVATE)
        val isFirstTime = preference.getBoolean("isFirstTime", true)
        if (isFirstTime) {
            setContentView(R.layout.login_layout)

            with (preference.edit()) {
                putBoolean("isFirstTime", false)
                apply()
            }
        }
        else {
            initUserFromPreference(preference)

            setTabs(presenter.user.username)
        }
    }

    override fun onDestroy() {
        val preference: SharedPreferences = this.getPreferences(Context.MODE_PRIVATE)

        addUserToPreference(preference)

        super.onDestroy()
    }

    fun onLogin(view: View) {
        val login= findViewById<EditText>(R.id.login).text.toString()
        presenter.setUserName(login)

        setContentView(R.layout.add_information_layout)
    }

    fun onAddedInfo(view: View) {
        val packageCost = findViewById<EditText>(R.id.package_cost).text.toString().toInt()
        val dayCycle = findViewById<EditText>(R.id.day_cycle).text.toString().toInt()
        val packagePerCycle = findViewById<EditText>(R.id.package_per_cycle).text.toString().toInt()

        setContentView(R.layout.create_goal_layout)
    }

    fun onCreatedGoal(view: View) {
        val title = findViewById<EditText>(R.id.goal_title).text.toString()
        val moneyGoal = findViewById<EditText>(R.id.goal_money).text.toString().toInt()
        presenter.setUserGoal(title, moneyGoal)

        setTabs(presenter.user.username)
    }

    fun setTabs(name: String) {
        setContentView(R.layout.activity_main)
        val title: TextView = findViewById(R.id.title)
        title.text = name
        val fragmentAdapter = PagerAdapter(supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = fragmentAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

    }

    private fun initUserFromPreference(preference: SharedPreferences) {
        val userName: String? = preference.getString(getString(R.string.user_name), "")

        val packCost: Int? = preference.getInt(getString(R.string.pack_cost), 150)
        val dayCycle: Int? = preference.getInt(getString(R.string.day_cycle), 3)
        val packPerDay: Int? = preference.getInt(getString(R.string.package_per_cycle), 2)

        val goalName: String? = preference.getString(getString(R.string.goal_name), "")
        val goalMoney: Int? = preference.getInt(getString(R.string.goal_money), 0)

        val packageCounter: Int? = preference.getInt(getString(R.string.package_counter), 0)
        val cigarettesNumber: Int? = preference.getInt(getString(R.string.cigarettes_number), 0)

        presenter.setUserName(userName!!)
        presenter.setUserInfo(packCost!!, dayCycle!!, packPerDay!!)
        presenter.setPackageInfo(packageCounter!!, cigarettesNumber!!)
        presenter.setUserGoal(goalName!!, goalMoney!!)


    }

    private fun addIntToPreference(preference: SharedPreferences, key: Int, defaultValue: Int) {
        with (preference.edit()) {
            putInt(getString(key), defaultValue)
            apply()
        }
    }

    private fun addStringToPreference(preference: SharedPreferences, key: Int, defaultValue: String) {
        with (preference.edit()) {
            putString(getString(key), defaultValue)
            apply()
        }
    }

    private fun addUserToPreference(preference: SharedPreferences) {
        val user = presenter.user

        addStringToPreference(preference, R.string.user_name, user.username)

        addIntToPreference(preference, R.string.pack_cost, user.smokePackInformation!!.packageCost)
        addIntToPreference(preference, R.string.day_cycle, user.smokePackInformation!!.dayCycle)
        addIntToPreference(preference, R.string.package_per_cycle, user.smokePackInformation!!.packagesPerCycle)

        addStringToPreference(preference, R.string.goal_name, user.currentGoal!!.title)
        addIntToPreference(preference, R.string.goal_money, user.currentGoal!!.moneyGoal)

        addIntToPreference(preference, R.string.package_counter, user.smokePackInformation!!.packageCounter)
        addIntToPreference(preference, R.string.cigarettes_number, user.smokePackInformation!!.currentPackage!!.countOfCigarettes)
    }
}
