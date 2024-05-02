
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class ChessGame extends JFrame{
    private ChessGameModel model;
    private ChessGameView view;
    private ChessGamePresenter presenter;

    public ChessGame(){
        model = new ChessGameModel();
        view = new ChessGameView();

        presenter = new ChessGamePresenter(model, view);

        setTitle("Chess Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

        // Set up the UI components and add event listeners
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(view.getBoardPanel(), BorderLayout.CENTER);

        //Add functionalities down.
        //mainPanel.add(statusPanel, BorderLayout.SOUTH);
        
        add(mainPanel);

        JLabel[][] squares = view.getBoardPanel().getSquares();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                int finalI = i;
                int finalJ = j;
                squares[i][j].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        presenter.handlePieceClicked(finalI, finalJ);
                    }
                });
            }
        }

        
        
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> (new ChessGame()).setVisible(true));
    }
}
