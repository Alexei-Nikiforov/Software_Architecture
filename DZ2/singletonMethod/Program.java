package singletonMethod;

public class Program {
    
    public static void main(String[] args) {
        
        Singleton o1 = Singleton.getInstance();
        System.out.println(o1.hashCode());

        Singleton o2 = Singleton.getInstance();
        System.out.println(o2.hashCode());

    }
}
