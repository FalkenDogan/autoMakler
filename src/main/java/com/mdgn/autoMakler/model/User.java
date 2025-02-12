package com.mdgn.autoMakler.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity implements UserDetails {

	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {//bu method UserDetail interface inden geliyor

		
		return List.of();
	}
	
	
}
