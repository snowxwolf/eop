package com.xwolf.eop.system.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.xwolf.eop.common.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author xwolf
 * @since 2016-12-20
 */
@TableName("com_roles")
public class Roles extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type= IdType.AUTO)
	private Integer rid;

	/**
	 * 角色code
	 */
	private String rcode;

	/**
	 * 角色名称
	 */
	private String rname;

	/**
	 * 角色权限识别code
	 */
	private String rpcode;

	/**
	 * 添加时间
	 */
	private Date rtime;

	/**
	 * 状态
	 */
	private Integer rstatus;



	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRcode() {
		return rcode;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRpcode() {
		return rpcode;
	}

	public void setRpcode(String rpcode) {
		this.rpcode = rpcode;
	}

	public Date getRtime() {
		return rtime;
	}

	public void setRtime(Date rtime) {
		this.rtime = rtime;
	}

	public Integer getRstatus() {
		return rstatus;
	}

	public void setRstatus(Integer rstatus) {
		this.rstatus = rstatus;
	}

}
