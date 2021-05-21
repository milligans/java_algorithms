public class ExampleSingleton{
    private int accessCount =0;
    private static ExampleSingleton instance = new ExampleSingleton();

    private ExampleSingleton(){
        System.out.println("I, the ExampleSingleton, am being created");

    }
    public static ExampleSingleton getInstance()
            //checking that there is no existing instance of the ExampleSingleton
            //as there should be only one
    {   if (instance == null){
        instance= new ExampleSingleton();

    }
        System.out.println("The sole instance of ExampleSingleton is being retrieved");

        return instance;
    }
    public int accessCount(){
        accessCount = accessCount + 1;
        return accessCount;

    }


}