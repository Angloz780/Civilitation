package com.di.civikotlin

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
import java.io.File

class MapaController {

    lateinit var root : GridPane
    private val mapa = Mapa()
    private val subMapa = mapa.obtenerMapaPorPosiciones(1,1, Configuracion.rangoVision)

    fun initialize() {
        iniciarGridPane()
        rellenarGirdPaneConMapa(subMapa)
    }

    private fun iniciarGridPane() {
        for (columna in 0 until Configuracion.columnasCampoVision)
            for (fila in 0 until Configuracion.filasCampoVision) {
                val vBox = VBox()
                vBox.children.add(0, ImageView())
                vBox.children.add(1, Label("fila $fila columna $columna"))
                root.add(vBox, columna, fila)
                vBox.alignment = Pos.CENTER

            }
        root.hgap = 5.0
        root.vgap = 5.0
        root.padding = Insets(50.0, 50.0, 50.0, 50.0)
    }

    private fun rellenarGirdPaneConMapa(subMapa: MutableList<MutableList<Terreno>>) {

        var pos = 0

        subMapa.forEachIndexed { _, terrenos ->
            terrenos.forEachIndexed { _, terreno ->

                val vBox = root.children[pos]
                vBox as VBox
                vBox.style = terreno.fondo

                val imageView = vBox.children[0] as ImageView
                println(terreno.imagen)
                val f = File(terreno.imagen)
                imageView.fitHeight = 60.0
                imageView.fitWidth = 60.0
                imageView.image = Image(f.toURI().toURL().toString())

                val label = vBox.children[1] as Label
                label.text = terreno.nombre
                label.maxWidth = 80.0
                label.style = terreno.fondo
                label.alignment = Pos.CENTER

                pos++
            }
        }
    }

    fun moverArriba() {
        println("Arriba")
        mapa.moverArriba()
        rellenarGirdPaneConMapa(mapa.obtenerMapaPorPosiciones())
    }
    fun moverAbajo(){
        println("Abajo")
        mapa.moverAbajo()
        rellenarGirdPaneConMapa(mapa.obtenerMapaPorPosiciones())
    }
    fun moverDerecha(){
        println("Derecha")
        mapa.moverDerecha()
        rellenarGirdPaneConMapa(mapa.obtenerMapaPorPosiciones())
    }
    fun moverIzquierda(){
        println("Izquierda")
        mapa.moverIzquierda()
        rellenarGirdPaneConMapa(mapa.obtenerMapaPorPosiciones())
    }
}