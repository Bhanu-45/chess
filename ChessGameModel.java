
public class ChessGameModel {
    private ChessPiece[][] board;

    public ChessGameModel() {
        this.board = new ChessPiece[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        // Initialize white pieces



        for (int i = 0; i < 8; i++) {
            board[1][i] = ChessPieceFactory.createPiece(PieceType.PAWN, true);
        }
        board[0][0] = ChessPieceFactory.createPiece(PieceType.ROOK, true);
        board[0][7] = ChessPieceFactory.createPiece(PieceType.ROOK, true);
        board[0][1] = ChessPieceFactory.createPiece(PieceType.KNIGHT, true);
        board[0][6] = ChessPieceFactory.createPiece(PieceType.KNIGHT, true);
        board[0][2] = ChessPieceFactory.createPiece(PieceType.BISHOP, true);
        board[0][5] = ChessPieceFactory.createPiece(PieceType.BISHOP, true);
        board[0][3] = ChessPieceFactory.createPiece(PieceType.QUEEN, true);
        board[0][4] = ChessPieceFactory.createPiece(PieceType.KING, true);

        // Initialize black pieces
        for (int i = 0; i < 8; i++) {
            board[6][i] = ChessPieceFactory.createPiece(PieceType.PAWN, false);
        }
        board[7][0] = ChessPieceFactory.createPiece(PieceType.ROOK, false);
        board[7][7] = ChessPieceFactory.createPiece(PieceType.ROOK, false);
        board[7][1] = ChessPieceFactory.createPiece(PieceType.KNIGHT, false);
        board[7][6] = ChessPieceFactory.createPiece(PieceType.KNIGHT, false);
        board[7][2] = ChessPieceFactory.createPiece(PieceType.BISHOP, false);
        board[7][5] = ChessPieceFactory.createPiece(PieceType.BISHOP, false);
        board[7][3] = ChessPieceFactory.createPiece(PieceType.QUEEN, false);
        board[7][4] = ChessPieceFactory.createPiece(PieceType.KING, false);
        
        //print the board.
        printBoard();

    }

    public ChessPiece getPieceAt(int x, int y) {
        return board[x][y];
    }

    public void movePiece(int startX, int startY, int endX, int endY) {
        // Move piece logic
        board[endX][endY] = board[startX][startY];
        board[startX][startY] = null;
    }

    public ChessPiece[][] getBoard(){
        return board;
    }

    public void printBoard(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                System.out.println(this.board[i][j]);
            }
        }
    }
}
