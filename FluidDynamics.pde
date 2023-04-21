int numParticles = 500;
Particle[] particles = new Particle[numParticles];

void setup() {
  size(800, 400);
  for (int i = 0; i < numParticles; i++) {
    particles[i] = new Particle(random(width), random(height/6, height*5/6));
  }
}

void draw() {
  background(255);
  stroke(0);
  line(0, height/6, width, height/6);
  line(0, height*5/6, width, height*5/6);
  
  float maxSpeedX = 0;
  float minSpeedX = Float.MAX_VALUE;
  
  for (int i = 0; i < numParticles; i++) {
    particles[i].update();
    maxSpeedX = max(maxSpeedX, particles[i].speedX);
    minSpeedX = min(minSpeedX, particles[i].speedX);
  }
  
  for (int i = 0; i < numParticles; i++) {
    particles[i].display(maxSpeedX, minSpeedX);
  }
}

class Particle {
  float x;
  float y;
  float speedX;
  float speedY;
  
  Particle(float x_, float y_) {
    x = x_;
    y = y_;
    if (random(1) < 0.01) {
      speedX = random(4,8);
    } else {
      speedX = map(abs(y - height/2), 0, height/3, 2, 0.5);
    }
    speedY = random(-1,1);
  }
  
  void update() {
    x += speedX;
    y += speedY;
    
    if (x > width) {
      x = 0;
      y = random(height/6, height*5/6);
      if (random(1) < 0.01) {
        speedX = random(4,8);
      } else {
        speedX = map(abs(y - height/2), 0, height/3, 2, 0.5);
      }
      speedY = random(-1,1);
    }
    
    if (y < height/6 || y > height*5/6) {
      speedY *= -1;
    }
    
    for (int i = 0; i < numParticles; i++) {
      float d = dist(x, y, particles[i].x, particles[i].y);
      if (d < 10 && d > 0) {
        float tempSpeedX = speedX;
        float tempSpeedY = speedY;
        speedX = particles[i].speedX;
        speedY = particles[i].speedY;
        particles[i].speedX = tempSpeedX;
        particles[i].speedY = tempSpeedY;
      }
    }
    
    speedX *= map(abs(y - height/2), 0, height/3, 1.001, 0.999);
    
    //speedX = constrain(speedX, 0.5, max(speedX));
  }
  /*
  void display(float maxSpeedX_, float minSpeedX_) {
    fill(map(speedX,minSpeedX_,maxSpeedX_,#FF0100,#0000FF));
    ellipse(x,y,10,10);
  }
  */
  void display(float maxSpeedX_, float minSpeedX_) {
  noStroke();
  fill(map(speedX,minSpeedX_,maxSpeedX_,#FF0000,#0000FF));
  //ellipse(x,y,10,10);
  stroke(0);
  noFill();
  ellipse(x,y,10,10);}
}
