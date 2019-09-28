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

    var currentPackage: CurrentPackage? = null

    var packageCounter: Int = 0

    var dayCycleToPackages: Float = dayCycle.toFloat() / packagesPerCycle
        private set

    /**
     * Добавить новую пачку сигарет.
     */
    fun changePackage() {
        packageCounter++

        updatePackage()
    }

    /**
     * Обновляет текущую пачку сигарет.
     */
    private fun updatePackage() {
        currentPackage = CurrentPackage()
    }

    /**
     * Попробовать заплатить за текущую пачку сигарет и обновить данные.
     */
    fun tryBuyPackage() {
        if (currentPackage != null) {
            if (currentPackage!!.isFull) {
                // пачку сигарет купили, обновляем текущую пачку.
                changePackage()
            }
        }
    }

}
