package JT.com.br.JT.Locator;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import JT.com.br.JT.places.Apartment;

@Entity
public class LocatorApartment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private int telefone;
	private String cpf;

	@OneToMany
	@JsonIgnore
	private List<Apartment> apartment;

	public LocatorApartment() {

	}

	public LocatorApartment(long id, String name, int telefone, String cpf, List<Apartment> apartment) {
		this.id = id;
		this.name = name;
		this.telefone = telefone;
		this.cpf = cpf;
		this.apartment = apartment;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getTelefone() {
		return telefone;
	}

	public String getCpf() {
		return cpf;
	}
	/*
	 * public List<Apartment>getApartments(){ return apartment; }
	 */
}
