package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.i18n.DisplayWelcomeMessage;
import edu.wgu.d387_sample_code.i18n.TimeConversion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@SpringBootApplication
public class D387SampleCodeApplication {

    //list to hold messages to share with controller
    public static List<Map<String, String>> welcomeMessageList = new ArrayList<>();

	public static void main(String[] args) {

        SpringApplication.run(D387SampleCodeApplication.class, args);

        //creating english welcome message thread
        DisplayWelcomeMessage englishWelcome = new DisplayWelcomeMessage(Locale.US);
        Thread englishThread = new Thread(englishWelcome);
        englishThread.start();

        //creating french welcome message thread
        DisplayWelcomeMessage frenchWelcome = new DisplayWelcomeMessage(Locale.CANADA_FRENCH);
        Thread frenchThread = new Thread(frenchWelcome);
        frenchThread.start();


        //waits for threads to finish before moving on
        try {
            englishThread.join();
            frenchThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        //storing english thread results for controller access
        Map<String, String> engMap = new HashMap<String,String>();
        engMap.put("lang", englishWelcome.getLanguage());
        engMap.put("message", englishWelcome.getWelcomeMessage());
        welcomeMessageList.add(engMap);
        //storing french thread results for controller access
        Map<String, String> freMap = new HashMap<String,String>();
        freMap.put("lang", frenchWelcome.getLanguage());
        freMap.put("message", frenchWelcome.getWelcomeMessage());
        welcomeMessageList.add(freMap);

        //TimeConversion.getTimeConversion();

        //System.out.println(D387SampleCodeApplication.welcomeMessageList);


	}

}
