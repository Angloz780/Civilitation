module com.di.civikotlin {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.di.civikotlin to javafx.fxml;
    exports com.di.civikotlin;
}