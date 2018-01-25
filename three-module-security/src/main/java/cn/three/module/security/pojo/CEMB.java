package cn.three.module.security.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@Entity
@Table(name = "DTCEMB")
public class CEMB {
    @Id
    @GeneratedValue(generator = "gd")
    @GenericGenerator(name = "gd",strategy = "guid")
    @Column(name = "EMBKEY")
    private String embKey;
    @Column(name = "EMBID")
    private String embID;
    @Column(name = "COMPANYID")
    private String companyID;
    @Column(name = "EAID")
    private String eaID;
    @Column(name = "MENUID")
    private String menuID;
    @Column(name = "BOID")
    private String boID;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CEMB{");
        sb.append("embKey='").append(embKey).append('\'');
        sb.append(", embID='").append(embID).append('\'');
        sb.append(", companyID='").append(companyID).append('\'');
        sb.append(", eaID='").append(eaID).append('\'');
        sb.append(", menuID='").append(menuID).append('\'');
        sb.append(", boID='").append(boID).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getEmbKey() {
        return embKey;
    }

    public void setEmbKey(String embKey) {
        this.embKey = embKey;
    }

    public String getEmbID() {
        return embID;
    }

    public void setEmbID(String embID) {
        this.embID = embID;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getEaID() {
        return eaID;
    }

    public void setEaID(String eaID) {
        this.eaID = eaID;
    }

    public String getMenuID() {
        return menuID;
    }

    public void setMenuID(String menuID) {
        this.menuID = menuID;
    }

    public String getBoID() {
        return boID;
    }

    public void setBoID(String boID) {
        this.boID = boID;
    }
}
