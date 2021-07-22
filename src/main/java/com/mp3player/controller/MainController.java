package com.mp3player.controller;

import javafx.fxml.FXML;

public class MainController {
    @FXML
    private ContentPaneController contentPaneController;
    @FXML
    private ControlPaneController controlPaneController;
    @FXML
    private MenuPaneController menuPaneController;

    public void initialize() {
        System.out.println("Main controller created");
        System.out.println(contentPaneController);
        System.out.println(controlPaneController);
        System.out.println(menuPaneController);
    }
}