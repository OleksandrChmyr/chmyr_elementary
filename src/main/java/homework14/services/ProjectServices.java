package homework14.services;

import homework14.entities.Projects;

public interface ProjectServices {
    void save (Projects projects);
    void update (Projects projects);
    void delete (Projects projects);
    Projects getById(int id);
}
