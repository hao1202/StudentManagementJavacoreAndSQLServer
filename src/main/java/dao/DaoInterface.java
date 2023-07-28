package dao;

import java.util.List;

public interface DaoInterface<T> {
    public List<T> getAllData();
    public void displayList();
    public int addStudent(T t);
    public T searchStudentWithId(int id);
}
