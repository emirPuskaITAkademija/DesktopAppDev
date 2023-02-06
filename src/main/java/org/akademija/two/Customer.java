package org.akademija.two;

public class Customer {
    private String name;
    private String surname;

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    //-1   0   1

    /**
     * Customer c1 = new Customer();
     * Customer c2 = new Customer();
     * c1.compareTo(c2);
     *
     * <li>   -1   c1 MANJI c2  </li>
     * <li>    0    c1 JEDNAK c2</li>
     * <li>    1    c1 VEĆI od c2</li>
     */
//    @Override
//    public int compareTo(Customer o) {
//        int result = name.compareTo(o.getName());
//        if(result == 0){
//            result = surname.compareTo(o.getSurname());
//        }
//        return result;
//    }
}
