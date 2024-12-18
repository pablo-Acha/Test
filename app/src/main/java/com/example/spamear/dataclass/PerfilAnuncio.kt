package com.example.spamear.dataclass

import java.io.Serializable

data class PerfilAnuncio(
    val titulo: String,
    val nombre: String,
    val imagen: String, //xd
    val descripcion: String
): Serializable
