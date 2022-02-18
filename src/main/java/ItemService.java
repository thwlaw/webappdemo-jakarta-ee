import java.util.List;
import java.util.ArrayList;

import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/item")
@Produces(MediaType.APPLICATION_JSON)
public class ItemService {

	@EJB
	private TestItemBean itemService;
	
	@GET
	@Path("/list-t")
	public List<TestItem> list_t()
	{
		List<TestItem> al = new ArrayList<TestItem>();
		al.add(new TestItem(1, "AA", "App"));
		al.add(new TestItem(2, "BB", "Boy"));
		al.add(new TestItem(3, "CC", "Cat"));
		return al;
	}
	
	@GET
	@Path("/detail-t/{id}")
	public Response get_t(@PathParam("id") int id)
	{
		return Response.ok()
				.entity(new TestItem(id, "OO", "KK")).build();
	}

	@GET
	@Path("/list")
	public List<TestItem> list()
	{
		return itemService.list();
	}
	
	@GET
	@Path("/detail/{id}")
	public Response get(@PathParam("id") int id)
	{
		TestItem res = itemService.find(id);
		return Response.ok()
				.entity(res).build();
	}
}
