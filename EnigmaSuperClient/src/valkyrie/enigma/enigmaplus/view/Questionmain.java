
package valkyrie.enigma.enigmaplus.view;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import static java.lang.Long.parseLong;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import valkyrie.enigma.enigmaplus.Controller.AutoSuggestor;
import valkyrie.enigma.enigmaplus.Controller.ElapsedTimeFinder;
import valkyrie.enigma.enigmaplus.Controller.QuestionController;
import valkyrie.enigma.enigmaplus.Controller.UserController;
import valkyrie.enigma.enigmaplus.Controller.elapsedTime;
import valkyrie.enigma.enigmaplus.EnigmaMain;
import static valkyrie.enigma.enigmaplus.EnigmaMain.jDesktopPane1;
import valkyrie.enigma.enigmaplus.jena_enigma.sortbydate;
import valkyrie.enigma.enigmaplus.service.controller.Simileraty;


public class Questionmain extends javax.swing.JInternalFrame {
 
    /**
     * Creates new form questionmain
     */
    public Questionmain() {
        
        
        
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        
        //  AutoSuggestor autoSuggestor = new AutoSuggestor( txt_mainsearch , this , null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
    
        
        if(QuestionController.nextQuestion == 0){
            jButton1.setEnabled(false);
        }
        jComboBox1.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {    
        public void keyReleased(KeyEvent event) {
            if (event.getKeyCode() == KeyEvent.VK_ENTER) {
         //   jComboBox1.removeAllItems();
            String s=   ((JTextField)jComboBox1.getEditor().getEditorComponent()).getText();
            Simileraty sim = new Simileraty();
            DefaultComboBoxModel model = (DefaultComboBoxModel)jComboBox1.getModel();
            model.removeAllElements();
            model.addElement(s); 
            for(int i=0;i<EnigmaMain.titlelist.size();i++){
                String title= EnigmaMain.titlelist.get(i);
            double probability3 = sim.compareStrings(s,title);
            if(probability3>0.7){
                
                model.addElement(title);           
            }
            }
            
                jComboBox1.showPopup();
    }}
});
        
        sortbydate sbd = new sortbydate();
        sbd.sortbydate();  
        elapsedTime et = new elapsedTime(); 
        
        QuestionController qc1 = new QuestionController();
        UserController uc1 = new UserController();
        
        try{
        qc1.viewQuestion(parseLong(sbd.sArray[0+QuestionController.nextQuestion]));
        uc1.getUser(qc1.q.getUid()); 
        qpanel1_qtitle.setText(qc1.q.getTitle());
        qpanel1_qnote.setText(qc1.q.getQ_short());        
        qpanel1_author.setText(uc1.u1.getFname()+" "+uc1.u1.getLname());
        qpanel1_date.setText(et.duration(qc1.q.getDate()));
        jLabel13.setText(String.valueOf(qc1.q.getRate()));
        }
        catch(NumberFormatException e){
            jButton9.hide();
            jButton11.hide();
            qpanel1_qtitle.hide();
            qpanel1_qnote.hide();
            qpanel1_author.hide();
            qpanel1_date.hide();
            jLabel13.hide();
            jButton2.setEnabled(false);
        }
        
        QuestionController qc2 = new QuestionController();
        UserController uc2 = new UserController();
        
        try{
        qc2.viewQuestion(parseLong(sbd.sArray[1+QuestionController.nextQuestion]));
        uc2.getUser(qc2.q.getUid());        
        qpanel2_qtitle.setText(qc2.q.getTitle());
        qpanel2_qnote.setText(qc2.q.getQ_short());        
        qpanel2_author.setText(uc2.u1.getFname()+" "+uc2.u1.getLname());
        qpanel2_date.setText(et.duration(qc1.q.getDate()));
        jLabel14.setText(String.valueOf(qc2.q.getRate()));
        }catch(NumberFormatException e){
            jButton6.hide();
            jButton7.hide();
            qpanel2_qtitle.hide();
            qpanel2_qnote.hide();
            qpanel2_author.hide();
            qpanel2_date.hide();
            jLabel14.hide();
            jButton2.setEnabled(false);
        }
        
        QuestionController qc3 = new QuestionController();
        UserController uc3 = new UserController();
        
