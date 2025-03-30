package main.java.miscellaneous;

import java.util.HashMap;
import java.util.Map;
import main.java.models.Employee;

public class HashMapMain {

        public static void main(String[] args) {


            Employee emp1 = null;
            Map<Employee,String> hm = new HashMap<Employee,String>();
            hm.put(emp1, "Verified");
            emp1.setName("John");

            for (Map.Entry element: hm.entrySet()
                 ) {
                element.getKey();
                element.getValue();
            }
            System.out.println(hm.get(emp1));
        }
}
