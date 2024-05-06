
import java.awt.Color;
import javax.swing.JLabel;

public class ChessGamePresenter {
    private ChessGameModel model;
    private ChessGameView view;
    private int selectedX, selectedY;
    private boolean pieceSelected = false;
    private static boolean isWhiteTurn = true;

    public ChessGamePresenter(ChessGameModel model, ChessGameView view) {
        this.model = model;
        this.view = view;
        view.updateBoard(model.getBoard());
    }

    //public void movePiece(int startX, int startY, int endX, int endY) {
    //    model.movePiece(startX, startY, endX, endY);
    //    view.updateBoard(model.getBoard());
    //}

    public void handlePieceClicked(int x, int y) {
        ChessPiece piece = model.getBoard()[x][y];
        JLabel[][] squares = view.getBoardPanel().getSquares();
        if (!pieceSelected ) {
            // Select the piece
            if (squares[x][y].getIcon() != null && isWhiteTurn == model.getPieceAt(x, y).isWhite) {
                selectedX = x;
                selectedY = y;
                pieceSelected = true;
                squares[x][y].setBackground(Color.YELLOW); // Highlight the selected square
                System.out.printf("Initial Values are %d and %d", selectedX, selectedY);
            }
        } else {
            // Move the piece
            if ((x == selectedX && y == selectedY) || isWhiteTurn != model.getPieceAt(selectedX, selectedY).isWhite) {
                // Click the same square again to deselect
                squares[selectedX][selectedY].setBackground((x + y) % 2 == 0 ? ColorEnum.ATHS_SPECIAL.getColor() : ColorEnum.ASPARAGUS.getColor());
            } else {
                // Validate the move here (you'll need to add your own logic)
                if(model.getPieceAt(selectedX, selectedY) != null){
                    boolean isValid = model.getPieceAt(selectedX, selectedY).canMove(model.getBoard(),selectedX, selectedY, x, y);
                    boolean isValid1 = !model.getPieceAt(selectedX, selectedY).kingChecks(model.getBoard());

                    if (isValid && isValid1) {
                        handleMovePiece(selectedX, selectedY, x, y);
                        System.out.printf("Initial Values are %d and %d", x, y);
                        isWhiteTurn = !isWhiteTurn;
                    }
                }
                
            }
            pieceSelected = false;
        }
        /* 
        // After a move is made:
        if (ChessGameStatus.isCheckmate(model.getBoard(), isWhiteTurn)) {
            System.out.println("Checkmate! " + (isWhiteTurn ? "Black" : "White") + " wins!");
        } else if (ChessGameStatus.isStalemate(model.getBoard(), isWhiteTurn)) {
            System.out.println("Stalemate! The game is a draw.");
        } else if (ChessGameStatus.isDrawByInsufficientMaterial(model.getBoard())) {
            System.out.println("Draw due to insufficient material.");
        }
        */
        
        
    }

    private void handleMovePiece(int fromX, int fromY, int toX, int toY) {
            // Update the board.
            model.movePiece(fromX, fromY, toX, toY);
            // Update the view.
            view.updateBoard(model.getBoard());
    }
}

