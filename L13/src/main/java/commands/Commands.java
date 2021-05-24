package commands;

public class Commands {

    public void loadClass(String className) throws ClassNotFoundException {
        Class cls = Class.forName(className);
        ClassLoader cLoader = cls.getClassLoader();
        System.out.println();
//        System.out.println("The package is: " + cls.getPackage());
//        System.out.println("Class name is: " + cls.getName());
    }

}
