/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valkyrie.enigma.enigmaplus.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import valkyrie.enigma.enigmaplus.Controller.TagPanel;
import valkyrie.enigma.enigmaplus.Controller.UserController;
import static valkyrie.enigma.enigmaplus.EnigmaMain.jDesktopPane1;

/**
 *
 * @author HELLFIRE
 */
public class signup extends javax.swing.JInternalFrame {
String filePath = "/Users/heshanjayasinghe/ enigma/EnigmaSuperClient/src/valkyrie/enigma/enigmaplus/view/images/default-person.png";


    /**
     * Creates new form signup
     */
    public signup() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        tagpanel.setPreferredSize(new Dimension(100, 30));
        tagpanel.setLayout(new FlowLayout(1, 3, 2));
        tagpanel.setBackground(Color.white);
        tagpanel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));

        AutoCompleteDecorator.decorate(Expert_area);
        AutoCompleteDecorator.decorate(signup_txt_cat);
        AutoCompleteDecorator.decorate(signup_txt_subcat);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        panelsignup = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        signup_txt_fname = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        signup_txt_lname = new javax.swing.JTextField();
        signup_txt_email = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        Expert_area = new javax.swing.JComboBox();
        jLabel74 = new javax.swing.JLabel();
        signup_txt_prof = new javax.swing.JTextField();
        profilepiclabel = new javax.swing.JLabel();
        jButton37 = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        signup_txt_cat = new javax.swing.JComboBox();
        signup_txt_subcat = new javax.swing.JComboBox();
        signup_txt_pw = new javax.swing.JPasswordField();
        signup_txt_cpw = new javax.swing.JPasswordField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jButton26 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        tagpanel = new javax.swing.JPanel();

        panelsignup.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel25.setText("First Name");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, 24));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setText("Last Name");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 94, 90, 24));

        signup_txt_fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_txt_fnameActionPerformed(evt);
            }
        });
        jPanel6.add(signup_txt_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 250, -1));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel27.setText("Email ");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 90, 26));

        signup_txt_lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_txt_lnameActionPerformed(evt);
            }
        });
        jPanel6.add(signup_txt_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 94, 250, -1));

        signup_txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_txt_emailActionPerformed(evt);
            }
        });
        jPanel6.add(signup_txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 250, -1));

        jLabel31.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel31.setText("Expertised areas");
        jPanel6.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 29));

        jLabel32.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel32.setText("Profession");
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 81, -1));

        Expert_area.setEditable(true);
        Expert_area.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Expert_area.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "marketing", "devloping", "business architecture" }));
        Expert_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Expert_areaActionPerformed(evt);
            }
        });
        jPanel6.add(Expert_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 253, -1));

        jLabel74.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel74.setText("profile picture ");
        jPanel6.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 100, 19));

        signup_txt_prof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_txt_profActionPerformed(evt);
            }
        });
        jPanel6.add(signup_txt_prof, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 250, -1));

        profilepiclabel.setMaximumSize(new java.awt.Dimension(31, 28));
        profilepiclabel.setMinimumSize(new java.awt.Dimension(31, 28));
        profilepiclabel.setPreferredSize(new java.awt.Dimension(31, 28));
        jPanel6.add(profilepiclabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 240, 240));

        jButton37.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton37.setText("Browse..");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, -1, -1));

        jLabel75.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel75.setText("Category");
        jPanel6.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        jLabel76.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel76.setText("Sub Category");
        jPanel6.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));

        signup_txt_cat.setEditable(true);
        signup_txt_cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_txt_catActionPerformed(evt);
            }
        });
        jPanel6.add(signup_txt_cat, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 250, -1));

        signup_txt_subcat.setEditable(true);
        signup_txt_subcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_txt_subcatActionPerformed(evt);
            }
        });
        jPanel6.add(signup_txt_subcat, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 250, -1));

        signup_txt_pw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                signup_txt_pwKeyReleased(evt);
            }
        });
        jPanel6.add(signup_txt_pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 250, -1));

        signup_txt_cpw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                signup_txt_cpwKeyReleased(evt);
            }
        });
        jPanel6.add(signup_txt_cpw, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 250, -1));

        jLabel28.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel28.setText("Password");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 90, 28));

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setText("Confirm Password");
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 123, 28));

        jButton26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton26.setText("cancel");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 504, 80, -1));

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setText("Sign up");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 504, 90, -1));
        jPanel6.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 520, -1));
        jPanel6.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 520, -1));

        javax.swing.GroupLayout tagpanelLayout = new javax.swing.GroupLayout(tagpanel);
        tagpanel.setLayout(tagpanelLayout);
        tagpanelLayout.setHorizontalGroup(
            tagpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tagpanelLayout.setVerticalGroup(
            tagpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel6.add(tagpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 540, 50));

        javax.swing.GroupLayout panelsignupLayout = new javax.swing.GroupLayout(panelsignup);
        panelsignup.setLayout(panelsignupLayout);
        panelsignupLayout.setHorizontalGroup(
            panelsignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsignupLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        panelsignupLayout.setVerticalGroup(
            panelsignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsignupLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(261, 261, 261))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1101, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelsignup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 854, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelsignup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signup_txt_fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_txt_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signup_txt_fnameActionPerformed

    private void signup_txt_lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_txt_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signup_txt_lnameActionPerformed

    private void signup_txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signup_txt_emailActionPerformed

    private void Expert_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Expert_areaActionPerformed

        String selected_tag = (String) Expert_area.getSelectedItem();

        if (selected_tag.length() > 0) {

            TagPanel tagp1 = new TagPanel(selected_tag);
            tagpanel.add(tagp1, tagpanel.getComponentCount() - 1);
                   //         txt_tags.setText("");

            repaint();
            revalidate();

        }

//        String exp = (String) signup_com_exp.getSelectedItem();
//        ArrayList<String> category;
//        try {
//            category = CategoryController.getcategory(exp);
//            //       signup_txt_cat = new JComboBox( category);
//            signup_txt_cat.setModel(new DefaultComboBoxModel<>(category.toArray(new String[category.size()])));
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_Expert_areaActionPerformed

    private void signup_txt_profActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_txt_profActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signup_txt_profActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed

         int o = jFileChooser1.showOpenDialog(this);
        if (o == JFileChooser.APPROVE_OPTION) {
            File picture = jFileChooser1.getSelectedFile();
            profilepiclabel.setIcon(new ImageIcon("" + jFileChooser1.getSelectedFile()));
            filePath=picture.getPath();
            System.out.println(picture.getPath());
        }
    }//GEN-LAST:event_jButton37ActionPerformed

    private void signup_txt_catActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_txt_catActionPerformed
//        String cat = (String) signup_txt_cat.getSelectedItem();
//        ArrayList<String> subcategory;
//
//        try {
//            subcategory = CategoryController.getsubcategory(cat);
//            signup_txt_subcat.setModel(new DefaultComboBoxModel<>(subcategory.toArray(new String[subcategory.size()])));
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_signup_txt_catActionPerformed

    private void signup_txt_subcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_txt_subcatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signup_txt_subcatActionPerformed

    private void signup_txt_pwKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_signup_txt_pwKeyReleased
        String password = signup_txt_pw.getText();
        String cpassword = signup_txt_cpw.getText();
        if (password.equals(cpassword)) {

        }
    }//GEN-LAST:event_signup_txt_pwKeyReleased

    private void signup_txt_cpwKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_signup_txt_cpwKeyReleased
        String password = signup_txt_pw.getText();
        String cpassword = signup_txt_cpw.getText();
        if (password.equals(cpassword)) {

        }
    }//GEN-LAST:event_signup_txt_cpwKeyReleased

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        JInternalFrame intr = new Login();
        jDesktopPane1.add(intr);
        intr.show();
        try {
            intr.setMaximum(true);
        } catch (PropertyVetoException e) {

        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 if (signup_txt_fname.getText().equals("")
                || signup_txt_lname.getText().equals("")
                || signup_txt_email.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "There are fields which are not filled", "Signup  error", JOptionPane.ERROR_MESSAGE);
        } else {
            UserController uc = new UserController();
            
            uc.newUser(signup_txt_fname.getText(), signup_txt_lname.getText(), signup_txt_email.getText(), signup_txt_pw.getText(), "Interested", signup_txt_prof.getText(), filePath);
//            uc.newUser(signup_txt_fname.getText(), signup_txt_lname.getText(), signup_txt_email.getText(),String.valueOf(signup_txt_pw.getPassword()), "Interested", signup_txt_prof.getText(), picture.getPath());//editUser(long uid, String fname, String lname, String email, String interested, String designation, String path)
//          uc.editUser(uc.getUserLogged(), name[0], name[1], panelProfile_view_email.getText(), panelProfile_view_Expertise.getText(), panelProfile_view_designation.getText(), Image_path.getText());
            JOptionPane.showMessageDialog(null, "Successfully signed up", "Signup  successfull", JOptionPane.INFORMATION_MESSAGE);
            JInternalFrame intr = new Login();
            jDesktopPane1.add(intr);
            intr.show();
            try {
                intr.setMaximum(true);
            } catch (PropertyVetoException e) {

            }
            head_main.setVisible(false);
        }

