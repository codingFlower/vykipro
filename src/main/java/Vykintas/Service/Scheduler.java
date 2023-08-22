package Vykintas.Service;

import Vykintas.DTO.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class Scheduler {
    private static final String fizzURL = "https://booking.the-fizz.com/json-interface/rs/marketing/marketingCollections";
    private static final String profitusURL = "https://api.profitus.com/api/v1/landing/projects?limit=8&page=1";

    private static final String email = "vykintas.martusevicius@gmail.com";
    private static final String email2 = "auste44@gmail.com";
    private static final String topic = "Naujas Profitus Projektas";

    private static final String fizzEmail1 = "nomudara.boldbaatar@gmail.com";
    private static final String fizzEmail2 = "dianacrucitti2@gmail.com";
    private static final String fizzEmail3 = "greta.aidietyte@gmail.com";
    private static final String fizzEmail4 = "vycintas2verslas@gmail.com";

    private String lastProjectsName = "s";

    @Autowired
    EmailSendingService emailSendingService;

    @Scheduled(cron = "30 * * * * *")
    void checkProfitus() {
        RestTemplate restTemplate = new RestTemplate();

            var response = restTemplate.getForEntity(profitusURL, ProfitusResponse.class);

            Project lastProject = response.getBody().getData().get(0);
            String newProjectsName = lastProject.getProject_name();

            log.info(lastProjectsName);

            if (lastProjectsName != null && !lastProjectsName.equals(newProjectsName)) {
                emailSendingService.sendEmail(email, buildEmail(lastProject), topic);
                emailSendingService.sendEmail(email2, buildEmail(lastProject), topic);
            }
            lastProjectsName = newProjectsName;
    }

    @Scheduled(cron = "59 * * * * *")
    void checkFizz() {
        RestTemplate restTemplate = new RestTemplate();
        FizzRequest requestUtrecht = new FizzRequest();
        requestUtrecht.setBuildingCode("FIZZ_UTRECHT");
//        FizzRequest requestBremen = new FizzRequest();
//        requestBremen.setBuildingCode("THE_FIZZ_BREMEN");

        var responseFizz = restTemplate.postForEntity(fizzURL, requestUtrecht, FizzResponse.class);
        MarketingRent rent = responseFizz.getBody().getLocations().get(0).getBuildings().get(0).getRoomTypes().get(1).getMarketingRent();
        log.info("Fizz job fired");
        if (rent != null) {
            emailSendingService.sendEmail(fizzEmail1, "Student Accommodation in Utrecht is now available!", "FIZZ_UTRECHT");
            emailSendingService.sendEmail(fizzEmail2, "Student Accommodation in Utrecht is now available!", "FIZZ_UTRECHT");
            emailSendingService.sendEmail(fizzEmail3, "Student Accommodation in Utrecht is now available!", "FIZZ_UTRECHT");
            emailSendingService.sendEmail(fizzEmail4, "Student Accommodation in Utrecht is now available!", "FIZZ_UTRECHT");
        }
    }




    private static String buildEmail(Project project) {
        StringBuilder builder = new StringBuilder();
        builder.append("Pavadinimas: ").append(project.getProject_name()).append("\n");
        builder.append("Reitingas: ").append(project.getRating_profitus()).append("\n");
        builder.append("Min palukanos: ").append(project.getBasic_interest()).append("\n");
        builder.append("Max palukanos: ").append(project.getMax_bonus_interest()).append("\n");

        return builder.toString();
    }
}