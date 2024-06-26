/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elitera.admin;

import elitera.DBConnectionManager;
import static elitera.DBConnectionManager.getConnection;
import elitera.FrameGUI;
import elitera.edit.Edit;
import elitera.edit.EditKursus;
import elitera.hapus.Hapus;
import elitera.login.loginPageAdmin;
import elitera.tambah.SessionManager;
import elitera.tambah.Tambah;
import elitera.tambah.TambahKursus;
import elitera.tambah.TambahMateri;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class FrameGUIAdmin extends javax.swing.JFrame {
    public String sub;
    public static String currentCourseId;
    public static String currentCourseTeach;
    public static String currentCourseJurusan;
    /**
     * Creates new form FrameGUIAdmin
     */
    public FrameGUIAdmin() {
        initComponents();
        getConnection();
    }

    public ArrayList<String> getSubjectsByTeachId(String teach_sub_id) {
    ArrayList<String> subjects = new ArrayList<>();
    Connection con = DBConnectionManager.getConnection();
    if (con != null) {
        try {
            String query = "SELECT Sub_name FROM Subject_tbl WHERE TRIM(Sub_teach) = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, teach_sub_id);
            ResultSet rs = ps.executeQuery();
            boolean found = false; // Gunakan flag untuk menandai apakah setidaknya satu mata pelajaran ditemukan
            while (rs.next()) {
                found = true;
                subjects.add(rs.getString("Sub_name"));
                //JOptionPane.showMessageDialog(null, "Subject added: " + rs.getString("Sub_name"));
            }
            if (!found) { // Jika tidak ada mata pelajaran yang ditemukan, tampilkan pesan kesalahan
                JOptionPane.showMessageDialog(this, "Tidak ada kursus yang diajarkan id ini", "Error", JOptionPane.ERROR_MESSAGE);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FrameGUI.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    return subjects;
}

    public void displaySubjects(ArrayList<String> subjects) {
    System.out.println("Jumlah kursus: " + subjects.size());
    //jPanel3.removeAll(); 
    jPanel3.setLayout(new BorderLayout()); 
    jPanel3.setPreferredSize(new Dimension(228, 272));
    jPanel3.setBackground(Color.WHITE);

    JPanel labelPanel = new JPanel();
    labelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    labelPanel.setBorder(new EmptyBorder(20, 20, 0, 0));
    labelPanel.setBackground(Color.WHITE);
    labelPanel.add(jLabel2);
    jPanel3.add(labelPanel, BorderLayout.NORTH);

    JPanel radioPanel = new JPanel();
    radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
    radioPanel.setBorder(new EmptyBorder(10, 20, 10, 0));
    radioPanel.setBackground(Color.WHITE);
    jPanel3.add(radioPanel, BorderLayout.CENTER);

    ButtonGroup group = new ButtonGroup();
    Font radioFont = new Font("Bookman Old Style", Font.BOLD, 14);
    
    for (String subject : subjects) {
        JRadioButton radioButton = new JRadioButton(subject);
        radioButton.setBackground(Color.WHITE);
        radioButton.setForeground(Color.BLACK);
        radioButton.setFont(radioFont);
        radioButton.addActionListener(new ActionListener() {
            private String materi_add_id;
            public void actionPerformed(ActionEvent evt) {
                JOptionPane.showMessageDialog(null, "You clicked on: " + subject);
                sub = subject;
                String subName = radioButton.getText();
                
                Connection con = null;
                
                try{
                    con = getConnection();
                    String sql = "SELECT * FROM subject_tbl WHERE Sub_name = ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, subName);

                    ResultSet rs = pst.executeQuery();
                    
                    if(rs.next()) {
                        currentCourseId = rs.getString("Sub_id");
                        currentCourseTeach = rs.getString("Sub_teach");
                        currentCourseJurusan = rs.getString("Sub_jurusan");
                    }
                    con.close();
                } catch(Exception e){
                   JOptionPane.showMessageDialog(null, "gagal" + subject); 
                }
            }
        });
        group.add(radioButton);
        radioPanel.add(radioButton);
        radioPanel.add(Box.createVerticalStrut(20));
    }
    
    jPanel3.revalidate();
    jPanel3.repaint();
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setForeground(new java.awt.Color(51, 102, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tch2.PNG"))); // NOI18N

        jButton5.setBackground(new java.awt.Color(153, 51, 255));
        jButton5.setForeground(new java.awt.Color(255, 153, 51));
        jButton5.setText("Teacher Status");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButton5)
                .addGap(299, 299, 299)
                .addComponent(jLabel3)
                .addContainerGap(402, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        jPanel3.setForeground(new java.awt.Color(255, 102, 0));

        jButton4.setBackground(new java.awt.Color(255, 153, 51));
        jButton4.setForeground(new java.awt.Color(51, 51, 255));
        jButton4.setText("Show");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kursus.PNG"))); // NOI18N

        jButton7.setBackground(new java.awt.Color(51, 102, 255));
        jButton7.setForeground(new java.awt.Color(255, 153, 51));
        jButton7.setText("Tambah Kursus");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 102, 255));
        jButton6.setForeground(new java.awt.Color(255, 153, 51));
        jButton6.setText("Edit Kursus");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(255, 51, 51));
        jButton11.setForeground(new java.awt.Color(255, 153, 51));
        jButton11.setText("Hapus Kursus");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton7)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton11)
                                .addComponent(jButton6)))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(61, 61, 61)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11)
                .addGap(45, 45, 45))
        );

        jPanel4.setBackground(new java.awt.Color(51, 102, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Title", "Description"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(255, 153, 51));
        jButton2.setForeground(new java.awt.Color(51, 51, 255));
        jButton2.setText("Video/Document");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 153, 51));
        jButton8.setForeground(new java.awt.Color(51, 51, 255));
        jButton8.setText("Tambahkan");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 153, 51));
        jButton9.setForeground(new java.awt.Color(51, 51, 255));
        jButton9.setText("Edit");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 51, 0));
        jButton10.setForeground(new java.awt.Color(51, 51, 255));
        jButton10.setText("Hapus");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(255, 153, 51));
        jButton12.setForeground(new java.awt.Color(51, 51, 255));
        jButton12.setText("Materi");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton12))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(jButton10))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (sub == null || sub.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Pilih kursus terlebih dahulu!");
        return;
    }
    
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        con = getConnection();
        String sql = "SELECT c.content_id, c.content_desc, c.content_url, m.materi_id, s.sub_id " +
                     "FROM content_tbl c " +
                     "JOIN materi_tbl m ON c.content_materi_id = m.materi_id " +
                     "JOIN subject_tbl s ON m.materi_sub_id = s.sub_id " +
                     "WHERE s.sub_name = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, sub);
        rs = ps.executeQuery();
        
        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        tblModel.setRowCount(0); // Clear existing rows
        
        while (rs.next()) {
            String ID = rs.getString("content_id");
            String Title = rs.getString("content_desc");
            String Description = rs.getString("content_url");
            // Add data to table model
            String tbdata[] = {ID, Title, Description};
            tblModel.addRow(tbdata);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    
        if (sub == null || sub.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Pilih kursus terlebih dahulu!");
        return;
    }
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        con = getConnection();
        String sql = "SELECT m.materi_id, m.materi_title, m.materi_desc, m.materi_sub_id,s.sub_id " +
                           "FROM materi_tbl m " +
                           "JOIN subject_tbl s ON m.materi_sub_id = s.sub_id " +
                           "WHERE s.sub_name = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, sub);
        rs = ps.executeQuery();
        DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel();
        tblModel.setRowCount(0); // Clear existing rows
        while (rs.next()){
            String ID = rs.getString("Materi_id");
            String Title = rs.getString("Materi_title");
            String Description = rs.getString("Materi_desc");
            String Sub_id = rs.getString("Materi_sub_id");
            String tbdata[] = {ID, Title, Description};
            tblModel.addRow(tbdata);
            
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
     new Hapus().setVisible(true);
     this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
     new Tambah().setVisible(true);
     this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
     new TambahKursus().setVisible(true);
     this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
     new Edit().setVisible(true);
     this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    if (sub == null || sub.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Pilih kursus terlebih dahulu!");
        return;
    }
    new EditKursus().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
     if (sub == null || sub.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Pilih kursus terlebih dahulu!");
        return;
    }
        Connection con = getConnection();
        if (con != null) {
            try {
                String query = "DELETE FROM Subject_tbl WHERE Sub_id = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, currentCourseId);
                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Kursus berhasil dihapus!");
                    new loginPageAdmin().setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "ID kursus tidak ditemukan.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Gagal menghapus kursus!");
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
     jButton4ActionPerformed(evt);
    }//GEN-LAST:event_jButton12ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameGUIAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameGUIAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameGUIAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameGUIAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameGUIAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
