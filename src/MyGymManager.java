
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.util.List;
import java.util.Scanner;

public class MyGymManager implements  GymManager {
    int max_count = 100;

    private static Scanner input = new Scanner(System.in);


    MongoClient mongoClient = new MongoClient("localhost", 27017);
    MongoDatabase gymDatabase = mongoClient.getDatabase("GymMemberdatabase");
    MongoCollection< Document > collection = gymDatabase.getCollection("gymMembers");


    @Override
    public void addDefaultMember(DefaultMember memberName) {
        MongoCollection< Document > collection = gymDatabase.getCollection("gymMembers");
        System.out.println("Collection Successful!!");

        Document document = new Document()
                .append("Member Name", memberName.getMemberName())
                .append("Membership Number", memberName.getMembershipNumber())
                .append("Membership Start Date", memberName.getMembershipStartDate())
                .append("Type", "Default Member");
        collection.insertOne(document);
        System.out.println("The document included");
        long count = collection.count();
        System.out.println("----------------------------------------------");
        System.out.println(count + "record spaces are used out of 100");
        System.out.println("You can enter " + (this.max_count - count)+" records more!!!");
    }

    @Override
    public void addStudentMember(StudentMember memberName) {

        MongoCollection< Document > collection = gymDatabase.getCollection("gymMembers");
        System.out.println("Collection Successful!!");

        Document document = new Document()
                .append("Member Name", memberName.getMemberName())
                .append("Membership Number", memberName.getMembershipNumber())
                .append("Membership Start Date", memberName.getMembershipStartDate())
                .append("School Name", memberName.getSchoolName())
                .append("Type", "Student Member");
        collection.insertOne(document);
        System.out.println("Document Included");
        long count = collection.count();
        System.out.println("----------------------------------------------");
        System.out.println(count + "record spaces are used out of 100");
        System.out.println("You can enter " + (this.max_count - count)+" records more!!!");
    }

    @Override
    public void addOver60Member(Over60Member memberName) {

        MongoCollection< org.bson.Document > collection = gymDatabase.getCollection("gymMembers");
        System.out.println("Collection Successful!!");

        Document document = new Document()
                .append("Member Name", memberName.getMemberName())
                .append("Membership Number", memberName.getMembershipNumber())
                .append("Membership Start Date", memberName.getMembershipStartDate())
                .append("Age", memberName.getAge())
                .append("Type", "Over 60 Member");
        collection.insertOne(document);
        System.out.println("Document Included");
        long count = collection.count();
        System.out.println("----------------------------------------------");
        System.out.println(count + "record spaces are used out of 100");
        System.out.println("You can enter " + (this.max_count - count)+" records more!!!");
    }


    @Override
    public void deleteMember(int membershipNumber) {

        MongoCollection<Document> collection = gymDatabase.getCollection("gymMembers");
        System.out.println("Collection Successful!!");
        try {
            DeleteResult deleteResult = collection.deleteOne(Filters.eq("Membership Number", membershipNumber));
            if (deleteResult.getDeletedCount() > 0) {
                System.out.println("Deleted Member " + membershipNumber + " Successfully!!!");
            } else {
                System.out.println("Member not found, Couldn't Delete! ");
            }

        } catch (Exception e) {
            System.out.println("Deletion Unsuccessful ");
        }
        long count = collection.count();
        System.out.println("----------------------------------------------");
        System.out.println(count + "record spaces are used out of 100");
        System.out.println("You can enter " + (this.max_count - count)+" records more!!!");

    }


    @Override
    public void viewList() {

        MongoCollection<Document> collection = gymDatabase.getCollection("gymMembers");
        System.out.println("~~~Member List~~~");
        System.out.println();
        for (Document viewList : collection.find()) {
            System.out.println("Member's Name : " + viewList.get("Member Name"));
            System.out.println("Membership Number : " + viewList.get("Membership Number"));
            System.out.println("Membership Start Date : " + viewList.get("Membership Start Date"));
            System.out.println("Membership Type: " + viewList.get("Type"));
            System.out.println();
        }
    }


    @Override
    public void sortMembers() {

        MongoCollection< Document > collection = gymDatabase.getCollection("gymMembers");
        System.out.println("Collection Successful!!");
        System.out.println();
        System.out.println("Sorting Members in Ascending Order!!");
        FindIterable<Document> sortMembers = collection.find().sort(new BasicDBObject("Member Name", 1));
        for (Document sort : sortMembers ){
            System.out.println(sort.get("Member Name") + " : " + sort.get("Membership Number" ));
        }

    }


    @Override
    public void save() {

    }


    @Override
    public List< DefaultMember > getmemberList() {
        return null;
    }

    @Override
    public DefaultMember getmembershipNumber(int membershipNumber) {
        return null;
    }

    @Override
    public DefaultMember[] getmemberbyname(String memberName) {
        return new DefaultMember[0];
    }
}