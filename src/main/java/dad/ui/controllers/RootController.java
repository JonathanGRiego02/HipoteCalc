package dad.ui.controllers;

import dad.api.ApiService;
import dad.api.HipotecaResponse;
import dad.api.RetrofitClient;
import dad.ui.model.Cuota;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import retrofit2.Call;
import retrofit2.Response;

public class RootController implements Initializable {

    // Model
    private final StringProperty capital = new SimpleStringProperty();
    private final StringProperty interes = new SimpleStringProperty();
    private final StringProperty anyos = new SimpleStringProperty();

    private final HipotecaResponse hipotecaResponse = new HipotecaResponse();
    private final ListProperty<Cuota> cuotas = new SimpleListProperty<>(FXCollections.observableArrayList());

    // View

    @FXML
    private TableView<Cuota> datosTableView;

    @FXML
    private TableColumn<Cuota, Integer> numCuotaColumn;

    @FXML
    private TableColumn<Cuota, Double> capInicialColumn;

    @FXML
    private TableColumn<Cuota, Double> interesColumn;

    @FXML
    private TableColumn<Cuota, Double> amortizadoColumn;

    @FXML
    private TableColumn<Cuota, Double> pendienteColumn;

    @FXML
    private TextField anyosTextField;

    @FXML
    private Button calcularButton;

    @FXML
    private TextField capitalTextField;

    @FXML
    private TextField interesTextField;
    @FXML
    private BorderPane root;

    public BorderPane getRoot() {
        return root;
    }

    private boolean validarCampos() {
        if (capital.get().isEmpty() || interes.get().isEmpty() || anyos.get().isEmpty()) {
            StringBuilder missingFields = new StringBuilder("Faltan los siguientes campos:\n");
            if (capital.get().isEmpty()) {
                missingFields.append("- Capital\n");
            }
            if (interes.get().isEmpty()) {
                missingFields.append("- Interés\n");
            }
            if (anyos.get().isEmpty()) {
                missingFields.append("- Años\n");
            }
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos faltantes");
            alert.setHeaderText(null);
            alert.setContentText(missingFields.toString());
            alert.showAndWait();
            return false;
        }
        return true;
    }

    private boolean validarNumeros() {
        try {
            Double.parseDouble(capital.get());
            Double.parseDouble(interes.get());
            Integer.parseInt(anyos.get());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de formato");
            alert.setHeaderText(null);
            alert.setContentText("Los campos Capital e Interés deben ser números decimales y Años debe ser un número entero.");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    @FXML
    void onCalcularAction(ActionEvent event) {
        if (!validarCampos() || !validarNumeros()) {
            return;
        }

        cuotas.clear();
        ApiService apiService = RetrofitClient.getApiService();
        // Llamada al endpoint con parámetros
        Call<HipotecaResponse> call = apiService.calcularHipoteca(
                Double.parseDouble(capital.get()),
                Double.parseDouble(interes.get()),
                Integer.parseInt(anyos.get())
        );

        try {
            Response<HipotecaResponse> response = call.execute(); // Llamada síncrona
            if (response.isSuccessful() && response.body() != null) {
                HipotecaResponse hipotecaResponse = response.body();

                for (HipotecaResponse.Cuota cuota : hipotecaResponse.cuotas) {
                    Cuota nuevaCuota = new Cuota(
                            cuota.numero,
                            cuota.capitalInicial,
                            cuota.intereses,
                            cuota.capitalAmortizado,
                            cuota.capitalPendiente
                    );
                    cuotas.add(nuevaCuota);
                }
            } else {
                System.err.println("Error: " + response.errorBody().string());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        // Bindings
        capital.bindBidirectional(capitalTextField.textProperty());
        interes.bindBidirectional(interesTextField.textProperty());
        anyos.bindBidirectional(anyosTextField.textProperty());
        datosTableView.itemsProperty().bind(cuotas);

        // TableView
        numCuotaColumn.setCellValueFactory(cellData -> cellData.getValue().cuotaProperty().asObject());
        capInicialColumn.setCellValueFactory(cellData -> cellData.getValue().capitalInicialProperty().asObject());
        interesColumn.setCellValueFactory(cellData -> cellData.getValue().interesesProperty().asObject());
        amortizadoColumn.setCellValueFactory(cellData -> cellData.getValue().capitalAmortizadoProperty().asObject());
        pendienteColumn.setCellValueFactory(cellData -> cellData.getValue().capitalPendienteProperty().asObject());


    }
}