        try{
        qc3.viewQuestion(parseLong(sbd.sArray[2+QuestionController.nextQuestion]));
        uc3.getUser(qc3.q.getUid());        
        qpanel3_qtitle.setText(qc3.q.getTitle());
        qpanel3_qnote.setText(qc3.q.getQ_short());        
        qpanel3_author.setText(uc3.u1.getFname()+" "+uc3.u1.getLname());
        qpanel3_date.setText(et.duration(qc3.q.getDate()));
        jLabel15.setText(String.valueOf(qc3.q.getRate()));
        }catch(NumberFormatException e){
            jButton13.hide();
            jButton14.hide();
            qpanel3_qtitle.hide();
            qpanel3_qnote.hide();
            qpanel3_author.hide();
            qpanel3_date.hide();
            jLabel15.hide();
            jButton2.setEnabled(false);
        }
        
        QuestionController qc4 = new QuestionController();
        UserController uc4 = new UserController();
        try{
        qc4.viewQuestion(parseLong(sbd.sArray[3+QuestionController.nextQuestion]));
        uc4.getUser(qc4.q.getUid());        
        qpanel4_qtitle.setText(qc4.q.getTitle());
        qpanel4_qnote.setText(qc4.q.getQ_short());        
        qpanel4_author.setText(uc4.u1.getFname()+" "+uc4.u1.getLname());
        qpanel4_date.setText(et.duration(qc4.q.getDate()));
        jLabel16.setText(String.valueOf(qc4.q.getRate()));
        }catch(NumberFormatException e){
            jButton18.hide();
            jButton19.hide();
            qpanel4_qtitle.hide();
            qpanel4_qnote.hide();
            qpanel4_author.hide();
            qpanel4_date.hide();
            jLabel16.hide();
            jButton2.setEnabled(false);
        }
        
        QuestionController qc5 = new QuestionController();
        UserController uc5 = new UserController();
        
