package cn.three.module.account.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@Entity
@Table(name = "DTCREMI")
public class CREMI {
    @Id
    @GeneratedValue(generator = "gd")
    @GenericGenerator(name = "gd",strategy = "guid")
    @Column(name = "REMIKEY",length = 50,nullable = false)
    private String remiKey;
    @Column(name = "REMIID",length = 50,nullable = false)
    private String remiID;
    @Column(name = "COMPANYID",length = 50,nullable = false)
    private String companyID;
    @Column(name = "ROLEID",length = 50,nullable = false)
    private String roleID;
    @Column(name = "EAID",length = 50,nullable = false)
    private String eaID;
    @Column(name = "MENUID",length = 50,nullable = false)
    private String menuID;
    @Column(name = "INTERFACEID",length = 50,nullable = false)
    private String interfaceID;
    @Column(name = "INTERFACEURL",length = 256,nullable = false)
    private String interfaceUrl;
    @Column(name = "INTERFACESTATUS",length = 2,nullable = false)
    private String interfaceStatus;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CREMI{");
        sb.append("remiKey='").append(remiKey).append('\'');
        sb.append(", remiID='").append(remiID).append('\'');
        sb.append(", companyID='").append(companyID).append('\'');
        sb.append(", roleID='").append(roleID).append('\'');
        sb.append(", eaID='").append(eaID).append('\'');
        sb.append(", menuID='").append(menuID).append('\'');
        sb.append(", interfaceID='").append(interfaceID).append('\'');
        sb.append(", interfaceUrl='").append(interfaceUrl).append('\'');
        sb.append(", interfaceStatus='").append(interfaceStatus).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getRemiKey() {
        return remiKey;
    }

    public void setRemiKey(String remiKey) {
        this.remiKey = remiKey;
    }

    public String getRemiID() {
        return remiID;
    }

    public void setRemiID(String remiID) {
        this.remiID = remiID;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
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

    public String getInterfaceID() {
        return interfaceID;
    }

    public void setInterfaceID(String interfaceID) {
        this.interfaceID = interfaceID;
    }

    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
    }

    public String getInterfaceStatus() {
        return interfaceStatus;
    }

    public void setInterfaceStatus(String interfaceStatus) {
        this.interfaceStatus = interfaceStatus;
    }
}
