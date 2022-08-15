import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Standard {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
//        for (String item : list) {
//            if ("3".equals(item)) {
//                list.remove(item);
//            }
//        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("1".equals(item)) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
