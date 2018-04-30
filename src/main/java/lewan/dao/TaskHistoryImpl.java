package lewan.dao;

import lewan.entity.Task;
import lewan.entity.TaskHistory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Lewan on 30.04.2018.
 */
@Repository
public class TaskHistoryImpl implements TaskHistoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<TaskHistory> getTasks(){



        Session currentSession = sessionFactory.getCurrentSession();
        Query<TaskHistory> query =
                currentSession.createQuery("from TaskHistory", TaskHistory.class);


        List<TaskHistory> taskHistoryList = query.getResultList();

        return taskHistoryList;
    }

}
