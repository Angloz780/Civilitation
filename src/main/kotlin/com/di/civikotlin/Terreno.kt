package com.di.civikotlin

data class Terreno(val nombre: String, val imagen: String, val sePuedeAndarSobreEl: Boolean) {

    companion object {

        fun crearLlanura(): Terreno {
            return Terreno("Llanura", "src\\main\\resources\\Terreno\\Plane.png",true)
        }

        fun crearColina(): Terreno {
            return Terreno("Colina", "src\\main\\resources\\Terreno\\Hill.png", true)
        }

        fun crearBosque(): Terreno {
            return Terreno("Bosque", "src\\main\\resources\\Terreno\\Bosque.png", true)
        }

        fun crearMontana(): Terreno {
            return Terreno("Montana", "src\\main\\resources\\Terreno\\Mountain.png", false)
        }

        fun crearMar(): Terreno {
            return Terreno("Mar", "src\\main\\resources\\Terreno\\Mar.png", false)
        }

        fun crearCiudad(): Terreno {
            return Terreno("Ciudad", "src\\main\\resources\\Terreno\\Village.png", true)
        }

        fun crearDesconocido(): Terreno {
            return Terreno("Terreno desconocido", "src\\main\\resources\\Terreno\\Desconocido.png", false)
        }
    }
}