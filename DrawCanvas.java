import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawCanvas extends JFrame {
    private static final long serialVersionUID = 1L;
    private int x = -1;
    private int y = -1;
    private boolean eraseMode = false;

    public DrawCanvas() {
        super("Draw Canvas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton writeButton = new JButton("Write");
        writeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eraseMode = false;
            }
        });
        buttonPanel.add(writeButton);

        JButton eraseButton = new JButton("Erase");
        eraseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eraseMode = true;
            }
        });
        buttonPanel.add(eraseButton);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        buttonPanel.add(clearButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.NORTH);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                Graphics g = getGraphics();
                if (eraseMode) {
                    g.setColor(Color.BLACK);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setStroke(new BasicStroke(10));
                } else {
                    g.setColor(Color.WHITE);
                }
                g.drawLine(x, y, e.getX(), e.getY());
                x = e.getX();
                y = e.getY();
            }
        });

    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public static void main(String[] args) {
        new DrawCanvas().setVisible(true);
    }
}
