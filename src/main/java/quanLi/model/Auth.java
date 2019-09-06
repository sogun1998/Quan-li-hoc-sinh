package quanLi.model;
// Generated Aug 28, 2019 5:31:39 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;

/**
 * Auth generated by hbm2java
 */
public class Auth implements java.io.Serializable {

	private Integer id;
	private Menu menu;
	private Role role;
	private int permision;
	private int activeFlag;
	private Date createDate;
	private Date updateDate;

	public Auth() {
	}

	public Auth(Menu menu, Role role, int permision, int activeFlag, Date createDate, Date updateDate) {
		this.menu = menu;
		this.role = role;
		this.permision = permision;
		this.activeFlag = activeFlag;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getPermision() {
		return this.permision;
	}

	public void setPermision(int permision) {
		this.permision = permision;
	}

	public int getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}