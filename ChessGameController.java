public class ChessGameController {
    private ChessGameModel model;
    private ChessGameView view;

    public ChessGameController(ChessGameModel model, ChessGameView view) {
        this.model = model;
        this.view = view;
        view.updateBoard(model.getBoard());
    }

    public void movePiece(int startX, int startY, int endX, int endY) {
        model.movePiece(startX, startY, endX, endY);
        view.updateBoard(model.getBoard());
    }
}

