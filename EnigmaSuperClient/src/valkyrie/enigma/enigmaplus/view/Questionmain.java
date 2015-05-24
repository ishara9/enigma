
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
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
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
       //  AutoCompleteDecorator.decorate(jComboBox1);
        
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
        //  AutoSuggestor autoSuggestor = new AutoSuggestor( txt_mainsearch , this , null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
        
        
      //  panelquestion.add(autoSuggestor.suggestionsPanel);
      
        
        
        
        
        sortbydate sbd = new sortbydate();
        sbd.sortbydate();  
        elapsedTime et = new elapsedTime(); 
        
        QuestionController qc1 = new QuestionController();
        UserController uc1 = new UserController();
               
        qc1.viewQuestion(parseLong(sbd.sArray[0]));
        uc1.getUser(qc1.q.getUid()); 
        qpanel1_qtitle.setText(qc1.q.getTitle());
        qpanel1_qnote.setText(qc1.q.getQ_short());        
        qpanel1_author.setText(uc1.u1.getFname()+" "+uc1.u1.getLname());
        qpanel1_date.setText(et.duration(qc1.q.getDate()));
        jLabel13.setText(String.valueOf(qc1.q.getRate()));
        
        
        QuestionController qc2 = new QuestionController();
        UserController uc2 = new UserController();
        
        qc2.viewQuestion(parseLong(sbd.sArray[1]));
        uc2.getUser(qc2.q.getUid());        
        qpanel2_qtitle.setText(qc2.q.getTitle());
        qpanel2_qnote.setText(qc2.q.getQ_short());        
        qpanel2_author.setText(uc2.u1.getFname()+" "+uc2.u1.getLname());
        qpanel2_date.setText(et.duration(qc1.q.getDate()));
        jLabel14.setText(String.valueOf(qc2.q.getRate()));
        
        QuestionController qc3 = new QuestionController();
        UserController uc3 = new UserController();
        
        qc3.viewQuestion(parseLong(sbd.sArray[2]));
        uc3.getUser(qc3.q.getUid());        
        qpanel3_qtitle.setText(qc3.q.getTitle());
        qpanel3_qnote.setText(qc3.q.getQ_short());        
        qpanel3_author.setText(uc3.u1.getFname()+" "+uc3.u1.getLname());
        qpanel3_date.setText(et.duration(qc3.q.getDate()));
        jLabel15.setText(String.valueOf(qc3.q.getRate()));
        
        QuestionController qc4 = new QuestionController();
        UserController uc4 = new UserController();
        
        qc4.viewQuestion(parseLong(sbd.sArray[3]));
        uc4.getUser(qc4.q.getUid());        
        qpanel4_qtitle.setText(qc4.q.getTitle());
        qpanel4_qnote.setText(qc4.q.getQ_short());        
        qpanel4_author.setText(uc4.u1.getFname()+" "+uc4.u1.getLname());
        qpanel4_date.setText(et.duration(qc4.q.getDate()));
        jLabel16.setText(String.valueOf(qc4.q.getRate()));
        
        QuestionController qc5 = new QuestionController();
        UserController uc5 = new UserController();
        
        qc5.viewQuestion(parseLong(sbd.sArray[4]));
        uc5.getUser(qc5.q.getUid());        
        qpanel5_qtitle.setText(qc5.q.getTitle());
        qpanel5_qnote.setText(qc5.q.getQ_short());        
        qpanel5_author.setText(uc5.u1.getFname()+" "+uc5.u1.getLname());
        qpanel5_date.setText(et.duration(qc5.q.getDate()));
        jLabel17.setText(String.valueOf(qc5.q.getRate()));
        
        
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
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

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

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                            .addGroup(panelquestionLayout.createSequentialGroup()
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
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(qpanel2_qtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(qpanel2_qnote, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
                                .addGap(20, 20, 20)
                                .addComponent(qpanel2_date)
                                .addGap(87, 87, 87)
                                .addComponent(qpanel2_author, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelquestionLayout.createSequentialGroup()
                                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelquestionLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(qpanel3_qnote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(30, 30, 30)
                                .addComponent(qpanel3_date)
                                .addGap(92, 92, 92)
                                .addComponent(qpanel3_author, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelquestionLayout.createSequentialGroup()
                                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelquestionLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addComponent(qpanel4_qnote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(40, 40, 40)
                                .addComponent(qpanel4_date)
                                .addGap(92, 92, 92)
                                .addComponent(qpanel4_author, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelquestionLayout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 916, Short.MAX_VALUE)))
                        .addGap(72, 72, 72))
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelquestionLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelquestionLayout.createSequentialGroup()
                                .addComponent(qpanel5_qnote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(97, 97, 97)
                                .addComponent(qpanel5_date)
                                .addGap(91, 91, 91)
                                .addComponent(qpanel5_author, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73))
                            .addGroup(panelquestionLayout.createSequentialGroup()
                                .addComponent(qpanel5_qtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelquestionLayout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(qpanel1_qtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelquestionLayout.createSequentialGroup()
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(qpanel3_qtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelquestionLayout.createSequentialGroup()
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(qpanel4_qtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10)
                        .addGap(48, 48, 48)
                        .addComponent(button_ask, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
            .addGroup(panelquestionLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton6)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel14)
                        .addGap(6, 6, 6)
                        .addComponent(jButton7))
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelquestionLayout.createSequentialGroup()
                                .addComponent(qpanel2_qtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(qpanel2_qnote, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelquestionLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(qpanel2_date)
                                    .addComponent(qpanel2_author))))))
                .addGap(44, 44, 44)
                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13)
                    .addComponent(qpanel3_qtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton14))
                    .addComponent(qpanel3_qnote, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(qpanel3_date))
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(qpanel3_author)))
                .addGap(27, 27, 27)
                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton18)
                    .addComponent(qpanel4_qtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton19))
                    .addComponent(qpanel4_qnote, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelquestionLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qpanel4_date)
                            .addComponent(qpanel4_author))))
                .addGap(27, 27, 27)
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
                        .addGap(4, 4, 4)
                        .addComponent(jButton17)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(panelquestion);

        javax.swing.GroupLayout panelquestionmainLayout = new javax.swing.GroupLayout(panelquestionmain);
        panelquestionmain.setLayout(panelquestionmainLayout);
        panelquestionmainLayout.setHorizontalGroup(
            panelquestionmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        panelquestionmainLayout.setVerticalGroup(
            panelquestionmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1065, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelquestionmain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 816, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelquestionmain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void qpanel5_qtitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qpanel5_qtitleActionPerformed
//        panelquestionmain.setVisible(false);
//        panelquestionview.setVisible(true);
        
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

        // TODO add your handling code here:
    }//GEN-LAST:event_qpanel1_qtitleMouseClicked

    private void qpanel1_qtitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qpanel1_qtitleActionPerformed

//        questionviewM qvm = new questionviewM();
        
        
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
        

        
        
//        QuestionController qc1 = new QuestionController();
//        qc1.qRate(100118, true);
//        this.setVisible(false);
//        JInternalFrame intr = new Questionmain();
//        jDesktopPane1.add(intr);
//        intr.show();
//        try {
//            intr.setMaximum(true);
//        } catch (PropertyVetoException e) {
//        }

//        panelquestionviewM.setVisible(true);
//        panelquestionmain.setVisible(false);
//        try {
//            Question qs = QuestionController.fillquestion(qid_1);
//
//            qviewpanel_title.setText("<html><body style=\"word-wrap: break-word;\">" + qs.getTitle() + "</body></html>");
//            qviewpanel_qnote.setText("<html><body style=\"word-wrap: break-word;\">" + qs.getQ_short() + "</body></html>");
//
//            qviewpanel_qdes.setText("<html><body style=\"word-wrap: break-word;\">" + qs.getQuestion() + "</body></html>");
//            jLabel41.setText(String.valueOf(points));
//            jLabel78.setText(String.valueOf(points));
//            resPoints = qid_1;
//            x = true;
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_qpanel1_qtitleActionPerformed

    private void qpanel2_qtitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qpanel2_qtitleActionPerformed
//        panelquestionviewM.setVisible(true);
//        panelquestionmain.setVisible(false);
//        try {
//            Question qs2 = QuestionController.fillquestion(qid_2);
//
//            qviewpanel_title.setText("<html><body style=\"word-wrap: break-word;\">" + qs2.getTitle() + "</body></html>");
//            qviewpanel_qnote.setText("<html><body style=\"word-wrap: break-word;\">" + qs2.getQ_short() + "</body></html>");
//            qviewpanel_qdes.setText("<html><body style=\"word-wrap: break-word;\">" + qs2.getQuestion() + "</body></html>");
//            resPoints = qid_2;
//            x = true;
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
//        panelquestionviewM.setVisible(true);
//        panelquestionmain.setVisible(false);
//        try {
//            Question qs3 = QuestionController.fillquestion(qid_3);
//
//            qviewpanel_title.setText("<html><body style=\"word-wrap: break-word;\">" + qs3.getTitle() + "</body></html>");
//            qviewpanel_qnote.setText("<html><body style=\"word-wrap: break-word;\">" + qs3.getQ_short() + "</body></html>");
//            qviewpanel_qdes.setText("<html><body style=\"word-wrap: break-word;\">" + qs3.getQuestion() + "</body></html>");
//            x = true;
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
//        } // TODO add your handling code here:
        
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
//        panelquestionviewM.setVisible(true);
//        panelquestionmain.setVisible(false);
//        try {
//            Question qs4 = QuestionController.fillquestion(qid_4);
//
//            qviewpanel_title.setText("<html><body style=\"word-wrap: break-word;\">" + qs4.getTitle() + "</body></html>");
//            qviewpanel_qnote.setText("<html><body style=\"word-wrap: break-word;\">" + qs4.getQ_short() + "</body></html>");
//            qviewpanel_qdes.setText("<html><body style=\"word-wrap: break-word;\">" + qs4.getQuestion() + "</body></html>");
//            x = true;
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
//        }  // TODO add your handling code here:
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
//        String search_title = txt_mainsearch.getText();
//
//        try {
//            Question que = QuestionController.searchquestion(search_title);
//
//            if (que != null) {
//
//                panelquestionmain.setVisible(false);
//                panelquestionviewM.setVisible(true);
//                qviewpanel_qdes.setText("<html><body style=\"word-wrap: break-word\">" + que.getQuestion() + "</body></html>");
//                qviewpanel_title.setText("<html><body style=\"word-wrap: break-word\">" + que.getTitle() + "</body></html>");
//                qviewpanel_qnote.setText("<html><body style=\"word-wrap: break-word\">" + que.getQ_short() + "</body></html>");
//
//            } else {
//                JOptionPane.showMessageDialog(this, "No Result found !");
//
//            }
//
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }

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

    private void jComboBox1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyReleased
        
             
                System.out.println("ok2");
    }//GEN-LAST:event_jComboBox1KeyReleased

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jComboBox1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyTyped
        
    }//GEN-LAST:event_jComboBox1KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1PopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuCanceled
        jComboBox1.removeAllItems();
    
    }//GEN-LAST:event_jComboBox1PopupMenuCanceled


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
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    public static javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel14;
    public static javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel17;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JPanel panelquestion;
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
