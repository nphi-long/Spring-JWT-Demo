package spring.demo.security.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.demo.entities.User;
import spring.demo.enums.ERole;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// class này chứa 1 field duy nhất
	private User user;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<ERole> roles = Arrays.asList(ERole.values());
//		List<GrantedAuthority> authorities = roles.stream()
//												  .map(role -> new SimpleGrantedAuthority(role.name()))
//												  .collect(Collectors.toList());
//		return authorities;
		return Collections.singleton(new SimpleGrantedAuthority(user.getRole().name()));
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
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
