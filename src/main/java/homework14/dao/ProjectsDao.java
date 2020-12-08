package homework14.dao;

import homework14.entities.Projects;

public interface ProjectsDao {

    void save (Projects projects);
    void update (Projects projects);
    void delete (Projects projects);
    Projects getById(int id);
}
