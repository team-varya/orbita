package com.example.orbita_android.models

/**
 * Информация о пачке сигарет.
 */
class CurrentPackage {

    /**
     * Количество сигарет в пачке (пока захардкожено)
     */
    private val cigarettesNumberInPack: Int = 20

    var isFull: Boolean = false

    /**
     * Число сигарет в текущей пачке
     */
    var countOfCigarettes = 0
        set(value){
            if (value >= cigarettesNumberInPack) {
                // Нельзя иметь в пачке сигарет больше, чем пачка вмещает в себя
                isFull = true
                field = cigarettesNumberInPack
            }
            else {
                field = value
            }
        }

    /**
     * Получить процент заполненности текущей пачки
     */
    // fun getInfo(): Int = countOfCigarettes * 100 / 20
    var occupancyPercentage: Int = countOfCigarettes * 100 / 20

    /**
     * Увеличить число сигарет в текущей пачке на единицу. Обновить пачку, если число сигарет достигло 20
     */
    fun addCigarette() {
        countOfCigarettes++
    }
}