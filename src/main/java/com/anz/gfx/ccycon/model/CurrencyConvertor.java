package com.anz.gfx.ccycon.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CurrencyConvertor implements Serializable {
	private static final long serialVersionUID = 8347310695829332037L;
	private String frmCcy;
	private String toCcy;
	private BigDecimal fromAmount;
	private BigDecimal toAmount;
	private BigDecimal conversionRate;


	public String getFrmCcy() {
		return frmCcy;
	}

	public void setFrmCcy(String frmCcy) {
		this.frmCcy = frmCcy;
	}

	public String getToCcy() {
		return toCcy;
	}

	public void setToCcy(String toCcy) {
		this.toCcy = toCcy;
	}

	public BigDecimal getFromAmount() {
		return fromAmount;
	}

	public void setFromAmount(BigDecimal fromAmount) {
		this.fromAmount = fromAmount;
	}

	public BigDecimal getToAmount() {
		return toAmount;
	}

	public void setToAmount(BigDecimal toAmount) {
		this.toAmount = toAmount;
	}

	public BigDecimal getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "CurrencyConvertor [frmCcy=" + frmCcy + ", toCcy=" + toCcy + ", fromAmount=" + fromAmount + ", toAmount="
				+ toAmount + ", conversionRate=" + conversionRate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conversionRate == null) ? 0 : conversionRate.hashCode());
		result = prime * result + ((frmCcy == null) ? 0 : frmCcy.hashCode());
		result = prime * result + ((fromAmount == null) ? 0 : fromAmount.hashCode());
		result = prime * result + ((toAmount == null) ? 0 : toAmount.hashCode());
		result = prime * result + ((toCcy == null) ? 0 : toCcy.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurrencyConvertor other = (CurrencyConvertor) obj;
		if (conversionRate == null) {
			if (other.conversionRate != null)
				return false;
		} else if (!conversionRate.equals(other.conversionRate))
			return false;
		if (frmCcy == null) {
			if (other.frmCcy != null)
				return false;
		} else if (!frmCcy.equals(other.frmCcy))
			return false;
		if (fromAmount == null) {
			if (other.fromAmount != null)
				return false;
		} else if (!fromAmount.equals(other.fromAmount))
			return false;
		if (toAmount == null) {
			if (other.toAmount != null)
				return false;
		} else if (!toAmount.equals(other.toAmount))
			return false;
		if (toCcy == null) {
			if (other.toCcy != null)
				return false;
		} else if (!toCcy.equals(other.toCcy))
			return false;
		return true;
	}

}
