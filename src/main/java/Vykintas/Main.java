package Vykintas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

//    public final String fizzURL = "https://booking.the-fizz.com/json-interface/rs/marketing/marketingCollections";
//
//    public static void main(String[] args) throws InterruptedException {
//        String lastProjectsName = "s";
//        RestTemplate restTemplate = new RestTemplate();
//        EmailSendingService emailSendingService = new EmailSendingService();
//        String email = "vykintas.martusevicius@gmail.com";
//        String email2 = "auste44@gmail.com";
//        String topic = "Naujas Profitus Projektas";
//
//
//        String fizzURL = "https://booking.the-fizz.com/json-interface/rs/marketing/marketingCollections";
//        FizzRequest requestUtrecht = new FizzRequest();
//        requestUtrecht.setBuildingCode("FIZZ_UTRECHT");
//        FizzRequest requestBremen = new FizzRequest();
//        requestBremen.setBuildingCode("THE_FIZZ_BREMEN");
//        String fizzEmail1 = "vykintas.martusevicius@gmail.com";
//        String fizzEmail2 = "auste44@gmail.com";
//        String fizzEmail3 = "vycintas2verslas@gmail.com";
//
//        while (true) {
//            var response = restTemplate.getForEntity("https://api.profitus.com/api/v1/landing/projects?limit=8&page=1", ProfitusResponse.class);
//
//            Project lastProject = response.getBody().getData().get(0);
//            String newProjectsName = lastProject.getProject_name();
//
//            if (lastProjectsName != null && !lastProjectsName.equals(newProjectsName)) {
//                emailSendingService.sendEmail(email, buildEmail(lastProject), topic);
//                emailSendingService.sendEmail(email2, buildEmail(lastProject), topic);
//            }
//            lastProjectsName = newProjectsName;
//            var responseFizz = restTemplate.postForEntity(fizzURL, requestUtrecht, FizzResponse.class);
//            System.out.println(responseFizz.getBody().getLocations().get(0).getBuildings().get(0).getRoomTypes().get(1).getMarketingRent());
//            if (responseFizz.getBody().getLocations().get(0).getBuildings().get(0).getRoomTypes().get(1).getMarketingRent() != null) {
//                emailSendingService.sendEmail(email, "Student Accommodation in Utrecht is now available!", "FIZZ_UTRECHT");
//                emailSendingService.sendEmail(email2, "Student Accommodation in Utrecht is now available!", "FIZZ_UTRECHT");
//            }
//
//
//            Thread.sleep(1000 * 60);
//        }
//    }
//
//    public static String buildEmail(Project project) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Pavadinimas: ").append(project.getProject_name()).append("\n");
//        builder.append("Reitingas: ").append(project.getRating_profitus()).append("\n");
//        builder.append("Min palukanos: ").append(project.getBasic_interest()).append("\n");
//        builder.append("Max palukanos: ").append(project.getMax_bonus_interest()).append("\n");
//
//        return builder.toString();
//    }
}
