package pt.isec.pa.apoio_poe.ui.gui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;


public class MainJX extends Application {
    public apoio_poeContext context;
    public MainJX() {
    }

    @Override
    public void start(Stage stage) throws Exception {
        Apoio_poeGUI root = new Apoio_poeGUI(new apoio_poeContext());
        Scene scene = new Scene(root,700,400);

        stage.setScene(scene);
        stage.setTitle("Aplicacao de gestao de projetos/estagio");
        stage.setMinWidth(700);
        stage.setMinHeight(400);
        stage.show();


    }


}
