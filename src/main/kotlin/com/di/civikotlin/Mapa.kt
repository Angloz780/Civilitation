package com.di.civikotlin

import kotlin.random.Random

class Mapa {

    class PosicionActual(var fila: Int, var columna: Int)

    private var posicionActual = PosicionActual(0, 0)

    private var matriz = MutableList(Configuracion.columnas) {
        MutableList(Configuracion.filas) {

           val terreno = when (Random.nextInt(0, 100)) {
                in 0..24 -> Terreno.crearLlanura()
                in 25..44 -> Terreno.crearColina()
                in 45..64 -> Terreno.crearBosque()
                in 65..69 -> Terreno.crearCiudad()
                in 70..89 -> Terreno.crearMar()
                in 90..99 -> Terreno.crearMontana()
                else -> {
                    Terreno.crearDesconocido()
                }
            }
            if (terreno.sePuedeAndarSobreEl){
                val unidadRandom = when(Random.nextInt(0, 5)){
                    in 0..1 -> Unidad.caballero()
                    in 2..3 -> Unidad.lancero()
                    in 3..4 -> Unidad.guerrero()
                    else -> {
                        Unidad.vacio()
                    }
                }
                terreno.unidad = unidadRandom
            }
            terreno
        }
    }
    fun moverArriba() {
        posicionActual.fila--
    }

    fun moverAbajo() {
        posicionActual.fila++
    }

    fun moverIzquierda() {
        posicionActual.columna--
    }

    fun moverDerecha() {
        posicionActual.columna++
    }

    fun obtenerMapaPorPosiciones(fila: Int = posicionActual.fila, columna: Int = posicionActual.columna, vision: Int = Configuracion.rangoVision): MutableList<MutableList<Terreno>> {

        posicionActual.fila = fila
        posicionActual.columna = columna

        val subMapa = MutableList(Configuracion.filasCampoVision) {
            MutableList(Configuracion.columnasCampoVision) {
                Terreno.crearDesconocido()
            }
        }
        for ((filaActual, filaActualMapaGrande) in ((fila - vision)..(fila + vision)).withIndex()) {
            println("Fila actual = $filaActual")

            for ((columnaActual, columnaActualMapaGrande) in ((columna - vision)..(columna + vision)).withIndex()) {
                println("Columna actual = $columnaActual")

                if (!(columnaActualMapaGrande < 0 || filaActualMapaGrande < 0 || columnaActualMapaGrande >= Configuracion.columnas || filaActualMapaGrande >= Configuracion.filas)) {
                    subMapa[columnaActual][filaActual] = matriz[columnaActualMapaGrande][filaActualMapaGrande]
                }
            }
        }
        println(subMapa)
        return subMapa
    }

    fun obtenerFilaActual(): Int {
        return posicionActual.fila
    }

    fun obtenerColumnaActual(): Int {
        return posicionActual.columna
    }

}