package com.joabesantana.thedogceoapiapp.model

import java.io.Serializable

data class Height(
    val imperial: String,
    val metric: String,
) : Serializable