module pierre.lab5cc {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens pierre.lab5cc to javafx.fxml;
    exports pierre.lab5cc;
}