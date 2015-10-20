package lab9;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;

import lab9.BinaryTree;
import lab9.BinaryTree.Node;

public class TreePanel extends JPanel {

    private final BinaryTree binaryTree;
    private int nodeRadius;
    private int verticalGap;

    public TreePanel(BinaryTree binaryTree) {
        this.binaryTree = binaryTree;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int gap = 50;
        verticalGap = (int) ((getHeight() - gap) / (binaryTree.getHeight() * 0.9));
        nodeRadius = (int) (verticalGap * 0.175);
        int horizontalGap = (int) (getWidth() / 4);
        if (binaryTree.getRoot() != null) {
            drawTree(g, binaryTree.getRoot(), getWidth() / 2, gap, horizontalGap);
        }
    }

    private void drawTree(Graphics g, Node node, int x, int y, int horizontalGap) {
        g.drawOval(x - nodeRadius, y - nodeRadius, 2 * nodeRadius, 2 * nodeRadius);
        Font nodeFont = new Font("SansSerif", Font.BOLD, (int) (12 * (1
                + Math.min(getWidth(), getHeight())
                / Math.max(getWidth(), getHeight()))));
        g.setFont(nodeFont);
        FontMetrics nodeFontMetrics = g.getFontMetrics(nodeFont);
        int stringWidth = nodeFontMetrics.stringWidth(node.toString());
        int stringHeight = nodeFontMetrics.getHeight();
        g.drawString(node.toString(), x - stringWidth / 2,
                y + stringHeight / 3);
        double distance = Math.sqrt(verticalGap * verticalGap + (x - (x
                - horizontalGap)) * (x - (x - horizontalGap)));
        if (node.getLeftChild() != null) {
            g.drawLine((int) ((x - horizontalGap) + nodeRadius * (x - (x
                    - horizontalGap)) / distance),
                    (int) ((y + verticalGap) - nodeRadius * verticalGap / distance),
                    (int) (x - nodeRadius * (x - (x - horizontalGap)) / distance),
                    (int) (y + nodeRadius * verticalGap / distance));
            drawTree(g, node.getLeftChild(), x - horizontalGap, y + verticalGap,
                    (int) (horizontalGap / 2));
        }

        if (node.getRightChild() != null) {
            g.drawLine((int) ((x + horizontalGap) - nodeRadius * ((x + horizontalGap) - x) / distance),
                    (int) ((y + verticalGap) - nodeRadius * verticalGap / distance),
                    (int) (x + nodeRadius * ((x + horizontalGap) - x) / distance),
                    (int) (y + nodeRadius * verticalGap / distance));

            drawTree(g, node.getRightChild(), x + horizontalGap, y
                    + verticalGap, (int) (horizontalGap / 2));
        }
    }
}
