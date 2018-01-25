package cn.three.module.security.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@Entity
@Table(name = "DTCMENU")
public class CMenu {
    @Id
    @GeneratedValue(generator = "gd")
    @GenericGenerator(name = "gd",strategy = "guid")
    @Column(name = "MENUKEY",nullable = false,length = 50)
    private String menuKey;
    @Column(name  ="MENUID",nullable = false,length = 50)
    private String menuID;
    @Column(name = "COMPANYID",nullable = false,length = 50)
    private String companyID;
    @Column(name="eaID",nullable = false,length = 50)
    private String eaID;
    @Column(name = "MENUNAME",nullable = false,length = 250)
    private String menuName;
    @Column(name = "MENUNUMBER",nullable = false,length =2 )
    private String menuNumber;
    @Column(name = "MENUDESC",nullable = true,length = 250)
    private String menuDesc;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CMenu{");
        sb.append("menuKey='").append(menuKey).append('\'');
        sb.append(", menuID='").append(menuID).append('\'');
        sb.append(", companyID='").append(companyID).append('\'');
        sb.append(", eaID='").append(eaID).append('\'');
        sb.append(", menuName='").append(menuName).append('\'');
        sb.append(", menuNumber='").append(menuNumber).append('\'');
        sb.append(", menuDesc='").append(menuDesc).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    public String getMenuID() {
        return menuID;
    }

    public void setMenuID(String menuID) {
        this.menuID = menuID;
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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuNumber() {
        return menuNumber;
    }

    public void setMenuNumber(String menuNumber) {
        this.menuNumber = menuNumber;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }
}
