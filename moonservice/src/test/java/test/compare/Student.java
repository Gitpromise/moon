package test.compare;

import lombok.Data;

/**
 * Created by maguoqiang on 2016/3/24.
 */
@Data
public class Student {
    private int id;
    private String name;
    private int sex;

    public Student(int id, String name, int sex) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
}

