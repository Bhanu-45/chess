import java.awt.*;
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
                squares[i][j].setPreferredSize(new Dimension(64, 64)); // Set square size
    
                // Alternate square colors
                //if ((i + j) % 2 == 0) {
                //    squares[i][j].setBackground(ColorEnum.ATHS_SPECIAL.getColor());
                //} else {
                //    squares[i][j].setBackground(ColorEnum.ASPARAGUS.getColor());
                //}
    
                add(squares[i][j]);
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
    

    /* 
    public void paint(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Paint board
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++) {
                g2d.setColor((c + r) % 2 == 0 ? ColorEnum.ATHS_SPECIAL.getColor() : ColorEnum.ASPARAGUS.getColor());
                g2d.fillRect(c * tileSize, r * tileSize, tileSize, tileSize);
            }

        // Paint selected piece highlight
        if (selectedPiece != null) {
            Color highlightColor;
            if (selectedPiece.isWhite) {
                highlightColor = new Color(0xB9CA70);
            } else {
                highlightColor = new Color(0xF5F682);
            }
        g2d.setColor(highlightColor);
        //g2d.fillRect(selectedPiece.col * tileSize, selectedPiece.row * tileSize, tileSize, tileSize);
        }

        // Paint pieces
        for (ChessPiece piece : pieceList) {
            piece.paint(g2d);
        };


    }

    /* 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Paint board
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++) {
                g2d.setColor((c + r) % 2 == 0 ? ColorEnum.ATHS_SPECIAL.getColor() : ColorEnum.ASPARAGUS.getColor());
                g2d.fillRect(c * tileSize, r * tileSize, tileSize, tileSize);
            };

        // Paint selected piece highlight
        if (selectedPiece != null) {
            Color highlightColor;
            if ((selectedPiece.col + selectedPiece.row) % 2 == 0) {
                highlightColor = new Color(0xB9CA70);
            } else {
                highlightColor = new Color(0xF5F682);
            }
            g2d.setColor(highlightColor);
            g2d.fillRect(selectedPiece.col * tileSize, selectedPiece.row * tileSize, tileSize, tileSize);
        };

        // Paint Highlights
        if (selectedPiece != null) {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (isValidMove(new Move(this, selectedPiece, c, r))) {
                        g2d.setColor(Color.WHITE);
                        g2d.setStroke(new BasicStroke(3));
                        g2d.drawRect(c * tileSize, r * tileSize, tileSize, tileSize);
                    };
                };
            };
        };

        // Paint pieces
        for (ChessPiece piece : pieceList) {
            piece.paint(g2d);
        };
    };
    */
}
