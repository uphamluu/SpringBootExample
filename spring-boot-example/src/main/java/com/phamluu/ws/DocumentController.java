package com.phamluu.ws;  
  
 
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

import java.util.Date;
import java.util.Set;

@RestController  
public class DocumentController {  
	@RequestMapping("/addDocument")
	public void addDocument(){
	try {

		Mongo mongo = new Mongo("localhost", 27017);
		DB db = mongo.getDB("yourdb");

		DBCollection collection = db.getCollection("dummyColl");

		// 1. BasicDBObject example
		System.out.println("BasicDBObject example...");
		BasicDBObject document = new BasicDBObject();
		document.put("database", "mkyongDB");
		document.put("table", "hosting");

		BasicDBObject documentDetail = new BasicDBObject();
		documentDetail.put("records", System.currentTimeMillis());
		documentDetail.put("index", "vps_index1");
		documentDetail.put("active", "true");
		document.put("detail", documentDetail);

		collection.insert(document);

		DBCursor cursorDoc = collection.find();
		while (cursorDoc.hasNext()) {
			System.out.println(cursorDoc.next());
		}
		


	    } catch (MongoException e) {
		e.printStackTrace();
	    }
	}
	
	@RequestMapping("/addUser")
	public void addUser() {
		Mongo mongo = new Mongo("localhost", 27017);
		DB db = mongo.getDB("yourdb");
		DBCollection table = db.getCollection("user");
		BasicDBObject document = new BasicDBObject();
		document.put("name", "mkyong");
		document.put("age", 30);
		document.put("createdDate", new Date());
		table.insert(document);
		
		
		listAllTables(mongo);

	}

	@RequestMapping("/listAllTables")
	public void listAllTables(Mongo mongo) {
		DB db = mongo.getDB("yourdb");
		Set<String> tables = db.getCollectionNames();

		for(String coll : tables){
			System.out.println(coll);
		}
	}
	
	
	
	
	
	
	

}  