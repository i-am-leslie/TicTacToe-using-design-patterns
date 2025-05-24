import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicTacToeModel {


    public static final int SIZE = 3;
    public static final boolean X = true;
    public static final boolean O = false;
    private final List<TicTacToeView> views;

    public enum Status {X_WON, O_WON, TIE, UNDECIDED};

    private final char[][] grid;
    private boolean turn;
    private Status status;


    public TicTacToeModel() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
        status = Status.UNDECIDED;
        this.views=new ArrayList<>();
    }
    public void addTicTacToeView(TicTacToeView v){
        views.add(v);
    }



    private void changeTurn() {
        turn = !turn;
    }

    public Status getStatus() {return status;}

    public  char[][] getGrid() {return grid;}

    private void updateStatus(int x, int y) {

        // Note: We don't need to check all rows, columns, and diagonals, only those
        // that contain the latest filled square.  We know that we have a winner
        // if all 3 squares are the same, as they can't all be blank (as the latest
        // filled square is one of them).

        // check row "row"

        boolean won = false;
        if ( grid[x][0]==(grid[x][1]) &&
                grid[x][0]==(grid[x][2]) ) won = true;

        // check column "col"
        if ( grid[0][y]==(grid[1][y]) &&
                grid[0][y]==(grid[2][y]) ) won = true;

        // if row=col check one diagonal
        if (x==y)
            if ( grid[0][0]==(grid[1][1]) &&
                    grid[0][0]==(grid[2][2]) ) won = true;

        // if row=2-col check other diagonal
        if (x==2-y)
            if ( grid[0][2]==(grid[1][1]) &&
                    grid[0][2]==(grid[2][0]) ) won = true;

        // no winner yet

        if(won) {
            status = getTurn() ? Status.X_WON : Status.O_WON;

        }else{
            for(char[] g:grid){
                for(char s:g){
                    if(s == ' '){
                        status=Status.UNDECIDED;
                        return;
                    }
                }
            }
            status = Status.TIE;
        }

    }

    public boolean getTurn() {return turn;}

    public void play(int x, int y) {
        if (!Character.isWhitespace(grid[x][y])) return;
        grid[x][y] = turn? 'X' : 'O'; //
        updateStatus( x, y); // update the model

        views.forEach(v->v.update(new TicTacToeEvent(this , x, y,grid,turn,getStatus()))); // update the jframe
        changeTurn();
    }
}

