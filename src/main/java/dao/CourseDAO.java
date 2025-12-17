package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Course;
import util.HibernateUtil;

public class CourseDAO {

    public void saveCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(course);

        tx.commit();
        session.close();
    }
}
