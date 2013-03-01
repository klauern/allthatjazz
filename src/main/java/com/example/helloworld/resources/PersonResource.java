package com.example.helloworld.resources;

import java.util.LinkedList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.example.helloworld.core.Person;
import com.example.helloworld.db.PeopleDAO;
import com.yammer.dropwizard.jersey.params.LongParam;
import com.yammer.dropwizard.logging.Log;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    private final PeopleDAO peopleDAO;
    private final Log LOG;

    public PersonResource(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
        LOG = Log.forClass(PersonResource.class);
    }

    @GET
    @Path("/{personId}")
    public Person getPerson(@PathParam("personId") LongParam personId) {
        return peopleDAO.findById(personId.get());
        
    }

	@POST
	public Response createPerson(Person person) {
		LOG.info("POST called with name {} and job {}", person.getFullName(), person.getJobTitle());
		long id = peopleDAO.create(person);
		LOG.info("created person with id {}", id);
		Person p = peopleDAO.findById(id);
		return Response.created(UriBuilder.fromPath("/person").build(p.getId())).build();
	}

//	@POST
//	public Response createPerson(Person p) {
//		LOG.info("POST called with person {}", p);
//		long id = peopleDAO.create(p);
//		LOG.info("create person with id {}", id);
//		return Response.created(UriBuilder.fromPath("/person").build(peopleDAO.findById(id))).build();
//	}

}
