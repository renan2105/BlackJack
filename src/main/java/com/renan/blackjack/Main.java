package main.java.com.renan.blackjack;

import main.java.com.renan.blackjack.entities.Carta;
import main.java.com.renan.blackjack.entities.Jogador;
import main.java.com.renan.blackjack.entities.Partida;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    private static final String statusJogadorParou = "PAROU";
    private static final String statusJogadorJogando = "JOGANDO";
    private static final String statusPartidaProgresso = "PROGRESSO";


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Jogo Black Jack ou 21 para os mais chegados!");

        System.out.println("Digite o nome dos jogadores separados por ; :");

        List<String> nomeJogadores = Arrays.asList(sc.next().split("\\s*;\\s*"));

//        método cria jogadores
        List<Jogador> jogadores = new ArrayList<>();

        nomeJogadores.forEach(jogador-> jogadores.add(new Jogador(jogador,
                0,
                0,
                new ArrayList<>(),
                statusJogadorJogando)));

//        método cria baralho
        Carta carta = new Carta();
        List<Carta> baralho = carta.criaBaralho();

//        método inicia partida
//        Partida partida = iniciaPartida(nomeJogadores);
        Partida partida = new Partida(
                1,
                jogadores,
                statusPartidaProgresso,
                null,
                baralho
        );

//        método serviço puxar carta

        String statusPartidaFinalizado = "FINALIZADO";
        do{

            partida.getJogadores().forEach(
                    jogador -> {
                        if (!jogador.getStatus().equals(statusJogadorJogando)){
                            jogador.setRodada(partida.getRodada());
                        }
                    }
            );

            boolean todosJogaram = true;

            boolean NaoAJogadoresJogando = true;

            System.out.println("Digite o nome do jogador que quer puxar a carta, ou digite \"PAROU\" e o nome do jogador caso queira parar:");

            String jogadorAtual = sc.next();

            for(Jogador jogador : partida.getJogadores()) {

                if(jogadorAtual.contains(jogador.getNome())){

                    int valorVencedor = 21;
                    String statusJogadorUltrapassou = "ULTRAPASSOU";
                    if (jogador.getStatus().equals(statusJogadorParou)) {

                        System.out.println("Jogador " + jogador.getNome() + " ja parou de puxar, por favor digite o nome de outro Jogador:");

                    }  else if (jogador.getStatus().equals(statusJogadorUltrapassou)) {

                        System.out.println("Jogador " + jogador.getNome() + " ja ultrapassou os " + valorVencedor + " pontos , por favor digite o nome de outro Jogador:");

                    } else if (jogador.getRodada().equals(partida.getRodada())){

                        System.out.println("Jogador " + jogador.getNome() + " ja puxou esta rodada, por favor digite o nome de outro Jogador:");

                    } else if (jogadorAtual.contains(statusJogadorParou)) {

                        jogador.setStatus(statusJogadorParou);
                        jogador.setRodada(partida.getRodada());

                        System.out.println("Jogador " + jogador.getNome() + " ja parou de puxar com: " + jogador.getPontuacao());


                    } else {

                        carta = partida.getBaralho().get(0);
                        partida.getBaralho().remove(0);

                        jogador.getCartas().add(carta);
                        jogador.setPontuacao(jogador.getPontuacao() + carta.getPontos());
                        jogador.setRodada(partida.getRodada());

                        System.out.println("Jogador " + jogador.getNome() + " puxou a carta " + carta.getNome() + " de " + carta.getNaipe());
                        System.out.println("e sua pontuacao atual é:" + jogador.getPontuacao());

                        if(jogador.getPontuacao() > valorVencedor)
                            jogador.setStatus(statusJogadorUltrapassou);

                        if(jogador.getPontuacao().equals(valorVencedor)){

                            partida.setStatus(statusPartidaFinalizado);
                            partida.setVencedor(jogador);

                        }

                    }

                }

                if(!jogador.getRodada().equals(partida.getRodada()))
                    todosJogaram = false;

                if(jogador.getStatus().equals(statusJogadorJogando))
                    NaoAJogadoresJogando = false;
            }

            if(todosJogaram)
                partida.setRodada(partida.getRodada() + 1);

            if(NaoAJogadoresJogando)
                partida.setStatus(statusPartidaFinalizado);


        } while (!partida.getStatus().equals(statusPartidaFinalizado));

        if(partida.getVencedor() != null){
            System.out.println("Jogador " + partida.getVencedor().getNome() + " eh o vencedor parabeins!!!");
        } else {
            List<Jogador> jogadoresRestantes = new ArrayList<>();
            partida.getJogadores().forEach(
                    jogador -> {
                        if (jogador.getStatus().equals(statusJogadorParou)){
                            jogadoresRestantes.add(jogador);
                        }
                    }
            );
            if(jogadoresRestantes.isEmpty())
                System.out.println("Ninguem venceu, que pena!!!");
            else if(jogadoresRestantes.size() == 1){
                partida.setVencedor(jogadoresRestantes.get(0));
                System.out.println("Jogador " + partida.getVencedor().getNome() + " eh o vencedor parabeins!!!");
            } else {

                AtomicBoolean empate = new AtomicBoolean(false);

                for(Jogador jogador: jogadoresRestantes){
                    if(partida.getVencedor() == null){
                        partida.setVencedor(jogador);
                    } else if(jogador.getPontuacao()> partida.getVencedor().getPontuacao()){
                        partida.setVencedor(jogador);
                    }
                }

                jogadoresRestantes.forEach(
                        jogador -> {
                            if (Objects.equals(jogador.getPontuacao(), partida.getVencedor().getPontuacao())
                                    && !jogador.getNome().equals(partida.getVencedor().getNome()) ){
                                empate.set(true);
                            }
                        }
                );



                if(empate.get())
                    System.out.println("Empate");
                else
                    System.out.println("Jogador " + partida.getVencedor().getNome() + " eh o vencedor parabeins!!!");


            }

        }

        sc.close();

    }

    private Partida iniciaPartida(List<String> nomeJogadores){

        Partida partida = new Partida(
                1,
                criaJogadores(nomeJogadores),
                statusPartidaProgresso,
                null,
                criaBaralho()
        );

        return partida;
    }

    private List<Jogador> criaJogadores(List<String> nomeJogadores){

        List<Jogador> jogadores = new ArrayList<>();

        nomeJogadores.forEach(jogador-> jogadores.add(new Jogador(jogador,
                0,
                0,
                new ArrayList<>(),
                statusJogadorJogando)));

        return jogadores;

    }

    private List<Carta> criaBaralho(){

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

        return baralho;

    }

}