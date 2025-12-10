package ifsc.joe.domain.impl;

import java.util.List;

public class Arqueiro extends Personagem implements Guerreiro {

    private int flechas = 20;

    public Arqueiro(int posX, int posY) {
        super(posX, posY, 40, 1.0, 10);
    }

    @Override
    protected String getNomeImagem() {
        return "arqueiro";
    }

    @Override
    public void atacarArea(List<Personagem> alvos) {
        if (flechas <= 0) return;

        for (Personagem alvo : alvos) {
            double distancia = this.calcularDistancia(alvo);
            if (distancia <= 120) {
                alvo.sofrerDano(this.ataque);
                flechas--;
            }
        }
    }
}
