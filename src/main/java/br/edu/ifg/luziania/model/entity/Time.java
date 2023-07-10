package br.edu.ifg.luziania.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_TIME")
public class Time {
    //Atributos dos time
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private int idTime;

}
