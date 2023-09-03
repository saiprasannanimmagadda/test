import org.bson.Document;
import java.util.*;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.*;
import com.mongodb.*;

public class MongoTest {

	private static String randomString() {
		// TODO Auto-generated method stub
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		
		int length = 7;
		for(int i=0;i< length;i++) {
			int index = r.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
			
		}
		String randomString = sb.toString();
		
		return randomString;
		
	}
	

	public static void main(String[] args) {
		
		
		
		// Creating a Mongo client 
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 ); 
		System.out.println("Created Mongo Connection successfully"); 
		
		// Creating a Database
		
		MongoDatabase db = mongoClient.getDatabase("Hospital_Management_System");
		System.out.println("Get database is successful");
		 
		Random r1 = new Random();
		
		
	   //Inserting sample record by creating collection and document.
		   MongoCollection<Document>  collection1= db.getCollection("bills");
		   MongoCollection<Document>  collection2= db.getCollection("doctor");
		   MongoCollection<Document>  collection3= db.getCollection("hospital");
		   // MongoCollection<Document>  collection4= db.getCollection("inpatient");
		   MongoCollection<Document>  collection5= db.getCollection("insurance");
		   MongoCollection<Document>  collection6= db.getCollection("inventory");
		   MongoCollection<Document>  collection7= db.getCollection("lab_reports");
		   MongoCollection<Document>  collection8= db.getCollection("nurse_data");
		   MongoCollection<Document>  collection9= db.getCollection("patient");
		   MongoCollection<Document>  collection10= db.getCollection("pharmacy");
		   
		  
		   
		   for(int i=0;i<10;i++) {
		   Document doc =new Document("patient_id",r1.nextInt(1000)).append("name", randomString()).append("weight", r1.nextFloat(100))
				   .append("main_disease", randomString()).append("height",r1.nextInt(6)).append("phone","9876"+r1.nextInt(9)+"4320"+r1.nextInt(9))
				   .append("emailid",randomString()+i+"@gmail.com").append(randomString(), i+ "street, NewBedford").append("blood_group", "B positive")
				   .append("sex","F").append("age", r1.nextInt(100)).append("admit_id", r1.nextInt());
		 
		   collection9.insertOne(doc);
		   
		   }
		   for(int i=0;i<10;i++) {
			 
			   Document doc =new Document("hospital_id",r1.nextInt(100))
			   .append("HospitalName", randomString()).append("address", randomString()+i+ "street, NewBedford")
					   .append("City Name", randomString()).append("State", "MA").append("ZIPCODE", r1.nextInt(5))
					   .append("phone","900080120"+i).append("beds_available",r1.nextInt(100)).append("doctors_count", r1.nextInt(100))
					   .append("hospital_overall_rating",r1.nextDouble(6));
			  
			   collection3.insertOne(doc);
		   }
		   for(int i=0;i<10;i++) {
			   Document doc =new Document("doctor_id",r1.nextInt(100))
					   .append("hosp_id", r1.nextLong(100000)).append("doctor_name",randomString() )
							   .append("doc_email", randomString()+"@gmail.com").append("'doc_phone'", "9389"+r1.nextInt(9)+"8933"+r1.nextInt(9));
					  
					   collection2.insertOne(doc);
		   }
		   for(int i=0;i<10;i++) {
				 
			   Document doc =new Document("bills_id","bil"+r1.nextInt(100))
			   .append("cash", r1.nextLong(100000)).append("total_amount", r1.nextLong(150000))
					   .append("due_amount", r1.nextInt(50000)).append("paid_amount", r1.nextInt(100000)).append("patient_id", r1.nextInt(1000))
					   .append("hospital_id",r1.nextInt(100));
					  
			  
			   collection1.insertOne(doc);
		   }
		   for(int i=0;i<10;i++) {
				 
			   Document doc =new Document("insurance_id",randomString()+r1.nextInt(10))
			   .append("hospital_insurance_tieup", "Yes").append("corporate_insurance", r1.nextInt(1000))
					   .append("personal_insurance",r1.nextInt(1000) ).append("patient_id", r1.nextInt(1000));
					  
			  
			   collection5.insertOne(doc);
		   }
		   for(int i=0;i<10;i++) {
				 
			   Document doc =new Document("inventory_id",randomString()+r1.nextInt(10))
			   .append("material", randomString()).append("unitprice", r1.nextInt(200))
					   .append("cost", r1.nextInt(1000)).append("hosp_id", randomString()+r1.nextInt(100)).append("inv_count", r1.nextInt(500));
					  
			  
			   collection6.insertOne(doc);
		   }
		   for(int i=0;i<10;i++) {
				 
			   Document doc =new Document("hosp_id",randomString()+r1.nextInt(100))
			   .append("medicine_id", randomString()+r1.nextInt(10)).append("medicine_name", randomString())
					   .append("medicine_count", r1.nextInt(1000)).append("purchase_amount", r1.nextInt(10000)).append("dosage", r1.nextInt(20));
					  
			  
			   collection10.insertOne(doc);
		   }
		   for(int i=0;i<10;i++) {
				 
			   Document doc =new Document("branch_id",randomString()+ r1.nextInt(9))
			   .append("branch_name", randomString()).append("patient_id", r1.nextInt(1000));
					  collection7.insertOne(doc);
		   }
		   for(int i=0;i<10;i++) {
				 
			   Document doc =new Document("nurse_id",randomString()+r1.nextInt(9))
			   .append("nurse_name", randomString()).append("hosp_id", r1.nextInt(100));
					  collection8.insertOne(doc);
		   }

	}


}
