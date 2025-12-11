package ifsc.joe.ui;

import ifsc.joe.domain.impl.Aldeao;
import ifsc.joe.domain.impl.Arqueiro;
import ifsc.joe.domain.impl.Cavaleiro;
import ifsc.joe.domain.impl.Personagem;
import ifsc.joe.enums.Direcao;

import javax.swing.*;
import java.awt.*;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Tela extends JPanel {

    private final Set<Aldeao> aldeoes;
    private final Set<Arqueiro> arqueiros;
    private final Set<Cavaleiro> cavaleiros;

    public Tela() {

        //TODO preciso ser melhorado

        this.setBackground(Color.white);
        this.aldeoes = new HashSet<>();
        this.arqueiros = new HashSet<>();
        this.cavaleiros = new HashSet<>();
    }

    /**
     * Method que invocado sempre que o JPanel precisa ser resenhado.
     * @param g Graphics componente de java.awt
     */

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //TODO preciso ser melhorado

        // percorrendo a lista de aldeões, arqueiros e cavaleiros e pedindo para cada um se desenhar na tela
        this.aldeoes.forEach(aldeao -> aldeao.desenhar(g, this));
        this.arqueiros.forEach(arqueiro -> arqueiro.desenhar(g, this));
        this.cavaleiros.forEach(cavaleiro -> cavaleiro.desenhar(g, this));

        // liberando o contexto gráfico
        g.dispose();
    }

    /**
     * Cria os personagens nas coordenadas X e Y
     */

    public void criarAldeao(int x, int y) {
        Aldeao a = new Aldeao(x, y);
        a.desenhar(super.getGraphics(), this);
        this.aldeoes.add(a);
    }
    public void criarArqueiro(int x, int y) {
        Arqueiro arq = new Arqueiro(x, y);
        arq.desenhar(super.getGraphics(), this);
        this.arqueiros.add(arq);
    }
    public void criarCavaleiro(int x, int y) {
        Cavaleiro cav = new Cavaleiro(x, y);
        cav.desenhar(super.getGraphics(), this);
        this.cavaleiros.add(cav);
    }

    /**
     * Atualiza as coordenadas X ou Y de todos os aldeoes
     *
     * @param direcao direcao para movimentar
     */

    public void movimentarAldeoes(Direcao direcao) {
        //TODO preciso ser melhorado

        this.aldeoes.forEach(aldeao -> aldeao.mover(direcao, this.getWidth(), this.getHeight()));
        this.arqueiros.forEach(arqueiro -> arqueiro.mover(direcao, this.getWidth(), this.getHeight()));
        this.cavaleiros.forEach(cavaleiro -> cavaleiro.mover(direcao, this.getWidth(), this.getHeight()));

        // Depois que as coordenadas foram atualizadas é necessário repintar o JPanel
        this.repaint();
    }

    private List<Personagem> getTodosOsPersonagens() {
        List<Personagem> lista = new ArrayList<>();
        lista.addAll(aldeoes);
        lista.addAll(arqueiros);
        lista.addAll(cavaleiros);
        return lista;
    }

    /**
     * Altera o estado do aldeão de atacando para não atacando e vice-versa
     */

    public void atacarTodos() {
        List<Personagem> personagens = getTodosOsPersonagens();

        for (Aldeao a : aldeoes) {
            a.atacarArea(personagens);
            a.atacar();
        }

        for (Arqueiro arq : arqueiros) {
            arq.atacarArea(personagens);
            arq.atacar();
        }

        for (Cavaleiro cav : cavaleiros) {
            cav.atacarArea(personagens);
            cav.atacar();
        }

        repaint();
    }
}