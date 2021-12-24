package com.franco.test.data.model

data class Pokemon(
    val name: String,
    val hability: MutableList<Hability> = mutableListOf(),
    val type: MutableList<Type> = mutableListOf(),
    val img: String
)

data class Hability(
    val hability: String
)

data class Type(
    val type: String
)