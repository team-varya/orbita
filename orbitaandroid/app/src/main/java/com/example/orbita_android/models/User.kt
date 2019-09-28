package com.example.orbita_android.models

/**
 * Хранит информацию о пользоателе.
 * @property username -- уникальный логин пользователя.
 * @property name -- по такому имени приложение будет обращаться к пользователю.
 */
class User{
    var username: String = ""

    var currentGoal: Goal? = null

    /**
     * Успешно закрытые предыдущие цели.
     */
    val previousGoals = mutableListOf<Goal>()

    var smokePackInformation: SmokePackInformation? = null

    /**
     * Попробовать заплатить за текущую (полную) пачку сигарет.
     */
    fun tryBuyPackage () {
        if (smokePackInformation != null) {
            if (smokePackInformation!!.currentPackage != null) {
                if (smokePackInformation!!.currentPackage!!.isFull) {
                    currentGoal?.addMoney(smokePackInformation!!.packageCost)

                    smokePackInformation!!.tryBuyPackage()
                }
            }
        }
    }

    /**
     * Добавляет информацию о невыкуренной пачке сигарет.
     */
//    fun addPackage() {
//        smokePackInformation?.addPackage()
//        currentGoal?.addMoney(smokePackInformation?.packageCost ?: 0)
//
//        // текущая цель выполнена, заменяем её на null
//        if (currentGoal?.isFull == true) {
//            previousGoals.add(currentGoal!!)
//
//            currentGoal = null
//        }
//    }
}