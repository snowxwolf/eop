package com.xwolf.eop.system.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

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
@TableName("com_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
    @TableId(type = IdType.AUTO)
	private Integer uid;

	/**
	 * 用户code
	 */
	private String ucode;

	/**
	 * 用户名
	 */
	private String uname;

	/**
	 * 昵称
	 */
	@TableField(value="nick_name")
	private String name;

	/**
	 * 
	 */
	private String upasswd;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * qq
	 */
	private String qq;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 创建时间
	 */
	private Date ctime;

	/**
	 * 创建人code
	 */
	private String ccode;

	/**
	 * 推荐人
	 */
	private String rcode;

	/**
	 * 推荐时间
	 */
	private Date rtime;

	/**
	 * 用户状态
	 */
	private Integer ustatus;



	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUcode() {
		return ucode;
	}

	public void setUcode(String ucode) {
		this.ucode = ucode;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpasswd() {
		return upasswd;
	}

	public void setUpasswd(String upasswd) {
		this.upasswd = upasswd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getRcode() {
		return rcode;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
	}

	public Date getRtime() {
		return rtime;
	}

	public void setRtime(Date rtime) {
		this.rtime = rtime;
	}

	public Integer getUstatus() {
		return ustatus;
	}

	public void setUstatus(Integer ustatus) {
		this.ustatus = ustatus;
	}

}
