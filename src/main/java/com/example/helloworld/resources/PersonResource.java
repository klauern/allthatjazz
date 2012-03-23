package com.example.helloworld.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.helloworld.core.Person;
import com.example.helloworld.db.PeopleDAO;
import com.yammer.dropwizard.jersey.params.LongParam;
import com.yammer.dropwizard.logging.Log;

@Path("/person/{personId}")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    private final PeopleDAO peopleDAO;
    private final Log LOG;

    public PersonResource(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
        LOG = Log.forClass(PersonResource.class);
    }

    @GET
    public Person getPerson(@PathParam("personId") LongParam personId) {
        return peopleDAO.findById(personId.get());
    }
    
    @DELETE
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean deletePerson(@PathParam("personId") LongParam personId) {
    	LOG.debug("Delete called on {}", personId.get());
    	return peopleDAO.deleteById(personId.get());
    }

}
