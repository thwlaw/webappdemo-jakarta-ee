import java.util.List;
import java.util.ArrayList;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/item")
@Produces(MediaType.APPLICATION_JSON)
public class ItemService {

	@GET
	@Path("/list")
	public List<TestItem> list()
	{
		ArrayList<TestItem> al = new ArrayList<TestItem>();
		al.add(new TestItem(1, "AA", "App"));
		al.add(new TestItem(2, "BB", "Boy"));
		al.add(new TestItem(3, "CC", "Cat"));
		return al;
	}
	
	@GET
	@Path("/detail/{id}")
	public Response item(@PathParam("id") int id)
	{
		return Response.ok()
				.entity(new TestItem(id, "OO", "KK")).build();
	}

}
