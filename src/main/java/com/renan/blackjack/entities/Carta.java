package main.java.com.renan.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carta {

    private String naipe;

    private String nome;

    private Integer pontos;


    public Carta() {
    }

    public Carta(String naipe, String nome, Integer pontos) {
        this.naipe = naipe;
        this.nome = nome;
        this.pontos = pontos;
    }


    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public List<Carta> criaBaralho(){

        List<Carta> baralho = new ArrayList<>();

        baralho.add(new Carta("ESPADAS", "A", 1));
        baralho.add(new Carta("PAUS", "A", 1));
        baralho.add(new Carta("COPAS", "A", 1));
        baralho.add(new Carta("OUROS", "A", 1));

        baralho.add(new Carta("ESPADAS", "2", 2));
        baralho.add(new Carta("PAUS", "2", 2));
        baralho.add(new Carta("COPAS", "2", 2));
        baralho.add(new Carta("OUROS", "2", 2));

        baralho.add(new Carta("ESPADAS", "3", 3));
        baralho.add(new Carta("PAUS", "3", 3));
        baralho.add(new Carta("COPAS", "3", 3));
        baralho.add(new Carta("OUROS", "3", 3));

        baralho.add(new Carta("ESPADAS", "4", 4));
        baralho.add(new Carta("PAUS", "4", 4));
        baralho.add(new Carta("COPAS", "4", 4));
        baralho.add(new Carta("OUROS", "4", 4));

        baralho.add(new Carta("ESPADAS", "5", 5));
        baralho.add(new Carta("PAUS", "5", 5));
        baralho.add(new Carta("COPAS", "5", 5));
        baralho.add(new Carta("OUROS", "5", 5));

        baralho.add(new Carta("ESPADAS", "6", 6));
        baralho.add(new Carta("PAUS", "6", 6));
        baralho.add(new Carta("COPAS", "6", 6));
        baralho.add(new Carta("OUROS", "6", 6));

        baralho.add(new Carta("ESPADAS", "7", 7));
        baralho.add(new Carta("PAUS", "7", 7));
        baralho.add(new Carta("COPAS", "7", 7));
        baralho.add(new Carta("OUROS", "7", 7));

        baralho.add(new Carta("ESPADAS", "8", 8));
        baralho.add(new Carta("PAUS", "8", 8));
        baralho.add(new Carta("COPAS", "8", 8));
        baralho.add(new Carta("OUROS", "8", 8));

        baralho.add(new Carta("ESPADAS", "9", 9));
        baralho.add(new Carta("PAUS", "9", 9));
        baralho.add(new Carta("COPAS", "9", 9));
        baralho.add(new Carta("OUROS", "9", 9));

        baralho.add(new Carta("ESPADAS", "10", 10));
        baralho.add(new Carta("PAUS", "10", 10));
        baralho.add(new Carta("COPAS", "10", 10));
        baralho.add(new Carta("OUROS", "10", 10));

        baralho.add(new Carta("ESPADAS", "K", 11));
        baralho.add(new Carta("PAUS", "K", 11));
        baralho.add(new Carta("COPAS", "K", 11));
        baralho.add(new Carta("OUROS", "K", 11));

        baralho.add(new Carta("ESPADAS", "J", 11));
        baralho.add(new Carta("PAUS", "J", 11));
        baralho.add(new Carta("COPAS", "J", 11));
        baralho.add(new Carta("OUROS", "J", 11));

        baralho.add(new Carta("ESPADAS", "Q", 11));
        baralho.add(new Carta("PAUS", "Q", 11));
        baralho.add(new Carta("COPAS", "Q", 11));
        baralho.add(new Carta("OUROS", "Q", 11));

        Collections.shuffle(baralho);

        return baralho;

    }
}
