package pt.isec.pa.apoio_poe.ui.gui.insercoes;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.GESTAO_PROPState;
import pt.isec.pa.apoio_poe.model.fsm.IApoio_poeState;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;

public class InserirProposta extends BorderPane {
    apoio_poeContext context;


    TextField textNrAluno;
    TextField textTipoProposta;
    TextField textIDProposta;
    TextField textTitulo;


    CheckBox isAtribuida;
    Button buttonConfirm;
    Button buttonClose;

    Label labelIDProposta;
    Label labelTipoProposta;
    Label labelNrAluno;
    Label labelTitulo;
    Label labelAtribuida;


    public InserirProposta(apoio_poeContext context) {
        super();
        this.context = context;
        createViews();
        registerHandlers();

    }

    private void registerHandlers(){

        buttonConfirm.setOnAction(ev->{
            context.addPropostaSingular(new Proposta(textTipoProposta.getText(), textIDProposta.getText(), Long.parseLong(textNrAluno.getText()),
                    textTitulo.getText(), isAtribuida.isSelected()));
            Stage stage = (Stage) this.getScene().getWindow();
            stage.close();

        });


    }

    private void createViews() {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);


        labelTipoProposta = new Label("");
        labelTipoProposta.setText("Insira o tipo de Proposta");
        grid.add(labelTipoProposta, 0, 0);

        labelIDProposta = new Label("");
        labelIDProposta.setText("Insira o numero do aluno associado a proposta ");
        grid.add(labelIDProposta, 0, 3);

        labelNrAluno = new Label("");
        labelNrAluno.setText("Insira o ID da proposta");
        grid.add(labelNrAluno, 0, 6);

        labelTitulo = new Label("");
        labelTitulo.setText("Insira o titulo da proposta");
        grid.add(labelTitulo, 0, 9);

        labelAtribuida = new Label("");
        labelAtribuida.setText("A proposta esta atribuida?");

        textTipoProposta = new TextField("");
        grid.add(textTipoProposta, 0, 1);

        textNrAluno = new TextField("");
        grid.add(textNrAluno, 0, 4);

        textIDProposta = new TextField();
        grid.add(textIDProposta, 0, 7);

        textTitulo = new TextField("");
        grid.add(textTitulo, 0, 10);

        isAtribuida = new CheckBox("");
        grid.add(isAtribuida, 0, 13);



        buttonConfirm = new Button("Confirmar novo aluno");
        grid.add(buttonConfirm, 2, 13);
        Font font = Font.font("Times New Roman", FontWeight.BOLD, 14);
        buttonConfirm.setFont(font);
        buttonConfirm.setStyle("-fx-background-color: red; -fx-text-fill: white;-fx-border-width: 2px;");




        this.setCenter(grid);



    }
}