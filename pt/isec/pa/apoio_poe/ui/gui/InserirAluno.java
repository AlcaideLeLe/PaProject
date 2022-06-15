package pt.isec.pa.apoio_poe.ui.gui;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;

public class InserirAluno extends BorderPane {
     apoio_poeContext context;


    TextField textNr;
    TextField textNome;
    TextField textEmail;
    TextField textSiglaCurso;
    TextField textSiglaRamo;
    TextField textPontuacao;
    TextField textPropostaAssociada;

    CheckBox isAcesso;
    Button buttonConfirm;
    Button buttonClose;

    Label labelNr;
    Label labelNome;
    Label labelEmail;
    Label labelSiglaCurso;
    Label labelSiglaRamo;
    Label labelPontuacao;
    Label labelIDProposta;
    Label labelAcessoEstagio;

    public InserirAluno(apoio_poeContext context) {
        super();
        this.context = context;
        createViews();
        registerHandlers();

    }

    private void registerHandlers(){
        buttonConfirm.setOnAction(ev->{
            context.addAlunoSingular(new Aluno(Long.parseLong(textNr.getText()), textNome.getText(), textEmail.getText(),
                    textSiglaCurso.getText(), textSiglaRamo.getText(), Double.parseDouble(textPontuacao.getText()),isAcesso.isSelected(), textPropostaAssociada.getText()));
        });

    }


    private void createViews() {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        labelNr = new Label("");
        labelNr.setText("Insira o numero do novo aluno");
        grid.add(labelNr, 0, 0);

        labelNome = new Label("");
        labelNome.setText("Insira o nome do novo aluno");
        grid.add(labelNome, 0, 3);

        labelEmail = new Label("");
        labelEmail.setText("Insira o e-mail do novo aluno");
        grid.add(labelEmail, 0, 6);

        labelSiglaCurso = new Label("");
        labelSiglaCurso.setText("Insira a sigla do curso do novo aluno");
        grid.add(labelSiglaCurso, 0, 9);

        labelSiglaRamo = new Label("");
        labelSiglaRamo.setText("Insira a sigla do ramo ");
        grid.add(labelSiglaRamo, 0, 12);

        labelPontuacao = new Label("");
        labelPontuacao.setText("Insira a pontuacao");
        grid.add(labelPontuacao, 0, 15);

        labelIDProposta = new Label("");
        labelIDProposta.setText("Insira o ID da proposta associado ao aluno");
        grid.add(labelIDProposta, 0, 18);

        labelAcessoEstagio = new Label("");
        labelAcessoEstagio.setText("Tem acesso a estagio");
        grid.add(labelAcessoEstagio, 0, 21);


        textNr = new TextField("");
        grid.add(textNr, 0, 1);

        textNome = new TextField("");
        grid.add(textNome, 0, 4);

        textEmail = new TextField("");
        grid.add(textEmail, 0, 7);

        textSiglaCurso = new TextField("");
        grid.add(textSiglaCurso, 0, 10);

        textSiglaRamo = new TextField("");
        grid.add(textSiglaRamo, 0, 13);

        textPontuacao = new TextField("");
        grid.add(textPontuacao, 0, 16);

        textPropostaAssociada = new TextField("");
        grid.add(textPropostaAssociada, 0, 19);

        isAcesso = new CheckBox("");
        grid.add(isAcesso, 0, 22);



        buttonClose = new Button("Fechar");
        grid.add(buttonClose, 2, 2);

        buttonConfirm = new Button("Confirmar novo aluno");
        grid.add(buttonConfirm, 2, 3);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(grid);
        scrollPane.fitToWidthProperty().set(true);


        this.setCenter(scrollPane);
    }
}
