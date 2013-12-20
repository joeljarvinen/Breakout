package sprites;

import java.awt.Rectangle;

public class Ball extends Sprite {

    private int dx, dy, defaultDX, defaultDY;
    private Paddle paddle;
    private boolean moving;

    public Ball(Paddle paddle) {
        super(paddle.getCenter() - 7, paddle.getY() - 16, 15, 15);
        this.paddle = paddle;
        init();
    }

    public Ball(int x, int y, int height, int width) {
        super(x, y, height, width);
        init();
    }

    private void init() {
        this.moving = false;
        dx = defaultDX = 5;
        dy = defaultDY = -5;
    }

    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }

    public int getDefaultDx() {
        return defaultDX;
    }

    public int getDefaultDy() {
        return defaultDY;
    }

    public boolean moving() {
        return moving;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void move() {
        if (moving) {
            setPos(x + dx, y + dy);
        }
    }

//    private void increaseSpeed() {
//        if (dy < 0) {
//            dy--;
//            if (dy < -maxSpeed) {
//                dy = -maxSpeed;
//            }
//        } else {
//            dy++;
//            if (dy > maxSpeed) {
//                dy = maxSpeed;
//            }
//        }
//    }
    public void launchBall() {
        moving = true;
    }

    private void setPos(int x, int y) {
        super.x = x;
        super.y = y;
    }

    public void reverseHorizontalMomentum() {
        dx = -dx;
    }

    public void reverseVerticalMomentum() {
        dy = -dy;
    }

    // Reset the ball back onto the paddle
    public void resetBall() {
        moving = false;
        setPos(paddle.getCenter() - getWidth() / 2, paddle.getY() - (height + 1));
        dy = defaultDY;
        dx = defaultDX;
    }

}
