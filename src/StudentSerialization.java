import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public void displayDetails() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Student GPA: " + gpa);
    }
}

public class StudentSerialization {

    public static void serializeStudent(Student student, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(student);
            System.out.println("Student details saved successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error: Unable to write to file.");
        }
    }

    public static Student deserializeStudent(String fileName) {
        Student student = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            student = (Student) in.readObject();
            System.out.println("Reading from file...");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error: Unable to read from file.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found.");
        }
        return student;
    }

    public static void main(String[] args) {
        Student student = new Student(101, "John Doe", 3.8);
        String fileName = "student.ser";
        serializeStudent(student, fileName);
        Student deserializedStudent = deserializeStudent(fileName);
        if (deserializedStudent != null) {
            deserializedStudent.displayDetails();
        }
    }
}
