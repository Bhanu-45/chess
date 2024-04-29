public class ChessGame {
    public static void main(String[] args) {
        ChessGameModel model = new ChessGameModel();
        ChessGameView view = new ChessGameView();
        ChessGameController controller = new ChessGameController(model, view);
    }
}
