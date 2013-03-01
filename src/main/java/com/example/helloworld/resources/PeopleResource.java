package com.example.helloworld.resources;

import com.example.helloworld.core.Person;
import com.example.helloworld.db.PeopleDAO;
import com.yammer.dropwizard.jersey.caching.CacheControl;
import com.yammer.dropwizard.jersey.params.LongParam;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
public class PeopleResource {
    private static final Logger LOG = LoggerFactory.getLogger(PeopleResource.class);

    private final PeopleDAO peopleDAO;

    public PeopleResource(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @GET
    @CacheControl(maxAge = 2, maxAgeUnit = TimeUnit.MINUTES)
    public List<Person> listPeople() {
        LOG.debug("Listing all people");
        List<Person> ppl = peopleDAO.findAll();
        LOG.debug("size of ppl is {}", ppl.size());
        return ppl;
    }

    @DELETE
    @Path("/{personId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deletePerson(@PathParam("personId") LongParam personId) {
        LOG.info("Deleting {} out", personId);
        this.peopleDAO.deleteById(personId.get());
        LOG.info("deleted, returning response");
        return Response.ok().build();
    }
}
