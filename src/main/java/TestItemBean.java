
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class TestItemBean {

	@PersistenceContext(unitName = "com.macroview.webappdemo")
	EntityManager entityManager;
	
	public TestItem find(int id) {
		return entityManager.find(TestItem.class, id);
	}
	
	public List<TestItem> list() {
		return entityManager.createQuery("from TestItem", TestItem.class).getResultList();
	}
	
	public void add(TestItem item) {
		entityManager.persist(item);
	}
	
	public void update(TestItem item) {
		entityManager.merge(item);
	}
	
	public void delete(int id) {
		entityManager.remove(find(id));
	}
		
}
