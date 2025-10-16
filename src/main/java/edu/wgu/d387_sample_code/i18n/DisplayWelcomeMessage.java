package edu.wgu.d387_sample_code.i18n;

import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class DisplayWelcomeMessage implements Runnable {

    String message;
    Locale locale;

    //constructor
    public DisplayWelcomeMessage(Locale locale) {
        this.locale = locale;
    }

    //runs inside thread when thread starts, calls spring utility to read .properties and where to look, picks message
    //based on locale.
    public void run(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("translation");
        messageSource.setDefaultEncoding("UTF-8");

        message = messageSource.getMessage("welcome.message", null, locale);
    }

    //returns message
    public String getWelcomeMessage() {
        return message;
    }

    //returns language code
    public String getLanguage() {
        return locale.getLanguage();
    }


}
