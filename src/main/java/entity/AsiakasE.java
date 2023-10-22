package entity;

import jakarta.persistence.*;
import simu.model.*;

@Entity
@Table(name="asiakas")
public class AsiakasE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int db_id;
    @Column(name = "sim_id")
    private int sim_id;
    @Column(name = "id")
    private int id;
    @Column(name = "arr_time")
    private double arr_time;
    @Column(name = "left_time")
    private double left_time;


    public AsiakasE(Asiakas a, int sim_id) {
        super();
        this.id = a.getId();
        this.arr_time = a.getSaapumisaika();
        this.left_time = a.getPoistumisaika();
        this.sim_id = sim_id;

    }

    public AsiakasE() {

    }

    public int getDb_id() {
        return db_id;
    }

    public void setDb_id(int db_id) {
        this.db_id = db_id;
    }

    public int getSim_id() {
        return sim_id;
    }

    public void setSim_id(int sim_id) {
        this.sim_id = sim_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getArr_time() {
        return arr_time;
    }

    public void setArr_time(double arr_time) {
        this.arr_time = arr_time;
    }

    public double getLeft_time() {
        return left_time;
    }

    public void setLeft_time(double left_time) {
        this.left_time = left_time;
    }
}


