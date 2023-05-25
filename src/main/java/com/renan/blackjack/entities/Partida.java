package main.java.com.renan.blackjack.entities;

import java.util.List;

public class Partida {

    private Integer rodada;

    private List<Jogador> jogadores;

    private String status;

    private Jogador vencedor;

    private List<Carta> baralho;


    public Partida() {
    }

    public Partida(Integer rodada, List<Jogador> jogadores, String status, Jogador vencedor, List<Carta> baralho) {
        this.rodada = rodada;
        this.jogadores = jogadores;
        this.status = status;
        this.vencedor = vencedor;
        this.baralho = baralho;
    }


    public Integer getRodada() {
        return rodada;
    }

    public void setRodada(Integer rodada) {
        this.rodada = rodada;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Jogador getVencedor() {
        return vencedor;
    }

    public void setVencedor(Jogador vencedor) {
        this.vencedor = vencedor;
    }

    public List<Carta> getBaralho() {
        return baralho;
    }

    public void setBaralho(List<Carta> baralho) {
        this.baralho = baralho;
    }
}
