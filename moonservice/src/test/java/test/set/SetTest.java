package test.set;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by maguoqiang on 2016/5/3.
 */
public class SetTest {
    @Test
    public void testSet01(){
        Set set=new HashSet();
        set.add("123");
        set.hashCode();
    }

    @Test
    public void testSet02(){
        String labelIds="1,2,2,3,2,3,4,5,1,2,3";
        String[] label = labelIds.split(",");
        List list = Arrays.asList(label);
        Set set = new HashSet(list);
        label=(String [])set.toArray(new String[0]);
        String s=new String();
        for (int i=0;i<label.length;i++){
            s+=label[i];
        }
        System.out.println(s);
    }
}
