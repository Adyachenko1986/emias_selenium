package pages.utilities;

import org.hibernate.Session;
import pages.sql.HltCallDoctorEntity;

public class HibernateSession {
    public static Session session;

    void run() {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        HltCallDoctorEntity hltCallDoctorEntity = new HltCallDoctorEntity();
        hltCallDoctorEntity.setBirthDate(new java.util.Date());

        session.save(hltCallDoctorEntity);

    }

    void close() {
        session.getTransaction().commit();
        session.close();
    }
}