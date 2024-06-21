/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elitera.tambah;

/**
 *
 * @author user
 */
public class SessionManager {
    private static String teach_sub_id;
    private static String materi_kursus_id;
    private static String materi_add_id;

    public static void setTeachId(String teachId) {
        SessionManager.teach_sub_id = teachId;
    }

    public static String getTeachId() {
        return teach_sub_id;
    }
    
    public static void setKursusId(String kursusId){
        SessionManager.materi_kursus_id = kursusId;
    }
    
    public static String getKursusId(){
        return materi_kursus_id;
    }
    
    public static void setMateriId(String materiId){
        SessionManager.materi_add_id = materiId;
    }
    
     public static String getMateriId(){
        return materi_add_id;
    }

    public static void getKursusId(String materi_kursus_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
