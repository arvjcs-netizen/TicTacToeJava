import java.util.Scanner;

public class Board {
    private String[][] boardState;
    Scanner input = new Scanner(System.in);
    private String player;

    public Board(){ 
        boardState = new String[][] {{"E", "E", "E"}, {"E", "E", "E"}, {"E", "E", "E"}};
        player = "X";
    }
    public void getMove(){
        System.out.println("Player " + player + ", it is your move.");
        System.out.println(this);
        System.out.println("Please enter the row which you want to play in. Should be 1, 2, or 3. ");
        int row = input.nextInt() -1 ;
        while (row < 0 || row > 2){
            System.out.println("That value was out of range, please try again");
            row = input.nextInt() -1 ;
        }
        System.out.println("Please enter the column which you want to play in. Should be 1, 2, or 3. ");
        int col = input.nextInt() -1 ;
        while (col < 0 || col > 2){
            System.out.println("That value was out of range, please try again");
            col = input.nextInt() -1 ;
        }
        if((boardState[row][col]).equals("E")){
            addMove(row, col, player);
            if(player.equals("X")){
                player = "O";
            }else{
                player = "X";
            }
            System.out.println(this);
        }else{
            System.out.println("That move was illegal, please try again.");
            getMove();
        }
    }
    public void addMove(int row, int col, String player){
        boardState[row][col] = player; 
    }
    public String checkRows(){
        for(int i = 0; i < 3; i++ ){
            String row = "";
            for(int j = 0; j<3; j++){
                row += boardState[i][j];  
            }
            if(row.equals("XXX")){
                return "X"; 
            }else if(row.equals("OOO")){
                return "O";
            }
        }
        return "none";
    }
    public String checkColumns(){
        for(int j = 0; j < 3; j++ ){
            String row = "";
            for(int i = 0; i<3; i++){
                row += boardState[i][j];  
            }
            if(row.equals("XXX")){
                return "X"; 
            }else if(row.equals("OOO")){
                return "O";
            }
        }
        return "none";
    }
    public String checkDiagonals(){
        for(int i = 0; i < 2; i++){
            String diagonal; 
            if(i == 0){
                diagonal = "";
                diagonal +=boardState[0][0];
                diagonal += boardState[1][1];
                diagonal += boardState[2][2];
                if(diagonal.equals("XXX")){
                    return "X";
                }else if (diagonal.equals("OOO")){
                    return "O";
                }
            }
            if(i == 1){
                diagonal = "";
                diagonal +=boardState[2][0];
                diagonal += boardState[1][1];
                diagonal += boardState[0][2];
                if(diagonal.equals("XXX")){
                    return "X";
                }else if (diagonal.equals("OOO")){
                    return "O";
                }
            }
        }
        return "none";
        
    }

    public String check(){
        String row = checkRows();
        String col = checkColumns();
        String diagonal = checkDiagonals();
        if (row.equals("none")){
            
        }else{
            return row;
        }
        if (col.equals("none")){

        }else{
            return col;
        }
        if (diagonal.equals("none")){
            
        }else{
            return diagonal;
        }
        for (int i = 0; i < boardState.length; i++) {
            for(int j = 0; j < boardState[i].length; j++) {
                if(boardState[i][j].equals("E")){
                    return "none";
                }
            }
            
        }
        return "tie";
    }       

    @Override
    public String toString(){
        String result = "";
        for (int i = 0; i < boardState.length; i++) {
            for(int j = 0; j < boardState[i].length; j++) {
                result += boardState[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }
}
