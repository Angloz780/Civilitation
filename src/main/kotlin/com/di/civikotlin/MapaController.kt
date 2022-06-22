package com.di.civikotlin

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
import javafx.stage.Stage
import java.io.File
import kotlin.random.Random

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
                val vBox = AnchorPane()
                vBox.children.add(0, ImageView())
                vBox.children.add(1, ImageView())
                vBox.children.add(2, Label())
                root.add(vBox, columna, fila)

            }
        root.hgap = 5.0
        root.vgap = 5.0
    }

    private fun rellenarGirdPane(subMapa: MutableList<MutableList<Terreno>>) {

        var posicion = 0

        subMapa.forEach { terreno1 ->
            terreno1.forEach {terreno2 ->

                val vBox = root.children[posicion]

                vBox as AnchorPane
                var f2 = File("")

                val imageView = vBox.children[0] as ImageView
                val f = File(terreno2.imagen)

                val nombre = vBox.children[2] as Label

                val imageView2 = vBox.children[1] as ImageView
                terreno2.unidad?.let {
                    f2 = File(it.imagen)
                }

                if (terreno2.estado != ""){
                    nombre.text = terreno2.estado
                }else{
                    nombre.text = terreno2.nombre
                }

                nombre.layoutX = 0.0
                nombre.layoutY = 80.0
                nombre.minHeight = 20.0
                nombre.minWidth = 120.0
                nombre.alignment = Pos.CENTER
                nombre.style = terreno2.fondoPaisaje

                vBox.setOnMouseClicked {
                    posi.text = "El terreno es "+terreno2.nombre
                    abrirVentanaDetails(terreno2)
                }

                if (terreno2.unidad?.seleccionado == true){
                    vBox.style = terreno2.fondo
                }else{
                    vBox.style = terreno2.fondoPaisaje
                }

                imageView2.layoutX = 5.0
                imageView2.layoutY = 5.0
                imageView2.fitHeight = 25.0
                imageView2.fitWidth = 25.0
                imageView2.image = Image(f2.toURI().toURL().toString())

                imageView.layoutX = 25.0
                imageView.layoutY = 30.0
                imageView.fitHeight = 50.0
                imageView.fitWidth =60.0
                imageView.image = Image(f.toURI().toURL().toString())

                posicion++
            }

            mostrarPosiconActual()
        }
    }
    fun moverPersonaje(terreno: Terreno){

        if (terreno.unidad?.seleccionado == true){
            mapa.moverArriba()
            mapa.moverAbajo()
            mapa.moverDerecha()
            mapa.moverIzquierda()
        }else{
            moverArriba()
            moverAbajo()
            moverDerecha()
            moverIzquierda()
        }
    }

    fun mirarSiAbajoEsTransitable(terreno: Terreno){

        if (!terreno.sePuedeAndarSobreEl){
            mostrarAlertInfo()
        }else{
            mapa.moverAbajo()
        }
    }

    fun mirarSiArribaEsTransitable(terreno: Terreno){

        if (!terreno.sePuedeAndarSobreEl){
            mostrarAlertInfo()
        }else{
            mapa.moverArriba()
        }
    }

    fun mirarSiDerechaEsTransitable(terreno: Terreno){

        if (!terreno.sePuedeAndarSobreEl){
            mostrarAlertInfo()
        }else{
            mapa.moverDerecha()
        }
    }

    fun mirarSiIzquierdaEsTransitable(terreno: Terreno){

        if (!terreno.sePuedeAndarSobreEl){
            mostrarAlertInfo()
        }else{
            mapa.moverIzquierda()
        }
    }

    @FXML
    fun mostrarAlertInfo() {
        val alert = Alert(Alert.AlertType.INFORMATION)
        alert.headerText = null
        alert.title = "Informacion"
        alert.contentText = "Terreno no transitable"
        alert.showAndWait()
    }

    fun mirarSiHayUnidad(terreno: Terreno){

        if (terreno.unidad != null && comprobarVentana){
            //batalla
        }else{


        }

    }

    fun realizarBatalla(unidad: Unidad){

        val random = Random.nextInt(25,50)

        unidad.vida = unidad.vida - random

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
    fun clickDeRestauracion() {
        rellenarGirdPane(mapa.obtenerMapaPorPosiciones(0,0, Configuracion.rangoVision))
    }

    fun mostrarPosiconActual() {
        psiciones.text = "Posicion actual ( "+ mapa.obtenerColumnaActual() + "," +mapa.obtenerFilaActual() + ")"
    }

    fun reconstruir(){
        rellenarGirdPane(subMapa)
    }

    var comprobarVentana = false

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