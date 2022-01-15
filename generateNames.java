String generateNames() {

    String name = "";
    int min = 2;
    int max = 6;
    Random random = new Random();
    int length = random.nextInt(max - min) + min;
     
    //String [] syllables = new String [] {"a","b","c"};
    
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
      
// this one fills the array 'names' with returns for the method 'generateNames'

void packNameArray(){
    String [] names = new String[11];
    
    for ( int i = 0; i <=10; i++){
        names[i] = generateNames();
    }
    
System.out.println(Arrays.toString(names));

}
