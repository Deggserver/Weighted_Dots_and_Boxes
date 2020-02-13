package src;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Minimax {
    static Scanner scanner = new Scanner(System.in);
    Node node;
    int plies;
    int turn = 0;   //even -> human
                    //odd  -> ai

    public Minimax(int width, int height, int ai_plies) {
        this.plies = ai_plies;
        this.node = new Node(width, height);
    }

    private void player1_move(){
        System.out.println("\t<row> <column> <side>");
        String[] move = this.scanner.nextLine().split(" ");
        if(move[0].equals("")) return;
        this.node.claim_edge(Integer.parseInt(move[1]), Integer.parseInt(move[0]), move[2], 1);
        this.node.regenerate_possible_moves();
    }

    private void player2_move(){
        String[] move = minimax(this.node, 2, true);
        System.out.println(move[1] +" "+ move[0] +" "+ move[2]);
        this.node.claim_edge(Integer.parseInt(move[0]), Integer.parseInt(move[1]), move[2], 2);
        this.node.regenerate_possible_moves();
    }

    private String[] minimax(Node curr, int depth, boolean isMaximizer){
//        if(depth == 0){ //reached horizon of lookahead
//            return move;
//        }
//        if(isMaximizer){
//            return move;
//        }
//        else{
//            return move;
//        }
        Random tmp = new Random();
        return curr.getPossible_moves().get(tmp.nextInt(curr.getPossible_moves().size() - 1));
    }

    public static void main(String[] args) {
        System.out.println("Input board-width board-height and AI's plies in the form of:\n\t <board-width> <board-height> <AI's-plies>\n");
        String[] tmp = scanner.nextLine().split(" ");
        int[] user_input = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            user_input[i] = Integer.parseInt(tmp[i]);
        }
        Minimax game = new Minimax(user_input[0], user_input[1], user_input[2]);
        game.node.show_board();
        for (int i = 0; !(game.node.isGameOver()) ; i++) {
            if(i % 2 == 0){
                game.player1_move();
            }
            else{
                game.player2_move();
            }
            game.node.show_board();
        }
        System.out.println("Final score: " + game.node.getPlayer1_score() + " vs " + game.node.getPlayer2_score());
    }
}
