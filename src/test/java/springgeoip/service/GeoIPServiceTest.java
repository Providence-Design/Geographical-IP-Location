package springgeoip.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.InetAddress;

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

        CityResponse cityResponse = createCityResponseForCountry("United Kingdom");
        when(reader.city(any(InetAddress.class))).thenReturn(cityResponse);
        
        // execute
        GeoIP res = service.getLocation("77.100.172.150");
        
        // validate
        assertNotNull(res);
        assertEquals("United Kingdom", res.getCountryName());
    }

    private CityResponse createCityResponseForCountry(String countryName) {
        Country country = mock(Country.class);
        when(country.getName()).thenReturn(countryName);
        
        CityResponse cityResponse = new CityResponse(null, null, country, null, null, null, null, null, null, null);
        return cityResponse;
    }
}
