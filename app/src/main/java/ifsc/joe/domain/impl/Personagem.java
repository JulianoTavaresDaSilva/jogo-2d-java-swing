package ifsc.joe.domain.impl;

import ifsc.joe.enums.Direcao;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public abstract class Personagem {

    protected int vida;
    protected int ataque;
    protected double velocidade;
    protected int posX, posY;
    protected boolean atacando;
    protected Image icone;

    public Personagem(int posX, int posY, int vida, double velocidade, int ataque) {
        this.icone = carregarImagem(getNomeImagem());
        this.posX = posX;
        this.posY = posY;
        this.vida = vida;
        this.velocidade = velocidade;
        this.ataque = ataque;
    }

    public int getVida() {
        return vida;
    }
    public int getAtaque() {
        return ataque;
    }
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }

    public void atacar() {
        this.atacando = !this.atacando;
    }

    public void sofrerDano(int dano) {
        this.vida = Math.max(0, this.vida - dano);
    }

    public double calcularDistancia(Personagem outro) {
        return Math.hypot(outro.posX - this.posX, outro.posY - this.posY);
    }

    protected abstract String getNomeImagem();

    public void mover(Direcao direcao, int maxLargura, int maxAltura) {
        switch (direcao) {
            case CIMA     -> this.posY -= 10;
            case BAIXO    -> this.posY += 10;
            case ESQUERDA -> this.posX -= 10;
            case DIREITA  -> this.posX += 10;
        }

        this.posX = Math.min(Math.max(0, this.posX), maxLargura - this.icone.getWidth(null));
        this.posY = Math.min(Math.max(0, this.posY), maxAltura - this.icone.getHeight(null));
    }

    public void desenhar(Graphics g, Component tela) {
        if (atacando) {
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(
                    this.icone,
                    this.posX + icone.getWidth(null),
                    this.posY,
                    -icone.getWidth(null),
                    icone.getHeight(null),
                    tela
            );
        } else {
            g.drawImage(this.icone, this.posX, this.posY, tela);
        }
    }

    protected Image carregarImagem(String imagem) {
        return new ImageIcon(
                Objects.requireNonNull(
                        getClass().getClassLoader().getResource("./" + imagem + ".png")
                )
        ).getImage();
    }
}