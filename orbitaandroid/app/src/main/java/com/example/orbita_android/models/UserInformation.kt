package com.example.orbita_android.models



/**
 * Информация о пользователе.
 * @param packageCost -- стоимость пачки сигарет.
 * @param dayCycle -- количество дней.
 * @param packagesPerCycle -- количество пачек сигарет, выкуриваемых пользователем в dayCycle дней.
 */
class UserInformation (
    var packageCost: Int,
    var dayCycle: Int,
    var packagesPerCycle: Int
){

    /**
     * Полная сумма денег, сэкономлеммая пользователем.
     */
    var fullCost: Int = 0

    /**
     * Добавить неиспользованную пачку сигарет.
     */
    fun addPackage() {
    }

}
