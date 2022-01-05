package JT.com.br.JT.places;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import JT.com.br.JT.Locator.LocatorApartment;
import JT.com.br.JT.STATUS.StatusDoApartamento;

@Entity
public class Apartment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int numero;
	private String Description;
	private String urlImagem;
	private String cidade;

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	@Enumerated(EnumType.STRING)
	private StatusDoApartamento status;

	@OneToOne
	@JsonIgnore
	private LocatorApartment locatorApartment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Condominium condominium;

	public Apartment() {

	}

	public Apartment(long id, int numero, LocatorApartment locator, Condominium condominium) {
		this.id = id;
		this.numero = numero;
		this.locatorApartment = locator;
		this.condominium = condominium;

	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public long getId() {
		return id;
	}

	public int getNumero() {
		return numero;
	}

	public LocatorApartment getLocator() {
		return locatorApartment;
	}

	public Condominium getCondominium() {
		return condominium;
	}

	public LocatorApartment getLocatorApartment() {
		return locatorApartment;
	}

	public void setLocatorApartment(LocatorApartment locatorApartment) {
		this.locatorApartment = locatorApartment;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setCondominium(Condominium condominium) {
		this.condominium = condominium;
	}

	public StatusDoApartamento getStatus() {
		return status;
	}

	public void setStatus(StatusDoApartamento status) {
		this.status = status;
	}

}
