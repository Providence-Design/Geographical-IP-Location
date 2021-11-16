package springgeoip.model;

import com.maxmind.geoip2.model.CityResponse;

public class GeoIP {

    private String ipAddress;
    private String city;
    private String latitude;
    private String longitude;
    private String countryName;
    private String countryCode;

    public GeoIP(CityResponse cityResponse) {
        countryName = cityResponse.getCountry().getName();
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getCity() {
        return city;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

}

