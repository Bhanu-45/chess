import java.awt.*;
import javax.swing.*;

public abstract class ChessPiece {
    protected boolean isWhite;
    protected ImageIcon image;

    public ChessPiece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public abstract boolean canMove(ChessPiece[][] board,int startX, int startY, int endX, int endY);

    public Image getImage() {
        return image.getImage();
    }

    public ImageIcon getImageIcon() {
        return image;
    }

    
public boolean kingChecks(ChessPiece[][] board) {
    int kingX = -1, kingY = -1;
    // Find the king's position
    for (int x = 0; x < board.length; x++) {
        for (int y = 0; y < board[x].length; y++) {
            ChessPiece piece = board[x][y];
            if (piece != null && piece instanceof King && piece.isWhite == this.isWhite) {
                kingX = x;
                kingY = y;
                break;
            }
        }
        if (kingX != -1) break; // King found, no need to continue searching
    }

    // Check if any opposing piece can move to the king's position
    for (int x = 0; x < board.length; x++) {
        for (int y = 0; y < board[x].length; y++) {
            ChessPiece piece = board[x][y];
            if (piece != null && piece.isWhite != this.isWhite && kingX != -1) {
                // Temporarily simulate the opposing piece's move to the king's position
                ChessPiece originalKingPosition = board[kingX][kingY];
                board[kingX][kingY] = piece;
                board[x][y] = null;
                
                if (piece.canMove(board, x, y, kingX, kingY)) {
                    // Undo the simulation
                    board[x][y] = piece;
                    board[kingX][kingY] = originalKingPosition;
                    return true; // The king is in check
                }
                
                // Undo the simulation
                board[x][y] = piece;
                board[kingX][kingY] = originalKingPosition;
            }
        }
    }
    return false; // The king is not in check
}

    

    public ImageIcon reSHape(ImageIcon imageIcon){
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(97, 97,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }
}

class Pawn extends ChessPiece {
    public Pawn(boolean isWhite) {
        super(isWhite);
        this.image = reSHape(new ImageIcon(getClass().getResource(isWhite ? "/images/wp.png" : "/images/bp.png")));
    }

    @Override
    public boolean canMove(ChessPiece[][] board,int startX, int startY, int endX, int endY) {
        // Pawn move logic
        // Can only move forward 2 steps max, and check valid positions in that.
        int direction = isWhite ? 1 : -1;
        // Forward move
        if (startY == endY && startX + direction == endX && board[endX][endY] == null) {
            return true;
        }
        // Initial two-square move
        if (startY == endY && startX + (2 * direction) == endX && board[endX][endY] == null && board[startX+direction][startY ] == null && (isWhite ? startX == 1 : startX == 6)) {
            return true;
        }
        // Diagonal capture
        if ((endY == startY + 1 || endY == startY - 1) && startX + direction == endX && board[endX][endY] != null && board[endX][endY].isWhite != this.isWhite) {
            return true;
        }

        return false;
    }
}

class Rook extends ChessPiece {
    public Rook(boolean isWhite) {
        super(isWhite);
        this.image = reSHape(new ImageIcon(getClass().getResource(isWhite ? "/images/wr.png" : "/images/br.png")));
    }

    @Override
    public boolean canMove(ChessPiece[][] board,int startX, int startY, int endX, int endY) {
        // Rook move logic
        // Can move forward/backward/leftwards/rightwards max 8 positions.
        if (startX != endX && startY != endY) {
            return false; // Rooks move in a straight line
        }
        int stepX = Integer.compare(endX, startX);
        int stepY = Integer.compare(endY, startY);
        int x = startX + stepX;
        int y = startY + stepY;
        while (x != endX ^ y != endY) {
            if (board[x][y] != null) {
                return false; // Blocked by another piece
            }
            x += stepX;
            y += stepY;
        }
        
        return (board[endX][endY] == null || board[endX][endY].isWhite != this.isWhite);
    }
}

class Knight extends ChessPiece {
    public Knight(boolean isWhite) {
        super(isWhite);
        this.image = reSHape(new ImageIcon(getClass().getResource(isWhite ? "/images/wn.png" : "/images/bn.png")));
    }

    @Override
    public boolean canMove(ChessPiece[][] board,int startX, int startY, int endX, int endY) {
        // Knight move logic
        // Can only move in L shapes from the starting square.
        
        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);
        return ((dx == 2 && dy == 1) || (dx == 1 && dy == 2) && (board[endX][endY] == null || board[endX][endY].isWhite != this.isWhite));
    }
}

class Bishop extends ChessPiece {
    public Bishop(boolean isWhite) {
        super(isWhite);
        this.image = reSHape(new ImageIcon(getClass().getResource(isWhite ? "/images/wb.png" : "/images/bb.png")));
    }

    @Override
    public boolean canMove(ChessPiece[][] board,int startX, int startY, int endX, int endY) {
        // Bishop move logic
        // Can move diagonally max 8 positions in either direction.
        
        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);
        if (dx != dy) {
            return false; // Bishops move diagonally
        }
        int stepX = Integer.compare(endX, startX);
        int stepY = Integer.compare(endY, startY);
        int x = startX + stepX;
        int y = startY + stepY;
        while (x != endX && y != endY) {
            if (board[x][y] != null) {
                return false; // Blocked by another piece
            }
            x += stepX;
            y += stepY;
        }
        return (board[endX][endY] == null || board[endX][endY].isWhite != this.isWhite);
    }
}

class Queen extends ChessPiece {
    public Queen(boolean isWhite) {
        super(isWhite);
        this.image = reSHape(new ImageIcon(getClass().getResource(isWhite ? "/images/wq.png" : "/images/bq.png")));
    }

    @Override
    public boolean canMove(ChessPiece[][] board,int startX, int startY, int endX, int endY) {
        // Queen move logic
        kingChecks(board);
        return (new Rook(isWhite).canMove(board, startX, startY, endX, endY) || new Bishop(isWhite).canMove(board, startX, startY, endX, endY));
    }
}

class King extends ChessPiece {
    public King(boolean isWhite) {
        super(isWhite);
        this.image = reSHape(new ImageIcon(getClass().getResource(isWhite ? "/images/wk.png" : "/images/bk.png")));
    }

    @Override
    public boolean canMove(ChessPiece[][] board, int startX, int startY, int endX, int endY) {
        // Basic movement check for the king (move only one square in any direction)
        if (Math.abs(startX - endX) > 1 || Math.abs(startY - endY) > 1) {
            return false;
        }
    
        // Check if the destination square contains an opponent's piece
        ChessPiece destinationPiece = board[endX][endY];
        if (destinationPiece != null && destinationPiece.isWhite != this.isWhite) {
            // Check if the opponent's piece is protected by another opponent's piece
            if (isSquareAttacked(board, endX, endY, !this.isWhite)) {
                return false; // Cannot capture as it is protected
            }
        }

        if(destinationPiece == null){
            // Check it is new positon is not 
            if (isSquareAttacked(board, endX, endY, !this.isWhite)) {
                return false; // Cannot move as it is protected
            }
        }
        

    
        // Ensure the destination square is not occupied by a piece of the same color
        if (destinationPiece != null && destinationPiece.isWhite == this.isWhite) {
            return false;
        }
    
        return true;
    }

    private boolean isSquareAttacked(ChessPiece[][] board, int x, int y, boolean byWhite) {
        // Loop through all squares to find all pieces of the specified color
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                ChessPiece piece = board[i][j];
                if (piece != null && piece.isWhite == byWhite) {
                    // Check if the piece can move to the square (x, y)
                    if (piece.canMove(board, i, j, x, y)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


}

