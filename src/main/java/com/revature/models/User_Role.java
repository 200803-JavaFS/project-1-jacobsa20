package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ers_user_roles")
public class User_Role {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "ers_user_role_id")
	private int id;

	@Column(name = "user_role", nullable = false)
	private Reimb_Type role;

	public User_Role() {
		super();
	}

	public User_Role(Reimb_Type role) {
		super();
		this.role = role;
	}

	public User_Role(int id, Reimb_Type role) {
		super();
		this.id = id;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Reimb_Type getRole() {
		return role;
	}

	public void setRole(Reimb_Type role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		User_Role other = (User_Role) obj;
		if (id != other.id)
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User_Role [id=" + id + ", role=" + role + "]";
	}
}
