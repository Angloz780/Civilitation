package com.di.civikotlin

import kotlin.random.Random

class Mapa {

    private val vision = 1

    var matriz = MutableList(100) {
        MutableList(100) {

            //var numRandom = (0..100).random()
            var numRandom = Random.nextInt(0, 100)

            when (numRandom) {
                in  0..24 -> Terreno.crearLlanura()
                in 25..44 -> Terreno.crearColina()
                in 45..64 -> Terreno.crearBosque()
                in 65..74 -> Terreno.crearMontana()
                in 75..94 -> Terreno.crearMar()
                in 95..99 -> Terreno.crearCiudad()
                else -> {
                    Terreno.crearDesconocido()
                }
            }
        }
    }
    init {
        println(matriz)
    }
    fun obtenerMapaPorPosicion(columna: Int, fila: Int): MutableList<MutableList<Unit>> {

        matriz[columna][fila]

        var posicionJugador = MutableList(11){
            MutableList(11){

                for (i in matriz) {
                    matriz[columna + 5][fila]
                    matriz[columna - 5][fila]
                    matriz[columna][fila + 5]
                    matriz[columna][fila - 5]
                }
            }
        }
        return posicionJugador
    }
}