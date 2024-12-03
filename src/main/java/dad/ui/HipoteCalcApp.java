package dad.ui;

import dad.ui.controllers.RootController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HipoteCalcApp extends Application {

    private final RootController rootController = new RootController();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ahorcado");
        primaryStage.setScene(new Scene(rootController.getRoot(), 640, 480));
        primaryStage.show();
    }

}
