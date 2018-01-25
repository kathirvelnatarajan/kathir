package firsthb;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cong.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		Employee e1 = new Employee();
		e1.setId(10);
		e1.setFirstName("Kathir");
		e1.setLastName("Vel");
		session.persist(e1);
		trans.commit();
		session.close();
		System.out.println("success");
		
	}

}
