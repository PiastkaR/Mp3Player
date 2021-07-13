package com.mp3player.controller;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class MenuPaneController {
    @FXML
    private MenuItem fileMenuItem;

    @FXML
    private MenuItem dirMenuItem;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private MenuItem aboutMenuItem;

    public void initialize() {
        System.out.println("Menu controller created");
    }
}
