package com.di.civikotlin

import kotlin.random.Random

class Mapa {

    private var matriz = MutableList(Configuracion.columnas) {
        MutableList(Configuracion.filas) {

            when (Random.nextInt(0,100)) {
                in  0..24 -> Terreno.crearLlanura()
                in 25..44 -> Terreno.crearColina()
                in 45..64 -> Terreno.crearBosque()
                in 65..69 -> Terreno.crearCiudad()
                in 70..89 -> Terreno.crearMar()
                in 90..99 -> Terreno.crearMontana()
                else -> {
                    Terreno.crearDesconocido()
                }
            }
        }
    }

    fun obtenerMapaPorPosiciones(fila : Int, columna : Int, rango: Int) : MutableList<MutableList<Terreno>>{

        val matriz2 = MutableList((rango * 2) + 1) { filaActual ->
            MutableList((rango * 2) + 1) { columnaActual ->
                if (fila - filaActual - rango < 0 || columna - columnaActual - rango < 0 || fila + filaActual - rango > Configuracion.filas || columna + columnaActual - rango > Configuracion.columnas) {
                    Terreno.crearDesconocido()
                }else {
                    matriz[fila - filaActual - rango][columna - columnaActual - rango]
                }
            }
        }
        println(matriz2)
        return matriz2
    }
}