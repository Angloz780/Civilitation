package com.di.civikotlin

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.AnchorPane
import java.io.File

class DetailsController {

    var mapaController = MapaController()
    var terreno : Terreno? = null

    @FXML
    private lateinit var nombre: Label
    @FXML
    private lateinit var imagen: ImageView
    @FXML
    private lateinit var andar: Label
    @FXML
    private lateinit var fondo: AnchorPane
    @FXML
    private lateinit var bt1: Button
    @FXML
    private lateinit var bt2: Button
    @FXML
    private lateinit var bt3: Button
    @FXML
    private lateinit var bt4: Button
    @FXML
    private lateinit var saqueo: ImageView
    @FXML
    private lateinit var conquista: ImageView
    @FXML
    private lateinit var mina: ImageView
    @FXML
    private lateinit var granja: ImageView
    @FXML
    private lateinit var estado: Label

    fun enviarTerreno(terreno: Terreno) {

        this.terreno = terreno

        nombre.text = "El terreno que has seleccionado es: "+ terreno.nombre
        andar.text = "¿Es transitable el terreno? " + terreno.sePuedeAndarSobreEl.toString()
        fondo.style = terreno.fondoPaisaje

        val f = File(terreno.imagen)
        imagen.image = Image(f.toURI().toURL().toString())

        comprobacionDeEstado()

    }

    fun comprobacionDeEstado(){

        if (terreno?.nombre == "Ciudad"){
            bt1.isVisible = true
            bt2.isVisible = true
            bt3.isVisible = false
            bt4.isVisible = false
        }

        if (terreno?.nombre == "Colina"){
            bt1.isVisible = false
            bt2.isVisible = false
            bt3.isVisible = true
            bt4.isVisible = false
        }

        if (terreno?.nombre == "Llanura"){
            bt1.isVisible = false
            bt2.isVisible = false
            bt3.isVisible = false
            bt4.isVisible = true
        }

        if (terreno?.nombre == "Bosque"){
            bt1.isVisible = false
            bt2.isVisible = false
            bt3.isVisible = false
            bt4.isVisible = false
        }

        if (terreno?.nombre == "Mar"){
            bt1.isVisible = false
            bt2.isVisible = false
            bt3.isVisible = false
            bt4.isVisible = false
        }

        if (terreno?.nombre == "Montaña"){
            bt1.isVisible = false
            bt2.isVisible = false
            bt3.isVisible = false
            bt4.isVisible = false
        }

        if (terreno?.nombre == "Terreno desconocido"){
            bt1.isVisible = false
            bt2.isVisible = false
            bt3.isVisible = false
            bt4.isVisible = false
        }
    }
    @FXML
    fun cambiarEstado1() {
        terreno?.estado = "Saqueado"
        estado.text = "El estado del lugar es " + terreno?.estado
        mapaController.reconstruir()
        saqueo.isVisible = true
        conquista.isVisible = false
        mina.isVisible = false
        granja.isVisible = false
    }

    @FXML
    fun cambiarEstado2() {
        terreno?.estado = "Conquistado"
        estado.text = "El estado del lugar es " + terreno?.estado
        mapaController.reconstruir()
        conquista.isVisible = true
        saqueo.isVisible = false
        mina.isVisible = false
        granja.isVisible = false
    }

    @FXML
    fun cambiarEstado3() {
        terreno?.estado = "Mina"
        estado.text = "El estado del lugar es " + terreno?.estado
        mapaController.reconstruir()
        conquista.isVisible = false
        saqueo.isVisible = false
        mina.isVisible = true
        granja.isVisible = false
    }

    @FXML
    fun cambiarEstado4() {
        terreno?.estado = "Granja"
        estado.text = "El estado del lugar es " + terreno?.estado
        mapaController.reconstruir()
        conquista.isVisible = false
        saqueo.isVisible = false
        mina.isVisible = false
        granja.isVisible = true
    }

    fun enviarDatos(mapaController: MapaController){
        this.mapaController=mapaController
    }

    fun imagenesOcultas(){

        val imagen1 = File("src\\main\\resources\\Terreno\\ic_corona.png")
        conquista.image = Image(imagen1.toURI().toURL().toString())
        conquista.isVisible=false

        val imagen2 = File("src\\main\\resources\\Terreno\\ic_granja.png")
        granja.image = Image(imagen2.toURI().toURL().toString())
        granja.isVisible = false

        val imagen3= File("src\\main\\resources\\Terreno\\ic_mina.png")
        mina.image = Image(imagen3.toURI().toURL().toString())
        mina.isVisible = false

        val imagen4 = File("src\\main\\resources\\Terreno\\ic_fuego.png")
        saqueo.image = Image(imagen4.toURI().toURL().toString())
        saqueo.isVisible = false

    }
}