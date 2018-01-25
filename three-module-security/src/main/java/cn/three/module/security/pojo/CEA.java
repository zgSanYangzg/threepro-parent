package cn.three.module.security.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@Entity
@Table(name = "DTCEA")
public class CEA {
    @Id
    @GeneratedValue(generator = "gd")
    @GenericGenerator(name = "gd",strategy = "guid")
    @Column(name = "CEAKEY",length = 50,nullable = false)
    private String ceaKey;
    @Column(name = "CEAID",length = 50,nullable = false)
    private String ceaID;
    @Column(name = "COMPANYID",length = 50,nullable = false)
    private String companyID;
    @Column(name = "EAID",length = 50,nullable = false)
    private String eaID;
    @Column(name = "CEATYPE",length = 2,nullable = false)
    private String ceaType;
    @Column(name = "CEATRYDATE",nullable = false)
    private Date ceaTryDate;
    @Column(name = "CEABUYDATE",nullable = false)
    private Date   ceaBuyDate;
    @Column(name = "CEAINVALIDATE",nullable = false)
    private Date   ceaInvalidDate;
    @Column(name = "CEASTATUS",length = 2,nullable = false)
    private String ceaStatus;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CEA{");
        sb.append("ceaKey='").append(ceaKey).append('\'');
        sb.append(", ceaID='").append(ceaID).append('\'');
        sb.append(", companyID='").append(companyID).append('\'');
        sb.append(", eaID='").append(eaID).append('\'');
        sb.append(", ceaType='").append(ceaType).append('\'');
        sb.append(", ceaTryDate=").append(ceaTryDate);
        sb.append(", ceaBuyDate=").append(ceaBuyDate);
        sb.append(", ceaInvalidDate=").append(ceaInvalidDate);
        sb.append(", ceaStatus='").append(ceaStatus).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getCeaKey() {
        return ceaKey;
    }

    public void setCeaKey(String ceaKey) {
        this.ceaKey = ceaKey;
    }

    public String getCeaID() {
        return ceaID;
    }

    public void setCeaID(String ceaID) {
        this.ceaID = ceaID;
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

    public String getCeaType() {
        return ceaType;
    }

    public void setCeaType(String ceaType) {
        this.ceaType = ceaType;
    }

    public Date getCeaTryDate() {
        return ceaTryDate;
    }

    public void setCeaTryDate(Date ceaTryDate) {
        this.ceaTryDate = ceaTryDate;
    }

    public Date getCeaBuyDate() {
        return ceaBuyDate;
    }

    public void setCeaBuyDate(Date ceaBuyDate) {
        this.ceaBuyDate = ceaBuyDate;
    }

    public Date getCeaInvalidDate() {
        return ceaInvalidDate;
    }

    public void setCeaInvalidDate(Date ceaInvalidDate) {
        this.ceaInvalidDate = ceaInvalidDate;
    }

    public String getCeaStatus() {
        return ceaStatus;
    }

    public void setCeaStatus(String ceaStatus) {
        this.ceaStatus = ceaStatus;
    }
}
