package com.example.orbita_android.models

/**
 * Определяет цель пользователя.
 * @property title -- загаловок цели
 * @property moneyGoal -- необходимое количество денег на исполнение цели.
 */
class Goal(
    val title: String,
    val moneyGoal: Int
) {
    var currentMoney = 0
        private set

    var moneyPercentage: Float = moneyGoal.toFloat() / 100 * currentMoney
        private set

    fun addMoney(money: Int){
        currentMoney += money
    }
}