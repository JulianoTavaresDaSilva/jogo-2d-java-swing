package ifsc.joe.domain.impl;

import java.util.List;

public class Cavaleiro extends Personagem implements Guerreiro {

    public Cavaleiro(int posX, int posY) {
        super(posX, posY, 75, 2.0, 15);
    }

    @Override
    protected String getNomeImagem() {
        return "cavaleiro";
    }

    @Override
    public void atacarArea(List<Personagem> alvos) {
        for (Personagem alvo : alvos) {
            double distancia = this.calcularDistancia(alvo);
            if (distancia <= 60) {
                alvo.sofrerDano(this.ataque);
            }
        }
    }
}
