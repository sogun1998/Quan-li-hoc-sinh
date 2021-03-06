package quanLi.model;
// Generated Aug 28, 2019 5:31:39 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Khoahoc generated by hbm2java
 */
public class Khoahoc implements java.io.Serializable {

	private Integer id;
	private Giangvien giangvien;
	private int thoiGianHoc;
	private int chiPhi;
	private String loai;
	private Set dangkis = new HashSet(0);

	public Khoahoc() {
	}

	public Khoahoc(Giangvien giangvien, int thoiGianHoc, int chiPhi, String loai) {
		this.giangvien = giangvien;
		this.thoiGianHoc = thoiGianHoc;
		this.chiPhi = chiPhi;
		this.loai = loai;
	}

	public Khoahoc(Giangvien giangvien, int thoiGianHoc, int chiPhi, String loai, Set dangkis) {
		this.giangvien = giangvien;
		this.thoiGianHoc = thoiGianHoc;
		this.chiPhi = chiPhi;
		this.loai = loai;
		this.dangkis = dangkis;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Giangvien getGiangvien() {
		return this.giangvien;
	}

	public void setGiangvien(Giangvien giangvien) {
		this.giangvien = giangvien;
	}

	public int getThoiGianHoc() {
		return this.thoiGianHoc;
	}

	public void setThoiGianHoc(int thoiGianHoc) {
		this.thoiGianHoc = thoiGianHoc;
	}

	public int getChiPhi() {
		return this.chiPhi;
	}

	public void setChiPhi(int chiPhi) {
		this.chiPhi = chiPhi;
	}

	public String getLoai() {
		return this.loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public Set getDangkis() {
		return this.dangkis;
	}

	public void setDangkis(Set dangkis) {
		this.dangkis = dangkis;
	}

}
