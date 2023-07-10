package br.edu.ifg.luziania.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {
    //Atributos dos usuarios
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private int idUsuario;
    @Getter @Setter private String nome;
    @Column(nullable = false, unique = true)
    @Getter @Setter private String email;
    @Column(nullable = false)
    @Getter @Setter private String senha;
    @Getter @Setter private int partidasGanhas;
    @Getter @Setter private int partidasPerdidas;
    @Getter @Setter private int partidasJogadas;

}
