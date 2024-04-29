import javax.swing.*;
import java.awt.*;

public class ChessGameView {
    private JFrame frame;
    private ChessBoardPanel boardPanel;

    public ChessGameView() {
        frame = new JFrame("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        boardPanel = new ChessBoardPanel();
        frame.add(boardPanel);
        frame.setVisible(true);
    }

    public void updateBoard(ChessPiece[][] board) {
        boardPanel.updateBoard(board);
    }
}

class ChessBoardPanel extends JPanel {
    private JLabel[][] squares;

    public ChessBoardPanel() {
        setLayout(new GridLayout(8, 8));
        squares = new JLabel[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new JLabel();
                add(squares[i][j]);
            }
        }
    }

    public void updateBoard(ChessPiece[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board[i][j];
                if (piece != null) {
                    squares[i][j].setIcon(piece.getImage());
                } else {
                    squares[i][j].setIcon(null);
                }
            }
        }
    }
}
