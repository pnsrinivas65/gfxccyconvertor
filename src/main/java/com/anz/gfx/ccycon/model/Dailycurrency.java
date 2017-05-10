package com.anz.gfx.ccycon.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Dailycurrency {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id = null;

	@ManyToOne
    @JoinColumn(name="frmccy", referencedColumnName="currencycode")
	private Currency frmccy = null;
	
	@ManyToOne
    @JoinColumn(name="toccy", referencedColumnName="currencycode")
	private Currency toccy = null;
	
	private String createdby = null;

	private BigDecimal conversionrate = null;
	
	private BigDecimal inversionrate = null;

	private Date conversiondate = null;
	private Date creationtimestamp = null;

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
	public Currency getFrmccy() {
		return frmccy;
	}

	public void setFrmccy(Currency frmccy) {
		this.frmccy = frmccy;
	}

	/**
	 * {}
	 **/
	public Currency getToccy() {
		return toccy;
	}

	public void setToccy(Currency toccy) {
		this.toccy = toccy;
	}

	/**
	 * {}
	 **/
	public BigDecimal getConversionrate() {
		return conversionrate;
	}

	public void setConversionrate(BigDecimal conversionrate) {
		this.conversionrate = conversionrate;
	}

	/**
	 * {}
	 **/
	public BigDecimal getInversionrate() {
		return inversionrate;
	}

	public void setInversionrate(BigDecimal inversionrate) {
		this.inversionrate = inversionrate;
	}

	/**
	 * {}
	 **/
	public Date getConversiondate() {
		return conversiondate;
	}

	public void setConversiondate(Date conversiondate) {
		this.conversiondate = conversiondate;
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
	public Date getCreationtimestamp() {
		return creationtimestamp;
	}

	public void setCreationtimestamp(Date creationtimestamp) {
		this.creationtimestamp = creationtimestamp;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Dailycurrency dailycurrency = (Dailycurrency) o;
		return Objects.equals(id, dailycurrency.id) && Objects.equals(frmccy, dailycurrency.frmccy)
				&& Objects.equals(toccy, dailycurrency.toccy)
				&& Objects.equals(conversionrate, dailycurrency.conversionrate)
				&& Objects.equals(inversionrate, dailycurrency.inversionrate)
				&& Objects.equals(conversiondate, dailycurrency.conversiondate)
				&& Objects.equals(createdby, dailycurrency.createdby)
				&& Objects.equals(creationtimestamp, dailycurrency.creationtimestamp);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, frmccy, toccy, conversionrate, inversionrate, conversiondate, createdby,
				creationtimestamp);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Dailycurrency {\n");

		sb.append("  id: ").append(id).append("\n");
		sb.append("  frmccy: ").append(frmccy).append("\n");
		sb.append("  toccy: ").append(toccy).append("\n");
		sb.append("  conversionrate: ").append(conversionrate).append("\n");
		sb.append("  inversionrate: ").append(inversionrate).append("\n");
		sb.append("  conversiondate: ").append(conversiondate).append("\n");
		sb.append("  createdby: ").append(createdby).append("\n");
		sb.append("  creationtimestamp: ").append(creationtimestamp).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
