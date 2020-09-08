import java.lang.reflect.Constructor;

class Bob {
    public int test;

    public Bob(Integer test) {
        this.test = test;
    }

    public int getTest() {
        return this.test;
    }
}
public class Test {
    public static void main(String[] args){
        try{
            Class<?> clazz = Class.forName("Bob");
            Constructor<?> ctor = clazz.getConstructor(Integer.class);
            Bob object = (Bob) ctor.newInstance(new Object[] { 42 });
            System.out.println(object.getTest());
        } catch (Exception e){
            System.out.println(e);
        }
    }
}

