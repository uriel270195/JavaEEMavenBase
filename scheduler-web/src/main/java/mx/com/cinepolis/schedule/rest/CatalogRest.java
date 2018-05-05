package mx.com.cinepolis.schedule.rest;

import mx.com.cinepolis.scheduler.commons.to.CatalogsTO;
import mx.com.cinepolis.scheduler.commons.to.UserTO;
import mx.com.cinepolis.scheduler.facade.CatalogFacadeEJB;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author jrodriguez
 */
@Path("/catalog")
public class CatalogRest {

    @EJB
    private CatalogFacadeEJB catalogFacadeEJB;
    /*@EJB
    private GithubFacadeEJB	githubFacadeEJB;*/


    @GET
    @Produces("application/json")
    @Path("/users")
    public Response getAllUsers()
    {
    	List<UserTO> userTOList= catalogFacadeEJB.getALLUsers();
    	GenericEntity<List<UserTO>> entity = new GenericEntity<List<UserTO>>(userTOList) {};
		return Response.ok().entity(entity).build();
    }
    
    @POST
    @Produces("application/json")
    @Path("/create")
    public Response setRegistrer(UserTO registrer) {
    	UserTO userTO= catalogFacadeEJB.agregar(registrer);
		return Response.ok().entity(userTO).build();
    }
    
    
    @GET
    @Produces("application/json")
    @Path("/user")
    public Response getSimpleCatalog()
    {
        UserTO userTO = catalogFacadeEJB.getSimpleUser();
        return Response.ok().entity(userTO).build();
    }
    @GET
    @Produces("application/json")
    //@Produces("text/html")//---retorna una pagina web
    @Path("/country/{pais}")
    public Response getEstados(@PathParam("pais") String pais) {
    	List<CatalogsTO> catalogsTOList= catalogFacadeEJB.getEstadosList(pais);
    	//cada vex que retornemos una lista siempre se pone el siguiente codigo para retornar una clase generica
    	GenericEntity<List<CatalogsTO>> entity = new GenericEntity<List<CatalogsTO>>(catalogsTOList) {};
		return Response.ok().entity(entity).build();
    	
    }
    @GET
    @Produces("application/json")
    @Path("/country")
    //country?pais=Mexico
    public Response getEstados(@Context UriInfo ui) {//trae el path completo de la uri
    	MultivaluedMap<String, String> queryParams =  ui.getQueryParameters();
    	String pais = queryParams.getFirst("pais");
    	List<CatalogsTO> catalogsTOList= catalogFacadeEJB.getEstadosList(pais);
    	GenericEntity<List<CatalogsTO>> entity = new GenericEntity<List<CatalogsTO>>(catalogsTOList) {};
		return Response.ok().entity(entity).build();
    	
    }
    
}
