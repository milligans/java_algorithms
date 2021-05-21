public class CelsiusToFahrenheitLoggerAdapter extends CelsiusLogger {
    FahrenheitLogger aFHL = new FahrenheitLogger();

    public void setTemperature(double aCelsiusTemperature){
        aFHL.setTheTemperature(aCelsiusTemperature * 9/5 + 32);

    }
    public double getTemperature(){
        //test line below to check that the functionality for the Fahrenheit logger is working in the
        //context of this adapter
        System.out.println("The temp in Fahrenheit is " + aFHL.getTheTemperature() + " Fahrenheit");
        return (aFHL.getTheTemperature() - 32) * 5/9 ;

    }

}