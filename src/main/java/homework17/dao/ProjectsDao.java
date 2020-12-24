package homework17.dao;

import homework17.entities.Projects;

public interface ProjectsDao {

    void save (Projects projects);
    void update (Projects projects);
    void delete (Projects projects);
    Projects getById(int id);
}
