package springgeoip.service;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.Country;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import springgeoip.model.GeoIP;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
@Service
public class GeoIPService {
    private final DatabaseReader reader;
    private DatabaseReader dbReader;

    @SneakyThrows
    public GeoIPService(DatabaseReader reader) throws IOException {
        this.reader = reader;
        File database = new File("GeoLite2-City.mmdb");
        dbReader = new DatabaseReader.Builder(database).build();
        InetAddress ipAddress = InetAddress.getByName("128.101.101.101");
        CityResponse response = reader.city(ipAddress);
        Country country = response.getCountry();
        System.out.println(country.getIsoCode());
    }

    public GeoIP getLocation(String ipAddress) {
        return getLocation(ipAddress);
    }

//    public GeoIP getLocation(String ip)
//            throws IOException, GeoIp2Exception {
//        InetAddress ipAddress = InetAddress.getByName(ip);
//        CityResponse response = dbReader.city(ipAddress);
//
//        String cityName = response.getCity().getName();
//        String latitude =
//                response.getLocation().getLatitude().toString();
//        String longitude =
//                response.getLocation().getLongitude().toString();
//        return new GeoIP(ip, cityName, latitude, longitude);
//    }
}

