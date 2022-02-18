import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

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
		man.close();
	}

}
