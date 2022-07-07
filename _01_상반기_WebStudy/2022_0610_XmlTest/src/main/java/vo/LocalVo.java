package vo;

public class LocalVo {
	
	String place_name;
	String road_address_name;
	String place_url;
	String phone;
	int    distance;  //meter단위
	double longitude; //경도(x)
	double latitude;  //위도(y)

	public LocalVo() {
		super();
	}

	public LocalVo(String place_name, String road_address_name, String place_url, String phone, int distance,
			double longitude, double latitude) {
		super();
		this.place_name = place_name;
		this.road_address_name = road_address_name;
		this.place_url = place_url;
		this.phone = phone;
		this.distance = distance;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public String getPlace_name() {
		return place_name;
	}

	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}

	public String getRoad_address_name() {
		return road_address_name;
	}

	public void setRoad_address_name(String road_address_name) {
		this.road_address_name = road_address_name;
	}

	public String getPlace_url() {
		return place_url;
	}

	public void setPlace_url(String place_url) {
		this.place_url = place_url;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
}
