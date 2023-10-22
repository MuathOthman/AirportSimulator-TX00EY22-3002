package entity;

import jakarta.persistence.*;

@Entity
@Table(name="simulaatio")
public class simulaatio {
    private static int idCounter = 0;

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

    @Column(name = "time")
    private double time;

    @Column(name = "customers")
    private int customers;

    @Column(name = "name")
    private String name;


    public simulaatio(int[] settings, String date) {
        super();
        this.checkin = settings[0];
        this.sec = settings[1];
        this.pass = settings[2];
        this.date = date;
        this.av_time = 0;
        this.time = 0;
        this.customers = 0;
        this.name = "Simulaatio" + getId();
    }

    public simulaatio() {

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

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
