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

    public static void setTeachId(String teachId) {
        SessionManager.teach_sub_id = teachId;
    }

    public static String getTeachId() {
        return teach_sub_id;
    }
}
