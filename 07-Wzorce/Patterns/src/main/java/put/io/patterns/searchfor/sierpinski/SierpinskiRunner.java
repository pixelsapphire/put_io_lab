package put.io.patterns.searchfor.sierpinski;

import put.io.patterns.searchfor.CustomRunner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Runner for organized GUI elements. Draws nice Sierpiński carpet.
 * <p>
 * Required command line parameters: depth of recursion
 */
public class SierpinskiRunner extends CustomRunner {

    private final JLabel addressLabel = new JLabel("---");
    private final JButton button = new JButton("RECOLOR!");

    public static void main(String[] args) {
        checkAndRun(args, 1, "carpetDepth", new SierpinskiRunner());
    }

    @Override
    public void run(String[] params) {
        final int level = Integer.parseInt(params[0]);
        SwingUtilities.invokeLater(() -> constructGUI(level));
    }

    private void constructGUI(int level) {
        JFrame frame = new JFrame("SwingApplication");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(createComponents(level), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private Component createComponents(int level) {
        final JPanel pane = new JPanel(new BorderLayout());
        pane.add(genSierpinskiCarpet(level, ""), BorderLayout.CENTER);

        JPanel topPane = new JPanel(new FlowLayout(FlowLayout.LEADING));
        topPane.add(button);
        topPane.add(new JLabel("Button address: "));
        topPane.add(addressLabel);
        pane.add(topPane, BorderLayout.NORTH);

        // here we define what should happen after the button is pressed
        // for carpet buttons see createBasicElems() below

        button.addActionListener(e -> pane.repaint());

        return pane;
    }

    private Component genSierpinskiCarpet(int level, String addressPrefix) {
        if (level <= 0) {
            return createBasicElem(addressPrefix);
        }
        JPanel pane = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 8; ++i) {
            if (i == 4) {
                // add the empty spot
                pane.add(new JPanel());
            }
            pane.add(genSierpinskiCarpet(level - 1, addressPrefix + i));
        }
        return pane;
    }

    private Component createBasicElem(String address) {
        JComponent comp = new JButton() {
            @Override
            public void paint(Graphics g) {
                Rectangle b = g.getClipBounds();
                g.setColor(Color.getHSBColor((float) Math.random(), 1.0f, 0.8f));
                g.fillRect(b.x, b.y, b.width, b.height);
            }
        };

        // remember the component's "address" to later show it
        comp.putClientProperty("address", address);

        // define what happens when some mouse event happens over the component
        comp.addMouseListener(new MouseListener() {

            // we don't need those events
            public void mouseClicked(MouseEvent e) { /* unused */ }

            public void mousePressed(MouseEvent e) { /* unused */ }

            public void mouseReleased(MouseEvent e) { /* unused */ }

            public void mouseEntered(MouseEvent e) {
                JComponent c = (JComponent) e.getSource();
                String address = (String) c.getClientProperty("address");
                if (address != null) {
                    addressLabel.setText(address);
                }
            }

            public void mouseExited(MouseEvent e) {

                addressLabel.setText("---");
            }
        });
        return comp;
    }
}
