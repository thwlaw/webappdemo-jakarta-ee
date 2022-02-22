import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestJPA {

	public static void main(String[] args) {

		EntityManagerFactory manFact = Persistence.createEntityManagerFactory("com.macroview.webappdemo");
		EntityManager man = manFact.createEntityManager();
		List<TestItem> items = man.createQuery("from TestItem", TestItem.class).getResultList();
		System.out.println("Total "+ items.size() + " items");
		for (TestItem item : items) {
			System.out.println(item.toString());
		}
		
		TestItem it = man.find(TestItem.class, 1);
		System.out.println(it);
		
		TestItem nitm = new TestItem(0, "JJ", "BB");
		man.getTransaction().begin();
		man.persist(nitm);
		man.getTransaction().commit();
		System.out.println(nitm+" added");
		man.close();
	}

}
