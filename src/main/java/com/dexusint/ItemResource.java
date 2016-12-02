package com.dexusint;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "item" path)
 */
@Path("/item")
public class ItemResource {
	@Context UriInfo uriInfo;
	
	@GET
	@Path("content")
	public ItemContentResource getItemContentResource() {
		return new ItemContentResource();
	}
	
	@GET
	@Path("text")
	@Produces(MediaType.TEXT_PLAIN)
	public String get() {
		return "Here";
	}
}

class ItemContentResource {
//	public Response get() {
//		
//	}

    @GET
    @Path("{version}")
    public String put(@PathParam("version") int version,
    				@Context HttpHeaders headers,
    				byte[] in) {
    	return "Got it!";
    }
}
