package springgeoip.controller;

import com.maxmind.geoip2.DatabaseReader;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springgeoip.model.GeoIP;
import springgeoip.service.GeoIPService;

import java.io.IOException;

@RestController

public class GeoIPController {
    private final DatabaseReader reader;
    private GeoIPService locationService;


    public GeoIPController(DatabaseReader reader) throws IOException {
        this.reader = reader;
        locationService = new GeoIPService(this.reader);
    }

    @PostMapping("/GeoIPTest")
    public GeoIP getLocation(
            @RequestParam(value="ipAddress", required=true) String ipAddress
    ) throws Exception {

        GeoIPService locationService = new GeoIPService(reader);
        return locationService.getLocation(ipAddress);
    }
}
