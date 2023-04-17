float frequency = 0.005;
float amplitude = 100;
float phase = 0;
float yoffset;
float noiseScale = 0;

void setup() {
  size(800, 400);
  yoffset = height / 2;
}

void draw() {
  background(255);
  stroke(100);
  noFill();
  beginShape();
  vertex(0, yoffset + amplitude / 2);
  for (int x = 1; x < width; x++) {
    float noiseVal = noise(x * noiseScale);
    float y = (sin(phase + x * frequency) * amplitude + yoffset) * noiseVal;
    vertex(x, y);
  }
  endShape();
}

void mousePressed() {
  if (mouseButton == LEFT) {
    amplitude += 15;
  } else if (mouseButton == RIGHT) {
    amplitude -= 15;
  }
}

void mouseDragged() {
  if (mouseX > pmouseX) {
    frequency += 0.001;
  } else if (mouseX < pmouseX) {
    frequency -= 0.001;
  }
}

void mouseWheel(MouseEvent event) {
  float e = event.getCount();
  noiseScale += e * 0.005;
}
