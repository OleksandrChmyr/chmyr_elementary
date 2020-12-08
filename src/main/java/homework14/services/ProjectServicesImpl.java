package homework14.services;


import homework14.dao.ProjectsDao;
import homework14.dao.ProjectsDaoImpl;
import homework14.entities.Projects;

public class ProjectServicesImpl implements ProjectServices{
    @Override
    public void save(Projects projects) {
        ProjectsDao projectsDao = new ProjectsDaoImpl();
        projectsDao.save(projects);
    }

    @Override
    public void update(Projects projects) {
        ProjectsDao projectsDao = new ProjectsDaoImpl();
        projectsDao.update(projects);

    }

    @Override
    public void delete(Projects projects) {
        ProjectsDao projectsDao = new ProjectsDaoImpl();
        projectsDao.delete(projects);
    }

    @Override
    public Projects getById(int id) {
        ProjectsDao projectsDao = new ProjectsDaoImpl();
        return projectsDao.getById(id);
    }
}
