// this is some Shiffmanian code... i love this dude. used the script to handle the genomic data lol
// also tried to run processing code in intellij idea, works except for the PGraphicsPDF lib stuff... dont know why.
// is it time for someone who struggles with syntax and beginner concepts to move over to emacs ? i   d o n t   t h i n k  s o .

// Daniel Shiffman
// http://codingtra.in
// http://patreon.com/codingtrain

// Book of Pi 1
// https://youtu.be/tbvG9hrJxOU

import processing.pdf.*;

String pi;

void setup() {
  size(1000, 1000, PDF, "C:/Users/Jenny/Documents/Processing/chromosome.pdf");
  PGraphicsPDF pdf = (PGraphicsPDF) g;  // Get the renderer
  pi = loadStrings("test3.txt")[0];

  int cols = 1000;
  int rows = 1000;

  //beginDraw();
  colorMode(HSB, 1.0);
  float w = float(width)/cols;
  float h = float(height)/rows;
  int index = 0;

  int totalPages = pi.length() / (cols*rows);
  println(totalPages);

  for (int i = 0; i < totalPages; i++) {

    for (float y = 0; y < height; y += h) {
      for (float x = 0; x < width; x += w) {
        String s = "" + pi.charAt(index);
        int digit = int(s);
        float hue = digit/4.0;
        fill(hue, 1, 1);
        noStroke();
        rect(x, y, w, h);
        // fill(255-bright);
        //textAlign(CENTER,CENTER);
        //text(digit,x+w/2,y+h/2);
        index++;
        if (index >= pi.length()) {
          index = pi.length() - 1;
        }
      }
    }
    println("Page " + i + " complete!");
    pdf.nextPage();
  }
  println("Finished");
  exit();
  //endRecord();
}
