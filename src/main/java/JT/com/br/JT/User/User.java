package JT.com.br.JT.User;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import JT.com.br.JT.places.Apartment;

@Entity
@Table(name="users")
public class User {

	@Id
	private String username;
	private String password;
	private boolean enabled;

	@OneToMany(cascade =CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY )
	private List<Apartment> apartments;

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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}

