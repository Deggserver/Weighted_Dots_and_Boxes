package src;

public class Edge {
    private int possession;

    public Edge(){
        this.possession = 0;
    }

     /**
     *
     * @return  0 for unowned
     *          1 for player1
     *          2 for player2
     */
    public int getPossession() {
        return possession;
    }

    /**
     *
     * @param player    0 for unowned
     *                  1 for player1
     *                  2 for player2
     */
    public void setPossession(int player){
        this.possession = player;
    }
}
