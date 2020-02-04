import java.awt.*;
import java.util.Random;

public class Node {
    private Random random_generator = new Random();
    private boolean[][] dots; //This represents the
    private int[][] boxes; //The boxes that give points

    public Node(){
        this.dots = this.generate_point_array();
        this.boxes = this.generate_box_values();
    }

    private boolean[][] generate_point_array(){
        boolean[][] out = new boolean[5][5];
        for (int i = 0; i < this.dots.length ; i++) {
            for (int j = 0; j < this.dots[0].length; j++) {
                out[i][j] = false;
            }
        }
        return out;
    }

    private int[][] generate_box_values(){
        int[][] out = new int[4][4];
        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out[0].length; j++) {
                out[i][j] = this.get_next_random_int();
            }
        }
        return out;
    }

    private int get_next_random_int(){
        return this.random_generator.nextInt(6); //upper bound
    }

}