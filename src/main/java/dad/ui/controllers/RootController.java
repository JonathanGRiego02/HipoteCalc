package dad.ui.controllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class RootController implements Initializable {

    @FXML
    private TableColumn<?, ?> anyosColumn;

    @FXML
    private TextField añosTextField;

    @FXML
    private Button calcularButton;

    @FXML
    private TableColumn<?, ?> capitalColumn;

    @FXML
    private TextField capitalTextField;

    @FXML
    private TableColumn<?, ?> cuotasColumn;

    @FXML
    private TableView<?> datosTableView;

    @FXML
    private TableColumn<?, ?> interesColumn;

    @FXML
    private TextField interesTextField;

    @FXML
    private BorderPane root;

    @FXML
    void onCalcularAction(ActionEvent event) {

    }

    public RootController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
