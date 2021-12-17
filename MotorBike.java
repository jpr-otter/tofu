public class MotorBike{

    // state
    boolean engineRunning = false;  // instance variables, member or field variable
    private int speed = 0;  // if you would add a static once the variable had a value...
                            // ...the value will be set for all instances of that class
    public int BHP;

    // not relevant for the jshell
    public static void main (String[] args){

        MotorBike ducati = new MotorBike();  // creates an instance of a class 
        MotorBike honda = new MotorBike(); 
        MotorBike aprilla = new MotorBike();

    }

    boolean start(){
        System.out.println ("Engine started.");
        return engineRunning = true;
    }

    boolean terminate(){
        assert speed == 0 : "Too fast to shut engine down!";
        System.out.println ("Engine turned off.");
        return engineRunning = false;
    }

    boolean checkEngine(){
        if (engineRunning == false){
            System.out.println("Engine is turned off.");    
        }else{
            System.out.println("Engine is turned on.");
        }
        return engineRunning;
    }
    
    void setSpeed(int speed){
        if (engineRunning == true){
            this.speed = speed;
            if (speed >= 0){
                System.out.println("Set speed to " + this.speed);
                System.out.println("called through method 'getSpeed' " + getSpeed());
            } else {
                System.out.println("Speed value invalid.");
            }
            
        } else {
            System.out.println("Engine still off!");
        }
    }
    
    // input
    int getSpeed(){
        return this.speed;
    }

    void setBHP (int BHP){
        this.BHP = BHP;

    }

    int getBHP(){
        return this.BHP;
    }
   
}

