package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class Reimb_Type implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int typeID;

	@Column(nullable = false)
	private String type;
	
	public Reimb_Type() {
		super();
	}

	public Reimb_Type(int typeID, String type) {
		super();
		this.typeID = typeID;
		this.type = type;
	}

	public int getId() {
		return typeID;
	}

	public void setId(int typeID) {
		this.typeID = typeID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + typeID;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Reimb_Type other = (Reimb_Type) obj;
		if (typeID != other.typeID)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimb_Type [id=" + typeID + ", type=" + type + "]";
	}

}
