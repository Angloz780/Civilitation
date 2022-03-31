package com.di.civikotlin

import kotlin.random.Random

class Mapa {

    init{
        var mapa = MutableList(100){
            MutableList(100){

                //var numRandom = (0..5).random()
                var numRandom = Random.nextInt(0,100)

                when{
                    numRandom in  0..24 -> Terreno("Llanura", "llanura.jpg", true)
                    numRandom in 25..44 -> Terreno("Colina","colina.jpg", true)
                    numRandom in 45..64 -> Terreno("Bosque","bosque.jpg", true)
                    numRandom in 65..74 -> Terreno("Montaña","montaña.jpg", false)
                    numRandom in 75..94 -> Terreno("Mar","mar.jpg", false)
                    numRandom in 95..100-> Terreno("Ciudad","ciudad.jpg", true)
                    else -> {Terreno("Terreno desconocido", "llanura.jpg", false)}
                }
            }
        }
        println(mapa)
    }
}