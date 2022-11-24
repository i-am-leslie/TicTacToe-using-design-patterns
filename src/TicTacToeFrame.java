import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame implements TicTacToeView {
    private JButton[][] buttons;
    private JOptionPane p;



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
        this.setSize(300,300);
        this.setVisible(true);
    }


    @Override
    public void update(TicTacToeEvent event) {
        String label= event.isTurn()? "X":"O";
        buttons[event.getX()][event.getY()].setText(label);
        if(event.getStatus()== TicTacToeModel.Status.X_WON){
            p.showMessageDialog(this,"X won the game");
            this.dispose();
        }
        else if(event.getStatus()== TicTacToeModel.Status.O_WON){
            p.showMessageDialog(this,"O won the game");
            this.dispose();
        }
        else if(event.getStatus()== TicTacToeModel.Status.TIE){
            p.showMessageDialog(this,"TIE");
            this.dispose();
        }

    }

    public static void main(String[] args) {
        new TicTacToeFrame();
    }
}
