package mx.com.cinepolis.schedule.rest;


import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import mx.com.cinepolis.scheduler.commons.to.GithubUserTO;
import mx.com.cinepolis.scheduler.facade.GithubFacadeEJB;

/**
 * @author uriel270195
 */
@Path("/github")

public class GithubRest {
	@EJB
    private GithubFacadeEJB	githubFacadeEJB;
	
	@GET
    @Produces("application/json")
    @Path("/user/{login}")
    public Response getInfo(@PathParam("login") String login) {
    	GithubUserTO GithubUserTO= githubFacadeEJB.getInfoGithub(login);
		return Response.ok().entity(GithubUserTO).build();
    }
    
    @GET
    @Produces("application/json")
    @Path("/login")
    //login?login=uriel270195
    public Response getlogin(@Context UriInfo ui) {
    	MultivaluedMap<String, String> queryParams =  ui.getQueryParameters();
    	String login = queryParams.getFirst("login");
    	String pass = queryParams.getFirst("pwd");
    	GithubUserTO validate= githubFacadeEJB.getLoginGithub(login, pass);
		return Response.ok().entity(validate).build();
    	
    }
    @POST
    @Produces("application/json")
    @Path("/alta")
    public Response setRegistrer(GithubUserTO registrer) {
    	GithubUserTO GithubUserTO= githubFacadeEJB.setRegistrerGithub(registrer);
		return Response.ok().entity(GithubUserTO).build();
    }

}
