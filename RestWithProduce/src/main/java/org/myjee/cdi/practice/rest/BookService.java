package org.myjee.cdi.practice.rest;

import org.myjee.cdi.practice.rest.entity.Book.BookType;
import org.myjee.cdi.practice.rest.selector.BookSelector;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.logging.Logger;

@Path("/book")
public class BookService {

	@Inject
	private BookSelector selector;

	@Inject
	private Logger logger;

	@GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok("method doGet invoked: " + new Date()).build();
	}

	@GET
	@Path("/{type}")
	@Produces("text/plain")
	public Response getBook(@PathParam("type") String type) {
		logger.info("Input Param: " + type);
		BookType bookType = selector.getBookType(type);
		String result = bookType.name();
		logger.info("Output Result: " + result);
		return Response.ok("Selected Book :" + result).build();
	}

}
