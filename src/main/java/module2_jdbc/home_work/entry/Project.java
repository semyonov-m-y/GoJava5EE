package module2_jdbc.home_work.entry;

/**
 * Created by GetFire on 20.02.2017.
 */
public class Project {
    private String projectName;
    private int cost;

    public Project(String projectName, int cost) {
        this.projectName = projectName;
        this.cost = cost;
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

    @Override
    public String toString() {
        return "{" +
                "projectName='" + projectName + '\'' +
                ", cost=" + cost +
                '}';
    }
}
