/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valkyrie.enigma.enigmaplus.view;

import java.awt.event.ActionListener;

/**
 *
 * @author avinda
 */
public class AnswerPanel extends javax.swing.JPanel {

    /**
     * Creates new form questionPanel
     */
    public AnswerPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        answerDateLabel = new javax.swing.JLabel();
        answerLabel = new javax.swing.JLabel();
        answer_rate_up = new javax.swing.JButton();
        answer_rate_down = new javax.swing.JButton();
        AnswerRate = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(950, 50));

        answerDateLabel.setText("days ago");

        answerLabel.setText("User Answer 1");

        answer_rate_up.setText("^");

        answer_rate_down.setText("v");
        answer_rate_down.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer_rate_downActionPerformed(evt);
            }
        });

        AnswerRate.setBackground(new java.awt.Color(0, 102, 255));
        AnswerRate.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        AnswerRate.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(answer_rate_up)
                            .addComponent(answer_rate_down)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(AnswerRate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(answerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 575, Short.MAX_VALUE)
                .addComponent(answerDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(answerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(answer_rate_up)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(answerDateLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AnswerRate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answer_rate_down))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void answer_rate_downActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer_rate_downActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answer_rate_downActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnswerRate;
    public javax.swing.JLabel answerDateLabel;
    public javax.swing.JLabel answerLabel;
    private javax.swing.JButton answer_rate_down;
    private javax.swing.JButton answer_rate_up;
    // End of variables declaration//GEN-END:variables

    void addActionListener(ActionListener actionListener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
