package com.example.orbita_android.models

class User(val username: String, var name: String) {
    var currentGoal: Goal? = null
    var previousGoals = mutableListOf<Goal>()
    var information: UserInformation? = null
}