package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Student;
import util.HibernateUtil;

public class StudentDAO {

    public void saveStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(student);

        tx.commit();
        session.close();
    }
}
