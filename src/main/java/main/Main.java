package main;

import model.Student;
import service.StudentService;
import service.TestInput;

public class Main {
    public final static StudentService studentService = new StudentService();

    public static void main(String[] args) {
        int choose;
        while (true) {
            studentService.listFunction();
            choose = TestInput.inputInteger("lua chon cua ban");
            switch (choose) {
                case 1:
                {
                    studentService.addStudent(studentService.createStudent());
                }break;
                case 2:
                {
                    studentService.displayList();
                }break;
                case 3:
                {
                    int id = TestInput.inputInteger("id cần tìm");
                    Student student = studentService.searchStudentWithId(id);
                    if (student != null) {
                        System.out.println("Tìm thấy");
                        System.out.println(student);
                        studentService.removeStudent(student);
                        System.out.println("Xóa thành công");
                    } else {
                        System.out.println("Không có sinh viên bạn muốn xóa");
                    }
                }break;
                case 4:
                {
                    int id = TestInput.inputInteger("id cần tìm");
                    Student student = studentService.searchStudentWithId(id);
                    if (student != null) {
                        System.out.println("Tìm thấy");
                        System.out.println(student);
                        System.out.println("Thực hiện sửa");
                        student.setName(TestInput.inputString("ten cần sửa"));
                        student.setAge(TestInput.inputInteger("tuoi cần sửa"));
                        student.setAddress(TestInput.inputString("dia chi cần sửa"));
                        student.setGpa(TestInput.inputDouble("gpa cần sửa"));
                        studentService.updateStudent(student);
                        System.out.println("Sửa thành công");
                    } else {
                        System.out.println("Không có sinh viên bạn muốn sửa");
                    }
                }break;
                case 0: {
                    return;
                }
                default:
                {
                    System.out.println("Không có lưa chọn này !");
                }break;
            }
        }
    }
}
