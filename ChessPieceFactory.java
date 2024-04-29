public class ChessPieceFactory {
    public static ChessPiece createPiece(PieceType type, boolean isWhite) {
        switch (type) {
            case PAWN:
                return new Pawn(isWhite);
            case ROOK:
                return new Rook(isWhite);
            case KNIGHT:
                return new Knight(isWhite);
            case BISHOP:
                return new Bishop(isWhite);
            case QUEEN:
                return new Queen(isWhite);
            case KING:
                return new King(isWhite);
            default:
                throw new IllegalArgumentException("Unknown piece type: " + type);
        }
    }
}

enum PieceType {
    PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING
}

