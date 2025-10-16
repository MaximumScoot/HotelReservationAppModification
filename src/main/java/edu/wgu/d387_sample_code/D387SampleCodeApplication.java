package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.i18n.DisplayWelcomeMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        DisplayWelcomeMessage frenchWelcome = new DisplayWelcomeMessage(Locale.FRENCH);
        Thread frenchThread = new Thread(frenchWelcome);
        frenchThread.start();

        //storing english thread results for controller access
        Map<String, String> engMap = new HashMap<String,String>();
        engMap.put("lang", englishWelcome.getLanguage());
        engMap.put("message", englishWelcome.getWelcomeMessage());
        welcomeMessageList.add(engMap);
        //storing french thread results for controller access
        Map<String, String> freMap = new HashMap<String,String>();
        engMap.put("lang", frenchWelcome.getLanguage());
        engMap.put("message", frenchWelcome.getWelcomeMessage());
        welcomeMessageList.add(freMap);

	}

}
