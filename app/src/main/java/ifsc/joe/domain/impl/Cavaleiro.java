package ifsc.joe.domain.impl;

public class Cavaleiro extends Personagem {

    public Cavaleiro(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    protected String getNomeImagem() {
        return "cavaleiro"; // cavaleiro.png
    }
}
