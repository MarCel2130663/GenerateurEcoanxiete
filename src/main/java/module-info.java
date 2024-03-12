module com.example.generateurecoanxiete {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires junit;

    opens com.example.generateurecoanxiete to javafx.fxml;
    exports com.example.generateurecoanxiete;
    exports com.example.generateurecoanxiete.testsUnitaires;
    opens com.example.generateurecoanxiete.testsUnitaires to javafx.fxml;
    exports com.example.generateurecoanxiete.controllers;
    opens com.example.generateurecoanxiete.controllers to javafx.fxml;
}