import processing.core.*;

public class App extends PApplet {
    public static void main(String[] args) {
        PApplet.main("App");
    }

    int scene = 1;
    int count1 = 0;
    int count2 = 0;
    int mainx1 = 0;
    int mainy2 = 0;
    int mainSpeed = 30;
    int pointX11 = (int) random(900);
    int pointY12 = (int) random(800);
    int pointX21 = (int) random(900);
    int pointY22 = (int) random(800);
    int pointX31 = (int) random(900);
    int pointY32 = (int) random(800);
    int r1 = 30;
    int r2 = 15;
    int mainColor = -256;
    int pointColor = -1;
    int enemyColor1 = -65536;
    int enemyColor2 = -7876885;
    int enemyColor3 = -23296;
    int enemyX11 = (int) random(900);
    int enemyY12 = 100;
    int enemy1S = 60;
    int enemyX21 = (int) random(900);
    int enemyY22 = 400;
    int enemy2S = 60;
    int enemyX31 = (int) random(900);
    int enemyY32 = 700;
    int enemy3S = 60;
    int enemySpeed1 = 5;
    int enemySpeed2 = 9;
    int enemySpeed3 = 13;
    boolean moveLeft = false;
    boolean moveRight = false;
    boolean moveUp = false;
    boolean moveDown = false;

    public void setup() {

    }

    public void settings() {
        size(1000, 800);
    }

    public void draw() {
        print(color(255, 255, 0));
        print(color(255, 255, 255));
        print(color(255, 0, 0));
        print(color(135, 206, 235));
        print(color(255, 165, 0));
        background(25);
        fill(mainColor);
        ellipse(mainx1, mainy2, r1 * 2, r1 * 2);
        fill(pointColor);
        ellipse(pointX11, pointY12, r2 * 2, r2 * 2);
        ellipse(pointX21, pointY22, r2 * 2, r2 * 2);
        ellipse(pointX31, pointY32, r2 * 2, r2 * 2);
        
        textSize(50);
        fill(mainColor);
        text("score:" + count1, 840, 50);
        drawEnemies();
        movement();
        enemyMovement();
       
        float distance1 = dist(mainx1, mainy2, pointX11, pointY12);
        if (distance1 < r1 + r2) {
            pointX11 = (int) random(900);
            pointY12 = (int) random(700);
            count1++;
        }
        float distance2 = dist(mainx1, mainy2, pointX21, pointY22);
        if (distance2 < r1 + r2) {
            pointX21 = (int) random(900);
            pointY22 = (int) random(700);
            count1++;
        }
        float distance3 = dist(mainx1, mainy2, pointX31, pointY32);
        if (distance3 < r1 + r2) {
            pointX31 = (int) random(900);
            pointY32 = (int) random(700);
            count1++;
        }
        System.out.println(count1);

        float distance4 = dist(mainx1, mainy2, enemyX11 + 30, enemyY12 + 30);
         float distance6 = dist(mainx1, mainy2, enemyX31 + 30, enemyY32 + 30);
         float distance5 = dist(mainx1, mainy2, enemyX21 + 30, enemyY22 + 30);
        if (distance4 <= 60 || distance6 <= 60 || distance5 <= 60) {
            scene += 1;
        

            scene += 1;

            if (scene == 1)
            ;
            background(0);
            text("dead", 50, 50);

        }
    }

    public void drawEnemies(){
        fill(enemyColor1);
        square(enemyX11, enemyY12, enemy1S);
        fill(enemyColor2);
        square(enemyX21, enemyY22, enemy2S);
        fill(enemyColor3);
        square(enemyX31, enemyY32, enemy3S);

    }

    public void enemyMovement(){
          enemyX11 = enemyX11 + enemySpeed1;
        if (enemyX11 > 1000 - 100 || enemyX11 < 0) {
            enemySpeed1 = enemySpeed1 * -1;
        }

        enemyX21 = enemyX21 + enemySpeed2;
        if (enemyX21 > 1000 - 100 || enemyX21 < 0) {
            enemySpeed2 = enemySpeed2 * -1;
        }

        enemyX31 = enemyX31 + enemySpeed3;
        if (enemyX31 > 1000 - 100 || enemyX31 < 0) {
            enemySpeed3 = enemySpeed3 * -1;
        }
    }

    public void movement(){
         if (moveLeft == true) {
            mainx1 -= 7;
        }
        if (moveRight == true) {
            mainx1 += 7;
        }
        if (moveUp == true) {
            mainy2 -= 7;
        }
        if (moveDown == true) {
            mainy2 += 7;
        }
    }

    public void keyPressed() {

        // if (keyCode == UP) {
        // mainy2 = mainy2 - mainSpeed;
        // }

        // if (keyCode == DOWN) {
        // mainy2 = mainy2 + mainSpeed;
        // }

        // if (keyCode == LEFT) {
        // mainx1 = mainx1 - mainSpeed;
        // }

        // if (keyCode == RIGHT) {
        // mainx1 = mainx1 + mainSpeed;
        // }
        if (keyCode == LEFT)

        {
            moveLeft = true;

        }
        if (keyCode == RIGHT)

        {
            moveRight = true;

        }
        if (keyCode == UP)

        {
            moveUp = true;

        }
        if (keyCode == DOWN)

        {
            moveDown = true;
        }
    }

    public void keyReleased() {

        if (keyCode == LEFT) {
            moveLeft = false;
        }
        if (keyCode == RIGHT) {
            moveRight = false;
        }
        if (keyCode == UP) {
            moveUp = false;
        }
        if (keyCode == DOWN) {
            moveDown = false;
        }
    }
}