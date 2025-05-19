import java.util.EventObject;

public class TicTacToeEvent extends EventObject {
    private final int y;
    private final int x;
    private final boolean turn;

    private final TicTacToeModel.Status status;

    public TicTacToeEvent(TicTacToeModel ticTacToeModel, int x, int y, char[][] grid, boolean turn, TicTacToeModel.Status status) {
        super(ticTacToeModel);
        this.y = y;
        this.x=x;
        this.turn = turn;
        this.status = status;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean isTurn() {
        return turn;
    }

    public TicTacToeModel.Status getStatus() {
        return status;
    }
}
