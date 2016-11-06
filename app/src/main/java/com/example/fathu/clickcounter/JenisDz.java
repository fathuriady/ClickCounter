package com.example.fathu.clickcounter;

/**
 * Created by fathu on 19-Oct-16.
 */

public class JenisDz {
    private String jenisdzikir;
    private int gambarID;
    private int suaraID;
    private int pos = 0;

    public JenisDz(String jenisdzikir, int gambarID, int suaraID){
        super();
        this.jenisdzikir = jenisdzikir;
        this.gambarID = gambarID;
        this.suaraID = suaraID;

    }

    public int getPos(){
        return this.pos;
    }

    public int setPos(int pos){
        return this.pos = pos;
    }

    public void addPos(){
        this.pos++;
    }

    public int resetPos(){
        return this.pos = 0;
    }

    public String getJenisDzikir() {
        return jenisdzikir;
    }

    public int getGambarID(){
        return gambarID;
    }

    public int getSuaraID(){
        return suaraID;
    }
}
