package br.edu.ifg.luziania.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_PARTIDA")
public class Partida {
    //Atributos da partida
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private int idPartida;
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
