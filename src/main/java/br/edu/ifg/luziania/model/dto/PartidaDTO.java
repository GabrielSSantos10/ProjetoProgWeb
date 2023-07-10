package br.edu.ifg.luziania.model.dto;

import lombok.Getter;
import lombok.Setter;


public class PartidaDTO {

    @Getter @Setter private String nomeJogador1Time1;
    @Getter @Setter private String nomeJogador2Time1;
    @Getter @Setter private String nomeJogador3Time1;
    @Getter @Setter private String nomeJogador1Time2;
    @Getter @Setter private String nomeJogador2Time2;
    @Getter @Setter private String nomeJogador3Time2;
    @Getter @Setter private String pontosTime1;
    @Getter @Setter private String pontosTime2;
    @Getter @Setter private int timeVencedor;

}
