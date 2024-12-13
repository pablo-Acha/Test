package com.example.spamear.dataclass

import java.io.Serializable

data class Zonas(
    val id : Int,
    var checkeo : Boolean,
    val nombreZona :String,
    val zonas: String

): Serializable
