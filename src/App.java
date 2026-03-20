import processing.core.*;

public class App extends PApplet {

    public static void main(String[] args) {
        PApplet.main("App");
    }

    PImage photo1;
    PImage photo2;
    PImage photo3;
    PImage photo4;
    int scene = 1;
    int count1 = 0;
    int lives = 3;
    int countHighscore = 0;
    int mainx1 = 0;
    int mainy2 = 0;
    int mainSpeed = 30;
    PVector point1 = new PVector(random(900), random(800));
    PVector point2 = new PVector(random(900), random(800));
    PVector point3 = new PVector(random(900), random(800));
    // int point2.x = (int) random(900);
    // int point2.y = (int) random(800);
    // int point3.x = (int) random(900);
    // int point3.y = (int) random(800);
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
    int enemySpeed2 = 5;
    int enemySpeed3 = 5;
    int startSideX = 450;
    int startSideY = 450;
    int startSideWidth = 100;
    int startSideHeight = 50;
    int timer = 0;

    boolean moveLeft = false;
    boolean moveRight = false;
    boolean moveUp = false;
    boolean moveDown = false;
    boolean speedUpable1 = true;
    boolean speedUpable2 = true;
    boolean speedUpable3 = true;
    boolean speedUpable4 = true;
    boolean speedUpable5 = true;
    boolean speedUpable6 = true;
    boolean speedUpable7 = true;
    boolean die2 = false;

    public void setup() {
        pictures();

    }

    public void settings() {
        size(1000, 800);

    }

    public void draw() {
        colors();
        if (scene == 1) { // sets scene as #1
            background(0);
            sceneOneTextRec();

        } else if (scene == 2) { // scene number 2 which has the rules
            background(0);
            sceneTwoTextRec();

        } else if (scene == 4) { // Scene after game and death scene at that can move back to game #4
            background(0);
            reset();
            sceneFourTextRec();

        } else if (count1 == 99) { // sets scene at #5 only happens if you win and get 99 points
            scene = 5;
            background(0);
            sceneFiveTextRec();
        } else if (scene == 3) { // main game scene where yoy play as a yellow cirlce and get white dots while
                                 // avoiding the rectanguls at scene #3
            background(0);
            drawMain();
            drawPoint();
            sceneThreeText();
            drawEnemies();
            movement();
            enemyMovement();
            locationOfPoints();
            System.out.println(count1);
            System.out.println(countHighscore);

        }
        livesAndDeaths();
        constrain();

    }

    public void drawEnemies() { // size and colors of the enmeies
        fill(enemyColor1);
        stroke(enemyColor1);
        square(enemyX11, enemyY12, enemy1S);
        image(photo1, enemyX11, enemyY12);

        fill(enemyColor2);
        stroke(enemyColor2);
        square(enemyX21, enemyY22, enemy2S);
        image(photo2, enemyX21, enemyY22);

        fill(enemyColor3);
        stroke(enemyColor3);
        square(enemyX31, enemyY32, enemy3S);
        image(photo3, enemyX31, enemyY32);

    }

    public void enemyMovement() { // how the enemies move and bounce and speed up after a certain amount of
                                  // points, ChatGPT for the bounncing

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

        if (speedUpable1 == true && count1 > 10) {

            enemySpeed1 = 9;
            enemySpeed2 = 9;
            enemySpeed3 = 9;
            speedUpable1 = false;
        }
        if (speedUpable2 == true && count1 > 20) {

            enemySpeed1 = (int) 11.5;
            enemySpeed2 = 10;
            enemySpeed3 = (int) 11.7;
            speedUpable2 = false;

        }
        if (speedUpable3 == true && count1 > 30) {

            enemySpeed1 = 11;
            enemySpeed2 = (int) 12.9;
            enemySpeed3 = 12;
            speedUpable3 = false;
        }
        if (speedUpable4 == true && count1 > 40) {

            enemySpeed1 = (int) 13.9;
            enemySpeed2 = 12;
            enemySpeed3 = (int) 13.6;
            speedUpable4 = false;
        }
        if (speedUpable5 == true && count1 > 50) {

            enemySpeed1 = (int) 14.3;
            enemySpeed2 = 13;
            enemySpeed3 = (int) 15.2;
            speedUpable5 = false;
        }
        if (speedUpable6 == true && count1 > 70) {

            enemySpeed1 = 17;
            enemySpeed2 = (int) 16.8;
            enemySpeed3 = (int) 14.6;
            speedUpable6 = false;
        }
        if (speedUpable7 == true && count1 > 90) {

            enemySpeed1 = (int) 17.5;
            enemySpeed2 = 18;
            enemySpeed3 = (int) 17.9;
            speedUpable7 = false;
        }
    }

