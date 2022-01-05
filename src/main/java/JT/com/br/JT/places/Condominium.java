package JT.com.br.JT.places;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import JT.com.br.JT.Locator.LocatorCondominium;

@Entity
public class Condominium {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private int maxCapacity;
	@OneToMany(mappedBy = "condominium", fetch = FetchType.LAZY)
	private List<Apartment> apartments;
	@OneToOne
	private LocatorCondominium locatorCondominium;
	private String description;
	@OneToOne
	private Street street;
	private String cidade;

	public List<Apartment> getApartments() {
		return apartments;
	}

	public void setApartments(List<Apartment> apartments) {
		this.apartments = apartments;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Condominium() {

	}

	public Condominium(String name, int maxCapacity, List<Apartment> apartment, LocatorCondominium locator,
			Street street) {
		this.name = name;
		this.maxCapacity = maxCapacity;
		this.apartments = apartment;
		this.locatorCondominium = locator;
		this.street = street;
	}

	public String getName() {
		return name;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public List<Apartment> getApartment() {
		return apartments;
	}

	public LocatorCondominium getLocator() {
		return locatorCondominium;
	}

	public String getDescription() {
		return description;
	}

	public Street getStreet() {
		return street;
	}

	public long getId() {
		return id;
	}

	public LocatorCondominium getLocatorCondominium() {
		return locatorCondominium;
	}

	public void setLocatorCondominium(LocatorCondominium locatorCondominium) {
		this.locatorCondominium = locatorCondominium;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public void setApartment(List<Apartment> apartment) {
		this.apartments = apartment;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

}
