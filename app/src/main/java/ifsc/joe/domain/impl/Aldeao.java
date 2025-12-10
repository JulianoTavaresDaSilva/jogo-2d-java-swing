package ifsc.joe.domain.impl;

import java.util.List;

public class Aldeao extends Personagem implements Guerreiro {

    public Aldeao(int posX, int posY) {
        super(posX, posY, 25, 0.8, 5);
    }

    @Override
    protected String getNomeImagem() {
        return "aldeao";
    }

    @Override
    public void atacarArea(List<Personagem> alvos) {
        for (Personagem alvo : alvos) {
            double distancia = this.calcularDistancia(alvo);
            if (distancia <= 40) {
                alvo.sofrerDano(this.ataque);
            }
        }
    }
}
