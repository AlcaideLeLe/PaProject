package pt.isec.pa.apoio_poe.model.data;


import java.io. * ;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class CsvReader {
    public static void main(String[] args) throws Exception {
        PoE poe = new PoE();
        poe.addAluno();
        //poe.addDocente();
        poe.addProposta();
        //System.out.println(poe.consultarProposta("P027"));
        //System.out.println(poe.consultarPropostas());
        //System.out.println(poe.consultarAluno(14));
        //System.out.println(poe.consultarAlunos());
        //System.out.println(poe.consultarDocente("ans@isec.pt"));
        //System.out.println(poe.consultarDocentes());
        //poe.addCandidatura();
        //System.out.println(poe.consultarCandidatura(2019999999));
        //System.out.println(poe.consultarCandidaturas());
        //System.out.println(poe.consultarAlunosComCandidatura());
        //System.out.println(poe.consultarAlunosSemCandidatura());
        //System.out.println(poe.consultaAlunosComAutoproposta());
        //System.out.println(poe.consultarListaDeAutopropostas());
        //poe.atribuirAutoproposta();
        //poe.atribuirPropostaDeDocente();
        //System.out.println(poe.consultarAlunos());
        //poe.atruibuicaoDeAlunosSemPropostasDefinidas();
        //System.out.println(poe.consultarPropostas());
        //System.out.println(poe.consultarAlunos());
        //poe.atribuirPropostaManualmente(2018014063, "P027");
        //poe.atribuirPropostaManualmente(2013684456, "P027");
        //System.out.println(poe.consultarAluno(2018014063));
        //System.out.println(poe.consultarProposta("P027"));
        //System.out.println(poe.consultarAluno(2013684456));
        //poe.removerPropostaManualmente(2018014063);
        //System.out.println(poe.consultarAluno(2018014063));
        //System.out.println(poe.consultarProposta("P027"));
        //System.out.println(poe.consultarAlunosSemPropostaAtribuida());
        //System.out.println(poe.consultaPropostasDisponiveis());
        System.out.println(poe.consultaPropostasAtribuidas());

    }
}