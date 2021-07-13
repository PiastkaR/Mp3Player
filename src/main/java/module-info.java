module mp3player {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports com.mp3player.main to javafx.graphics;
    opens com.mp3player.controller to javafx.fxml;
}