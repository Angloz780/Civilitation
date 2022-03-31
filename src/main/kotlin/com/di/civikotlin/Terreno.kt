package com.di.civikotlin

data class Terreno(val nombre: String, val imagen: String, val sePuedeAndarSobreEl: Boolean) {

    companion object {

        fun crearLlanura(): Terreno {
            return Terreno("Llanura", "llanura.jpg", true)
        }

        fun crearColina(): Terreno {
            return Terreno("Colina", "colina.jpg", true)
        }

        fun crearBosque(): Terreno {
            return Terreno("Bosque", "bosque.jpg", true)
        }

        fun crearMontana(): Terreno {
            return Terreno("Montaña", "montaña.jpg", false)
        }

        fun crearMar(): Terreno {
            return Terreno("Mar", "mar.jpg", false)
        }

        fun crearCiudad(): Terreno {
            return Terreno("Ciudad", "ciudad.jpg", true)
        }

        fun crearDesconocido(): Terreno {
            return Terreno("Terreno desconocido", "desconocido.jpg", false)
        }
    }
}