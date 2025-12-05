package ifsc.joe.domain.impl;

public class Arqueiro extends Personagem {

    public Arqueiro(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    protected String getNomeImagem() {
        return "arqueiro"; // arqueiro.png
    }
}
