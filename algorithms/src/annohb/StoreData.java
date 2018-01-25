package annohb;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;


public class StoreData {

	public static void main(String[] args) {
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		Employee e1 = new Employee();
		e1.setId(100);
		e1.setFirstName("kathirvel");
		e1.setLastName("Natarajan");
		session.persist(e1);
		tr.commit();
		session.close();
		System.out.println("successfull");

	}

}
