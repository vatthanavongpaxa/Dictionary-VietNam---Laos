package myfriend.com.dictionaryvietnam_laos.model;

import java.io.InputStream;
import java.io.Serializable;

/**
 * Created by vatth on 3/31/2017.
 */

public class Word implements Serializable {
    private int id;
    private String VNWORD;
    private String LAWORD;
    private int BOOKMARK;

    public int getBOOKMARK() {
        return BOOKMARK;
    }

    public void setBOOKMARK(int BOOKMARK) {
        this.BOOKMARK = BOOKMARK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVNWORD() {
        return VNWORD;
    }

    public void setVNWORD(String VNWORD) {
        this.VNWORD = VNWORD;
    }

    public String getLAWORD() {
        return LAWORD;
    }

    public void setLAWORD(String LAWORD) {
        this.LAWORD = LAWORD;
    }

    public Word(int id, String VNWORD, String LAWORD, int BOOKMARK) {
        this.id = id;
        this.VNWORD = VNWORD;
        this.LAWORD = LAWORD;
        this.BOOKMARK = BOOKMARK;
    }

    @Override
    public String toString() {
        return VNWORD;
    }
}
