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

    public boolean kingChecks(ChessPiece[][] board){
        // Check if there are any king checks present.
        return true;
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
        kingChecks(board);
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
        kingChecks(board);
        return false;
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
        kingChecks(board);
        return false;
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
        kingChecks(board);
        return false;
    }
}

class Queen extends ChessPiece {
    public Queen(boolean isWhite) {
        super(isWhite);
        this.image = reSHape(new ImageIcon(getClass().getResource(isWhite ? "/images/wq.png" : "/images/bq.png")));
    }

    @Override
    public boolean canMove(ChessPiece[][] board,int startX, int startY, int endX, int endY) {
        // Rook move logic
        kingChecks(board);
        return false;
    }
}

class King extends ChessPiece {
    public King(boolean isWhite) {
        super(isWhite);
        this.image = reSHape(new ImageIcon(getClass().getResource(isWhite ? "/images/wk.png" : "/images/bk.png")));
    }

    @Override
    public boolean canMove(ChessPiece[][] board,int startX, int startY, int endX, int endY) {
        // Rook move logic
        kingChecks(board);
        return false;
    }


}

// Similarly, define classes for Knight, Bishop, Queen, and King

