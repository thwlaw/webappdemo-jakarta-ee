import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "testitem")
public class TestItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String item_name;
	String item_value;
	boolean status;
	@UpdateTimestamp
	Date last_updated;
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getItem_name() { return item_name; }
	public void setItem_name(String n) { item_name = n; }
	public String getItem_value() { return item_value; }
	public void setItem_value(String v) { item_value = v; }
	public boolean getStatus() { return status; }
	public void setStatus(boolean s) { status = s; }
	public Date getLast_updated() { return last_updated; }
	public void setLast_updated(Date d) { last_updated = d; }

	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append(id);
		buf.append(": "+item_name);
		buf.append(" - "+item_value);
		buf.append(" ("+status+") " );
		buf.append(last_updated);
		return buf.toString();
	}
	
	public TestItem() {
		last_updated = new Date();
	}
	public TestItem(int itemid, String n, String v)
	{
		id = itemid;
		item_name = n;
		item_value = v;
		status = false;
		last_updated = new Date();
	}
}
