package com.di.civikotlin

class Unidad (val tipo: String, val imagen: String, var vida: Int, var seleccionado: Boolean = false){

    companion object {

        fun caballero(): Unidad {
            return Unidad("Caballero","src\\main\\resources\\com\\di\\civikotlin\\Unidad\\caballero.png", 100)
        }

        fun guerrero(): Unidad {
            return Unidad("Guerrero", "src\\main\\resources\\com\\di\\civikotlin\\Unidad\\guerrero.png", 100)
        }

        fun lancero(): Unidad {
            return Unidad("Lancero", "src\\main\\resources\\com\\di\\civikotlin\\Unidad\\lancero.png", 100)
        }

        fun vacio(): Unidad {
            return Unidad("Vacio", "", 0)
        }
    }
}