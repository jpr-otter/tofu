int[][][] world;
int worldSize = 16;
int blockSize = 20;
float rotX = 0;
float rotY = 0;
float zoom = 1;
int lastUpdateTime = 0;

void setup() {
  size(800, 600, P3D);
  world = new int[worldSize][worldSize][worldSize];
}

void draw() {
  if (millis() - lastUpdateTime > 1000) {
    for (int x = 0; x < worldSize; x++) {
      for (int y = 0; y < worldSize; y++) {
        for (int z = 0; z < worldSize; z++) {
          if (world[x][y][z] != 0) {
            world[x][y][z] = color(random(255), random(255), random(255));
          }
        }
      }
    }
    lastUpdateTime = millis();
  }

  background(255);
  translate(width / 2, height / 2);
  scale(zoom);
  rotateX(rotX);
  rotateY(rotY);
  translate(-worldSize * blockSize / 2, -worldSize * blockSize / 2);
  for (int x = 0; x < worldSize; x++) {
    for (int y = 0; y < worldSize; y++) {
      for (int z = 0; z < worldSize; z++) {
        if (world[x][y][z] != 0) {
          pushMatrix();
          translate(x * blockSize, y * blockSize, z * blockSize);
          fill(world[x][y][z]);
          box(blockSize);
          popMatrix();
        }
      }
    }
  }
}

void mouseDragged() {
    rotY += (mouseX - pmouseX) * 0.01;
    rotX += (mouseY - pmouseY) * 0.01;
}

void mouseWheel(MouseEvent event) {
    float e = event.getCount();
    zoom -= e * 0.1;
}

void mousePressed() {
    if (mouseButton == LEFT) {
        for (int i = 0; i < worldSize; i++) {
            int x = int(random(worldSize));
            int y = int(random(worldSize));
            int z = int(random(worldSize));
            world[x][y][z] = color(random(255), random(255), random(255));
        }
    }
}
