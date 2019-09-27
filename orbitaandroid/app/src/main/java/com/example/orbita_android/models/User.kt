package com.example.orbita_android.models

/**
 * Хранит информацию о пользоателе.
 * @property username -- уникальный логин пользователя.
 * @property name -- по такому имени приложение будет обращаться к пользователю.
 */
class User(val username: String, var name: String) {
    var currentGoal: Goal? = null
        private set

    /**
     * Успешно закрытые предыдущие цели.
     */
    val previousGoals = mutableListOf<Goal>()

    var smokePackInformation: SmokePackInformation? = null

    /**
     * Добавляет информацию о невыкуренной пачке сигарет.
     */
    fun addPackage() {
        smokePackInformation?.addPackage()
        currentGoal?.addMoney(smokePackInformation?.packageCost ?: 0)

        // текущая цель выполнена, заменяем её на null
        if (currentGoal?.isFull == true) {
            previousGoals.add(currentGoal!!)

            currentGoal = null
        }
    }
}