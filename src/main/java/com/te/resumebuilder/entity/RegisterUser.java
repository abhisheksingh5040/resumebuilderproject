package com.te.resumebuilder.entity;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RegisterUser implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int registerUserId;

	@Column(name = "user_email_id", unique = true, nullable = false)
	private String registerUserEmail;

	@Column(name = "user_email_password", nullable = false)
	private String registerUserPassword;

	@OneToOne(mappedBy = "registerUser")
	@JoinColumn(name = "user_profile_id")
	private UserProfile userProfile;

	@ManyToMany(mappedBy = "registerUser", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<UserRole> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = roles.stream()
				.map((role) -> new SimpleGrantedAuthority(role.getUserRole())).collect(Collectors.toList());
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.registerUserPassword;
	}

	@Override
	public String getUsername() {
		return this.registerUserEmail;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
