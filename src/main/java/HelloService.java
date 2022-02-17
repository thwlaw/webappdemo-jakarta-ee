import java.util.Date;

import jakarta.servlet.ServletContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public class HelloService {

	@Context
	ServletContext servletContext;
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "["+new Date()+"] hello service";
	}

	@GET
	@Path("/info")
	@Produces(MediaType.TEXT_PLAIN)
	public String info() {
		StringBuilder bdr = new StringBuilder();
		bdr.append("Conext path: "+servletContext.getContextPath());
		
		return bdr.toString();
	}
}
