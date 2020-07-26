package com.michael.hiplaces

import kotlinx.serialization.Serializable

interface IBoxedData

@Serializable
data class SignInBoxedData(val name: String, val password: String):IBoxedData { }

@Serializable
data class SignUpBoxedData(val name: String, val email: String, val password: String, val repeatPassword: String):IBoxedData { }
