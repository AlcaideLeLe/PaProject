package pt.isec.pa.apoio_poe.model.data;


import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.text.UI;

import java.io. * ;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class CsvReader {
    public static void main(String[] args) throws Exception {
        
        apoio_poeContext fsm = new apoio_poeContext();
        UI ui = new UI(fsm);
        ui.start();
        //PoE poe = new PoE();
        //poe.addAluno();
        //System.out.println(poe.consultarAlunos());
        //poe.addDocente();
        //poe.addProposta();
        //System.out.println(poe.consultarAlunos());
        //System.out.println(poe.consultarPropostas());
        //System.out.println(poe.consultarPropostasDocentes());;
        //poe.atruibuicaoDeAlunosSemPropostasDefinidas();
        //System.out.println(poe.consultarAlunosComPropostaAtribuida());
        //poe.atribuirPropostaManualmente(2018014063, "P031");
        //System.out.println(poe.consultarAluno(2018014063));
        //System.out.println(poe.consultarProposta("P031"));
        //poe.removerTodasAsAtribuicoes();
        //System.out.println(poe.consultarAluno(2018014063));
        //System.out.println(poe.consultarProposta("P031"));
        //System.out.println(poe.consultarProposta("P027"));
        //System.out.println(poe.consultarAluno(14));
        //System.out.println(poe.consultarDocente("ans@isec.pt"));
        //System.out.println(poe.consultarDocentes());
        //poe.addCandidatura();
        //System.out.println(poe.consultarCandidatura(2019999999));
        //System.out.println(poe.consultarCandidaturas());
        //System.out.println(poe.consultarAlunosComCandidatura());
        //System.out.println(poe.consultarAlunosSemCandidatura());
        //System.out.println(poe.consultaAlunosComAutoproposta());
        //System.out.println(poe.consultarListaDeAutopropostas());
        //poe.atribuirPropostaManualmente(2019999999, "P027");
        //poe.atribuirAutoproposta();
        //poe.atribuirPropostaDeDocente();
        //System.out.println(poe.consultarAlunos());
        //System.out.println(poe.consultarAlunos());

        //System.out.println(poe.consultarPropostas());
        //System.out.println(poe.consultarAlunos());
        //poe.atribuirPropostaManualmente(2018014063, "P064");
        //System.out.println(poe.consultarProposta("P064"));
        //poe.atribuirPropostaManualmente(2013684456, "P027");
        //System.out.println(poe.consultarAluno(2018014063));
        //System.out.println(poe.consultarAluno(2013684456));
        //poe.removerPropostaManualmente(2018014063);
        //System.out.println(poe.consultarProposta("P064"));
        //System.out.println(poe.consultarAluno(2018014063));
        //System.out.println(poe.consultarProposta("P027"));
        //System.out.println(poe.consultarAlunosSemPropostaAtribuida());
        //System.out.println(poe.consultaPropostasDisponiveis());
        //System.out.println(poe.consultaPropostasAtribuidas());
        //poe.atribuirPropostaADocenteProponenteAutomaticamente();
        //System.out.println(poe.consultarDocentes());
        //System.out.println(poe.consultarPropostas());
        //poe.atribuirPropostaManualmente(2018014063, "P064");
        //poe.atribuirManualmenteOrientadorAAlunosComPropostas(2022987654, "rmc.silva@isec.pt");
        //System.out.println(poe.consultarProposta("P064"));
        //poe.editarOrientadorDeProposta("P064", "cysko");
        //System.out.println(poe.consultarProposta("P064"));
        //poe.removerOrientadorDeProposta("P064");
        //System.out.println(poe.consultarProposta("P064"));
        //System.out.println(poe.consultarProposta("P023"));
        //System.out.println(poe.consultarDocentes());
        //System.out.println(poe.consultarDocente("rmc.silva@isec.pt"));
        //System.out.println(poe.consultaAlunosComPropostaEComOrientador());
        //System.out.println(poe.consultaAlunosComPropostaESemOrientador());
        //System.out.println(poe.consultaAlunosComCandidaturaESemProposta());

    }
}