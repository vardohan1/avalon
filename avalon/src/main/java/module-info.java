module com.example.avalon {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires static lombok;

    opens com.example.avalon to javafx.fxml;
    exports com.example.avalon;
    exports com.example.avalon.model;
    opens com.example.avalon.model to javafx.fxml;
}