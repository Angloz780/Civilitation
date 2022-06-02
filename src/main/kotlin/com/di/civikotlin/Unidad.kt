package com.di.civikotlin

class Unidad (val tipo: String, val imagen: String, val vida: Int){

    companion object {

        fun caballero(): Unidad {
            return Unidad("Caballero","src\\main\\resources\\Unidad\\caballero.png", 100)
        }

        fun guerrero(): Unidad {
            return Unidad("Guerrero", "src\\main\\resources\\Unidad\\guerrero.png", 100)
        }

        fun lancero(): Unidad {
            return Unidad("Lancero", "src\\main\\resources\\Unidad\\lancero.png", 100)
        }

        fun vacio(): Unidad {
            return Unidad("Vacio", "", 0)
        }
    }
}