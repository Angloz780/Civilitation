package com.di.civikotlin

import kotlin.random.Random

class Mapa {

    private var matriz = MutableList(5) {
        MutableList(5) {

            //var numRandom = (0..100).random()

            when (Random.nextInt(0, 100)) {
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

    fun obtenerMapaPorPosicion(filPersonaje: Int, colPersonaje: Int, rango: Int) : MutableList<MutableList<Terreno>>{

        val subMapa = MutableList((rango * 2) + 1) { colActual ->
            MutableList((rango * 2) + 1) { filActual ->
                if (filActual - filPersonaje - rango < 0 || colActual - colPersonaje - rango < 0) {
                    Terreno.crearDesconocido()
                }else {
                    matriz[colActual - colPersonaje - rango][filActual - filPersonaje - rango]
                }
            }
        }
        println(subMapa)
        return subMapa
    }
}