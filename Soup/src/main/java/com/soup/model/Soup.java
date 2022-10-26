package com.soup.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="sopadeletras", schema="sopadeletras")
@EntityListeners(AuditingEntityListener.class)
public class Soup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer w;
	private Integer h;
	private boolean ltr;
	private boolean rtl;
	private boolean ttb;
	private boolean btt;
	private boolean d;
	
	@Column(length = 100000)
	private String cadena;
		
	UUID uuid = UUID.randomUUID();
	
	private String uuidString = uuid.toString();
	
	private boolean estado;
	
	public Soup() {
		
	}	
	
	public Soup(Integer id, Integer w, Integer h, boolean ltr, boolean rtl, boolean ttb, boolean btt, boolean d, String cadena, String uuidString, boolean estado) {
		super();
		this.id = id;
		this.w = w;
		this.h = h;
		this.ltr = ltr;
		this.rtl = rtl;
		this.ttb = ttb;
		this.btt = btt;
		this.d = d;
		this.cadena = cadena;
		this.uuidString = uuidString;
		this.estado = estado;
		
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getW() {
		return w;
	}
	public void setW(Integer w) {
		this.w = w;
	}
	public Integer getH() {
		return h;
	}
	public void setH(Integer h) {
		this.h = h;
	}
	public boolean isLtr() {
		return ltr;
	}
	public void setLtr(boolean ltr) {
		this.ltr = ltr;
	}
	public boolean isRtl() {
		return rtl;
	}
	public void setRtl(boolean rtl) {
		this.rtl = rtl;
	}
	public boolean isTtb() {
		return ttb;
	}
	public void setTtb(boolean ttb) {
		this.ttb = ttb;
	}
	public boolean isBtt() {
		return btt;
	}
	public void setBtt(boolean btt) {
		this.btt = btt;
	}
	public boolean isD() {
		return d;
	}
	public void setD(boolean d) {
		this.d = d;
	}
	public String getCadena() {
		return cadena;
	}
	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
	public String getUuidString() {
		return uuidString;
	}
	public void setUuidString(String uuidString) {
		this.uuidString = uuidString;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Soup [id=" + id + ", w=" + w + ", h=" + h + ", ltr=" + ltr + ", rtl=" + rtl + ", ttb=" + ttb + ", btt="
				+ btt + ", d=" + d + ", cadena=" + cadena + ", uuidString=" + uuidString + ", estado=" + estado + "]";
	}

}
