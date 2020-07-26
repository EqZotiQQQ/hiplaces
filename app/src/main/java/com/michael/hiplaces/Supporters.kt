package com.michael.hiplaces

import kotlinx.serialization.Serializable

interface IBoxedData

@Serializable
data class SignInBoxedData(val username: String,
                           val password: String)
    :IBoxedData { }

@Serializable
data class SignUpBoxedData(val username: String,
                           val email: String,
                           val password: String)
    :IBoxedData { }
