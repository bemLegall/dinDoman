package JT.com.br.JT.Locator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import JT.com.br.JT.places.Condominium;

@Entity
public class LocatorCondominium {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private int telefone;
	private String cpf;
	@OneToOne
	@JsonIgnore
	private Condominium condominium;

	public LocatorCondominium() {

	}

	public LocatorCondominium(long id, String name, int telefone, String cpf, Condominium condominium) {
		this.id = id;
		this.name = name;
		this.telefone = telefone;
		this.cpf = cpf;
		this.condominium = condominium;

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

	public Condominium getCondominium() {
		return condominium;
	}

}
