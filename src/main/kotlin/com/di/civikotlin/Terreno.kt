package com.di.civikotlin

data class Terreno(val nombre: String, val imagen: String, val fondo: String, val sePuedeAndarSobreEl: Boolean) {

    companion object {

        fun crearLlanura(): Terreno {
            return Terreno("Llanura", "src\\main\\resources\\Terreno\\Plane.png", "-fx-background-color: #26B743;",true)
        }

        fun crearColina(): Terreno {
            return Terreno("Colina", "src\\main\\resources\\Terreno\\Hill.png", "-fx-background-color: #6D4C41;", true)
        }

        fun crearBosque(): Terreno {
            return Terreno("Bosque", "src\\main\\resources\\Terreno\\Bosque.png", "-fx-background-color: #33691E;", true)
        }

        fun crearMontana(): Terreno {
            return Terreno("Montana", "src\\main\\resources\\Terreno\\Mountain.png","-fx-background-color: #5D4037;", false)
        }

        fun crearMar(): Terreno {
            return Terreno("Mar", "src\\main\\resources\\Terreno\\Mar.png","-fx-background-color: #0288D1;", false)
        }

        fun crearCiudad(): Terreno {
            return Terreno("Ciudad", "src\\main\\resources\\Terreno\\Village.png","-fx-background-color: #686363;", true)
        }

        fun crearDesconocido(): Terreno {
            return Terreno("Terreno desconocido", "src\\main\\resources\\Terreno\\Desconocido.png","-fx-background-color: #90A4AE;", false)
        }
    }
}