package com.example.orbita_android.models

/**
 *Информация о текущей пачке
 * @property numberOfPack -- Порядковый номер текущей пачки
 */
class CurrentPackInformation(
    var numberOfPack: Int = 1
) {
    /**
     * Число сигарет в текущей пачке
     */
    var countOfSigarets = 0
        private set(value){
            if (value == 20) {
                field = 0
                numberOfPack++
            }
        }

    /**
     * Получить процент заполненности текущей пачки
     */
    fun getInfo(): Int = countOfSigarets * 100 / 20

    /**
     * Увеличить число сигарет в текущей пачке на единицу. Обновить пачку, если число сигарет достигло 20
     */
    fun addSigaret() {
        countOfSigarets++
    }
}