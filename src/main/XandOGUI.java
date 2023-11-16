package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XandOGUI {
    private XandO game;
    private JButton[][] buttons;
    private JLabel currentPlayerLabel;

    public XandOGUI() {
        game = new XandO();
        buttons = new JButton[3][3];
        JFrame frame = new JFrame("X and O");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new BorderLayout());

        currentPlayerLabel = new JLabel("Current Player: " + game.getCurrentPlayer());
        frame.add(currentPlayerLabel, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        frame.add(boardPanel, BorderLayout.CENTER);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i][j].setPreferredSize(new Dimension(100, 100));
                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (game.getCell(row, col) == ' ' && !game.checkWin('X') && !game.checkWin('O')) {
                            game.setCell(row, col, game.getCurrentPlayer());
                            buttons[row][col].setText(String.valueOf(game.getCurrentPlayer()));
                            if (game.checkWin(game.getCurrentPlayer())) {
                                currentPlayerLabel.setText("Player " + game.getCurrentPlayer() + " wins!");
                            } else if (game.draw()) {
                                currentPlayerLabel.setText("It's a draw!");
                            } else {
                                game.currentPLayer = (game.getCurrentPlayer() == 'X') ? 'O' : 'X';
                                currentPlayerLabel.setText("Current Player: " + game.getCurrentPlayer());
                            }
                        }
                    }
                });
                boardPanel.add(buttons[i][j]);
            }
        }
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new XandOGUI();
            }
        });
    }
}
