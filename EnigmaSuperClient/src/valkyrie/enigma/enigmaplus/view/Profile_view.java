/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package valkyrie.enigma.enigmaplus.view;

import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import valkyrie.enigma.enigmaplus.Controller.QuestionController;
import valkyrie.enigma.enigmaplus.Controller.UserController;
import valkyrie.enigma.enigmaplus.Controller.elapsedTime;
import static valkyrie.enigma.enigmaplus.EnigmaMain.jDesktopPane1;
import valkyrie.enigma.enigmaplus.jena_enigma.sortbydate;
import static valkyrie.enigma.enigmaplus.view.editProfile.resize;



/**
 *
 * @author HELLFIRE
 */
public class Profile_view extends javax.swing.JInternalFrame {

    /**
     * Creates new form Profile_view
     */
    public Profile_view() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.initialize();
    }
    
    public void initialize(){
        UserController uc = new UserController();
        uc.getUser(uc.getUserLogged());
       panelProfile_view_name.setText(uc.u1.getFname()+" "+uc.u1.getLname());
       panelProfile_view_email.setText(uc.u1.getEmail());
       panelProfile_view_designation.setText(uc.u1.getProfession());
       panelProfile_view_expertise.setText(uc.u1.getInterrested());
       panelProfile_view_reputation.setText(String.valueOf(uc.u1.getReputation()));
       
       BufferedImage image;
        try {
            image = ImageIO.read(new File(uc.u1.getPic()));
            BufferedImage resizedImage = editProfile.resize(image, 180, 156);//resize the image to 100x100
            ImageIcon icon = new ImageIcon(resizedImage);
            Profile_pic.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(editProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        QuestionController qc = new QuestionController();
        elapsedTime et = new elapsedTime();         
        
        sortbydate sbd = new sortbydate();
        sbd.sortbyUser(uc.getUserLogged());

        int n = sbd.sArrayLength(sbd.sArray);
        int x = 60;

        for (int i = 0; i < n; i++) {
            qc.viewQuestion(Long.parseLong(sbd.sArray[i]));
            questionPanel qp1 = new questionPanel();
            qp1.jLabel1.setText(qc.q.getTitle());
            qp1.jLabel2.setText(qc.q.getQ_short());
            qp1.jLabel3.setText(et.duration(qc.q.getDate()));
            qp1.setBounds(10, 10 + i * x, 1080, 50);
            jPanel64.add(qp1);
        }
        
        sbd.sortAnswer(uc.getUserLogged());
        try{
        for (int i = 0; i < n; i++) {
            
            qc.viewQuestion(Long.parseLong(sbd.sArray2[i]));
            questionPanel qp1 = new questionPanel();
            qp1.jLabel1.setText(qc.q.getTitle());
            qp1.jLabel2.setText(qc.q.getQ_short());
            qp1.jLabel3.setText(et.duration(qc.q.getDate()));
            qp1.setBounds(10, 10 + i * x, 1080, 50);
            jPanel73.add(qp1);
        }
        }catch(NumberFormatException e){
            
        }

//         for(int i = 0;i<n;i++){
//        qc.viewQuestion(Long.parseLong(sbd.sArray[i]));   
//        questionPanel qp1 = new questionPanel();
//        qp1.jLabel1.setText(qc.q.getTitle());
//        qp1.jLabel2.setText(qc.q.getQ_short());
//        qp1.jLabel3.setText(et.duration(qc.q.getDate()));
//        qp1.setBounds(10, 10+i*x, 1080, 50);
//        jPanel31.add(qp1);
//        }
        
        
//        qc.viewQuestion(Long.parseLong(sbd.sArray2[0]));          
//        qpanel1_qtitle20.setText(qc.q.getTitle());
//        qpanel1_qnote31.setText(qc.q.getQ_short());
//        qpanel1_date19.setText(et.duration(qc.q.getDate()));
        
//        qc.viewQuestion(Long.parseLong(sbd.sArray2[1]));        
//        qpanel1_qtitle21.setText(qc.q.getTitle());
//        qpanel1_qnote32.setText(qc.q.getQ_short());
//        qpanel1_date20.setText(et.duration(qc.q.getDate()));
//        
//        qc.viewQuestion(Long.parseLong(sbd.sArray2[2]));        
//        qpanel1_qtitle22.setText(qc.q.getTitle());
//        qpanel1_qnote33.setText(qc.q.getQ_short());
//        qpanel1_date21.setText(et.duration(qc.q.getDate()));
//        
//        qc.viewQuestion(Long.parseLong(sbd.sArray2[3]));        
//        qpanel1_qtitle23.setText(qc.q.getTitle());
//        qpanel1_qnote34.setText(qc.q.getQ_short());
//        qpanel1_date22.setText(et.duration(qc.q.getDate()));
//        
//        qc.viewQuestion(Long.parseLong(sbd.sArray2[4]));        
//        qpanel1_qtitle24.setText(qc.q.getTitle());
//        qpanel1_qnote35.setText(qc.q.getQ_short());
//        qpanel1_date23.setText(et.duration(qc.q.getDate()));
//        
//        qc.viewQuestion(Long.parseLong(sbd.sArray2[5]));        
//        qpanel1_qtitle25.setText(qc.q.getTitle());
//        qpanel1_qnote36.setText(qc.q.getQ_short());
//        qpanel1_date24.setText(et.duration(qc.q.getDate()));
//        
//        qc.viewQuestion(Long.parseLong(sbd.sArray2[6]));        
//        qpanel1_qtitle26.setText(qc.q.getTitle());
//        qpanel1_qnote37.setText(qc.q.getQ_short());
//        qpanel1_date25.setText(et.duration(qc.q.getDate()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelProfile_view = new javax.swing.JPanel();
        jButton36 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jPanel64 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jPanel73 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jPanel31 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        Profile_pic = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        panelProfile_view_name = new javax.swing.JLabel();
        panelProfile_view_designation = new javax.swing.JLabel();
        panelProfile_view_email = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        panelProfile_view_expertise = new javax.swing.JLabel();
        panelProfile_view_reputation = new javax.swing.JLabel();
        edit_button = new javax.swing.JButton();

        setMaximizable(true);
        setResizable(true);

        panelProfile_view.setBackground(new java.awt.Color(255, 255, 255));

        jButton36.setBackground(new java.awt.Color(255, 255, 255));
        jButton36.setText("ok");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jPanel64.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1049, Short.MAX_VALUE)
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );

        jScrollPane14.setViewportView(jPanel64);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1061, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Questions      ", jPanel29);

        jPanel73.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel73Layout = new javax.swing.GroupLayout(jPanel73);
        jPanel73.setLayout(jPanel73Layout);
        jPanel73Layout.setHorizontalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1049, Short.MAX_VALUE)
        );
        jPanel73Layout.setVerticalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );

        jScrollPane15.setViewportView(jPanel73);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1061, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Answers       ", jPanel28);

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1059, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );

        jScrollPane12.setViewportView(jPanel31);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Reputation     ", jPanel30);

        Profile_pic.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Profile_pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/valkyrie/enigma/enigmaplus/view/images/profile pic_3.jpg"))); // NOI18N

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel46.setText("Name ");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel47.setText("Designation");

        panelProfile_view_name.setText("Malithi Gunathilaka");

        panelProfile_view_designation.setText("Student");

        panelProfile_view_email.setText("email@domain.com");

        jLabel1.setText("Interested");

        jLabel49.setText("Member for");

        jLabel50.setText("Email");

        jLabel51.setText("reputation");

        jLabel68.setText("8 months");

        panelProfile_view_expertise.setText("Java, C#");

        panelProfile_view_reputation.setText("92 ");

        edit_button.setText("Edit Profile");
        edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edit_button)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(Profile_pic)
                        .addGap(126, 126, 126)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49)
                            .addComponent(jLabel51)
                            .addComponent(jLabel1))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelProfile_view_name)
                            .addComponent(panelProfile_view_email, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelProfile_view_designation)
                            .addComponent(jLabel68)
                            .addComponent(panelProfile_view_reputation)
                            .addComponent(panelProfile_view_expertise))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(panelProfile_view_name)
                        .addGap(16, 16, 16)
                        .addComponent(panelProfile_view_email)
                        .addGap(16, 16, 16)
                        .addComponent(panelProfile_view_designation)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel68)
                        .addGap(16, 16, 16)
                        .addComponent(panelProfile_view_reputation)
                        .addGap(16, 16, 16)
                        .addComponent(panelProfile_view_expertise))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel50)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel47)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel49)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel51)
                                .addGap(16, 16, 16))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(Profile_pic, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)))
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edit_button)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout panelProfile_viewLayout = new javax.swing.GroupLayout(panelProfile_view);
        panelProfile_view.setLayout(panelProfile_viewLayout);
        panelProfile_viewLayout.setHorizontalGroup(
            panelProfile_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProfile_viewLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelProfile_viewLayout.setVerticalGroup(
            panelProfile_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProfile_viewLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1066, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelProfile_view, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 767, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panelProfile_view, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
       
    }//GEN-LAST:event_jButton36ActionPerformed

    private void edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_buttonActionPerformed
        
        this.setVisible(false);        
        
        editProfile intr = new editProfile();
        jDesktopPane1.add(intr);
        intr.show();

        try {
            intr.setMaximum(true);
        } catch (PropertyVetoException e) {
            System.out.println(e);
        }
        
        
        
    }//GEN-LAST:event_edit_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Profile_pic;
    private javax.swing.JButton edit_button;
    private javax.swing.JButton jButton36;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelProfile_view;
    private javax.swing.JLabel panelProfile_view_designation;
    private javax.swing.JLabel panelProfile_view_email;
    private javax.swing.JLabel panelProfile_view_expertise;
    private javax.swing.JLabel panelProfile_view_name;
    private javax.swing.JLabel panelProfile_view_reputation;
    // End of variables declaration//GEN-END:variables
}
