package ifsc.joe.domain.impl;

import ifsc.joe.enums.Direcao;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public abstract class Personagem {

    public static final String NOME_IMAGEM = "aldeao";

    protected int posX, posY;
    protected boolean atacando;
    protected Image icone;

    public Personagem(int posX, int posY) {
        this.icone = this.carregarImagem(NOME_IMAGEM);
        this.posX = posX;
        this.posY = posY;
        this.atacando = false;
    }

    public void mover(Direcao direcao, int maxLargura, int maxAltura) {
        switch (direcao) {
            case CIMA     -> this.posY -= 10;
            case BAIXO    -> this.posY += 10;
            case ESQUERDA -> this.posX -= 10;
            case DIREITA  -> this.posX += 10;
        }

        //Não deixa a imagem ser desenhada fora dos limites do JPanel pai
        this.posX = Math.min(Math.max(0, this.posX), maxLargura - this.icone.getWidth(null));
        this.posY = Math.min(Math.max(0, this.posY), maxAltura - this.icone.getHeight(null));
    }

    public void atacar() {
        this.atacando = !this.atacando;
    }

    public Image carregarImagem(String imagem) {
        return new ImageIcon(Objects.requireNonNull(
                getClass().getClassLoader().getResource("./"+imagem+".png")
        )).getImage();
    }
}
