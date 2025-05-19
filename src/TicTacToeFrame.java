import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class TicTacToeFrame extends JFrame implements TicTacToeView {
    private final JButton[][] buttons;
    private final JOptionPane p;
    private final Map<TicTacToeModel.Status, Runnable> update=new HashMap<>();



    public TicTacToeFrame(){
        super("tic tac toe");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(TicTacToeModel.SIZE, TicTacToeModel.SIZE));
        p=new JOptionPane();

        TicTacToeModel model=new TicTacToeModel();

        buttons=new JButton[TicTacToeModel.SIZE][TicTacToeModel.SIZE];
        TicTacToeController ttc =new TicTacToeController(model);
        model.addTicTacToeView(this);//

        for(int i = 0; i< TicTacToeModel.SIZE; i++){
            for(int j = 0; j< TicTacToeModel.SIZE; j++){
                JButton b=new JButton(" ");
                b.setActionCommand(i + " "+ j);
                buttons[i][j]=b;
                b.addActionListener(ttc);

                this.add(b);

            }
        }
        update.put(TicTacToeModel.Status.X_WON, ()-> {
            JOptionPane.showMessageDialog(this, "X won the game!!");
            this.dispose();
        });
        update.put(TicTacToeModel.Status.O_WON, ()-> {
            JOptionPane.showMessageDialog(this,"O won the game!!");
            this.dispose();
        });
        update.put(TicTacToeModel.Status.TIE, ()-> {
            JOptionPane.showMessageDialog(this,"TIE!!");
            this.dispose();
        });


        this.setSize(300,300);
        this.setVisible(true);
    }


    @Override
    public void update(TicTacToeEvent event) {
        String label= event.isTurn()? "X":"O";
        buttons[event.getX()][event.getY()].setText(label);
        Runnable r=update.get(event.getStatus());
        if(r!=null)r.run();
    }

    public static void main(String[] args) {
        new TicTacToeFrame();
    }
}
