package springgeoip.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.InetAddress;
import java.util.*;

import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.City;
import org.junit.Test;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.Country;

import springgeoip.model.GeoIP;

public class GeoIPServiceTest {

    @Test
    public void shouldReturnNullWhenIpIsNull() throws Exception {
        // prepare
        DatabaseReader reader = mock(DatabaseReader.class);
        GeoIPService service = new GeoIPService(reader);
        
        // execute
        GeoIP res = service.getLocation(null);
        
        // validate
        assertNull(res);
    }

    @Test
    public void shouldReturnCountryInfoWhenValidIp() throws Exception {
        // prepare
        DatabaseReader reader = mock(DatabaseReader.class);
        GeoIPService service = new GeoIPService(reader);

        CityResponse cityResponse = createCityResponseForCountry("United Kingdom", "UK");
        when(reader.city(any(InetAddress.class))).thenReturn(cityResponse);
        
        // execute
        GeoIP res = service.getLocation("77.100.172.150");
        
        // validate
        assertNotNull(res);
        assertEquals("United Kingdom", res.getCountryName());
        assertEquals("UK", res.getCountryCode());
    }

    private CityResponse createCityResponseForCountry(String countryName, String countryCode) {
        Country country = mock(Country.class);
        when(country.getName()).thenReturn(countryName);
        when(country.getIsoCode()).thenReturn(countryCode);

        CityResponse cityResponse = new CityResponse(null, null, country, null, null, null, null, null, null, null);
        return cityResponse;
    }

    @Test
    public void shouldReturnCityNameWhenValidIp() throws Exception{
        // prepare
        DatabaseReader reader = mock(DatabaseReader.class);
        GeoIPService service = new GeoIPService(reader);

        CityResponse cityResponse = createCityResponseForCity("London");
        when(reader.city(any(InetAddress.class))).thenReturn(cityResponse);

        // execute
        GeoIP res = service.getLocation("77.100.172.150");

        // validate
        assertNotNull(res);
        assertEquals("London", res.getCity());
    }

    private CityResponse createCityResponseForCity(String cityName) {
        List<String> locales = Arrays.asList("en");
        Map<String, String> names = new HashMap<>();
        names.put("en", "London");

        City city = new City(locales, 0, 0, names);

        CityResponse cityResponse = new CityResponse(city, null, null, null, null, null, null, null, null, null);
        return cityResponse;
    }


}
