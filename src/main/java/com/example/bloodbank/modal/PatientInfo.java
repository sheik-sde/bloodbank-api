package com.example.bloodbank.modal;
import javax.persistence.*;

@Entity
@Table(name="bloodbankinfo")
public class PatientInfo {

    @Id
    @GeneratedValue
    @Column(name="id")
    int id;
    @Column(name="pname")
    String pname;
    @Column(name="age")
    int age;
    @Column(name="b_grp")
        String    b_grp;
    @Column(name="qty")
   int qty;
    @Column(name="loc")
   String loc;
    @Column(name="phealth_his")
    String phealth_his;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getQty() {
        return qty;
    }

    public void setB_grp(String b_grp) {
        this.b_grp = b_grp;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public void setPhealth_his(String phealth_his) {
        this.phealth_his = phealth_his;
    }

    public void setPid(int pid) {
        this.id = pid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getB_grp() {
        return b_grp;
    }

    public String getLoc() {
        return loc;
    }

    public String getPhealth_his() {
        return phealth_his;
    }

    public int getPid() {
        return id;
    }

    public String getPname() {
        return pname;
    }
}
