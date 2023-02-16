package collection;

import java.util.Arrays;
import java.util.List;

public class TestNote {
    public static void main(String[] args) {
        NoteString note1 = new NoteString("java gc");
        System.out.println(note1.getContent());

        NoteInt note2 = new NoteInt(1);
        System.out.println(note2.getContent());


        //TODO:使用generic 改善
        Note<String> n1 = new Note<String>("java gc");
        System.out.println(n1.getContent());
        
        Note<Integer> n2 = new Note<Integer>(1);
        System.out.println(n2.getContent());
        
        List<String> list = Arrays.asList("Hello","Generic");
        List<Integer> list2 = Arrays.asList(1,2,3);
        //透過Arrays.asList產生的List物件，不能remove,add,但是可以set(index,object)
        list.set(0, "aaa");
        //list.remove("Hello"); //fixed-size
        //list.add("aaa");
        
        
        sumNote(n2);
        
        
    }
    //限制放在方法上
    public static double sumNote(Note<? extends Number>... notes){
        double sum = 0.0;
        for (Note<? extends Number> note : notes) {
            sum = note.getContent().doubleValue();
        }
        return sum / notes.length;
    }

}
