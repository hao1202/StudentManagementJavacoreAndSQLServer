package main;

import model.Student;
import service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Student s1 = new Student(5 , "tu" , 20 , "DC" , 9.9f);
                   int result = studentService.addStudent(s1);
            if (result > 0) {
                System.out.println("Thêm thành công");
            }
    }
}
