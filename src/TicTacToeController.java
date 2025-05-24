import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class listens for an event and when an event occurs it updates the model so it keeps accurate
 * state of the game
 */
public class TicTacToeController implements ActionListener {
    private final TicTacToeModel model;
    private TicTacToeAI ai;


    public TicTacToeController(TicTacToeModel model, int aiOrHuman) {
        this.model=model;
        if(aiOrHuman<1) ai=new TicTacToeAI(this.model);
    }

    /**
     * Gets the action that was performed with the position passing it on to the model
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String[] input=e.getActionCommand().split(" ");
        int x =Integer.parseInt(input[0]);
        int y =Integer.parseInt(input[1]);
        model.play(x,y);

        if(ai != null) {
            ai.play();
        }
    }


}
