package springgeoip.model;

import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.City;

import java.util.Map;

public class GeoIP {

    private String ipAddress;
    private String city;
    private String latitude;
    private String longitude;
    private String countryName;
    private String countryCode;

    public GeoIP(CityResponse res) {
        countryName = res.getCountry().getName();
        countryCode = res.getCountry().getIsoCode();

        City cityObject = res.getCity();
        Map<String, String> namesMap = cityObject.getNames();
        city = namesMap.get("en");
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

