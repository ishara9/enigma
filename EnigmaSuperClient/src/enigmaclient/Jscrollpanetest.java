/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigmaclient;

/**
 *
 * @author heshanjayasinghe
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Jscrollpanetest extends JFrame {

    JScrollPane scrollPane;
    Box box;
    private static int panelCount = 0;

    public Jscrollpanetest() {
        setPreferredSize(new Dimension(200, 400));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(15);
        box = Box.createVerticalBox();
        scrollPane.getViewport().add(box);

        this.add(scrollPane);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

       
        Timer t = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                box.add(new TestPanel(), box.size());

                scrollPane.validate();
            }
        });
        t.setRepeats(true);
        t.start();
//        scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
//
//            @Override
//            public void adjustmentValueChanged(AdjustmentEvent event) {
//                JScrollBar scrollBar = (JScrollBar) event.getAdjustable();
//                int extent = scrollBar.getModel().getExtent();
//                System.out.println("1. Value: " + (scrollBar.getValue() + extent) + " Max: " + scrollBar.getMaximum());
//                box.add(new TestPanel(), box.size());
//                scrollPane.validate();
//            }
//        });

    }

    public class TestPanel extends JPanel {

        int myId = panelCount++;

        public TestPanel() {
            this.setLayout(new GridBagLayout());
            this.setBorder(BorderFactory.createBevelBorder(1));
            JLabel label = new JLabel("" + myId);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);

            this.setMaximumSize(new Dimension(1000, 200));
            this.setPreferredSize(new Dimension(1000, 100));

            this.add(label);
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Jscrollpanetest testScrollPane = new Jscrollpanetest();
            }
        });
    }
}
