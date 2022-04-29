package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public enum apoio_poeState {
    FASE1,FASE1BLOCKSTATE, FASE2, FASE2BLOCKSTATE, FASE3, FASE3BLOCKSTATE, FASE4, FASE5, GESTAO_PROP,
    GESTAO_DOC, GESTAO_AL, GESTAO_CAND, TRATAMENTO_PROP, GESTAO_ORI;

    public IApoio_poeState createState(apoio_poeContext context, PoE data){
        return switch (this){
            case FASE1 -> new FASE1State(context, data);
            case FASE1BLOCKSTATE -> new FASE1BlockState(context, data);
            case FASE2 -> new FASE2State(context, data);
            case FASE2BLOCKSTATE -> new FASE2BlockState(context, data);
            case FASE3 -> new FASE3State(context, data);
            case FASE3BLOCKSTATE -> new FASE3BlockState(context, data);
            case FASE4 -> new FASE4State(context, data);
            case FASE5 -> new FASE5State(context, data);
            case GESTAO_PROP -> new GESTAO_PROPState(context, data);
            case GESTAO_DOC -> new GESTAO_DOCState(context, data);
            case GESTAO_CAND -> new GESTAO_CANDState(context, data);
            case TRATAMENTO_PROP -> new TRATAMENTO_PROPState(context, data);
            case GESTAO_ORI -> new GESTAO_ORIState(context, data);
            case GESTAO_AL -> new GESTAO_ALState(context, data);


        };
    }
}