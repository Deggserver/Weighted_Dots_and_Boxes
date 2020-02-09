import java.util.Scanner;

public class minimax {
    int plies;
    int turn;   //even -> human
                //odd  -> ai

    public minimax(int ai_plies){
        this.plies = ai_plies;
    }

    // TODO: 2/9/2020
    private void minimax_decision(){
        return;
    }

    // TODO: 2/9/2020
    private int max_value(Node curr){
        return 0;
    }

    // TODO: 2/9/2020
    private int min_value(Node curr){
        return 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String user_input;
        int[] user_input_int;

        System.out.println("Enter the size of the board in terms of boxes and enter how many plies the ai will look ahead, then press enter.\n<board_x> <board_y> <plies>");
        user_input = scanner.nextLine();
        user_input_int = translate_user_input(user_input);

        /*
        create node starting object and minimax object from ^user_input_int^
         */
    }
    static int[] translate_user_input(String s){
        int[] out = new int[3];
        int i = 0;
        for (String x : s.split(" ")) {
            out[i] = Integer.getInteger(x);
            i++;
        }
        return out;
    }
}
