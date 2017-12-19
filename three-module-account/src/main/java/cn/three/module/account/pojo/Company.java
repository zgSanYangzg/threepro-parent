package cn.three.module.account.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "DTCOMPANY")
public class Company {
	@Id
	@GeneratedValue(generator = "gd")
	@GenericGenerator(name = "gd",strategy = "guid")
	@Column(name = "COMPANYKEY",length = 50,nullable = false)
	private String companyKey;
	@Column(name = "COMPANYID",length = 50)
	private String companyID;
	@Column(name = "COMPANYPID",length = 50)
	private String companyPID;
	@Column(name = "DISTRICTID",length = 50)
	private String districtID;//地址表业务主键
	@Column(name = "COMPANYIDENTIFIER",length = 250)
	private String companyIdentifier;//组织机构名
	@Column(name = "COMPANYNAME",length = 250)
	private String companyName;//公司名称
	@Column(name = "COMPANYREGISTERDATE")
	private Date companyRegisterDate;//注册时间
	@Column(name = "COMPANYLICENSECOUNT",length = 2)
	private int    companyLicenseCount;
	@Column(name = "ISST",length = 1)
	private int isst;//是否在驾校联盟网站标识
	@Column(name = "SHOWWECHAT",length = 50)
	private String showwechat;//是否显示在微信
	@Column(name = "INDUSTRYTYPE",length = 250)
	private String industryType;//注册公司行类别
	@Column(name = "BOOKCURRENCY",length = 4)
	private String bookCurrency; //记账币别
	@Column(name = "ACCUMULATED",length = 100)
	private String accumulated; //累积盈亏科目
	@Column(name = "SUBJECTSID",length = 50)
	private String subjectsID;//科目ID
	@Column(name = "CODEID",length = 50)
	private String codeID;//币别ID
	/*
	 * 00表示正常  01表示不正常
	 */
	@Column(name = "COMPANYSTATUS",length = 2)
	private String companyStatus;
	/*
	 *00表示企业
	 *01表示客户 （其中11表示未付费注册客户 12表示已付费注册客户）
	 */
	@Column(name = "COMPANYTYPE",length = 2)
	private String companyType;//公司类型
	@Column(name = "GROUPCOMPANYSN",length = 50)
	private String groupCompanySn; //集团公司标识
	@Transient
	private Boolean isSt;//是否为驾校
	@Column(name = "COMTYPE",length = 10)
	private String comType;//
	@Column(name = "CCOMTYPE",length = 250)
	private String ccomtype;//0大型 1中型  2小型  3微型  4微小型   5供应商
	@Transient
	private List<Object> pklist;//为了购物车   写的 没生成数据库


 	public String getCompanyKey() {
		return companyKey;
	}
	public void setCompanyKey(String companyKey) {
		this.companyKey = companyKey;
	}
	public String getCompanyID() {
		return companyID;
	}
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	public String getCompanyPID() {
		return companyPID;
	}
	public void setCompanyPID(String companyPID) {
		this.companyPID = companyPID;
	}
	public String getDistrictID() {
		return districtID;
	}
	public void setDistrictID(String districtID) {
		this.districtID = districtID;
	}
	public String getCompanyIdentifier() {
		return companyIdentifier;
	}
	public void setCompanyIdentifier(String companyIdentifier) {
		this.companyIdentifier = companyIdentifier;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Date getCompanyRegisterDate() {
		return companyRegisterDate;
	}



	public List<Object> getPklist() {
		return pklist;
	}
	public void setPklist(List<Object> pklist) {
		this.pklist = pklist;
	}
	public String getCcomtype() {
		return ccomtype;
	}
	public void setCcomtype(String ccomtype) {
		this.ccomtype = ccomtype;
	}
	public void setCompanyRegisterDate(Date companyRegisterDate) {
		this.companyRegisterDate = companyRegisterDate;
	}
	public int getCompanyLicenseCount() {
		return companyLicenseCount;
	}
	public void setCompanyLicenseCount(int companyLicenseCount) {
		this.companyLicenseCount = companyLicenseCount;
	}
	public String getCompanyStatus() {
		return companyStatus;
	}
	public void setCompanyStatus(String companyStatus) {
		this.companyStatus = companyStatus;
	}
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getGroupCompanySn() {
		return groupCompanySn;
	}
	public void setGroupCompanySn(String groupCompanySn) {
		this.groupCompanySn = groupCompanySn;
	}

	public void setIsst(int isst) {
		this.isst = isst;
	}
	public int getIsst() {
		return isst;
	}
	public String getShowwechat() {
		return showwechat;
	}
	public void setShowwechat(String showwechat) {
		this.showwechat = showwechat;
	}
	public String getIndustryType() {
		return industryType;
	}
	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}
	public String getComType() {
		return comType;
	}
	public void setComType(String comType) {
		this.comType = comType;
	}
	public String getBookCurrency() {
		return bookCurrency;
	}
	public void setBookCurrency(String bookCurrency) {
		this.bookCurrency = bookCurrency;
	}
	public String getAccumulated() {
		return accumulated;
	}
	public void setAccumulated(String accumulated) {
		this.accumulated = accumulated;
	}
	public String getSubjectsID() {
		return subjectsID;
	}
	public void setSubjectsID(String subjectsID) {
		this.subjectsID = subjectsID;
	}
	public String getCodeID() {
		return codeID;
	}
	public void setCodeID(String codeID) {
		this.codeID = codeID;
	}
	
	
}
