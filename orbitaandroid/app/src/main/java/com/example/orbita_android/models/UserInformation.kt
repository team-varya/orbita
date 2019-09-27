package com.example.orbita_android.models



/**
 * Информация о пользователе.
 * @param packageCost -- стоимость пачки сигарет.
 * @param dayCycle -- количество дней
 * @param packagesPerCycle -- количество пачек сигарет, выкуриваемых пользователем в dayCycle дней
 */
class UserInformation (
    packageCost: Int,
    dayCycle: Int,
    packagesPerCycle: Int
){

    var fullCost: Int = 0

}
