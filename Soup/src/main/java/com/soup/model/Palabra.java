package com.soup.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="palabras", schema="sopadeletras")
@EntityListeners(AuditingEntityListener.class)
public class Palabra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	public String palabra;
	public Integer sr;
	public Integer sc;
	public Integer er;
	public Integer ec;
	public long uuid;

	public Palabra(String palabra, Integer sr, Integer sc, Integer er, Integer ec, long uuid) {
		super();
		this.id = id;
		this.palabra = palabra;
		this.sr = sr;
		this.sc = sc;
		this.er = er;
		this.ec = ec;
		this.uuid = uuid;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPalabra() {
		return palabra;
	}
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	public Integer getSr() {
		return sr;
	}
	public void setSr(Integer sr) {
		this.sr = sr;
	}
	public Integer getSc() {
		return sc;
	}
	public void setSc(Integer sc) {
		this.sc = sc;
	}
	public Integer getEr() {
		return er;
	}
	public void setEr(Integer er) {
		this.er = er;
	}
	public Integer getEc() {
		return ec;
	}
	public void setEc(Integer ec) {
		this.ec = ec;
	}
	public long getUuid() {
		return uuid;
	}
	public void setUuid(long uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "Palabra [id="+ id +",palabra=" + palabra + ", sr=" + sr + ", sc=" + sc + ", er=" + er + ", ec=" + ec + ", uuid="+ uuid +"]";
	}

}
