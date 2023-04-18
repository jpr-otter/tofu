int x = 0;
int y = 200;
int speed = 5;
int score = 0;
int highScore = 0;
boolean jump = false;
int jumpSpeed = 10;
ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

void setup() {
    size(600, 400);
}

void draw() {
    background(255);

    // draw ground
    stroke(0);
    line(0, 300, width, 300);

    // draw score
    fill(0);
    textSize(20);
    text("Score: " + score, width - 100, 50);

    // draw high score
    text("High Score: " + highScore, width - 150, 80);

    // draw player
    fill(0);
    rect(x, y, 50, 50);

    // update player position
    if (jump) {
        y -= jumpSpeed;
        jumpSpeed--;
        if (y >= 200) {
            y = 200;
            jump = false;
            jumpSpeed = 10;
        }
    }

    // generate obstacles
    if (random(1) < 0.02) {
        obstacles.add(new Obstacle());
        score++;
        if (score > highScore) {
            highScore = score;
        }
        speed += 0.1;
        if (speed > 10) {
            speed = 10;
        }
    }

    // update and draw obstacles
    for (int i = obstacles.size()-1; i >=0; i--) {
        Obstacle o = obstacles.get(i);
        o.update();
        o.draw();
        if (o.x < -50) {
            obstacles.remove(i);
        }

        // check collision
        if (o.x < x+50 && o.x+20 > x && o.y < y+50 && o.y+50 > y) {
            // game over
            speed = 5;
            score = 0;
            obstacles.clear();
        }

        // parallax scrolling background
        fill(200);
        for (int j = -1; j < width/50; j++) {
            ellipse(j*50 + frameCount % width/2, height/2, random(10), random(10));
            ellipse(j*50 + frameCount % width/4, height/4, random(20), random(20));
            ellipse(j*50 + frameCount % width/8, height/8, random(30), random(30));
        }
    }
}

void keyPressed() {
    if (key == ' ') {
        jump = true;
    }
}

class Obstacle {
    float x;
    float y;

    Obstacle() {
        x = width;
        y = random(150,250);
    }

    void update() {
        x -= speed;
    }

    void draw() {
        fill(255,0,0);
        rect(x,y,20,50);
    }
}
