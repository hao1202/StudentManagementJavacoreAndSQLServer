package service;

import dao.DaoInterface;
import model.Student;
import repository.DBContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements DaoInterface<Student> {
    private List<Student> list;

    public Student createStudent() {
        Integer id = TestInput.inputInteger("id");
        String name = TestInput.inputString("name");
        Integer age = TestInput.inputInteger("age");
        String address = TestInput.inputString("address");
        Float gpa = TestInput.inputDouble("gpa");
        Student student = new Student(id, name, age, address, gpa);
        return student;
    }


    @Override
    public List<Student> getAllData() {
        List<Student> list = new ArrayList<>();
        Connection cn = DBContext.getConnection();
        String SQL = "SELECT * FROM STUDENT";
        try {
            Statement statement = cn.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                list.add(new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("address"),
                        rs.getFloat("gpa")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void displayList() {
        list = getAllData();
        for (Student sv : list) {
            System.out.println(sv);
        }
    }

    @Override
    public int addStudent(Student student) {
        int ketQua = -1;
        Connection cn = DBContext.getConnection();
        String SQL = "insert into STUDENT(id , name , age, address , gpa) " +
                "values (? , ? , ? , ?, ?)";
        try {
            if (searchStudentWithId(student.getId()) != null) {
                System.out.println("Bị trùng id rồi !");
            } else {
                PreparedStatement pre = cn.prepareStatement(SQL);
                pre.setInt(1, student.getId());
                pre.setString(2, student.getName());
                pre.setInt(3, student.getAge());
                pre.setString(4, student.getAddress());
                pre.setFloat(5, student.getGpa());
                ketQua = pre.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public Student searchStudentWithId(int id) {
        Student ketQua = null;
        Connection cn = DBContext.getConnection();
        String SQL = "select * from STUDENT\n" +
                "where id = ?";
        try {
            PreparedStatement pre = cn.prepareStatement(SQL);
            pre.setInt(1, id);

            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                ketQua = new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("address"),
                        rs.getFloat("gpa"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int removeStudent(Student student) {
        int ketQua = -1;
        Connection cn = DBContext.getConnection();
        String SQL = "delete from STUDENT\n" +
                "where id = ?";
        try {
            if (searchStudentWithId(student.getId()) != null) {
                PreparedStatement pre = cn.prepareStatement(SQL);
                pre.setInt(1, student.getId());
                ketQua = pre.executeUpdate();
            } else {
                System.out.println("Không có sinh viên bạn muốn xóa");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ketQua;
    }
}
