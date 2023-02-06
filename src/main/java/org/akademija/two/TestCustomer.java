package org.akademija.two;

import java.util.ArrayList;
import java.util.List;

public class TestCustomer {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Ivica", "Stanić"));
        customers.add(new Customer("Eldar", "Pediša"));
        customers.add(new Customer("Eldar", "Halilović"));
        customers.add(new Customer("Martin", "Filipović"));
        customers.add(new Customer("Alden", "Efendić"));
        //customers.forEach(c-> System.out.println(c));
        //Comparator<Customer> comparator = (c1, c2) -> TestCustomer.uporediKupce(c1, c2);
        //Comparator<Customer> comparator1 = (c1,c2) -> TestCustomer.porediKupce(c1);
        //Comparator<Customer> comparator = TestCustomer::uporediKupce;
        customers.stream()//
                .sorted(TestCustomer::uporediKupce)//
                .forEach(System.out::println);
    }

    //    static int porediKupce(Customer c1){
//        return 0;
//    }
    static int uporediKupce(Customer c1, Customer c2) {
        int result = c1.getName().compareTo(c2.getName());
        if (result == 0) {
            result = c1.getSurname().compareTo(c2.getSurname());
        }
        return result;
    }
}
