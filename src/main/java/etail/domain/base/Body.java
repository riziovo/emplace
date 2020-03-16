package etail.domain.base;

public interface Body extends BaseEntity{
	default public String getBody() {
		return "";
	}
}