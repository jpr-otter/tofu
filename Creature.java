import java.util.Random;

public class Creature {

    String name;
    int age;
    boolean kind;
    int counter = 0 ;
    int health;
    Creature[] parentOf = new Creature[5];

    static Random rando = new Random();

    Creature (){
        this(createName(),(rando.nextInt(500) + 1),rando.nextInt(2) == 0, rando.nextInt(100) + 1);               
    }
// "rando.nextInt(2) == 0" gives either 1 or 0, interpreted as boolean, so true or false
// but could also be "rando.nextBoolean()" to get a random true or false

    Creature(String name, int age, boolean kind, int health){
        assert age >= 1:"Age is invalid";
        assert name != null && !name.isEmpty():"Creature needs a name!";
        assert health >= 1 && health <= 100:"Health needs be in between 1 and 100";
        this.name = name;
        this.age = age;
        this.kind = kind;
        this.health = health;
    }


    public static String createName(){
        String name = "";
        int min = 2;
        int max = 6;
        Random random = new Random();
        int length = random.nextInt(max - min) + min;
     
        String [] syllables = new String[] {"ka","ki","ku","ke","ko",
                                    "sa","shi","su","se","so",
                                    "ta","chi","tsu","te","to",
                                    "ha","hi","fu","he","ho",
                                    "ma","mi","mu","me","mo"};                               
    
        for (int i = 0; i < length; i++){
            name += syllables[(int) (Math.random() * syllables.length)];        
            //System.out.println ("name: " + name);
        }
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;
    }

    void decreaseHealth (int amount){
        assert amount >= 0;
        health -= amount;
        if (health < 0) health = 0;
    }

    void increaseHealth (int amount){
        assert amount >=0;
        health += amount;
        if (health > 100) health = 100;
    }

    void giveKindness (){
        assert kind == false:"Already kind enough";
        kind = true;
    }

    boolean canMergeWith(Creature other){
        if (this == other) return false;
        if (this.health < 50 || other.health < 50) return false;
        if (this.counter >= parentOf.length) return false;
        if (this.age < 20 || other.age < 20) return false;   
        if (this.kind == false || other.kind == false) return false;
        return true;
        // could be written as a oneliner:
        // "return  this != other && this.health >= 50 && other.health >= 50 && counter < parentOf.length;"
    }

    
    Creature mergeWith(Creature other){
        assert canMergeWith(other) : "Unable to merge with " + other;
        boolean kindness = this.kind == other.kind ? this.kind : rando.nextInt(2) == 0;
        Creature offspring = new Creature(createName(), age = 1, kindness, (this.health + other.health) / 2);
        parentOf[counter++] = offspring;
        decreaseHealth(20);
        return offspring;
    }

    public String toString(){
        
        return "" + name + " (" + "Age: " + age +" | "+ "Socialstatus: " + (kind ? "kind" : "unkind") + " | " + "Health: " + health + ")";
    }
        
}
