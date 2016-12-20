package com.xwolf.eop.system.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xwolf
 * @since 2016-12-20
 */
@TableName("com_menus")
public class Menus implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId(type= IdType.AUTO)
	private Integer mid;

	/**
	 * 菜单code
	 */
	private String mcode;

	/**
	 * 菜单名称
	 */
	private String mname;

	/**
	 * 父菜单CODE
	 */
	private String pcode;

	/**
	 * 是否是父菜单
	 */
	@TableField(value="is_parent")
	private Integer parent;

	/**
	 * 菜单url
	 */
	private String murl;

	/**
	 * 菜单状态
	 */
	private Integer mstatus;



	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMcode() {
		return mcode;
	}

	public void setMcode(String mcode) {
		this.mcode = mcode;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public String getMurl() {
		return murl;
	}

	public void setMurl(String murl) {
		this.murl = murl;
	}

	public Integer getMstatus() {
		return mstatus;
	}

	public void setMstatus(Integer mstatus) {
		this.mstatus = mstatus;
	}

}
