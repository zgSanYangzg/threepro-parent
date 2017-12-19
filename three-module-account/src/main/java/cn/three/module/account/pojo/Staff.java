package cn.three.module.account.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/7 0007.
 */
@Entity
@Table(name = "DT_HR_STAFF")
public class Staff {
    @Id
    @GeneratedValue(generator = "pg")
    @GenericGenerator(name = "pg", strategy = "guid")
    @Column(name = "STAFFKEY",length = 50,nullable = false)
    private String staffKey;
    @Column(name = "STAFFID",length = 50)
    private String staffID;
    @Column(name = "GROUPCOMPANYSN",length = 50)
    private String groupCompanySn;//集团公司标志外键
    /**
     * 00:正常  98 表示删除
     */
    @Column(name = "STAFFSTATUS",length = 2)
    private String staffStatus;
    @Column(name = "STAFFCODE",length = 250)
    private String staffCode;// 人员编号
    @Column(name = "RECORDCODE",length = 250)
    private String recordCode;// 档案编号//作为条码
    @Column(name = "CHIPID",length = 250)
    private String chipid;//芯片号，mz添加
    @Column(name = "STAFFNAME",length = 250)
    private String staffName;// 人员名
    @Column(name = "USEDNMAE",length = 250)
    private String usedNmae;// 曾用名
    @Column(name = "SEX",length = 50)
    private String sex;// 性别
    @Column(name = "NATIVEPLACE",length = 250)
    private String nativePlace;// 籍贯
    @Column(name = "NATIONALITY",length = 250)
    private String nationality;// 国籍
    @Column(name = "NATION",length = 250)
    private String nation;// 民族
    @Column(name = "STAFFIDENTITYCARD",length = 250)
    private String staffIdentityCard;// 身份证
    @Column(name = "PASSPORTNUM",length = 250)
    private String passportNum;  //护照号
    @Column(name = "ADDRESS",length = 250)
    private String address;// 家庭地址ID
    @Column(name = "STAFFADDRESS",length = 250)
    private String staffAddress;//家庭地址路径
    @Column(name = "REFERENCEORGANIZATION",length = 250)
    private String referenceOrganization;// 邮箱
    @Column(name = "REFERENCE",length = 250)
    private String reference;// 电话
    @Column(name = "REFERENCECODE",length = 250)
    private String referenceCode;// qq
    @Column(name = "WEIXIN",length = 50)
    private String weixin;   //微信号zzl
    @Column(name = "POSITION",length = 50)
    private String position;//职位zzl

    @Column(name = "VERIFYTIME",length = 250)
    private Date verifyTime;// 录入时间
    @Column(name = "STAFFDESC",length = 250)
    private String staffDesc;// 备注
    @Column(name = "BIRTHDAY",length = 250)
    private String birthday;// 日期
    @Column(name = "PHOTO",length = 250)
    private String photo;// 照片路径  原来系统身份证照片路径
    @Column(name = "POLITICSSTATUS",length = 250)
    private String politicsStatus;//政治面貌
    @Column(name = "CULTURALDEGREE",length = 250)
    private String culturalDegree;//文化程度
    @Column(name = "MARRIAGE",length = 50)
    private String marriage;//婚姻状况（已婚/未婚）
    @Column(name = "HEALTH",length = 250)
    private String health;//健康状况
    @Column(name = "BANKNUM",length = 250)
    private String bankNum;//银行帐号
    @Column(name = "PROVINCE",length = 250)
    private String province;   //开户行省
    @Column(name = "CITY",length = 250)
    private String city;//开户行市
    @Column(name = "STAUS",length = 50)
    private String staus ;//00:确定人员信息 ；01：未确定人员信息
    @Transient
    private String staffOrgName;//人员所在部门(预设空字段)
    @Column(name = "STAFFPOST",length = 150)
    private String staffPost; //人员岗位(预设空字段)、
    @Column(name = "SCCID",length = 150)
    private String sccid; //微分金账号表外键(T_Eshop_cuscom)
    //KW android接口信息
    @Column(name = "STAFFSM",length = 150)
    private String staffsm;//个人签名
    @Column(name = "STAFFUPF",length = 150)
    private String staffupf;//微分金店地址;
    @Column(name = "VIPNO",length = 10)
    private String vipno;//是否激活会员;0 激活 1 未激活

    //mz添加
    @Column(name = "USERNAME",length = 50)
    private String userName;//用于公共信息平台访问的用户名；
    @Column(name = "PASSWORD",length = 50)
    private String password;//用于公共信息平台访问的密码


