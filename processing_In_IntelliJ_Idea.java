import processing.core.PApplet;

public class Main extends PApplet {

    //Spot sp1, sp2;


    public static void main(String[] args) {
        PApplet.main(new String[]{Main.class.getName()});
    }
    @Override
    public void settings() {
        //size(600, 400 );

    }

    @Override
    public void setup() {
        //background(204);
        //noLoop();
        //sp1 = new Spot(this);
        //sp2 = new Spot(this,width * 0.5f, height * 0.5f, 120);

    }

    @Override
    public void draw() {

        //sp1.display();
        //sp2.display();
        //circle(300,200,100);

    }
}


// another example class file!

import processing.core.PApplet;


public class Spot {
    PApplet p5;
    float x, y, radius;
    Spot(PApplet p5){
        this.p5 = p5;
        radius = 40;
        x = p5.width * 0.25f;
        y = p5.height * 0.5f;
    }
    Spot(PApplet p5, float xpos, float ypos, float r){
        this.p5 = p5;
        x = xpos;
        y = ypos;
         radius = r;
    }
    void display(){
        p5.ellipse(x, y, radius * 2, radius * 2  );
    }
}

