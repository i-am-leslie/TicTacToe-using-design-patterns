import java.util.Random;

public class TicTacToeAI{

    private final TicTacToeModel model;

    private boolean hasPlayed;


    public TicTacToeAI(TicTacToeModel model){
        this.model = model;
        hasPlayed=false;
    }

    public void play(){
        while(!hasPlayed ){
            int[] points= pickRandomPoint();
            if(model.getGrid()[points[0]][points[1]]==' '){
                model.play(points[0], points[1]);
                hasPlayed=!hasPlayed;
            }
        }
        hasPlayed= false;
    }
    private int[] pickRandomPoint(){
        int i= new Random().nextInt(TicTacToeModel.SIZE);
        int j= new Random().nextInt(TicTacToeModel.SIZE);
        return new int[]{i,j};
    }
}