    //MZ添加
    @Column(name = "PRICE",length = 50)
    private String price;//档案价格；

    //lwz 添加
    @Column(name = "STATUS",length = 50)
    private String status; // 用于人员多级分类
    // 00 一般人物 01政界人物 02商界人物 03学术界人物 04艺术届人物 05科学届人物
    //zll 添加
    @Column(name = "SOURCE",length = 50)
    private String source;//来源  微信  网站  系统
    @Column(name = "ACTIVITYID",length = 50)
    private String activityId;//微信活动id
    @Column(name = "ENTRYPERSONNEL",length = 250)
    private String entryPersonnel;//信息录入人员姓名

    @Column(name = "ACCOUNTID",length = 50)
    private String accountID;//账号
    @Column(name = "ACCOUNTNAME",length = 50)
    private String accountName;//人员姓名； 
    @Column(name = "INDUSTRYTYPE",length = 50)
    private String industryType;//行业

    /*
     * zj  个人名片
     */
    @Column(name = "LOCALAREAVALUE",length = 150)
    private String localAreaValue;  //个人名片所在详细地址
    @Column(name = "EDUCATIONVALUE",length = 150)
    private String educationValue;  //个人名片学历
    @Column(name = "WHERECOMPANY",length = 150)
    private String whereCompany;//个人名片所在公司
    @Column(name = "HEADIMAGE",length = 150)
    private String 	headimage;//	微分金用户头像		
    @Column(name = "PHOTOPOSITIVE",length = 150)
    private String photoPositive;//身份证正面路径
    @Column(name = "PHOTOBACK",length = 150)
    private String  photoBack;//身份证背面路径
    @Column(name = "PROVINCEADDRESS",length = 150)
    private String provinceAddress;//省份
    @Column(name = "QRCODEPATH",length = 150)
    private String qrCodePath;		//个人名片二维码图片路径


    /**
     * 不得不写十次同样的代码!!!!!!!!!!!!!!!!
     */
    public static String[] columnHeadings() {
        String[] titles = { "序号", "人员编号", "档案编号", "人员姓名", "曾用名", "性别", "出生日期",
                "籍贯", "国籍", "民族", "身份证","家庭地址", "电话", "qq","邮箱", " 录入时间", "政治面貌","现住地址","文化程度","婚姻状况","健康状况","银行帐号","备注" };
        return titles;
    }
    public static String[] columnHeadings0() {
        String[] titles = { "序号", "人员编号", "档案编号","员工工种", "人员姓名", "曾用名", "性别", "出生日期",
                "籍贯", "国籍", "民族", "身份证","家庭地址", "电话", "qq","邮箱", " 录入时间", "政治面貌","现住地址","文化程度","婚姻状况","健康状况","银行帐号","备注" };
        return titles;
    }
    public static String[] columnHeadings1() {
        String[] titles = { "序号", "人员编号", "档案编号","员工工种", "人员姓名", "部门名称", "岗位名称", "曾用名", "性别", "出生日期",
                "国籍", "籍贯", "民族", "身份证","家庭地址", "电话", "qq","邮箱", " 录入时间", "政治面貌","文化程度","婚姻状况","健康状况","银行帐号","备注" };
        return titles;
    }
    public static String[] columnHeadings2() {
        String[] titles = { "序号", "人员编号", "档案编号","员工工种", "人员姓名", "岗位名称", "曾用名", "性别", "出生日期",
                "国籍", "籍贯", "民族", "身份证"};//,"家庭地址", "电话", "qq","邮箱", " 录入时间", "政治面貌","文化程度","婚姻状况","健康状况","银行帐号","备注" };
        return titles;
    }
    /**
     * 提供积分管理导出使用
     * @return
     */
    public static String[] columnHeadings3() {
        String[] titles = { "序号","姓名","编号","电话","积分"};
        return titles;
    }
    public String[] properties() {
        String[] properties = { staffCode, recordCode, staffName,usedNmae, sex,
                birthday, nativePlace, nationality, nation, staffIdentityCard,staffAddress,
                reference, referenceCode,referenceOrganization,
                String.format("%1$tF", verifyTime),politicsStatus,
                culturalDegree,marriage,health,bankNum,staffDesc };
        return properties;
    }


    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public String getStaffIdentityCard() {
        return staffIdentityCard;
    }

    public void setStaffIdentityCard(String staffIdentityCard) {
        this.staffIdentityCard = staffIdentityCard;
    }

