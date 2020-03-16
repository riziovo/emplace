package etail.incoming.domain;

public class SearchObj {
	public String searchStr;
	public Long subcatId;
	public Long areaId;
	public Long cityId;
	public Long stateId;
	public Long countryId;
	
	public SearchObj(String searchStr, Long subcatId, Long areaId, Long cityId, Long stateId, Long countryId) {
		this.searchStr = searchStr;
		this.subcatId = subcatId;
		this.areaId = areaId;
		this.cityId = cityId;
		this.stateId = stateId;
		this.countryId = countryId;
	}
	
	
}
