package lewan.dao;

import lewan.entity.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Task> getTasks(){

        Session currentSession = sessionFactory.getCurrentSession();
        Query<Task> theQuery =
                currentSession.createQuery("from Task", Task.class);

        List<Task> tasks = theQuery.getResultList();

        return tasks;
    }

    @Override
    @Transactional
    public void saveTask(Task task) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(task);
    }

    @Override
    @Transactional
    public Task getTask(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Task task = currentSession.get(Task.class,id);
        return task;
    }

    @Override
    @Transactional
    public void deleteTask(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("delete from Task where id=:taskId");
        query.setParameter("taskId", id);
        query.executeUpdate();

    }


}
