public class Main {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Welcome to Tic Tac Toe!"); 
        System.out.println("");
        Board board = new Board();
        while (true){
            board.getMove();
            if ((board.check().equals("none"))){

            }else if(!board.check().equals("tie")){
                System.out.println("Player " + board.check() + " has won!");
                break;
            }else{
                System.out.println("The game has ended in a tie.");
                break;
            }
        }

        



    }
}
