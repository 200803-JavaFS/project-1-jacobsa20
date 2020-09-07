package com.revature.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ReimbDTO {
	public int id;
	public double amount;
//	public LocalDateTime submitted;
//	public LocalDateTime resolved;
	public String description;
//	public String receipt;
	public int authorID;
//	public String resolver;
	public String status;
	public String type;

	public ReimbDTO() {
		super();
	}

	public ReimbDTO(int id, double amount, String description, int authorID, String status, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.authorID = authorID;
		this.status = status;
		this.type = type;
	}

	public ReimbDTO(double amount, String description, int authorID, String status, String type) {
		super();
		this.amount = amount;
		this.description = description;
		this.authorID = authorID;
		this.status = status;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + authorID;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		ReimbDTO other = (ReimbDTO) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (authorID != other.authorID)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
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
		return "ReimbDTO [id=" + id + ", amount=" + amount + ", description=" + description + ", authorID=" + authorID
				+ ", status=" + status + ", type=" + type + "]";
	}

}