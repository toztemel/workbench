package reactive;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/location")
public class LocationResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLocations() {
        List<Location> locationList = new ArrayList<Location>() {
            {
                add(new Location("London"));
                add(new Location("Istanbul"));
                add(new Location("Prague"));
            }
        };
        return Response.ok(
                new GenericEntity<List<Location>>(locationList) {})
                .build();
    }
}
