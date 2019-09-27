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
    var previousGoals = mutableListOf<Goal>()

    var information: UserInformation? = null
    
}