package co.edu.uniquindio;

public class MainHasCodeEqualsTest {
    public static void main(String[] args) {
        ComparablePerson persona1 = new ComparablePerson(25);
        persona1.setNombre("Carlos");

        ComparablePerson persona2 = new ComparablePerson(25);
        persona2.setNombre("Carlos");

        ComparablePerson persona3 = new ComparablePerson(30);
        persona3.setNombre("Ana");

        //Equals
        System.out.println(persona1.equals(persona2)); // true
        System.out.println( persona1.equals(persona3)); // false

        //hashCode()
        System.out.println(persona1.hashCode());
        System.out.println(persona2.hashCode());
        System.out.println(persona3.hashCode());
    }
}
