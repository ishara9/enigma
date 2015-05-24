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

public class answertest extends JFrame {

    JScrollPane scrollPane;
    Box box;
    int qboxheight;
    int qboxwidth;
    //  Dimension boxsize;
    private static int panelCount = 0;

    public answertest() {
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

        box.add(new questionpnel(), box.size());
              qboxheight = box.size().height;
              qboxwidth = box.size().width;
        box.add(new answeringpanel(), box.size());
        scrollPane.validate();

//        Timer t = new Timer(1000, new ActionListener() {
//
//            public void actionPerformed(ActionEvent ae) {
//                box.add(new TestPanel(), box.size());
//
//                scrollPane.validate();
//            }
//        });
//        t.setRepeats(true);
//        t.start();
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

    public class answeringpanel extends JPanel {

        public answeringpanel() {
            this.setLayout(new GridBagLayout());
            // this.setBorder(BorderFactory.createBevelBorder(1));
            JButton postAnswer = new JButton("send");

            JTextArea textAreal = new JTextArea("", 5, 10);
            textAreal.setPreferredSize(new Dimension(100, 100));
            this.setMaximumSize(new Dimension(1000, 100));
            this.setPreferredSize(new Dimension(1000, 100));
            this.add(textAreal);
            this.add(postAnswer);
            postAnswer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    box.add(new TestPanel(), 1);
                    
                    scrollPane.validate();
                }
            });
        }

    }

    public class questionpnel extends JPanel {

        public questionpnel() {
            this.setLayout(new GridBagLayout());
            // this.setBorder(BorderFactory.createBevelBorder(1));
            JButton up = new JButton("^");
            JLabel rate = new JLabel("1");
            JButton down = new JButton("^");
            JLabel label = new JLabel("question blaaa");
            label.setHorizontalAlignment(JLabel.LEFT);
            label.setVerticalAlignment(JLabel.CENTER);
            this.setMaximumSize(new Dimension(1000, 200));
            this.setPreferredSize(new Dimension(1000, 100));
            this.add(up);
            this.add(rate);
            this.add(down);
            this.add(label);
            
        }

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                answertest testScrollPane = new answertest();
            }
        });
    }
}
