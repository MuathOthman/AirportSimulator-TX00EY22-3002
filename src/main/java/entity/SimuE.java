package entity;

import jakarta.persistence.*;
import simu.model.*;

@Entity
@Table(name="simulaatio")
public class SimuE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "av_time")
    private double av_time;

    @Column(name = "date")
    private String date;

    @Column(name = "checkin")
    private int checkin;

    @Column(name = "pass")
    private int pass;

    @Column(name = "sec")
    private int sec;

    public SimuE(int[] settings, String date) {
        super();
        this.checkin = settings[0];
        this.sec = settings[1];
        this.pass = settings[2];
        this.date = date;

    }

    public SimuE() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAv_time() {
        return av_time;
    }

    public void setAv_time(double av_time) {
        this.av_time = av_time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCheckin() {
        return checkin;
    }

    public void setCheckin(int checkin) {
        this.checkin = checkin;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }
}
