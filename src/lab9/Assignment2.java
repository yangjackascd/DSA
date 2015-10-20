package lab9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Assignment2 extends JPanel {

    private static final int DEFAULT_WIDTH = 1800;
    private static final int DEFAULT_HEIGHT = 600;

    public Assignment2() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        TreePanel treePanel = new TreePanel(buildTree(10));
        add(treePanel, BorderLayout.CENTER);
        ControlPanel controlPanel = new ControlPanel();
        add(controlPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Assignment 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Assignment2 assignment2 = new Assignment2();
        frame.setContentPane(assignment2);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void buildChildren(int start, int end, BinaryTree<String> binaryTree) {
        if (start < end + 1) {
            int mid = start + (end - start) / 2;
           // binaryTree.insert(mid);

            buildChildren(start, mid - 1, binaryTree);
            buildChildren(mid + 1, end, binaryTree);
        }
    }

    private BinaryTree<Integer> buildTree(int n) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(4);
        binaryTree.insert(5);
        binaryTree.insert(6);
        binaryTree.insert(7);
        binaryTree.insert(8);
        binaryTree.insert(9);
        binaryTree.insert(10);
        binaryTree.insert(11);
        binaryTree.insert(12);
        //buildChildren(1, n - 1, binaryTree);
        return binaryTree;
    }

}
