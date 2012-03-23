package com.example.helloworld.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.example.helloworld.core.Person;
import com.example.helloworld.db.PeopleDAO;

@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
public class PeopleResource {

    private final PeopleDAO peopleDAO;

    public PeopleResource(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @POST
    public Person createPerson(Person person) {
        final long personId = peopleDAO.create(person);
        return peopleDAO.findById(personId);
    }
    
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public Person createPerson(MultivaluedMap<String, String> form) {
    	Person p = new Person();
    	p.setFullName(form.getFirst("fullName"));
    	p.setJobTitle(form.getFirst("jobTitle"));
    	return createPerson(p);
    }

    @GET
    public List<Person> listPeople() {
        return peopleDAO.findAll();
    }

}
