package com.example.freetuts.model;

// default package
// Generated Jan 28, 2019 1:44:07 PM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DiemThiId generated by hbm2java
 */

public class DiemThiId implements java.io.Serializable {

	private int maMh;
	private int maSv;

	public DiemThiId() {
	}

	public DiemThiId(int maMh, int maSv) {
		this.maMh = maMh;
		this.maSv = maSv;
	}

	@Column(name = "MaMh", nullable = false)
	public int getMaMh() {
		return this.maMh;
	}

	public void setMaMh(int maMh) {
		this.maMh = maMh;
	}

	@Column(name = "MaSV", nullable = false)
	public int getMaSv() {
		return this.maSv;
	}

	public void setMaSv(int maSv) {
		this.maSv = maSv;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DiemThiId))
			return false;
		DiemThiId castOther = (DiemThiId) other;

		return (this.getMaMh() == castOther.getMaMh()) && (this.getMaSv() == castOther.getMaSv());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getMaMh();
		result = 37 * result + this.getMaSv();
		return result;
	}

}
