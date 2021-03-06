package com.example.freetuts.model;

import static javax.persistence.GenerationType.IDENTITY;

// default package
// Generated Jan 22, 2019 7:27:24 PM by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Lop generated by hbm2java
 */
@Entity
@Table(name = "lop", catalog = "ql_sv")
public class Lop implements java.io.Serializable {

	private int maLop;
	private String tenLop;
	private String khoa;
	private String heDaoTao;
	private String namNhapHoc;
	private String siSo;
	private String maKhoa;
	

	public Lop() {
	}

	public Lop(int maLop) {
		this.maLop = maLop;
	}

	public Lop(int maLop, String tenLop, String khoa, String heDaoTao, String namNhapHoc, String siSo, String maKhoa) {
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.khoa = khoa;
		this.heDaoTao = heDaoTao;
		this.namNhapHoc = namNhapHoc;
		this.siSo = siSo;
		this.maKhoa = maKhoa;
		
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ma_lop", unique = true, nullable = false)
	public int getMaLop() {
		return this.maLop;
	}

	public void setMaLop(int maLop) {
		this.maLop = maLop;
	}

	@Column(name = "ten_lop", length = 45)
	public String getTenLop() {
		return this.tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	@Column(name = "Khoa", length = 45)
	public String getKhoa() {
		return this.khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	@Column(name = "he_dao_tao", length = 45)
	public String getHeDaoTao() {
		return this.heDaoTao;
	}

	public void setHeDaoTao(String heDaoTao) {
		this.heDaoTao = heDaoTao;
	}

	@Column(name = "nam_nhap_hoc", length = 45)
	public String getNamNhapHoc() {
		return this.namNhapHoc;
	}

	public void setNamNhapHoc(String namNhapHoc) {
		this.namNhapHoc = namNhapHoc;
	}

	@Column(name = "si_so", length = 45)
	public String getSiSo() {
		return this.siSo;
	}

	public void setSiSo(String siSo) {
		this.siSo = siSo;
	}

	@Column(name = "ma_khoa", length = 45)
	public String getMaKhoa() {
		return this.maKhoa;
	}

	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}

	

}
