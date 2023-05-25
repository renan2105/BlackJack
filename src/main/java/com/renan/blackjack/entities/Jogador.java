package main.java.com.renan.blackjack.entities;

import java.util.List;

public class Jogador {

    private String nome;

    private Integer rodada;

    private Integer pontuacao;

    private List<Carta> cartas;

    private String status;


    public Jogador() {
    }

    public Jogador(String nome, Integer rodada, Integer pontuacao, List<Carta> cartas, String status) {
        this.nome = nome;
        this.rodada = rodada;
        this.pontuacao = pontuacao;
        this.cartas = cartas;
        this.status = status;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getRodada() {
        return rodada;
    }

    public void setRodada(Integer rodada) {
        this.rodada = rodada;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
