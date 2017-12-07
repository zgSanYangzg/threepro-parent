/**
 * Page Form
 */
package cn.three.core.database.base;


import java.util.List;

public class PageForm {
	private int pageSize;
	private int pageNumber;
	private int pageCount;
	private int recordCount;
	private List<BaseBean> list;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<BaseBean> getList() {
		return list;
	}
	public void setList(List<BaseBean> list) {
		this.list = list;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
}
