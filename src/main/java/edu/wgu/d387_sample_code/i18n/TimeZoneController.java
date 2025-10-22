package edu.wgu.d387_sample_code.i18n;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TimeZoneController {

    @GetMapping("/time")
    public Map<String, String> getTimeZones(){

        return TimeConversion.getTimeConversion();

    }
}
