package com.anz.gfx.ccycon.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Audit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id = null;

	private String request = null;
	private String createdby = null;
	private String updatedby = null;

	private Date creationtimestamp = null;
	private Date updationtimestamp = null;

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
	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
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
	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
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

	/**
	 * {}
	 **/
	public Date getUpdationtimestamp() {
		return updationtimestamp;
	}

	public void setUpdationtimestamp(Date updationtimestamp) {
		this.updationtimestamp = updationtimestamp;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Audit audit = (Audit) o;
		return Objects.equals(id, audit.id) && Objects.equals(request, audit.request)
				&& Objects.equals(createdby, audit.createdby) && Objects.equals(updatedby, audit.updatedby)
				&& Objects.equals(creationtimestamp, audit.creationtimestamp)
				&& Objects.equals(updationtimestamp, audit.updationtimestamp);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, request, createdby, updatedby, creationtimestamp, updationtimestamp);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Audit {\n");

		sb.append("  id: ").append(id).append("\n");
		sb.append("  request: ").append(request).append("\n");
		sb.append("  createdby: ").append(createdby).append("\n");
		sb.append("  updatedby: ").append(updatedby).append("\n");
		sb.append("  creationtimestamp: ").append(creationtimestamp).append("\n");
		sb.append("  updationtimestamp: ").append(updationtimestamp).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
