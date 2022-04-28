package com.di.civikotlin

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {

        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 800.0, 620.0)
        stage.title = "Hello!"
        stage.scene = scene
        stage.show()

        val mapController = fxmlLoader.getController<MapaController>()

        scene.addEventHandler(KeyEvent.KEY_PRESSED){ keyPressed ->
            when (keyPressed.code) {
                KeyCode.UP -> {
                    println("UP")
                    mapController.moverArriba()
                }
                KeyCode.DOWN -> {
                    println("DOWN")
                    mapController.moverAbajo()
                }
                KeyCode.LEFT -> {
                    println("LEFT")
                    mapController.moverIzquierda()
                }
                KeyCode.RIGHT -> {
                    println("RIGHT")
                    mapController.moverDerecha()
                }
            }
        }
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}