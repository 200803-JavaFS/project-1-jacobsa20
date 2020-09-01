package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Id;

public class Reimb_Status {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@Column(nullable = false)
	private String status;

	public Reimb_Status() {
		super();
	}

	public Reimb_Status(String status) {
		super();
		this.status = status;
	}

	public Reimb_Status(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Reimb_Status other = (Reimb_Status) obj;
		if (id != other.id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimb_Status [id=" + id + ", status=" + status + "]";
	}
}
