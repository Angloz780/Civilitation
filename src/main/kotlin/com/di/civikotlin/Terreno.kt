package com.di.civikotlin

data class Terreno(val nombre: String, val imagen: String, val fondo: String, val sePuedeAndarSobreEl: Boolean, val fondoPaisaje: String, var estado: String = "") {

    companion object {

        fun crearLlanura(): Terreno {
            return Terreno("Llanura", "src\\main\\resources\\Terreno\\Plane.png", "-fx-background-color: #26B743;",true, "-fx-background-color: #26B743;")
        }

        fun crearColina(): Terreno {
            return Terreno("Colina", "src\\main\\resources\\Terreno\\Hill.png", "-fx-background-color: #6D4C41;", true, "-fx-background-color: #6D4C41;")
        }

        fun crearBosque(): Terreno {
            return Terreno("Bosque", "src\\main\\resources\\Terreno\\Bosque.png", "-fx-background-color: #33691E;", true, "-fx-background-color: #33691E;")
        }

        fun crearMontana(): Terreno {
            return Terreno("Montaña", "src\\main\\resources\\Terreno\\Mountain.png","-fx-background-color: #5D4037;", false, "-fx-background-color: #5D4037;")
        }

        fun crearMar(): Terreno {
            return Terreno("Mar", "src\\main\\resources\\Terreno\\Mar.png","-fx-background-color: #0288D1;", false, "-fx-background-color: #0288D1;")
        }

        fun crearCiudad(): Terreno {
            return Terreno("Ciudad", "src\\main\\resources\\Terreno\\Village.png","-fx-background-color: #686363;", true, "-fx-background-color: #686363;")
        }

        fun crearDesconocido(): Terreno {
            return Terreno("Terreno desconocido", "src\\main\\resources\\Terreno\\Desconocido.png","-fx-background-color: #90A4AE;", false, "-fx-background-color: #90A4AE;")
        }
    }
}