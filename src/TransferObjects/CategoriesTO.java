package TransferObjects;

public class CategoriesTO {
	
	private String age;
	private String sex;
	private String country;
	private String region;
	private double year;
	private double noOfDeaths;
	
	public CategoriesTO(CategoriesTO cat){
		age = cat.age;
		sex = cat.sex;
		country = cat.country;
		region = cat.region;
		year = cat.year;
		noOfDeaths = cat.noOfDeaths;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public double getNoOfDeaths() {
		return noOfDeaths;
	}
	public void setNoOfDeaths(double noOfDeaths) {
		this.noOfDeaths = noOfDeaths;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public double getYear() {
		return year;
	}
	public void setYear(double year) {
		this.year = year;
	}

}
