public class Edge {
    private int x, y;
    private int possession;

    public Edge(int x, int y){
        this.x = x;
        this.y = y;
        this.possession = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
