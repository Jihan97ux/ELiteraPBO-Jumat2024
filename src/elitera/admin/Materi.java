/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elitera.admin;

/**
 *
 * @author user
 */
class Materi {
    private int id;
    private String title;
    private String desc;
    private String subId;

    public Materi(int id, String title, String desc, String subId) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.subId = subId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getSubId() {
        return subId;
    }
}