    public String getVipno() {
        return vipno;
    }
    public void setVipno(String vipno) {
        this.vipno = vipno;
    }
    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }


    public String getStaffKey() {
        return staffKey;
    }

    public void setStaffKey(String staffKey) {
        this.staffKey = staffKey;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }


    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    /**
     * 00:正常  98 表示删除
     * @return
     */
    public String getStaffStatus() {
        return staffStatus;
    }
    /**
     * 00:正常  98 表示删除
     * @param staffStatus
     */
    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getUsedNmae() {
        return usedNmae;
    }

    public void setUsedNmae(String usedNmae) {
        this.usedNmae = usedNmae;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReferenceOrganization() {
        return referenceOrganization;
    }

    public void setReferenceOrganization(String referenceOrganization) {
        this.referenceOrganization = referenceOrganization;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public Date getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }

    public String getStaffDesc() {
        return staffDesc;
    }

    public void setStaffDesc(String staffDesc) {
        this.staffDesc = staffDesc;
    }
    public String getStaffAddress() {
        return staffAddress;
    }
    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }
    public String getPoliticsStatus() {
        return politicsStatus;
    }
    public void setPoliticsStatus(String politicsStatus) {
        this.politicsStatus = politicsStatus;
    }
    public String getCulturalDegree() {
        return culturalDegree;
    }
    public void setCulturalDegree(String culturalDegree) {
        this.culturalDegree = culturalDegree;
    }
    public String getMarriage() {
        return marriage;
    }
    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }
    public String getHealth() {
        return health;
    }
    public void setHealth(String health) {
        this.health = health;
    }
    public String getBankNum() {
        return bankNum;
    }
    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }
    /**
     * 集团公司标志外键
     * @return
     */
    public String getGroupCompanySn() {
        return groupCompanySn;
    }
    /**
     * 集团公司标志外键
     * @param groupCompanySn
     */
    public void setGroupCompanySn(String groupCompanySn) {
        this.groupCompanySn = groupCompanySn;
    }

    public String getStaffOrgName() {
        return staffOrgName;
    }
    public void setStaffOrgName(String staffOrgName) {
        this.staffOrgName = staffOrgName;
    }
    public String getStaffPost() {
        return staffPost;
    }
    public void setStaffPost(String staffPost) {
        this.staffPost = staffPost;
    }
    public String getUserName() {
        return userName;
    }
    public String getStaffsm() {
        return staffsm;
    }
    public void setStaffsm(String staffsm) {
        this.staffsm = staffsm;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassportNum() {
        return passportNum;
    }
    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }
    public String getStaus() {
        return staus;
    }

    public String getStaffupf() {
        return staffupf;
    }
    public void setStaffupf(String staffupf) {
        this.staffupf = staffupf;
    }
    public void setStaus(String staus) {
        this.staus = staus;
    }
    public String getChipid() {
        return chipid;
    }
    public void setChipid(String chipid) {
        this.chipid = chipid;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getActivityId() {
        return activityId;
    }
    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }
    public String getEntryPersonnel() {
        return entryPersonnel;
    }
    public void setEntryPersonnel(String entryPersonnel) {
        this.entryPersonnel = entryPersonnel;
    }

    public String getAccountID() {
        return accountID;
    }
    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getWeixin() {
        return weixin;
    }
    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }
    public String getIndustryType() {
        return industryType;
    }
    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getEducationValue() {
        return educationValue;
    }
    public void setEducationValue(String educationValue) {
        this.educationValue = educationValue;
    }
    public String getWhereCompany() {
        return whereCompany;
    }
    public void setWhereCompany(String whereCompany) {
        this.whereCompany = whereCompany;
    }
    public String getLocalAreaValue() {
        return localAreaValue;
    }
    public void setLocalAreaValue(String localAreaValue) {
        this.localAreaValue = localAreaValue;
    }
    public String getHeadimage() {
        return headimage;
    }
    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }
    public String getPhotoBack() {
        return photoBack;
    }
    public void setPhotoBack(String photoBack) {
        this.photoBack = photoBack;
    }
    public String getProvinceAddress() {
        return provinceAddress;
    }
    public void setProvinceAddress(String provinceAddress) {
        this.provinceAddress = provinceAddress;
    }
    public String getPhotoPositive() {
        return photoPositive;
    }
    public void setPhotoPositive(String photoPositive) {
        this.photoPositive = photoPositive;
    }
    public String getQrCodePath() {
        return qrCodePath;
    }
    public void setQrCodePath(String qrCodePath) {
        this.qrCodePath = qrCodePath;
    }
    public String getSccid() {
        return sccid;
    }
    public void setSccid(String sccid) {
        this.sccid = sccid;
    }

}
