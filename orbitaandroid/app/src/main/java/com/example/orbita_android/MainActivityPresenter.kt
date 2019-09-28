package com.example.orbita_android

import com.example.orbita_android.models.Goal
import com.example.orbita_android.models.SmokePackInformation
import com.example.orbita_android.models.User

/**
 * Добавляет бизнес-логику приложению.
 */
public class MainActivityPresenter (val view: View){
    private val user: User = User()

    fun setUserName(username: String) {
        user.username = username
    }

    fun setUserInfo(packageCost: Int, dayCycle: Int, packagesPerCycle: Int) {
        user.smokePackInformation = SmokePackInformation(packageCost, dayCycle, packagesPerCycle)
    }

    fun setUserGoal(title: String, goalMoney: Int) {
        user.currentGoal = Goal(title, goalMoney)
    }

    /**
     * Здесь хронятся методы, которые должны реализовываться во view.
     */
    public interface View {

    }
}