public class Project {
    private String project_name;
    private String rating_profitus;
    private float basic_interest;
    private float max_bonus_interest;

    public Project() {
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getRating_profitus() {
        return rating_profitus;
    }

    public void setRating_profitus(String rating_profitus) {
        this.rating_profitus = rating_profitus;
    }

    public float getBasic_interest() {
        return basic_interest;
    }

    public void setBasic_interest(float basic_interest) {
        this.basic_interest = basic_interest;
    }

    public float getMax_bonus_interest() {
        return max_bonus_interest;
    }

    public void setMax_bonus_interest(float max_bonus_interest) {
        this.max_bonus_interest = max_bonus_interest;
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_name='" + project_name + '\'' +
                ", rating_profitus='" + rating_profitus + '\'' +
                ", basic_interest=" + basic_interest +
                ", max_bonus_interest=" + max_bonus_interest +
                '}';
    }
}
