package com.wakkir.designpattern.TransferObjectPattern;

/**
 * User: wakkir.muzammil
 * Date: 29/10/13
 * Time: 17:31
 */
/*
The Transfer Object pattern is used when we want to pass data with multiple attributes in one shot from client to server. Transfer object is also known as Value Object. Transfer Object is a simple POJO class having getter/setter methods and is serializable so that it can be transferred over the network. It do not have any behavior. Server Side business class normally fetches data from the database and fills the POJO and send it to the client or pass it by value. For client, transfer object is read-only. Client can create its own transfer object and pass it to server to update values in database in one shot. Following are the entities of this type of design pattern.

    Business Object - Business Service which fills the Transfer Object with data.

    Transfer Object -Simple POJO, having methods to set/get attributes only.

    Client - Client either requests or sends the Transfer Object to Business Object.

Implementation:
We're going to create a StudentBO as Business Object,Student as Transfer Object representing our entities.

TransferObjectPatternDemo, our demo class is acting as a client here and will use StudentBO and Student to demonstrate Transfer Object Design Pattern.
*/
public class TransferObjectPatternDemo
{
    public static void main(String[] args)
    {
        StudentBO studentBusinessObject = new StudentBO();

        //print all students
        for (StudentVO student : studentBusinessObject.getAllStudents())
        {
            System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
        }

        //update student
        StudentVO student = studentBusinessObject.getAllStudents().get(0);
        student.setName("Michael");
        studentBusinessObject.updateStudent(student);

        //get the student
        studentBusinessObject.getStudent(0);
        System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
    }
}
