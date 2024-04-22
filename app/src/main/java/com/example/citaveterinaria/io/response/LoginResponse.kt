package com.example.citaveterinaria.io.response

import com.example.citaveterinaria.model.User

data class LoginResponse(
    val success: Boolean,
    val user:User,
    val jwt:String
)
