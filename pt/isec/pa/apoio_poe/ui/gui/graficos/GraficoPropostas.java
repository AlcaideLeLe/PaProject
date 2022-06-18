package pt.isec.pa.apoio_poe.ui.gui.graficos;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;

public class GraficoPropostas extends BorderPane {
    apoio_poeContext context;
    double d;

    public GraficoPropostas(apoio_poeContext context, double d) {
        this.context = context;
        this.d = d;
        createViews();
    }

    public void createViews(){
        System.out.println(d);
        System.out.println(context.devolveNumPropostasDA()+"DA");
        System.out.println(context.devolveNumPropostasRAS()+"RAS");
        System.out.println(context.devolveNumPropostasSI()+"SI");
        Scene scene = new Scene(new Group());
        Stage stage = new Stage();
        stage.setTitle("Imported Fruits");
        stage.setWidth(500);
        stage.setHeight(500);
        //double orientacoes = Double.parseDouble(context.consultarOrientacoesDocente("jduraes@isec.pt"));
        //System.out.println(orientacoes);
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("OK", d),
                        new PieChart.Data("Oranges", 25),
                        new PieChart.Data("Plums", 10),
                        new PieChart.Data("Pears", 22),
                        new PieChart.Data("Apples", 30));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Imported Fruits");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        //stage.show();
        this.setCenter(chart);
    }

}
