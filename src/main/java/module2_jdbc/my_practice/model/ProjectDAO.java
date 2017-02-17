package module2_jdbc.my_practice.model;

import java.util.List;

/**
 * Created by GetFire on 16.02.2017.
 */
public interface ProjectDAO {
    List<Project> getAll() throws Exception;

    Project load(int id) throws Exception;
}
