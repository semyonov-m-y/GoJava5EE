package module2_jdbc.model;

/**
 * Created by GetFire on 15.02.2017.
 */
public class Project {
    private String companyName;
    private String projectName;
    private int cost;

    public Project(String companyName, String projectName, int cost) {
        this.companyName = companyName;
        this.projectName = projectName;
        this.cost = cost;
    }

    public Project() {
    }

    @Override
    public String toString() {
        return "{" +
                "companyName = " + companyName
                + ", projectName = " + projectName +
                ", cost = " + cost +
                '}';
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