        try{
        qc5.viewQuestion(parseLong(sbd.sArray[4+QuestionController.nextQuestion]));
        uc5.getUser(qc5.q.getUid());        
        qpanel5_qtitle.setText(qc5.q.getTitle());
        qpanel5_qnote.setText(qc5.q.getQ_short());        
        qpanel5_author.setText(uc5.u1.getFname()+" "+uc5.u1.getLname());
        qpanel5_date.setText(et.duration(qc5.q.getDate()));
        jLabel17.setText(String.valueOf(qc5.q.getRate()));
        }catch(NumberFormatException e){
            jButton16.hide();
            jButton17.hide();
            qpanel5_qtitle.hide();
            qpanel5_qnote.hide();
            qpanel5_author.hide();
            qpanel5_date.hide();
            jLabel17.hide();
            jButton2.setEnabled(false);
        }
        
    }
    
   public void dateDifferacne(String date){
    //public static void main(String[] args) {
    
        Date now = new Date();
        String modifiedNow = new SimpleDateFormat("yyyy-MM-dd").format(now);
        
        System.out.println(modifiedNow);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelquestionmain = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelquestion = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        qpanel2_date = new javax.swing.JLabel();
        qpanel2_author = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        qpanel3_date = new javax.swing.JLabel();
        qpanel3_author = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        qpanel5_date = new javax.swing.JLabel();
        qpanel5_author = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        qpanel4_date = new javax.swing.JLabel();
        qpanel4_author = new javax.swing.JLabel();
        qpanel5_qnote = new javax.swing.JLabel();
        qpanel1_qnote = new javax.swing.JLabel();
        qpanel1_date = new javax.swing.JLabel();
        qpanel1_author = new javax.swing.JLabel();
        qpanel5_qtitle = new javax.swing.JButton();
        qpanel1_qtitle = new javax.swing.JButton();
        qpanel2_qtitle = new javax.swing.JButton();
        qpanel3_qtitle = new javax.swing.JButton();
        qpanel4_qtitle = new javax.swing.JButton();
        qpanel2_qnote = new javax.swing.JLabel();
        qpanel3_qnote = new javax.swing.JLabel();
        qpanel4_qnote = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        button_ask = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();

        setMaximizable(true);
        setResizable(true);

        panelquestionmain.setBackground(new java.awt.Color(255, 255, 255));

        panelquestion.setBackground(new java.awt.Color(255, 255, 255));

        jButton6.setText("^");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("v");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        qpanel2_date.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        qpanel2_date.setText("1 day ago");

        qpanel2_author.setText("malithi gunasekara");

        jButton9.setText("^");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton11.setText("v");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton13.setText("^");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("v");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        qpanel3_date.setText("1 day ago");

        qpanel3_author.setText("malithi gunasekara");

        jButton16.setText("^");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("v");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        qpanel5_date.setText("1 day ago");

        qpanel5_author.setText("malithi ");

        jButton18.setText("^");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("v");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        qpanel4_date.setText("1 day ago");

        qpanel4_author.setText("malithi ");

        qpanel5_qnote.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        qpanel5_qnote.setText("how to create ");

        qpanel1_qnote.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        qpanel1_qnote.setText("how to create java class in netbeans");

        qpanel1_date.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        qpanel1_date.setText("1 day ago");

        qpanel1_author.setText("malithi gunasekara");

        qpanel5_qtitle.setBackground(new java.awt.Color(255, 255, 255));
        qpanel5_qtitle.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        qpanel5_qtitle.setText("How to create ");
        qpanel5_qtitle.setAutoscrolls(true);
        qpanel5_qtitle.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        qpanel5_qtitle.setBorderPainted(false);
        qpanel5_qtitle.setContentAreaFilled(false);
        qpanel5_qtitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        qpanel5_qtitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qpanel5_qtitleActionPerformed(evt);
            }
        });

        qpanel1_qtitle.setBackground(new java.awt.Color(255, 255, 255));
        qpanel1_qtitle.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        qpanel1_qtitle.setText("How to create java class");
        qpanel1_qtitle.setAutoscrolls(true);
        qpanel1_qtitle.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        qpanel1_qtitle.setBorderPainted(false);
        qpanel1_qtitle.setContentAreaFilled(false);
        qpanel1_qtitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        qpanel1_qtitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qpanel1_qtitleMouseClicked(evt);
            }
        });
        qpanel1_qtitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qpanel1_qtitleActionPerformed(evt);
            }
        });

        qpanel2_qtitle.setBackground(new java.awt.Color(255, 255, 255));
        qpanel2_qtitle.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        qpanel2_qtitle.setText("How to create java class");
        qpanel2_qtitle.setAutoscrolls(true);
        qpanel2_qtitle.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        qpanel2_qtitle.setBorderPainted(false);
        qpanel2_qtitle.setContentAreaFilled(false);
        qpanel2_qtitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        qpanel2_qtitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qpanel2_qtitleActionPerformed(evt);
            }
        });

        qpanel3_qtitle.setBackground(new java.awt.Color(255, 255, 255));
        qpanel3_qtitle.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        qpanel3_qtitle.setText("How to create java class");
        qpanel3_qtitle.setAutoscrolls(true);
        qpanel3_qtitle.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        qpanel3_qtitle.setBorderPainted(false);
        qpanel3_qtitle.setContentAreaFilled(false);
        qpanel3_qtitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        qpanel3_qtitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qpanel3_qtitleActionPerformed(evt);
            }
        });

        qpanel4_qtitle.setBackground(new java.awt.Color(255, 255, 255));
        qpanel4_qtitle.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        qpanel4_qtitle.setText("How to ");
        qpanel4_qtitle.setAutoscrolls(true);
        qpanel4_qtitle.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        qpanel4_qtitle.setBorderPainted(false);
        qpanel4_qtitle.setContentAreaFilled(false);
        qpanel4_qtitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        qpanel4_qtitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qpanel4_qtitleActionPerformed(evt);
            }
        });

        qpanel2_qnote.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        qpanel2_qnote.setText("how to create java class in netbeans");

        qpanel3_qnote.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        qpanel3_qnote.setText("how to create java class in netbeans");

        qpanel4_qnote.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        qpanel4_qnote.setText("how to ");

        jLabel13.setText("0");

        jLabel14.setText("0");

        jLabel15.setText("0");

        jLabel16.setText("0");

        jLabel17.setText("0");

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Search");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        button_ask.setBackground(new java.awt.Color(255, 255, 255));
        button_ask.setText("ask");
        button_ask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_askActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1)
                .addComponent(jButton2))
        );

        jComboBox1.setEditable(true);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Search" }));
        jComboBox1.setToolTipText("search..");
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuCanceled(evt);
            }
        });
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboBox1KeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelquestionLayout = new javax.swing.GroupLayout(panelquestion);
        panelquestion.setLayout(panelquestionLayout);
        panelquestionLayout.setHorizontalGroup(
            panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelquestionLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelquestionLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelquestionLayout.createSequentialGroup()
                                .addComponent(qpanel5_qtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(550, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelquestionLayout.createSequentialGroup()
                                .addComponent(qpanel5_qnote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(374, 374, 374))))
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_ask, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelquestionLayout.createSequentialGroup()
                                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelquestionLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addComponent(qpanel1_qnote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(20, 20, 20)
                                .addComponent(qpanel1_date)
                                .addGap(87, 87, 87)
                                .addComponent(qpanel1_author, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelquestionLayout.createSequentialGroup()
                                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelquestionLayout.createSequentialGroup()
                                        .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelquestionLayout.createSequentialGroup()
                                                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(panelquestionLayout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(50, 50, 50)
                                                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(qpanel2_qtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(panelquestionLayout.createSequentialGroup()
                                                        .addComponent(qpanel2_qnote, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(qpanel2_date))))
                                            .addGroup(panelquestionLayout.createSequentialGroup()
                                                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(panelquestionLayout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addComponent(qpanel3_qnote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(98, 98, 98))
                                            .addGroup(panelquestionLayout.createSequentialGroup()
                                                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(panelquestionLayout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(50, 50, 50)
                                                .addComponent(qpanel4_qnote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(199, 199, 199))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelquestionLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(qpanel4_date, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(qpanel3_date, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(qpanel5_date, javax.swing.GroupLayout.Alignment.TRAILING))))
                                        .addGap(88, 88, 88))
                                    .addGroup(panelquestionLayout.createSequentialGroup()
                                        .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelquestionLayout.createSequentialGroup()
                                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(50, 50, 50)
                                                .addComponent(qpanel4_qtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelquestionLayout.createSequentialGroup()
                                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(50, 50, 50)
                                                .addComponent(qpanel3_qtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panelquestionLayout.createSequentialGroup()
                                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(50, 50, 50)
                                                .addComponent(qpanel1_qtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(qpanel2_author, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(qpanel3_author, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(qpanel4_author, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(qpanel5_author, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(72, 72, 72))))
        );
        panelquestionLayout.setVerticalGroup(
            panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelquestionLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_ask, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9)
                    .addComponent(qpanel1_qtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(6, 6, 6)
                        .addComponent(jButton11))
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(qpanel1_qnote, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(qpanel1_date))
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(qpanel1_author)))
                .addGap(29, 29, 29)
                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel14)
                        .addGap(6, 6, 6)
                        .addComponent(jButton7))
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(qpanel2_qtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qpanel2_qnote, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qpanel2_date)
                            .addComponent(qpanel2_author))))
                .addGap(29, 29, 29)
                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13)
                    .addComponent(qpanel3_qtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton14))
                    .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(qpanel3_qnote, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(qpanel3_date)
                        .addComponent(qpanel3_author)))
                .addGap(28, 28, 28)
                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton18)
                    .addComponent(qpanel4_qtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton19))
                    .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(qpanel4_qnote, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(qpanel4_date)
                        .addComponent(qpanel4_author)))
                .addGap(30, 30, 30)
                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(qpanel5_qtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelquestionLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(qpanel5_author)
                                    .addComponent(qpanel5_date)))
                            .addGroup(panelquestionLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(qpanel5_qnote, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelquestionLayout.createSequentialGroup()
                                .addComponent(jButton16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton17)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(314, 314, 314))
        );

        jScrollPane1.setViewportView(panelquestion);

        javax.swing.GroupLayout panelquestionmainLayout = new javax.swing.GroupLayout(panelquestionmain);
        panelquestionmain.setLayout(panelquestionmainLayout);
        panelquestionmainLayout.setHorizontalGroup(
            panelquestionmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1087, Short.MAX_VALUE)
        );
        panelquestionmainLayout.setVerticalGroup(
            panelquestionmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1087, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelquestionmain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelquestionmain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void qpanel5_qtitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qpanel5_qtitleActionPerformed

        questionviewM qvm = new questionviewM();
        sortbydate sbd = new sortbydate();
        sbd.sortbydate();
        qvm.setMainQuestion(parseLong(sbd.sArray[4]));
        this.setVisible(false);
        jDesktopPane1.add(qvm);
        
        qvm.show();
        try {
            //qvm.setUI(null);
            qvm.setMaximum(true);
            
        } catch (PropertyVetoException e) {

        }
    }//GEN-LAST:event_qpanel5_qtitleActionPerformed

    private void qpanel1_qtitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qpanel1_qtitleMouseClicked

    }//GEN-LAST:event_qpanel1_qtitleMouseClicked

    private void qpanel1_qtitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qpanel1_qtitleActionPerformed

        questionviewM qvm = new questionviewM();
        sortbydate sbd = new sortbydate();
        sbd.sortbydate();
        qvm.setMainQuestion(parseLong(sbd.sArray[0]));
        this.setVisible(false);
        jDesktopPane1.add(qvm);
        
        qvm.show();
        try {
            //qvm.setUI(null);
            qvm.setMaximum(true);
            
        } catch (PropertyVetoException e) {
        }
    }//GEN-LAST:event_qpanel1_qtitleActionPerformed

    private void qpanel2_qtitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qpanel2_qtitleActionPerformed

        questionviewM qvm = new questionviewM();
        sortbydate sbd = new sortbydate();
        sbd.sortbydate();
        qvm.setMainQuestion(parseLong(sbd.sArray[1]));
        this.setVisible(false);
        jDesktopPane1.add(qvm);
        
        qvm.show();
        try {
            //qvm.setUI(null);
            qvm.setMaximum(true);
            
        } catch (PropertyVetoException e) {

        }  
    }//GEN-LAST:event_qpanel2_qtitleActionPerformed

    private void qpanel3_qtitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qpanel3_qtitleActionPerformed

        
        questionviewM qvm = new questionviewM();
        sortbydate sbd = new sortbydate();
        sbd.sortbydate();
        qvm.setMainQuestion(parseLong(sbd.sArray[2]));
        this.setVisible(false);
        jDesktopPane1.add(qvm);
        
        qvm.show();
        try {
            //qvm.setUI(null);
            qvm.setMaximum(true);
            
        } catch (PropertyVetoException e) {

        }
    }//GEN-LAST:event_qpanel3_qtitleActionPerformed

    private void qpanel4_qtitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qpanel4_qtitleActionPerformed

        questionviewM qvm = new questionviewM();
        sortbydate sbd = new sortbydate();
        sbd.sortbydate();
        qvm.setMainQuestion(parseLong(sbd.sArray[3]));
        this.setVisible(false);
        jDesktopPane1.add(qvm);
        
        qvm.show();
        try {
            //qvm.setUI(null);
            qvm.setMaximum(true);
            
        } catch (PropertyVetoException e) {

        }       
    }//GEN-LAST:event_qpanel4_qtitleActionPerformed

    private void button_askActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_askActionPerformed

        JInternalFrame intr = new ask();
        jDesktopPane1.add(intr);
        intr.show();
        try {
            intr.setMaximum(true);
        } catch (PropertyVetoException e) {

        }
        this.setVisible(false);
    }//GEN-LAST:event_button_askActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed


    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       
        QuestionController qc1 = new QuestionController();
        sortbydate sbd = new sortbydate();
        sbd.sortbydate();
        qc1.qRate(parseLong(sbd.sArray[0]), true);
        this.setVisible(false);
        JInternalFrame intr = new Questionmain();
        jDesktopPane1.add(intr);
        intr.show();
        try {
            intr.setMaximum(true);
        } catch (PropertyVetoException e) {
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        QuestionController qc1 = new QuestionController();
        sortbydate sbd = new sortbydate();
        sbd.sortbydate();
        qc1.qRate(parseLong(sbd.sArray[0]), false);
        this.setVisible(false);
        JInternalFrame intr = new Questionmain();
        jDesktopPane1.add(intr);
        intr.show();
        try {
            intr.setMaximum(true);
        } catch (PropertyVetoException e) {
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        QuestionController qc1 = new QuestionController();
        sortbydate sbd = new sortbydate();
        sbd.sortbydate();
        qc1.qRate(parseLong(sbd.sArray[1]), true);
        this.setVisible(false);
        JInternalFrame intr = new Questionmain();
        jDesktopPane1.add(intr);
        intr.show();
        try {
            intr.setMaximum(true);
        } catch (PropertyVetoException e) {
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        QuestionController qc1 = new QuestionController();
        sortbydate sbd = new sortbydate();
        sbd.sortbydate();
        qc1.qRate(parseLong(sbd.sArray[1]), false);
        this.setVisible(false);
        JInternalFrame intr = new Questionmain();
        jDesktopPane1.add(intr);
        intr.show();
        try {
            intr.setMaximum(true);
        } catch (PropertyVetoException e) {
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        QuestionController qc1 = new QuestionController();
        sortbydate sbd = new sortbydate();
        sbd.sortbydate();
        qc1.qRate(parseLong(sbd.sArray[2]), true);
        this.setVisible(false);
        JInternalFrame intr = new Questionmain();
        jDesktopPane1.add(intr);
        intr.show();
        try {
            intr.setMaximum(true);
        } catch (PropertyVetoException e) {
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        QuestionController qc1 = new QuestionController();
        sortbydate sbd = new sortbydate();
        sbd.sortbydate();
        qc1.qRate(parseLong(sbd.sArray[2]), false);
        this.setVisible(false);
        JInternalFrame intr = new Questionmain();
        jDesktopPane1.add(intr);
        intr.show();
        try {
            intr.setMaximum(true);
        } catch (PropertyVetoException e) {
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        QuestionController qc1 = new QuestionController();
        sortbydate sbd = new sortbydate();
        sbd.sortbydate();
        qc1.qRate(parseLong(sbd.sArray[3]), true);
        this.setVisible(false);
        JInternalFrame intr = new Questionmain();
        jDesktopPane1.add(intr);
        intr.show();
        try {
            intr.setMaximum(true);
        } catch (PropertyVetoException e) {
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        QuestionController qc1 = new QuestionController();
        sortbydate sbd = new sortbydate();
        sbd.sortbydate();
        qc1.qRate(parseLong(sbd.sArray[3]), false);
        this.setVisible(false);
        JInternalFrame intr = new Questionmain();
        jDesktopPane1.add(intr);
        intr.show();
        try {
            intr.setMaximum(true);
        } catch (PropertyVetoException e) {
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        QuestionController qc1 = new QuestionController();
        sortbydate sbd = new sortbydate();
        sbd.sortbydate();
        qc1.qRate(parseLong(sbd.sArray[4]), true);
        this.setVisible(false);
        JInternalFrame intr = new Questionmain();
        jDesktopPane1.add(intr);
        intr.show();
        try {
            intr.setMaximum(true);
        } catch (PropertyVetoException e) {
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        QuestionController qc1 = new QuestionController();
        sortbydate sbd = new sortbydate();
        sbd.sortbydate();
        qc1.qRate(parseLong(sbd.sArray[4]), false);
        this.setVisible(false);
        JInternalFrame intr = new Questionmain();
        jDesktopPane1.add(intr);
        intr.show();
        try {
            intr.setMaximum(true);
        } catch (PropertyVetoException e) {
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        QuestionController.nextQuestion +=5;
        this.hide();
        JInternalFrame intr = new Questionmain();
        jDesktopPane1.add(intr);
        intr.show();
        this.setVisible(false);
        try {
            intr.setMaximum(true);
        } catch (PropertyVetoException e) {
            System.out.println(e);
        }
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(QuestionController.nextQuestion>=5){
            QuestionController.nextQuestion -=5;
            this.hide();
            JInternalFrame intr = new Questionmain();
            jDesktopPane1.add(intr);
            intr.show();
            this.setVisible(false);
            try {
                intr.setMaximum(true);
            } catch (PropertyVetoException e) {
                System.out.println(e);
            }
        }
        else jButton1.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1PopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuCanceled
        jComboBox1.removeAllItems();

    }//GEN-LAST:event_jComboBox1PopupMenuCanceled

    private void jComboBox1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyTyped

    }//GEN-LAST:event_jComboBox1KeyTyped

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed

    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jComboBox1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyReleased

        System.out.println("ok2");
    }//GEN-LAST:event_jComboBox1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_ask;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    public static javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel14;
    public static javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelquestion;
    private javax.swing.JPanel panelquestionmain;
    public static javax.swing.JLabel qpanel1_author;
    public static javax.swing.JLabel qpanel1_date;
    public static javax.swing.JLabel qpanel1_qnote;
    public static javax.swing.JButton qpanel1_qtitle;
    public static javax.swing.JLabel qpanel2_author;
    public static javax.swing.JLabel qpanel2_date;
    public static javax.swing.JLabel qpanel2_qnote;
    public static javax.swing.JButton qpanel2_qtitle;
    public static javax.swing.JLabel qpanel3_author;
    public static javax.swing.JLabel qpanel3_date;
    public static javax.swing.JLabel qpanel3_qnote;
    public static javax.swing.JButton qpanel3_qtitle;
    public static javax.swing.JLabel qpanel4_author;
    public static javax.swing.JLabel qpanel4_date;
    public static javax.swing.JLabel qpanel4_qnote;
    public static javax.swing.JButton qpanel4_qtitle;
    public static javax.swing.JLabel qpanel5_author;
    public static javax.swing.JLabel qpanel5_date;
    public static javax.swing.JLabel qpanel5_qnote;
    public static javax.swing.JButton qpanel5_qtitle;
    // End of variables declaration//GEN-END:variables
}
