package JT.com.br.JT.places;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Street {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String StreetName;
	private String districtName;
	@OneToOne
	private Condominium condominium;

	public Street() {

	}

	public Street(String streetName, String districtName) {
		StreetName = streetName;
		this.districtName = districtName;
	}

	public String getStreetName() {
		return StreetName;
	}

	public String getDistrictName() {
		return districtName;
	}

}