    public void movement() { // controls the speed, how to move main character using arrow keys
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

    public void keyPressed() { // using actual keys to make the movements happen in game

        // if (key == 'c') {
        // count1++;
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

    public void keyReleased() { // stopping the movment so it doesnt go on forever

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

    public void mousePressed() { // switching scenes when you press on a rectangul in the middle of the screen
        if (scene == 2 || scene == 4) {
            if (mouseX > startSideX && mouseX < startSideX + startSideWidth && mouseY > startSideY
                    && mouseY < startSideY + startSideHeight) {

                scene = 3;
                count1 = 0;
                mainx1 = 0;
                mainy2 = 0;

            }
        }
        if (scene == 1) {
            if (mouseX > startSideX && mouseX < startSideX + startSideWidth && mouseY > startSideY
                    && mouseY < startSideY + startSideHeight) {
                scene = 2;
            }
        }
        if (scene == 5) {
            if (mouseX > startSideX && mouseX < startSideX + startSideWidth && mouseY > startSideY
                    && mouseY < startSideY + startSideHeight) {
                scene = 1;
            }
        }
    }

    public void colors() { // settinf specifc colors as numbers so its easy to get the same colors again

        print(color(255, 255, 0));
        print(color(255, 255, 255));
        print(color(255, 0, 0));
        print(color(135, 206, 235));
        print(color(255, 165, 0));
    }

    public void locationOfPoints() { // puts the points in a random location on the screen eachtime to make the game
                                     // more random

        heroTouchPoints(point1);
        heroTouchPoints(point2);
        heroTouchPoints(point3);

        // float distance2 = dist(mainx1, mainy2, point, point2.y);
        // if (distance2 < r1 + r2) {
        // point2.x = (int) random(900);
        // point2.y = (int) random(700);
        // count1++;
        // }
        // float distance3 = dist(mainx1, mainy2, point3.x, point3.y);
        // if (distance3 < r1 + r2) {
        // point3.x = (int) random(900);
        // point3.y = (int) random(700);
        // count1++;

        // }
    }

    public void heroTouchPoints(PVector point) {// shortens the code for the location of the pointd
        float distance = dist(mainx1, mainy2, point.x, point.y);
        if (distance < r1 + r2) {
            point.x = (int) random(900);
            point.y = (int) random(700);
            count1++;
        }
    }

    public void livesAndDeaths() { // what happens when you die and how many times you can die beofre the game is
                                   // over

        float distance4 = dist(mainx1, mainy2, enemyX11 + 30, enemyY12 + 30);
        float distance6 = dist(mainx1, mainy2, enemyX31 + 30, enemyY32 + 30);
        float distance5 = dist(mainx1, mainy2, enemyX21 + 30, enemyY22 + 30);

        if (timer > 0) {
            timer--;
        }
        if ((distance4 <= 60 || distance6 <= 60 || distance5 <= 60) && lives > 0 && timer == 0) { // alexa+ ChatGPT
            lives--;
            timer = 60;

        }
        if (lives == 0) {
            scene = 4;

        }
        System.out.println(lives);
    }

    public void drawMain() {// size and colors of the main
        fill(mainColor);
        stroke(mainColor);
        ellipse(mainx1, mainy2, r1 * 2, r1 * 2);
        image(photo4, mainx1 - 30, mainy2 - 30);
    }

    public void drawPoint() {// size and colors of the point
        fill(pointColor);
        stroke(pointColor);
        ellipse(point1.x, point1.y, r2 * 2, r2 * 2);
        ellipse(point2.x, point2.y, r2 * 2, r2 * 2);
        ellipse(point3.x, point3.y, r2 * 2, r2 * 2);
    }

    public void sceneThreeText() {// the text in scene 3
        textSize(40);
        fill(mainColor);
        text("SCORE:" + count1, 810, 50);
        textSize(40);
        fill(mainColor);
        text("LIVES:" + lives, 650, 50, 40);
    }

    public void sceneFiveTextRec() { // the text in scene 5 and the rectangul to go to the next scene
        stroke(mainColor);
        fill(0);
        rect(startSideX, startSideY, startSideWidth, startSideHeight);

        textSize(250);
        fill(mainColor);
        text("YOU WON!", 3, 350);
        textSize(30);
        text(("restart"), 457, 486);

    }

    public void sceneFourTextRec() {// the text in scene 4 and the rectangul to go to the next scene
        stroke(mainColor);
        fill(0);
        rect(startSideX, startSideY, startSideWidth, startSideHeight);
        highScore();

        textSize(250);
        fill(mainColor);
        text("YOU ARE", 50, 200);
        text("DEAD", 227, 380);

        textSize(35);
        fill(mainColor);
        text("replay", 454, 486);

        textSize(30);
        text("Score:" + count1, 454, 700, 50);
        text("Highscore: " + countHighscore, 440, 600, 50);

    }

    public void reset() { // resets all the variables to make the game start again

        lives = 3;

        mainx1 = 0;
        mainy2 = 0;
        mainSpeed = 30;
        point1.x = (int) random(900);
        point1.y = (int) random(800);
        point2.x = (int) random(900);
        point2.y = (int) random(800);
        point3.x = (int) random(900);
        point3.y = (int) random(800);
        r1 = 30;
        r2 = 15;
        mainColor = -256;
        pointColor = -1;
        enemyColor1 = -65536;
        enemyColor2 = -7876885;
        enemyColor3 = -23296;
        enemyX11 = (int) random(900);
        enemyY12 = 100;
        enemy1S = 60;
        enemyX21 = (int) random(900);
        enemyY22 = 400;
        enemy2S = 60;
        enemyX31 = (int) random(900);
        enemyY32 = 700;
        enemy3S = 60;
        startSideX = 450;
        startSideY = 450;
        startSideWidth = 100;
        startSideHeight = 50;
        timer = 0;
        enemySpeed1 = 5;
        enemySpeed2 = 5;
        enemySpeed3 = 5;

    }

    public void highScore() { // counting the highscore eachtime you play the full game, when closed its reset
        if (count1 > countHighscore) {
            countHighscore = count1;

        }
    }

    public void sceneTwoTextRec() {// the text in scene 2 and the rectangul to go to the next scene

        stroke(mainColor);
        fill(0);
        rect(startSideX, startSideY, startSideWidth, startSideHeight);

        textSize(40);
        fill(mainColor);
        text("begin", 453, 490);

        fill(mainColor);
        textSize(70);
        text("RULES", 400, 100);
        textSize(50);
        text("START UP TOP, YOU ARE THE YELLOW CIRCLE", 40, 180);
        text("CONTROL USING ARROWS, AVOID THE GHOSTS", 10, 260);
        text("PICK UP WHITE DOTS", 300, 340);
        text("TRY AND GET TO 99", 300, 420);

    }

    public void sceneOneTextRec() {// the text in scene 1 and the rectangul to go to the next scene
        stroke(mainColor);
        fill(0);
        rect(startSideX, startSideY, startSideWidth, startSideHeight);

        textSize(50);
        fill(mainColor);
        text("start", 453, 490);
        textSize(250);
        text(("MAC-MAN"), 0, 300);

    }

    public void constrain() {//keeps the circle inside the sides of the game
        mainx1 = constrain(mainx1, r1, 1000 - r1);
        mainy2 = constrain(mainy2, r1, 799 - r1);

    }

    public void pictures() {//the pictures i use to make the enemies and main character
        photo1 = loadImage("Screenshot 2026-03-19 at 12.10.40 PM.png");
        photo2 = loadImage("Screenshot 2026-03-19 at 4.27.18 PM.png");
        photo3 = loadImage("Screenshot 2026-03-19 at 12.12.24 PM.png");
        photo4 = loadImage("Screenshot 2026-03-19 at 4.49.30 PM.png");
        photo1.resize(61, 61);
        photo2.resize(61, 61);
        photo3.resize(61, 61);
        photo4.resize(61, 61);
    }
}