package com.example.freetuts.model;

// default package
// Generated Jan 22, 2019 10:27:21 AM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Sinhvien generated by hbm2java
 */
@Entity
@Table(name = "sinhvien", catalog = "ql_sv")
public class Sinhvien implements java.io.Serializable {

	private Integer maSv;
	private String ho;
	private String ten;
	private String ngaySinh;
	private Integer gioitinh;
	private String noiSinh;

	private Integer maLop;

	public Sinhvien() {
	}

	public Sinhvien(String ho) {
		this.ho = ho;
	}

	public Sinhvien(int maLop, String ho, String ten, String ngaySinh, Integer gioitinh, String noiSinh) {
		this.maLop = maLop;
		this.ho = ho;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.gioitinh = gioitinh;
		this.noiSinh = noiSinh;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "MaSV", unique = true, nullable = false)
	public Integer getMaSv() {
		return this.maSv;
	}

	public void setMaSv(Integer maSv) {
		this.maSv = maSv;
	}

	@Column(name = "MaLop")
	public Integer getMaLop() {
		return this.maLop;
	}

	public void setMaLop(Integer maLop) {
		this.maLop = maLop;
	}

	@Column(name = "Ho", nullable = false, length = 45)
	public String getHo() {
		return this.ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	@Column(name = "Ten", length = 45)
	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	@Column(name = "NgaySinh", length = 45)
	public String getNgaySinh() {
		return this.ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	@Column(name = "Gioitinh")
	public Integer getGioitinh() {
		return this.gioitinh;
	}

	public void setGioitinh(Integer gioitinh) {
		this.gioitinh = gioitinh;
	}

	@Column(name = "NoiSinh", length = 45)
	public String getNoiSinh() {
		return this.noiSinh;
	}

	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

}
