package test.compare;

import java.util.HashMap;

/**
 * Created by maguoqiang on 2016/3/24.
 */
public class TestComparable {
    private static HashMap<Integer, Student> studentMap;

    public static void main(String[] args) {
        loadStudent();
        for(Student student : studentMap.values()) {
            System.out.println("ID:" + student.getId() + "  NAME:" + student.getName() + "  SEX:" + student.getSex());
        }
    }

    private static void loadStudent() {
        studentMap = new HashMap<Integer, Student>();
        //请无视我对学生的命名吧。。。。毕竟用来测试的 呵呵
        Student student0 = new Student(2, "张二", 0);
        Student student1 = new Student(4, "张四", 1);
        Student student2 = new Student(6, "张六", 1);
        Student student3 = new Student(1, "张一", 0);
        Student student4 = new Student(3, "张三", 0);
        Student student5 = new Student(8, "张八", 1);
        Student student6 = new Student(9, "张九", 0);
        Student student7 = new Student(7, "张七", 1);
        Student student8 = new Student(0, "张零", 0);
        Student student9 = new Student(5, "张五", 0);
        studentMap.put(student0.getId(), student0);
        studentMap.put(student1.getId(), student1);
        studentMap.put(student2.getId(), student2);
        studentMap.put(student3.getId(), student3);
        studentMap.put(student4.getId(), student4);
        studentMap.put(student5.getId(), student5);
        studentMap.put(student6.getId(), student6);
        studentMap.put(student7.getId(), student7);
        studentMap.put(student9.getId(), student9);
        studentMap.put(student8.getId(), student8);
        studentMap.put(student0.getId(), student0);
    }
}
