public class Person {
    private String name;
    private int age;
    private boolean married;
    private Adress homeAdress;

    public Person(){


    }


    public Person(String name, int age, boolean married) {
        this();
        this.name = name;
        this.age = age;
        this.married = married;
    }

    public Person(String name, int age, boolean married, Adress homeAdress) {
        this(name, age, married);
        this.homeAdress = homeAdress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public Adress getHomeAdress() {
        return homeAdress;
    }

    public void setHomeAdress(Adress homeAdress) {
        this.homeAdress = homeAdress;
    }

    void walk(int km){
        System.out.println(name + "is walking " +  km + "kms.");
    }

    int calculateBirthYear(){
        return 2022 - age;
    }
}
