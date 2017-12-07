package cn.three.core.database.base;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/28 0028.
 */
@Entity
@Table(name = "TB_JP_CAR")
public class JpCar implements Serializable {
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "guid")
    @Column(name = "CARKEY")
    private String carKey;
    @Column(name = "CARID")
    private String carId;  //车辆ID

    @Column(name="CARNUM")
    private String carnum;  //教练车全国唯一编号
    @Column(name="COMPANY_ID")
    private String companyId; //驾校ID
    @Column(name="FRANUM")
    private String franum;  //车架号
    @Column(name="ENGNUM")
    private String engnum;  //发动机号
    @Column(name="PLATE_NUMBER")
    private String plateNumber; //车牌号码
    @Column(name="PLATE_COLOR")
    private String plateColor; //车牌颜色  1蓝色 2黄色 3 黑色 4白色 5 绿色 9其他
    @Column(name="PHOTO")
    private String photo;  //车辆照片文件ID
    @Column(name="MANUFACTURE")
    private String manufacture; //生产厂家
    @Column(name="BRAND")
    private String brand; //车辆品牌
    @Column(name="MODEL")
    private String model;  //厂牌型号
    @Column(name="PERDRITYPE")
    private String perdritype;  //培训车型 A1 A2 A3 B1 B2 C1 C2 C3 C4 C5 D E F M N P
    @Column(name="BUYDATE")
    private Date buydate;  //购买时间
    @Column(name="LINCE_DISPATH_DATE")
    private Date linceDispathDate;  //行驶证发证日期
    @Column(name="VEHICLE_STATE")
    private String vehicleState;  //车辆状态
    @Column(name="SKILL_LEVEL")
    private String skillLevel;  //技术等级 1 无 2一级 3二级 4三级
    @Column(name="FUEL")
    private String fuel;  //燃油 1无 2汽油 3柴油 4其他 5 双燃油
    @Column(name="ZKL")
    private String zkl;  //载客量
    @Column(name="JCQK")
    private String jcqk;  //检测情况
    @Column(name="EQUIP_STATUS")
    private String equipStatus;  //设备状况
    @Column(name="SYNC_TYPE")
    private String syncType;  //同步类型
    @Column(name="SYNC_STATUS")
    private String syncStatus;  //同步状态
    @Column(name="DEL_FLAG")
    private String delFlag;  //删除标志
    @Column(name="CHECK_STATUS")
    private String checkStatus;  //审核状态
    @Column(name="REMARK")
    private String remark;  //备注
    @Column(name="UPDATEPERSON")
    private String updateperson;  //更新人
    @Column(name="CREATEDATE")
    private Date createdate;  //创建时间
    @Column(name="UPDATEDATE")
    private Date updatedate;  //更新时间
    @Column(name="CREATEPERSON")
    private String createperson;  //创建人
    @Column(name="SYNC_XLYC_STATUS")
    private String syncXlycStatus;  //同步状态（0待同步1同步成功2同步失败）

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getFranum() {
        return franum;
    }

    public void setFranum(String franum) {
        this.franum = franum;
    }

    public String getEngnum() {
        return engnum;
    }

    public void setEngnum(String engnum) {
        this.engnum = engnum;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(String plateColor) {
        this.plateColor = plateColor;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPerdritype() {
        return perdritype;
    }

    public void setPerdritype(String perdritype) {
        this.perdritype = perdritype;
    }

    public Date getBuydate() {
        return buydate;
    }

    public void setBuydate(Date buydate) {
        this.buydate = buydate;
    }

    public Date getLinceDispathDate() {
        return linceDispathDate;
    }

    public void setLinceDispathDate(Date linceDispathDate) {
        this.linceDispathDate = linceDispathDate;
    }

    public String getVehicleState() {
        return vehicleState;
    }

    public void setVehicleState(String vehicleState) {
        this.vehicleState = vehicleState;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getZkl() {
        return zkl;
    }

    public void setZkl(String zkl) {
        this.zkl = zkl;
    }

    public String getJcqk() {
        return jcqk;
    }

    public void setJcqk(String jcqk) {
        this.jcqk = jcqk;
    }

    public String getEquipStatus() {
        return equipStatus;
    }

    public void setEquipStatus(String equipStatus) {
        this.equipStatus = equipStatus;
    }

    public String getSyncType() {
        return syncType;
    }

    public void setSyncType(String syncType) {
        this.syncType = syncType;
    }

    public String getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUpdateperson() {
        return updateperson;
    }

    public void setUpdateperson(String updateperson) {
        this.updateperson = updateperson;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getCreateperson() {
        return createperson;
    }

    public void setCreateperson(String createperson) {
        this.createperson = createperson;
    }

    public String getSyncXlycStatus() {
        return syncXlycStatus;
    }

    public void setSyncXlycStatus(String syncXlycStatus) {
        this.syncXlycStatus = syncXlycStatus;
    }

    public String getCarKey() {
        return carKey;
    }

    public void setCarKey(String carKey) {
        this.carKey = carKey;
    }
}
