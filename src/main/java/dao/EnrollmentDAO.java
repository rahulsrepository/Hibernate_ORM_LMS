package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Course;
import entity.Enrollment;
import entity.Student;
import util.HibernateUtil;

public class EnrollmentDAO {

    public void enrollStudent(int studentId, int courseId) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, studentId);
        Course course = session.get(Course.class, courseId);

        Enrollment enrollment = new Enrollment(student, course);
        session.save(enrollment);

        tx.commit();
        session.close();
    }
}
