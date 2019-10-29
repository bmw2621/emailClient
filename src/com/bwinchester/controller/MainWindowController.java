package com.bwinchester.controller;

import com.bwinchester.EmailManager;
import com.bwinchester.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

public class MainWindowController extends BaseController {

    public MainWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    private MenuItem closeFileMenu;

    @FXML
    private MenuItem openFileMenu;

    @FXML
    private MenuItem opetionsEditMenu;

    @FXML
    private TreeView<?> emailTreeView;

    @FXML
    private TableView<?> emailTableView;

    @FXML
    private WebView emailWebView;

    @FXML
    void closeAction() {

    }

    @FXML
    void openAction() {

    }

    @FXML
    void optionsAction() {
        viewFactory.showOptionWindow();
    }

}
