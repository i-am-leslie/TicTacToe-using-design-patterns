import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeModelTest {
    TicTacToeModel t;

    @Before
    public void setup(){
        t=new TicTacToeModel();
    }
    @Test
    public  void testInitialStatus(){
        assertEquals(TicTacToeModel.Status.UNDECIDED,t.getStatus());
    }
    @Test
    public void testxwins(){
        t.play(0,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED,t.getStatus());
        t.play(0,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED,t.getStatus());
        t.play(1,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED,t.getStatus());
        t.play(1,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED,t.getStatus());
        t.play(2,0);
        assertEquals(TicTacToeModel.Status.X_WON,t.getStatus());
    }
    @Test
    public void testOwins(){
        t.play(0,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED,t.getStatus());
        t.play(0,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED,t.getStatus());
        t.play(1,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED,t.getStatus());
        t.play(1,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED,t.getStatus());
        t.play(2,2);
        assertEquals(TicTacToeModel.Status.UNDECIDED,t.getStatus());
        t.play(2,1);
        assertEquals(TicTacToeModel.Status.O_WON,t.getStatus());
    }
    @Test
    public void Tie(){
        t.play(0,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED,t.getStatus());
        t.play(0,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED,t.getStatus());
        t.play(1,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED,t.getStatus());
        t.play(1,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED,t.getStatus());
        t.play(2,0);
        assertEquals(TicTacToeModel.Status.UNDECIDED,t.getStatus());
        t.play(2,2);
        assertEquals(TicTacToeModel.Status.UNDECIDED,t.getStatus());
        t.play(2,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED,t.getStatus());
        t.play(0,2);
        assertEquals(TicTacToeModel.Status.UNDECIDED,t.getStatus());
        t.play(1,2);
        assertEquals(TicTacToeModel.Status.TIE,t.getStatus());
    }



}