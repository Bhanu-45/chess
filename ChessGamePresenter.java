
import java.awt.Color;
import javax.swing.JLabel;

public class ChessGamePresenter {
    private ChessGameModel model;
    private ChessGameView view;
    private int selectedX, selectedY;
    private boolean pieceSelected = false;

    public ChessGamePresenter(ChessGameModel model, ChessGameView view) {
        this.model = model;
        this.view = view;
        view.updateBoard(model.getBoard());
    }

    public void movePiece(int startX, int startY, int endX, int endY) {
        model.movePiece(startX, startY, endX, endY);
        view.updateBoard(model.getBoard());
    }

    public void handlePieceClicked(int x, int y) {
        ChessPiece piece = model.getBoard()[x][y];
        JLabel[][] squares = view.getBoardPanel().getSquares();
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
                boolean isValid = piece.canMove(selectedX, selectedY, x, y);
                if (isValid) {
                    handleMovePiece(selectedX, selectedY, x, y);
                }
                pieceSelected = false;
                
            }
        }
    }

    private void handleMovePiece(int fromX, int fromY, int toX, int toY) {
            // Update the board.
            model.movePiece(fromX, fromY, toX, toY);
            // Update the view.
            view.updateBoard(model.getBoard());
    }
}

