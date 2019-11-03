import java.util.concurrent.atomic.AtomicInteger;

public class Pet {
//    private static final AtomicInteger count = new AtomicInteger(0);
//    public int ID;
    public int age;
    public String name;

    public Pet(String name, int age) {
//        this.ID = count.incrementAndGet();
        this.age = age;
        this.name = name;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
