package br.edu.ifg.luziania.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTime;

    @Column(nullable = false)
    //private List<Usuario> jogadores;
    private int pontosTime;

    public int getIdTime() {
        return idTime;
    }

    public void setIdTime(int idTime) {
        this.idTime = idTime;
    }

//    public List<Usuario> getJogadores() {
//        return jogadores;
//    }
//
//    public void setJogadores(List<Usuario> jogadores) {
//        this.jogadores = jogadores;
//    }

    public int getPontosTime() {
        return pontosTime;
    }

    public void setPontosTime(int pontosTime) {
        this.pontosTime = pontosTime;
    }
}
