package com.example.orbita_android

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
        setContentView(R.layout.login_layout)
    }

    fun setTabs(view: View) {
        var login= findViewById<EditText>(R.id.login).text.toString()
        presenter.setUserName(login)
        setContentView(R.layout.activity_main)

        val title: TextView = findViewById(R.id.title)
        title.text = login
        val fragmentAdapter = PagerAdapter(supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = fragmentAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

    }
}
