package module2_jdbc.model;

import java.util.List;

/**
 * Created by GetFire on 16.02.2017.
 */
public interface ProjectDAO {
    List<Project> getAll();

    Project load(int id);
}
