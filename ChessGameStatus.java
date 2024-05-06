public class ChessGameStatus {
    // Method to check if the king of a given color is in check
    public static boolean isKingInCheck(ChessPiece[][] board, boolean isWhite) {
        // Implementation of finding the king and checking if it's in check
        // Similar to the previously discussed kingChecks method
        return false; // Placeholder
    }

    // Method to check if there's any legal move available for the given color
    private static boolean canMoveAnyPiece(ChessPiece[][] board, boolean isWhite) {
        // Loop through all pieces of the given color and check if any can make a legal move
        return false; // Placeholder
    }

    // Method to check for checkmate
    public static boolean isCheckmate(ChessPiece[][] board, boolean isWhite) {
        return isKingInCheck(board, isWhite) && !canMoveAnyPiece(board, isWhite);
    }

    // Method to check for stalemate
    public static boolean isStalemate(ChessPiece[][] board, boolean isWhite) {
        return !isKingInCheck(board, isWhite) && !canMoveAnyPiece(board, isWhite);
    }

    // Method to check for a draw due to insufficient material
    public static boolean isDrawByInsufficientMaterial(ChessPiece[][] board) {
        // Simplified version: check for king vs. king
        int pieceCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != null) {
                    pieceCount++;
                    if (pieceCount > 2) {
                        return false; // More than two pieces on the board
                    }
                }
            }
        }
        return true; // Only two kings left
    }
}

