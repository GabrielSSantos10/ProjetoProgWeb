package br.edu.ifg.luziania.model.entity;

import br.edu.ifg.luziania.model.entity.Usuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPartida;
    //private List<Time> times;

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

//    public List<Time> getTimes() {
//        return times;
//    }
//
//    public void setTimes(List<Time> times) {
//        this.times = times;
//    }
}
