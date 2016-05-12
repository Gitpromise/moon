package test.array;

import org.junit.Test;

import java.util.*;

/**
 * Created by maguoqiang on 2016/4/21.
 *
 */
public class ListDemo {
    @Test
    public void test01(){

        List<Integer> arrayList=new ArrayList<>();//默认放10个数据
        System.out.println(arrayList.size());
        List vector=new Vector();
        long sTime=System.currentTimeMillis();
        for (int i=0;i<9000000;i++){
            arrayList.add(i);
        }
        long eTime=System.currentTimeMillis();
        System.out.println(eTime-sTime);
        /*long startTime=System.currentTimeMillis();
        for (int i=0;i<50000;i++){
            arrayList.add(0,"插入2");
        }
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);*/

    }

    //public static native long currentTimeMillis();
    @Test
    public void testLinkAndArray(){
        List linkList=new LinkedList();
    }

    @Test
    public void testCollection(){
        Collections.synchronizedList(new ArrayList<Object>());
    }

    @Test
    public void testLinkedList(){
        List list=new LinkedList();
        list.get(1);
    }

}
