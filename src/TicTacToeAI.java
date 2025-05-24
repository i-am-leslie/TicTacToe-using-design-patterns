public class TicTacToeAI{

    private final TicTacToeModel model;


    public TicTacToeAI(TicTacToeModel model){
        this.model = model;
    }

    public void play(){
        for (int i = 0; i < TicTacToeModel.SIZE; i++){
            for(int j = 0; j < TicTacToeModel.SIZE; j++){
                if(model.getGrid()[i][j] == ' '){
                    model.play(i, j);
                    return;
                }
            }
        }
    }
}
