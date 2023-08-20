import org.springframework.web.client.RestTemplate;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        String lastProjectsName = "s";
        RestTemplate restTemplate = new RestTemplate();
        EmailSendingService emailSendingService = new EmailSendingService();
        String email = "vykintas.martusevicius@gmail.com";
        String email2 = "auste44@gmail.com";
        String topic = "Naujas Profitus Projektas";
        while (true) {
            var response = restTemplate.getForEntity("https://api.profitus.com/api/v1/landing/projects?limit=8&page=1", ProfitusResponse.class);

            Project lastProject = response.getBody().getData().get(0);
            String newProjectsName = lastProject.getProject_name();

            if (lastProjectsName != null && !lastProjectsName.equals(newProjectsName)) {
                emailSendingService.sendEmail(email, buildEmail(lastProject), topic);
                emailSendingService.sendEmail(email2, buildEmail(lastProject), topic);
            }
            lastProjectsName = newProjectsName;
            System.out.println("miau");
            Thread.sleep(1000 * 60);
        }
    }

    public static String buildEmail(Project project) {
        StringBuilder builder = new StringBuilder();
        builder.append("Pavadinimas: ").append(project.getProject_name()).append("\n");
        builder.append("Reitingas: ").append(project.getRating_profitus()).append("\n");
        builder.append("Min palukanos: ").append(project.getBasic_interest()).append("\n");
        builder.append("Max palukanos: ").append(project.getMax_bonus_interest()).append("\n");

        return builder.toString();
    }

}
