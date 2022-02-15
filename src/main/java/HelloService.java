import java.util.Date;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api")
public class HelloService {

	@GET
	@Path("/hello")
	public String hello() {
		return "["+new Date()+"] hello service";
	}

}
