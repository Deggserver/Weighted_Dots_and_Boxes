package src;

import java.util.ArrayList;
import java.util.Random;

public class Node {
    private Random random_generator = new Random();
    private Box[][] board;
    private ArrayList<String[]> possible_moves;
    private int board_width, board_height;
    private int player1_score, player2_score;

    public Node(int board_width, int board_height){
        this.board_width = board_width;
        this.board_height = board_height;
        this.board = this.create_board(board_width, board_height);
        this.possible_moves = this.generate_possible_moves();
    }

    private Box[][] create_board(int width, int height){
        Box[][] out = new Box[height][width];
        for (int y = 0; y < out.length; y++) {
            for (int x = 0; x < out[y].length; x++){
                Edge top = (y == 0) ? new Edge() : out[y-1][x].getBottom();
                Edge right = new Edge();
                Edge bottom = new Edge();
                Edge left = (x == 0) ? new Edge() : out[y][x-1].getRight();
                out[y][x] = new Box(top, right, bottom, left, this.get_next_random_int());
            }
        }
        return out;
    }

    private int get_next_random_int(){
        return this.random_generator.nextInt(5) + 1; //upper bound using the '+1' to make it start at 1 and goto 5 inclusive
    }

    public void claim_edge(int x, int y, String side, int player){
        if(side.toLowerCase().equals("top")){
            this.board[y][x].getTop().setPossession(player);
        }
        else if(side.toLowerCase().equals("right")){
            this.board[y][x].getRight().setPossession(player);
        }
        else if(side.toLowerCase().equals("bottom")){
            this.board[y][x].getBottom().setPossession(player);
        }
        else if(side.toLowerCase().equals("left")){
            this.board[y][x].getLeft().setPossession(player);
        }

        if(this.board[y][x].isCompleted()){
            if(player == 1){
                player1_score += this.board[y][x].getValue();
                this.board[y][x].setOwner(player);
            }
            else{
                player2_score += this.board[y][x].getValue();
                this.board[y][x].setOwner(player);
            }
        }
    }

    public boolean isGameOver(){
        for (Box[] row : this.board) {
            for (Box curr : row) {
                if(!(curr.isCompleted())) return false;
            }
        }
        return true;
    }

    public void show_board(){
        System.out.println("\nScore: " + this.getPlayer1_score() + " vs " + this.getPlayer2_score() + "\n");
        for (int i = 0; i < this.board_width; i++) {
            System.out.print("  " + i +  "  ");
        }
        System.out.println();
        for (int y = 0; y < this.board_height; y++) {
            String lines[] = {"",
                              "",
                              ""};                     //lines[0] == top of box lines[1] = center lines[2] = bottom
            for (int x = 0; x < this.board_width; x++) {
                if(this.board[y][x].getTop().getPossession() != 0){
                    lines[0] = lines[0] + "+---+";
                }
                else{
                    lines[0] = lines[0] + "+   +";
                }
                if(this.board[y][x].getLeft().getPossession() != 0){
                    lines[1] = lines[1] + "| ".concat((Integer.toString(this.board[y][x].getValue())));
                }
                else{
                    lines[1] = lines[1] + "  ".concat((Integer.toString(this.board[y][x].getValue())));
                }
                if(this.board[y][x].getRight().getPossession() != 0){
                    lines[1] = lines[1] + " |";
                }else{
                    lines[1] = lines[1] + "  ";
                }
                if(this.board[y][x].getBottom().getPossession() != 0){
                    lines[2] = lines[2] + "+---+";
                }else{
                    lines[2] = lines[2] + "+   +";
                }
            }
            lines[1] = lines[1] + " " + y;
            for (String l : lines){
                System.out.println(l);
            }
        }
        System.out.println("-----------------------------------------------------------");
    }

    public int getPlayer1_score() {
        return player1_score;
    }

    public int getPlayer2_score() {
        return player2_score;
    }

    /**
     *
     * @return positive means player1 is winning, negative is player2 winning
     */
    public int evaluate(){
        return this.player1_score - this.player2_score;
    }

    public ArrayList<String[]> generate_possible_moves(){
        ArrayList<String[]> out = new ArrayList<>();
        for (int y = 0; y < this.board_height; y++) {
            for (int x = 0; x < this.board_width; x++) {
//                {"top", "right", "bottom", "left"})
                if(this.board[y][x].getTop().getPossession() == 0) out.add(new String[] {String.valueOf(x), String.valueOf(y), "top"});
                if(this.board[y][x].getRight().getPossession() == 0) out.add(new String[] {String.valueOf(x), String.valueOf(y), "right"});
                if(this.board[y][x].getBottom().getPossession() == 0) out.add(new String[] {String.valueOf(x), String.valueOf(y), "bottom"});
                if(this.board[y][x].getLeft().getPossession() == 0) out.add(new String[] {String.valueOf(x), String.valueOf(y), "left"});
            }
        }
        return out;
    }

    public ArrayList<String[]> getPossible_moves() {
        return possible_moves;
    }

    public void regenerate_possible_moves() {
        this.possible_moves = this.generate_possible_moves();
    }
}