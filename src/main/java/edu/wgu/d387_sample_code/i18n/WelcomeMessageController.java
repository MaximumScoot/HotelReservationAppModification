package edu.wgu.d387_sample_code.i18n;


import edu.wgu.d387_sample_code.D387SampleCodeApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class WelcomeMessageController {


    @GetMapping("/welcome")
    public Map<String,String> getWelcomeMessages(){
        //new empty hashmap for storage
        Map<String,String> welcomeMap = new HashMap<>();
        //looping through welcomeMessageList from application class where threads are stored and putting in welcomeMap
        D387SampleCodeApplication.welcomeMessageList.forEach(welcomeMessage->{
            welcomeMap.put(welcomeMessage.get("lang"), welcomeMessage.get("message"));
        });
        return welcomeMap;
    }

}
