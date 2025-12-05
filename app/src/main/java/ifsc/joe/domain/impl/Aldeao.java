package ifsc.joe.domain.impl;

public class Aldeao extends Personagem {

    public Aldeao(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    protected String getNomeImagem() {
        return "aldeao";
    }
}