//
//        String fname = signup_txt_fname.getText();
//        String lname = signup_txt_lname.getText();
//        String email = signup_txt_email.getText();
//        String password = signup_txt_pw.getText();
//        String cpassword = signup_txt_cpw.getText();
//        if (password.equals(cpassword)) {
//            String interest = signup_txt_if.getText();
//            String expert = (String) signup_com_exp.getSelectedItem();
//            String category = (String) signup_txt_cat.getSelectedItem(); //add aray later
//            String subcat = (String) signup_txt_subcat.getSelectedItem();
//            String prof = signup_txt_prof.getText();
//            //   String upprof = signup_txt_upprof.getText();
//            //   String downprof = signup_txt_lowprof.getText();
//            //   String parallel = signup_txt_pprof.getText();
//            String pic = "";
//
//            User user = new User();
//            user.setFname(fname);
//            user.setLname(lname);
//            user.setEmail(email);
//            user.setPassword(password);
//            user.setInterrested(interest);
//            user.setExpertis(expert);
//            user.setCat(pic);
//            user.setSubcat(subcat);
//            user.setProfession(prof);
//            //  user.setUp_prof(upprof);
//            //  user.setDown_prof(downprof);
//            //  user.setPar_prof(parallel);
//
//            UserCat cat = new UserCat(email, category, subcat);
//            try {
//                int res = UserController.addUser(user, cat);
//                //   if (res > 0) {
//                    JOptionPane.showMessageDialog(this, "User Addded ");
//                    panellogin.setVisible(true);
//                    panelsignup.setVisible(false);
//
//                    //   }
//            } catch (ClassNotFoundException ex) {
//                ex.printStackTrace();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        } else {
//            panel_notmatch.setVisible(true);
//        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Expert_area;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton37;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel panelsignup;
    private javax.swing.JLabel profilepiclabel;
    private javax.swing.JComboBox signup_txt_cat;
    private javax.swing.JPasswordField signup_txt_cpw;
    private javax.swing.JTextField signup_txt_email;
    private javax.swing.JTextField signup_txt_fname;
    private javax.swing.JTextField signup_txt_lname;
    private javax.swing.JTextField signup_txt_prof;
    private javax.swing.JPasswordField signup_txt_pw;
    private javax.swing.JComboBox signup_txt_subcat;
    public static javax.swing.JPanel tagpanel;
    // End of variables declaration//GEN-END:variables

    public class TagPanel extends JPanel {

        public TagPanel(String text) {
            JLabel textlable = new JLabel(text);
            JLabel close = new JLabel("X");
            close.setOpaque(true);
            close.setBackground(new Color(123, 123, 123));
            textlable.setOpaque(true);
            textlable.setBackground(new Color(0, 185, 203));
            textlable.setForeground(Color.white);
            setLayout(new BorderLayout());
            close.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
            //    new Main().removecomp(TagPanel.this);

                    tagpanel.remove(TagPanel.this);
                    tagpanel.repaint();
                    tagpanel.revalidate();
                }
            });
            add(close, BorderLayout.EAST);
            add(textlable, BorderLayout.WEST);
        }

    }
}
