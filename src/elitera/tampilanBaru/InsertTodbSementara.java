/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elitera.tampilanBaru;

/**
 *
 * @author user
 */
import elitera.DBConnectionManager;
import static elitera.DBConnectionManager.getConnection;
import elitera.FrameGUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InsertTodbSementara {
    
    public void insertTo(String jrsn, int kls) {
        if (jrsn == null || jrsn.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pilih jurusan terlebih dahulu!");
            return;
        }
        
        Connection con = getConnection();
        if (con != null) {
            try {
                String sql = "INSERT INTO db_sementara (jrsn, kls) VALUES (?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, jrsn);
                ps.setInt(2, kls);
                
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
                System.out.println(jrsn);
                
                // Contoh penggunaan FrameGUI di sini
                FrameGUI frame = new FrameGUI();
                ArrayList<String> subjects = frame.getSubjectsByJurusan(jrsn);
                frame.displaySubjects(subjects);
                frame.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(InsertTodbSementara.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Gagal menyimpan data!");
            }
        }
    }
}

