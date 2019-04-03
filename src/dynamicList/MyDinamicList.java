package dynamicList;

import javax.jws.Oneway;
import java.lang.reflect.Array;

public class MyDinamicList<T> {


    private int size = 1;
    private T[] data;
    private int lastIndex = 0;

    public MyDinamicList(int size, Class<T> tClass) {
        this.size = size;
        this.data = (T[])Array.newInstance(tClass, size);
    }

    public void add(T value){
        data[lastIndex+1] = value;
        lastIndex++;
        System.out.println(data[lastIndex]);
    }

    public void resizeArray(){
//        T[] arr = (T[])Array.newInstance(tClass, size);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        int index = 0;
        while (index == size-1){
            str.append(data[index]);
            str.append(",");
            index++;
        }
        System.out.println(str.toString());
        return str.toString();
    }
}

