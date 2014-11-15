package com.fan1tuan.general.webservices;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fan1tuan.test.Person;
import com.fan1tuan.test.TestBean;

@Path("test")
public class Fan1TuanWebserviceTest {
	private static final Logger LOGGER = Logger.getLogger(Fan1TuanWebserviceTest.class.getName());
	
	private TestBean testBean; //injection
	public void setTestBean(TestBean testBean){
		this.testBean = testBean;
	}
	
	public Fan1TuanWebserviceTest() {
        LOGGER.fine("HelloWorldResource()");
    }

	@GET
	@Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return String.format("%s: %s", new Date().toString(), "Fan1Tuan - Webservice Test");
    }
	
	@GET
	@Path("find/{username}")
	@Produces("text/html")
	public String getUserInfo(@PathParam("username") String username){
		//testBean.insertDocument(username, 18, new String[]{"handsome"});
		//Person person = testBean.findOne("lihe");
		Person person = new Person();
		person.setName(username);
		person.setAge(18);
		person.setSex(0);
		
		return "<h1>The user "+username+" you are finding has the infos as following:</h1><p><b>age: "+person.getAge()+", sex: "+person.getSex()+".</b></p>";
	}
	
	@GET
	@Path("user")
    @Produces(MediaType.TEXT_PLAIN)
    public String getUserInfoWithParam(
    		@DefaultValue("jim") @QueryParam("username") String username) {
		//Person person = testBean.findOne("lihe");
		Person person = new Person();
		person.setName(username);
		person.setAge(18);
		person.setSex(0);
		return "<h1>(By Param)The user "+username+" you are finding has the infos as following:</h1><p><b>age: "+person.getAge()+", sex: "+person.getSex()+".</b></p>";
    }
	
	@POST
	@Path("update")
	@Consumes("application/x-www-form-urlencoded")
	public Response updateInfo(@FormParam("name") String name,
			@FormParam("age") int age,
			@FormParam("sex") int sex){
		Person person = testBean.findOne(name);
		
		person.setAge(age);
		person.setSex(sex);
		
		URI uri = null;
		try {
			uri = new URL("http://www.baidu.com").toURI();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return Response.created(uri).build();
	}
	
}
