package etail;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import etail.domain.account.Credential;
import etail.domain.bubbles.Category;
import etail.domain.bubbles.Subcategory;
import etail.domain.geo.Area;
import etail.domain.geo.City;
import etail.domain.geo.Country;
import etail.domain.geo.State;
import etail.domain.seller.Seller;
import etail.domain.seller.SellerAddress;
import etail.domain.seller.SellerBody;
import etail.domain.seller.SellerHead;
import etail.domain.seller.SellerPInfo;

//High level possible JWT flow:
//
//Front end passes credentials to a public endpoint.
//
//JWT access and refresh tokens are created and returned along with expiration data.
//
//Front end stores the tokens and expiration of the access token. Possibly in local or session storage.
//
//On all future api calls, check the expiration. If still good, place the access token in the Authorization 
//header for Spring to extract.
//
//If the token is expired, send the refresh token to a refresh endpoint. Validate the refresh token on the 
//back end then create and return new access and refresh tokens to the front end and repeat the process.

@Component
public class bootstrap implements CommandLineRunner{

	@PersistenceUnit
	public EntityManagerFactory entityManagerF;
	
	public EntityManager entityManager;
	public bootstrap() {
		super();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(entityManagerF!=null);
		entityManager = entityManagerF.createEntityManager();
		//////////////////////////////////////////////////////
		List<Category> catgrs = new ArrayList<>();
		//1
		catgrs.add(new Category("General Labour"));
		//2
		catgrs.add(new Category("Skilled Trade"));
		//3
		catgrs.add(new Category("Arts"));
		
		//insertCategories(catgrs);
		//***
		List<Subcategory> subcatgrs = new ArrayList<>();
		//1
		subcatgrs.add(new Subcategory());
		subcatgrs.get(0).setName("Landscaping");
		subcatgrs.get(0).setCategory(catgrs.get(0));
		//2
		subcatgrs.add(new Subcategory());
		subcatgrs.get(1).setName("Roofing");
		subcatgrs.get(1).setCategory(catgrs.get(1));
		//3
		subcatgrs.add(new Subcategory());
		subcatgrs.get(2).setName("Choreographer");
		subcatgrs.get(2).setCategory(catgrs.get(2));
		
		//4
		subcatgrs.add(new Subcategory());
		subcatgrs.get(3).setName("Welder");
		subcatgrs.get(3).setCategory(catgrs.get(0));
		
		//insertSubcategories(subcatgrs);
		////////////////////////////////////////////////////
		
		////////////////////////////////////////////////////
		List<String> countries = new ArrayList<>();
		countries.add("India");
		countries.add("Canada");
		//insertCountries(countries);
		
		List<String> states = new ArrayList<>();
		states.add("Gujarat");
		states.add("Maharastra");
		//insertStates(states,"India");
		
		List<String> cities = new ArrayList<>();
		cities.add("Baroda");
		cities.add("Surat");
		//insertCities(cities,"Gujarat");
		cities.clear();
		cities.add("Pune");
		cities.add("Jalgaon");
		//insertCities(cities,"Maharastra");
		
		List<String> areas = new ArrayList<>();
		areas.add("Manjalpur");
		areas.add("Sama");
		areas.add("Karelibaug");
		//insertAreas(areas,"Baroda");
		areas.clear();
		areas.add("Pune Area");
		//insertAreas(areas,"Pune");
		
		entityManager.close();
	}
	
	/*------------------------------------------------*/
	public void insertCategories(List<Category> catgrs) {
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();
			for(Category cy:catgrs) {
				entityManager.persist(cy);
			}
			entityTransaction.commit();
			entityManager.clear();
		}
		catch(Exception e) {
			entityTransaction.rollback();
			System.out.println(e);
		}
	}
	
	public void insertSubcategories(List<Subcategory> subcatgrs) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		int id = 0;
		try {
			entityTransaction.begin();
			for(Subcategory x:subcatgrs) {
				entityManager.persist(x);
				id+=1;
			}
			entityTransaction.commit();
			entityManager.clear();
		}
		catch(Exception e) {
			entityTransaction.rollback();
			System.out.println(id+" "+e);
		}
	}
	
	/*-------------------------------------------------*/
	
	public void insertCredentials(List<Credential> credList) {
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();
			for(Credential x:credList) {
				entityManager.persist(x);
			}
			entityTransaction.commit();
			entityManager.clear();
		}
		catch(Exception e) {
			entityTransaction.rollback();
			System.out.println(e);
		}
	}
	
	/*--------------------------------------------------*/
	
	public void insertCountries(List<String> countries) {
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();
			for(String x:countries) {
				Country cy = new Country(x);
				entityManager.persist(cy);
			}
			entityTransaction.commit();
			entityManager.clear();
		}
		catch(Exception e) {
			entityTransaction.rollback();
			System.out.println(e);
		}
	}
	
	public void insertStates(List<String> states, String countryName) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		String findCountry = "Select * From Country Where Country.COUNTRY_NAME = :countryName";
		try {
			entityTransaction.begin();
			Country country =(Country) entityManager.createNativeQuery(findCountry, Country.class).setParameter("countryName", countryName).getSingleResult();
			for(String x:states) {
				State st = new State(x);
				st.setCountry(country);
				entityManager.persist(st);
			}
			entityTransaction.commit();
			entityManager.clear();
		}
		catch(Exception e) {
			entityTransaction.rollback();
			System.out.println(e);
		}
	}
	
	public Area findArea(String area) {
		String findArea = "Select * From Area Where Area.AREA_NAME = :area";
		Area _area = null;
		try {
			_area =(Area) entityManager.createNativeQuery(findArea, Area.class).setParameter("area", area).getSingleResult();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return _area;
	}
	
	public void insertCities(List<String> cities, String stateName) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		String findState = "Select * From State Where State.STATE_NAME = :stateName";
		try {
			entityTransaction.begin();
			State state = (State) entityManager.createNativeQuery(findState, State.class).setParameter("stateName", stateName).getSingleResult();
			for(String x:cities) {
				City ct = new City(x);
				ct.setState(state);
				entityManager.persist(ct);
				Area ar = new Area("x");
				ar.setCity(ct);
				entityManager.persist(ar);
			}
			entityTransaction.commit();
		}
		catch(Exception e) {
			entityTransaction.rollback();
			System.out.println(e);
		}
	}
	
	public void insertAreas(List<String> areas, String cityName) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		String findCity = "Select * From City Where City.CITY_NAME = :cityName";
		try {
			entityTransaction.begin();
			City city = (City) entityManager.createNativeQuery(findCity, City.class).setParameter("cityName", cityName).getSingleResult();
			for(String x:areas) {
				Area area = new Area(x);
				area.setCity(city);
				entityManager.persist(area);
			}
			entityTransaction.commit();
		}
		catch(Exception e) {
			entityTransaction.rollback();
			System.out.println(e);
		}
	}
	
	public void insertSellers(List<Seller> sellers) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		//String findCity = "Select * From City Where City.CITY_NAME = :cityName";
		try {
			entityTransaction.begin();
			//City city = (City) entityManager.createNativeQuery(findCity, City.class).setParameter("cityName", cityName).getSingleResult();
			for(Seller x:sellers) {
				entityManager.persist(x);
			}
			entityTransaction.commit();
		}
		catch(Exception e) {
			entityTransaction.rollback();
			System.out.println(e);
		}
	}
}
