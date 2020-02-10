import java.util.ArrayList;
import java.util.Random;

public class Node {
    private Random random_generator = new Random();
    private Edge[][] vEdges, hEdges;                //vEgdes[x][y] where x is width of the board and y is the height
    private int[][] boxes; //The boxes that give points
    private int player1_score, player2_score;
    private int board_x_boxes, board_y_boxes;
    private ArrayList<Edge> available_edges;
    private Node parent;

    /**
     *
     * @param board_x in terms of boxes
     * @param board_y in terms of boxes
     */
    public Node(int board_x, int board_y){
        this.parent = null;
        this.board_x_boxes = board_x;
        this.board_y_boxes = board_y;
        this.hEdges = new Edge[board_x][board_y + 1];
        this.vEdges = new Edge[board_x + 1][board_y];
        this.boxes = this.generate_box_values();
    }

    public Node(Node par){
        this.parent = null;
        this.board_x_boxes = par.board_x_boxes;
        this.board_y_boxes = par.board_y_boxes;
        this.hEdges = par.gethEdges();
        this.vEdges = par.getvEdges();
        this.boxes = par.getBoxes();
    }

    private int[][] generate_box_values(){
        int[][] out = new int[this.board_x_boxes][this.board_y_boxes];
        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out[0].length; j++) {
                out[i][j] = this.get_next_random_int();
            }
        }
        return out;
    }

    private int get_next_random_int(){
        return this.random_generator.nextInt(5) + 1; //upper bound
    }

    public int[][] getBoxes() {
        return boxes;
    }

    public int getPlayer1_score() {
        return player1_score;
    }

    public int getPlayer2_score() {
        return player2_score;
    }

    public Edge[][] gethEdges() {
        return hEdges;
    }

    public Edge[][] getvEdges() {
        return vEdges;
    }

    public void show_board() {
        for (int x = 0; x < this.board_x_boxes; x++) {
            for (int y = 0; y < this.board_x_boxes; y++) {

            }
        }
    }

    private void print_x_boxes(){
        System.out.print("+");
        for (int i = 0; i < this.board_x_boxes; i++) {
            System.out.print("-----+");
        }
        System.out.print("\n");
    }

    private int find_boxes(){
        return -1;
    }
}
