
import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OthelloGUI extends JFrame {

    private OthelloModel model = new OthelloModel();
    private JButton[][] buttons;
    private int boardDimensionHeight = 520, boardDimensionWidth = 500;
    int boardSize = model.boardSize;


    public OthelloGUI(){
        //this.model = model;
        //model = new OthelloModel();
        setTitle("Othello");
        this.setSize(boardDimensionWidth, boardDimensionHeight);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);


        this.setLayout(new GridLayout(boardSize, boardSize));

        ActionListener a = new ButtonListener();
        buttons = new MyJButton[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                this.add(buttons[i][j] = new MyJButton(i,j));
                buttons[i][j].addActionListener(a);
                buttons[i][j].setBackground(Color.GREEN);
            }
        }
        updateBoard();
    }

    void updateBoard(){
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                OthModInter.GamePiece g = model.whatsInThatSquare(i,j);
                buttons[i][j].setText(g.toIcon());
            }
        }
    }

    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MyJButton m = (MyJButton) e.getSource();
            updateBoard();
            model.placePiece(model.whosTurn(), m.x, m.y);

            updateBoard();
        }
    }

    private static class MyJButton extends JButton {
        int x,y;
        MyJButton(int x, int y){
            this.x = x;
            this.y = y;
        }
    }



}
