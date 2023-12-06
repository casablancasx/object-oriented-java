package entities;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class PrintService<T> {
    private List<T> list = new ArrayList<>();
    public PrintService(){}

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void addValue(T value){
        list.add(value);
    }
    public T firt(){
        return list.get(0);
    }

    public void print(){
        if (list.isEmpty()){
            System.out.println("[]");
        }else {
            System.out.print("[" + firt());
            for (int i = 1; i < list.size(); i++) {
                System.out.print(", " + list.get(i));
            }
            System.out.print("]");
        }
    }
}
