package src;

/**
 * possestion : 0 == unowned
 *              1 == player1 owned
 *              2 == player2 owned
 */
public class Owner {

    private int possession = 0;

    public Owner(){
    }

    public int getPossession() {
        return possession;
    }
}
