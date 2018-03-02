package com.javatpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

@RestController
public class JSONServiceWithMongo {

	
	@RequestMapping(value="/listProductInMongo", method=RequestMethod.GET )
	@Produces("application/json")
	public void listProductInMongo() {
//		List<Product> results= new ArrayList<>();
		
		Mongo mongo = new Mongo("localhost", 27017);
		DB db = mongo.getDB("yourdb");
		DBCollection collection = db.getCollection("PRODUCT_TBL");
		DBCursor cursorDoc = collection.find();
		ObjectMapper mapper = new ObjectMapper();
		while (cursorDoc.hasNext()) {
//			results.add((Product) cursorDoc.next());
//			DBObject object = cursorDoc.next();
			
			
			String jsonInString = cursorDoc.next().toString();
			
//			try {
				System.out.println(jsonInString);
//				Product user = mapper.readValue(jsonInString, Product.class);
//				results.add(user);
//			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (JsonMappingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
//		return results;
		
		
	}
	
	@RequestMapping(value="/dropProductTable", method=RequestMethod.GET )
	public void dropProductTable() {
		
		Mongo mongo = new Mongo("localhost", 27017);
		DB db = mongo.getDB("yourdb");
		DBCollection collection = db.getCollection("PRODUCT_TBL");
		collection.drop();
		
	}
	

	@Consumes("application/json")
	@RequestMapping(value="/postProductInJSONInMongo", method=RequestMethod.POST, produces = "application/json")
	public  @ResponseBody Response createProductInJSON( @RequestBody String jsonInString,HttpServletRequest request,
	        HttpServletResponse response) {


			DBObject dbObject = (DBObject) JSON.parse(jsonInString);
			

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("yourdb");
			DBCollection table = db.getCollection("PRODUCT_TBL");
			
			table.insert(dbObject);
			
			return Response.status(201).entity(jsonInString).build();


	}

}