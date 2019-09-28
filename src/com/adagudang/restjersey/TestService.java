package com.adagudang.restjersey;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.adagudang.db.DbHelper;
import com.adagudang.obj.TestObj;
 
/**
 * @author naveenvemulapalli
 *
 */
@Path("/testservice")
public class TestService {
	private static final Logger LOG = Logger.getLogger(TestService.class.getName());
	
 
  @GET
	@Path("/getbanner")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getbanner() {
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		List<TestObj> lstBanner=new ArrayList<TestObj>();
		try {
			lstBanner=DbHelper.getInstance().getBannerList();
			return Response.status(Response.Status.OK).header("Content-Type", "application/json;charset=UTF-8")
					.entity(lstBanner).type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			LOG.info("Exception on getbanner, message:"+e.getMessage());
			responseMap.put("errMsg", e.getMessage());
			responseMap.put("status","Failed");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(responseMap)
					.type(MediaType.APPLICATION_JSON).build();
		}


	}

}