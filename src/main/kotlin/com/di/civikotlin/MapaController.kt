package com.di.civikotlin

import javafx.geometry.Insets
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
import java.io.File

class MapaController {

    lateinit var root : GridPane
    private val map = Mapa()
    private val subMapa = map.obtenerMapaPorPosiciones(100, 100, Configuracion.rangoVision)

    fun initialize() {
        iniciarGridPane()
        rellenarGirdPaneConMapa(subMapa)
    }

    private fun iniciarGridPane() {

        for (columna in 0 until Configuracion.columnasCampoVision) {
            for (fila in 0 until Configuracion.filasCampoVision) {

                val vBox = VBox()
                vBox.children.add(0, ImageView())
                vBox.children.add(1, Label("fila $fila columna $columna"))

                root.add(vBox, columna, fila)
            }
        }
        root.hgap = 50.0
        root.vgap = 50.0
        root.padding = Insets(50.0, 50.0, 50.0, 50.0)
    }

    private fun rellenarGirdPaneConMapa(subMapa: MutableList <MutableList <Terreno>>) {

        var pos = 0

        subMapa.forEachIndexed {_, terrenos ->
            terrenos.forEachIndexed {_, terreno ->

                val view = root.children[pos]
                view as VBox
                val imageView = view.children[0] as ImageView
                println(terreno.imagen)

                val f = File(terreno.imagen)
                imageView.fitHeight = 50.0
                imageView.fitWidth = 50.0
                imageView.image = Image(f.toURI().toURL().toString())

                val label = view.children[1] as Label
                label.text = terreno.nombre
                pos++
            }
        }
    }
}