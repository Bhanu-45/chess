import java.awt.*;
import javax.swing.*;

public abstract class ChessPiece {
    protected boolean isWhite;
    protected ImageIcon image;

    public ChessPiece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public abstract boolean canMove(int startX, int startY, int endX, int endY);

    public Image getImage() {
        return image.getImage();
    }

    public ImageIcon getImageIcon() {
        return image;
    }

    public ImageIcon reSHape(ImageIcon imageIcon){
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
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
    public boolean canMove(int startX, int startY, int endX, int endY) {
        // Pawn move logic
        return false;
    }
}

class Rook extends ChessPiece {
    public Rook(boolean isWhite) {
        super(isWhite);
        this.image = reSHape(new ImageIcon(getClass().getResource(isWhite ? "/images/wr.png" : "/images/br.png")));
    }

    @Override
    public boolean canMove(int startX, int startY, int endX, int endY) {
        // Rook move logic
        return false;
    }
}

class Knight extends ChessPiece {
    public Knight(boolean isWhite) {
        super(isWhite);
        this.image = reSHape(new ImageIcon(getClass().getResource(isWhite ? "/images/wn.png" : "/images/bn.png")));
    }

    @Override
    public boolean canMove(int startX, int startY, int endX, int endY) {
        // Rook move logic
        return false;
    }
}

class Bishop extends ChessPiece {
    public Bishop(boolean isWhite) {
        super(isWhite);
        this.image = reSHape(new ImageIcon(getClass().getResource(isWhite ? "/images/wb.png" : "/images/bb.png")));
    }

    @Override
    public boolean canMove(int startX, int startY, int endX, int endY) {
        // Rook move logic
        return false;
    }
}

class Queen extends ChessPiece {
    public Queen(boolean isWhite) {
        super(isWhite);
        this.image = reSHape(new ImageIcon(getClass().getResource(isWhite ? "/images/wq.png" : "/images/bq.png")));
    }

    @Override
    public boolean canMove(int startX, int startY, int endX, int endY) {
        // Rook move logic
        return false;
    }
}

class King extends ChessPiece {
    public King(boolean isWhite) {
        super(isWhite);
        this.image = reSHape(new ImageIcon(getClass().getResource(isWhite ? "/images/wk.png" : "/images/bk.png")));
    }

    @Override
    public boolean canMove(int startX, int startY, int endX, int endY) {
        // Rook move logic
        return false;
    }
}

// Similarly, define classes for Knight, Bishop, Queen, and King

