import src.*;

public class Main {
    public static void main(String[] args) {
        Node test0 = new Node(3, 4);
        test0.show_board();
        test0.claim_edge(0,0,"bottom", 1);
        test0.show_board();
        test0.claim_edge(0,0,"right", 1);
        test0.show_board();
        test0.claim_edge(2,1,"top", 1);
        test0.show_board();
        test0.claim_edge(0,2,"top", 1);
        test0.show_board();
        test0.claim_edge(0,0,"top", 1);
        test0.show_board();
        test0.claim_edge(0,0,"left", 1);
        test0.show_board();
    }
}
