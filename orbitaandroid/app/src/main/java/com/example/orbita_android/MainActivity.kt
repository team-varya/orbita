package com.example.orbita_android

import android.content.Context
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity

import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), MainActivityPresenter.View {

    private val presenter: MainActivityPresenter = MainActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var preference = this.getPreferences(Context.MODE_PRIVATE)
        var isFirstTime = preference.getBoolean("isFirstTime", true)
        if (isFirstTime) {
            setContentView(R.layout.login_layout)

            with (preference.edit()) {
                putBoolean("isFirstTime", false)
                apply()
            }
        }
    }

    fun onLogin(view: View) {
        var login= findViewById<EditText>(R.id.login).text.toString()
        presenter.setUserName(login)

        setContentView(R.layout.add_information_layout)
    }

    fun onAddedInfo(view: View) {
        val packageCost = findViewById<EditText>(R.id.package_cost).text.toString().toInt()
        val dayCycle = findViewById<EditText>(R.id.day_cycle).text.toString().toInt()
        val packagePerCycle = findViewById<EditText>(R.id.package_per_cycle).text.toString().toInt()
        presenter.setUserInfo(packageCost, dayCycle, packagePerCycle)

        setContentView(R.layout.create_goal_layout)
    }

    fun onCreatedGoal(view: View) {
        val title = findViewById<EditText>(R.id.goal_title).text.toString()
        val moneyGoal = findViewById<EditText>(R.id.goal_money).text.toString().toInt()
        presenter.setUserGoal(title, moneyGoal)

        setTabs("Name")
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
}
