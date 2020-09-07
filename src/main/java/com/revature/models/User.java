package com.revature.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ers_users")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "ers_users_id")
	private int id;

	//@Column(name = "ers_username", nullable = false, unique = true)
	public String username;

	//@Column(name = "ers_password", nullable = false)
	public String password;

	//@Column(name = "user_first_name", nullable = false)
	private String first;

	//@Column(name = "user_last_name", nullable = false)
	private String last;

	//@Column(name = "user_email", nullable = false, unique = true)
	private String email;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_role_id", nullable = false)
	private User_Role userRoleId;

	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
	private List<Reimb> list;

	public User() {
		super();
	}

	public User(int id, String username, String password, String first, String last, String email, User_Role userRoleId,
			List<Reimb> list) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.first = first;
		this.last = last;
		this.email = email;
		this.userRoleId = userRoleId;
		this.list = list;
	}

	public User(String username, String password, String first, String last, String email, User_Role userRoleId,
			List<Reimb> list) {
		super();
		this.username = username;
		this.password = password;
		this.first = first;
		this.last = last;
		this.email = email;
		this.userRoleId = userRoleId;
		this.list = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User_Role getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(User_Role userRoleId) {
		this.userRoleId = userRoleId;
	}

	public List<Reimb> getList() {
		return list;
	}

	public void setList(List<Reimb> list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + id;
		result = prime * result + ((last == null) ? 0 : last.hashCode());
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userRoleId == null) ? 0 : userRoleId.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (id != other.id)
			return false;
		if (last == null) {
			if (other.last != null)
				return false;
		} else if (!last.equals(other.last))
			return false;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userRoleId == null) {
			if (other.userRoleId != null)
				return false;
		} else if (!userRoleId.equals(other.userRoleId))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", first=" + first + ", last="
				+ last + ", email=" + email + ", userRoleId=" + userRoleId + ", list=" + list + "]";
	}

	

}
