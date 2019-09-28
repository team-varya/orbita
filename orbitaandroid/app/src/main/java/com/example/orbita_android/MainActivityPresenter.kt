package com.example.orbita_android

import com.example.orbita_android.models.User

/**
 * Добавляет бизнес-логику приложению.
 */
public class MainActivityPresenter (val view: View){
    private val user: User = User()

    fun setUserName(username: String) {
        user.username = username
    }

    /**
     * Здесь хронятся методы, которые должны реализовываться во view.
     */
    public interface View {

    }
}