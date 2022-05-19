package com.di.civikotlin

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.MouseEvent
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
import javafx.stage.Stage
import java.io.File

class MapaController {

    @FXML
    private lateinit var posi: Label
    @FXML
    private lateinit var psiciones: Label

    lateinit var root : GridPane

    var mapa = Mapa()
    var subMapa =  mapa.obtenerMapaPorPosiciones(0,0,Configuracion.rangoVision)

    fun initialize() {
        iniciarGridPane()
        rellenarGirdPane(subMapa)
    }

    private fun iniciarGridPane() {

        for (columna in 0 until Configuracion.columnasCampoVision)
            for (fila in 0 until Configuracion.filasCampoVision) {
                val vBox = VBox()
                vBox.children.add(0, ImageView())
                vBox.children.add(1, Label())
                root.add(vBox, columna, fila)

            }
        root.hgap = 5.0
        root.vgap = 5.0
        root.padding = Insets(50.0, 50.0, 50.0, 50.0)
    }

    private fun rellenarGirdPane(subMapa: MutableList<MutableList<Terreno>>) {

        var posicion = 0

        subMapa.forEach { terreno1 ->
            terreno1.forEach {terreno2 ->

                val vBox = root.children[posicion]

                vBox as VBox

                val imageView = vBox.children[0] as ImageView
                val f = File(terreno2.imagen)

                val nombre = vBox.children[1] as Label

                if (terreno2.estado != ""){
                    nombre.text = terreno2.estado
                }else{
                    nombre.text = terreno2.nombre
                }

                nombre.maxWidth = 80.0
                nombre.style = terreno2.fondoPaisaje
                nombre.alignment = Pos.CENTER

                vBox.setOnMouseClicked {
                    posi.text = "El terreno es "+terreno2.nombre
                    abrirVentanaDetails(terreno2)
                }

                vBox.style = terreno2.fondoPaisaje

                imageView.fitHeight = 80.0
                imageView.fitWidth = 80.0
                imageView.image = Image(f.toURI().toURL().toString())

                val label = vBox.children[1] as Label

                label.text = terreno2.nombre
                label.maxWidth = 80.0
                label.style = terreno2.fondo
                label.alignment = Pos.CENTER

                posicion++
            }

            mostrarPosiconActual()
        }
    }

    fun moverArriba() {
        println("Arriba")
        mapa.moverArriba()
        rellenarGirdPane(mapa.obtenerMapaPorPosiciones())
        mostrarPosiconActual()

    }
    fun moverAbajo(){
        println("Abajo")
        mapa.moverAbajo()
        rellenarGirdPane(mapa.obtenerMapaPorPosiciones())
        mostrarPosiconActual()
    }
    fun moverDerecha(){
        println("Derecha")
        mapa.moverDerecha()
        rellenarGirdPane(mapa.obtenerMapaPorPosiciones())
        mostrarPosiconActual()
    }
    fun moverIzquierda(){
        println("Izquierda")
        mapa.moverIzquierda()
        rellenarGirdPane(mapa.obtenerMapaPorPosiciones())
        mostrarPosiconActual()
    }

    @FXML
    fun clickDeRestauracion(mouseEvent: MouseEvent) {
        rellenarGirdPane(mapa.obtenerMapaPorPosiciones(0,0, Configuracion.rangoVision))
    }

    fun mostrarPosiconActual() {
        psiciones.text = "Posicion actual ( "+ mapa.obtenerColumnaActual() + "," +mapa.obtenerFilaActual() + ")"
    }

    fun reconstruir(){
        rellenarGirdPane(subMapa)

    }

    fun abrirVentanaDetails(terreno: Terreno){
        val stage = Stage()
        val loader = FXMLLoader(javaClass.getResource("details.fxml"))
        val root = loader.load<AnchorPane>()
        val scene = Scene(root,720.0,462.0)
        stage.scene = scene
        stage.show()
        val detailsController = loader.getController<DetailsController>()
        detailsController.enviarTerreno(terreno)
        detailsController.comprobacionDeEstado()
        detailsController.imagenesOcultas()
        detailsController.enviarDatos(this)
    }

}