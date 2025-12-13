package ifsc.joe.domain.ui;

import ifsc.joe.domain.enums.Direcao;
import ifsc.joe.domain.enums.TipoPersonagem;
import ifsc.joe.domain.enums.FiltroPersonagem;
import ifsc.joe.config.Config;

import javax.swing.*;
import java.util.Random;

public class PainelControles {

    private final Random sorteio = new Random();
    private Tela tela;

    private JPanel painelPrincipal;
    private JPanel painelTela;
    private JPanel painelLateral;
    private JButton bCriaAldeao;
    private JButton bCriaArqueiro;
    private JButton bCriaCavaleiro;
    private JRadioButton todosRadioButton;
    private JRadioButton aldeaoRadioButton;
    private JRadioButton arqueiroRadioButton;
    private JRadioButton cavaleiroRadioButton;
    private JButton atacarButton;
    private JButton buttonCima;
    private JButton buttonEsquerda;
    private JButton buttonBaixo;
    private JButton buttonDireita;
    private JLabel logo;

    public PainelControles() {
        configurarRadioButtons();
        configurarListeners();
    }

    private void configurarListeners() {
        configurarBotoesMovimento();
        configurarBotoesCriacao();
        configurarBotaoAtaque();
    }

    private void configurarRadioButtons() {
        ButtonGroup grupo = new ButtonGroup();

        grupo.add(todosRadioButton);
        grupo.add(aldeaoRadioButton);
        grupo.add(arqueiroRadioButton);
        grupo.add(cavaleiroRadioButton);
        todosRadioButton.setSelected(true);
    }

    private FiltroPersonagem getFiltroSelecionado() {
        if (aldeaoRadioButton.isSelected()) return FiltroPersonagem.ALDEAO;
        if (arqueiroRadioButton.isSelected()) return FiltroPersonagem.ARQUEIRO;
        if (cavaleiroRadioButton.isSelected()) return FiltroPersonagem.CAVALEIRO;
        return FiltroPersonagem.TODOS;
    }

    private void configurarBotoesMovimento() {
        buttonCima.addActionListener(e -> mover(Direcao.CIMA));
        buttonBaixo.addActionListener(e -> mover(Direcao.BAIXO));
        buttonEsquerda.addActionListener(e -> mover(Direcao.ESQUERDA));
        buttonDireita.addActionListener(e -> mover(Direcao.DIREITA));
    }

    private void configurarBotoesCriacao() {
        bCriaAldeao.addActionListener(e -> criarPersonagem(TipoPersonagem.ALDEAO));
        bCriaArqueiro.addActionListener(e -> criarPersonagem(TipoPersonagem.ARQUEIRO));
        bCriaCavaleiro.addActionListener(e -> criarPersonagem(TipoPersonagem.CAVALEIRO));
    }

    private void configurarBotaoAtaque() {
        atacarButton.addActionListener(e ->
                getTela().atacarFiltrados(getFiltroSelecionado())
        );
    }

    private void mover(Direcao direcao) {
        getTela().movimentarFiltrados(direcao, getFiltroSelecionado());
    }

    private void criarPersonagem(TipoPersonagem tipo) {
        int padding = Config.getInt("tela.padding");

        int posX = sorteio.nextInt(painelTela.getWidth() - padding);
        int posY = sorteio.nextInt(painelTela.getHeight() - padding);

        getTela().criarPersonagem(tipo, posX, posY);
    }

    private Tela getTela() {
        if (tela == null) {
            tela = (Tela) painelTela;
        }
        return tela;
    }

    public JPanel getPainelPrincipal() {
        return painelPrincipal;
    }

    private void createUIComponents() {
        this.painelTela = new Tela();
    }
}