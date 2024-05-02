import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChessGameView {
    private JFrame frame;
    private ChessBoardPanel boardPanel;

    public ChessGameView() {
        frame = new JFrame("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setBackground(ColorEnum.DUNE.getColor());
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
    private int selectedX, selectedY;
    private boolean pieceSelected = false;
    public int tileSize = 85;
    public int cols = 8;
    public int rows = 8;
    public ChessPiece selectedPiece;

    public ChessBoardPanel() {
        setLayout(new GridLayout(8, 8));
        squares = new JLabel[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
 
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new JLabel();
                squares[i][j].setPreferredSize(new Dimension(64, 64)); // Set square size.
    
                add(squares[i][j]);

                int finalI = i;
                int finalJ = j;
                squares[i][j].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        handleChessSquareClick(finalI, finalJ);
                    }
                });
            }
        }
    }

    public void updateBoard(ChessPiece[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board[i][j];
    
                // Set the icon for the JLabel, if a piece is present
                if (piece != null) {
                    squares[i][j].setIcon(piece.getImageIcon());  // Assuming ChessPiece has getImageIcon() returning an ImageIcon
                } else {
                    squares[i][j].setIcon(null);  // Remove icon if no piece is present
                }
    
                // Set background colors
                squares[i][j].setOpaque(true);  // Make the JLabel opaque to show the background
                squares[i][j].setBackground((i + j) % 2 == 0 ? ColorEnum.ATHS_SPECIAL.getColor() : ColorEnum.ASPARAGUS.getColor());
    
                // Refresh the label to ensure updates are displayed
                squares[i][j].validate();
                squares[i][j].repaint();
            }
        }
    }

    private void handleChessSquareClick(int x, int y) {
        if (!pieceSelected) {
            // Select the piece
            if (squares[x][y].getIcon() != null) {
                selectedX = x;
                selectedY = y;
                pieceSelected = true;
                squares[x][y].setBackground(Color.YELLOW); // Highlight the selected square
            }
        } else {
            // Move the piece
            if (x == selectedX && y == selectedY) {
                // Click the same square again to deselect
                pieceSelected = false;
               // squares[x][y].setBackground((x + y) % 2 == 0 ? ColorEnum.ATHS_SPECIAL.getColor() : ColorEnum.ASPARAGUS.getColor());
            } else {
                // Validate the move here (you'll need to add your own logic)
                movePiece(selectedX, selectedY, x, y);
                pieceSelected = false;
            }
        }
    }

    private void movePiece(int startX, int startY, int endX, int endY) {
        ImageIcon icon = (ImageIcon) squares[startX][startY].getIcon();
        squares[endX][endY].setIcon(icon);
        squares[startX][startY].setIcon(null);
        // Reset background colors
        squares[startX][startY].setBackground((startX + startY) % 2 == 0 ? ColorEnum.ATHS_SPECIAL.getColor() : ColorEnum.ASPARAGUS.getColor());
        squares[endX][endY].setBackground((endX + endY) % 2 == 0 ? ColorEnum.ATHS_SPECIAL.getColor() : ColorEnum.ASPARAGUS.getColor());

        
    }
    
}