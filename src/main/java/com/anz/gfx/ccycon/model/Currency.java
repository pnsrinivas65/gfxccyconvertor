package com.anz.gfx.ccycon.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currency implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6668155430155633764L;
	@Id
	private Integer id = null;
	private Integer decimalplace = null;

	private String currencyname = null;
	private String currencycode = null;
	private String ccymode = null;
	private String createdby = null;
	private String ccycon = null;
	private Date insertiontimestamp = null;

	/**
	 * {"primaryKey":true}
	 **/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * {}
	 **/
	public String getCurrencyname() {
		return currencyname;
	}

	public void setCurrencyname(String currencyname) {
		this.currencyname = currencyname;
	}

	/**
	 * {"primaryKey":true}
	 **/
	public String getCurrencycode() {
		return currencycode;
	}

	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}

	/**
	 * {}
	 **/
	public Integer getDecimalplace() {
		return decimalplace;
	}

	public void setDecimalplace(Integer decimalplace) {
		this.decimalplace = decimalplace;
	}

	/**
	 * {}
	 **/
	public String getCcymode() {
		return ccymode;
	}

	public void setCcymode(String ccymode) {
		this.ccymode = ccymode;
	}


	/**
	 * {}
	 **/
	public String getCcycon() {
		return ccycon;
	}

	public void setCcycon(String ccycon) {
		this.ccycon = ccycon;
	}
	
	/**
	 * {}
	 **/
	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	/**
	 * {}
	 **/
	public Date getInsertiontimestamp() {
		return insertiontimestamp;
	}

	public void setInsertiontimestamp(Date insertiontimestamp) {
		this.insertiontimestamp = insertiontimestamp;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Currency currency = (Currency) o;
		return Objects.equals(id, currency.id) && Objects.equals(currencyname, 
			currency.currencyname)
				&& Objects.equals(currencycode, currency.currencycode)
				&& Objects.equals(decimalplace, currency.decimalplace) 
				&& Objects.equals(ccymode, currency.ccymode)
				&& Objects.equals(ccycon, currency.ccycon)
				&& Objects.equals(createdby, currency.createdby)
				&& Objects.equals(insertiontimestamp, currency.insertiontimestamp);
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, currencyname, currencycode, decimalplace, ccymode, ccycon, createdby, insertiontimestamp);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Currency {\n");

		sb.append("  id: ").append(id).append("\n");
		sb.append("  currencyname: ").append(currencyname).append("\n");
		sb.append("  currencycode: ").append(currencycode).append("\n");
		sb.append("  decimalplace: ").append(decimalplace).append("\n");
		sb.append("  ccymode: ").append(ccymode).append("\n");
		sb.append("  ccycon: ").append(ccycon).append("\n");
		sb.append("  createdby: ").append(createdby).append("\n");
		sb.append("  insertiontimestamp: ").append(insertiontimestamp).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
