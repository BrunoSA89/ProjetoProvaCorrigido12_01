package com.example.novoprojetoapp12janeiro.Model

import java.io.Serializable

data class DataCalculo(
    var nome: String,
    var media: Float
) : Serializable

//Serialezable puxa o args, ficar em formato de objeto