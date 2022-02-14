import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "testitem")
public class TestItem {
	
	@Id
	Integer id;
	String item_name;
	String item_value;
	boolean status;
	Date last_updated;

	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append(id);
		buf.append(": "+item_name);
		buf.append(" - "+item_value);
		buf.append(" ("+status+") " );
		buf.append(last_updated);
		return buf.toString();
	}
}
