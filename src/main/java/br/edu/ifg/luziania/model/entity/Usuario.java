package br.edu.ifg.luziania.model.entity;

import javax.persistence.*;

@Entity
@Table
public class Usuario {
    //Atributos dos usuarios
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String senha;
    private int partidasGanhas;
    private int partidasPerdidas;
    private int partidasJogadas;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPartidasGanhas() {
        return partidasGanhas;
    }

    public void setPartidasGanhas(int partidasGanhas) {
        this.partidasGanhas = partidasGanhas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    public int getPartidasJogadas() {
        return partidasJogadas;
    }

    public void setPartidasJogadas(int partidasJogadas) {
        this.partidasJogadas = partidasJogadas;
    }
}
