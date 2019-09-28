package com.example.orbita_android.models

/**
 * Информация о пользователе.
 * @param packageCost -- стоимость пачки сигарет.
 * @param dayCycle -- количество дней.
 * @param packagesPerCycle -- количество пачек сигарет, выкуриваемых пользователем в dayCycle дней.
 */
class SmokePackInformation (
    var packageCost: Int,
    var dayCycle: Int,
    var packagesPerCycle: Int
){

    /**
     * Полная сумма денег, сэкономленная пользователем.
     */
    var fullCost: Int = 0
        private set

    var packageCounter: Int = 0
        private set

    var dayCycleToPackages: Float = dayCycle.toFloat() / packagesPerCycle
        private set

    /**
     * Добавить неиспользованную пачку сигарет.
     */
    fun addPackage() {
        packageCounter++
        fullCost += packageCost
    }

}
