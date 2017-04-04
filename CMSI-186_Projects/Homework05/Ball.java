public class Ball {

private double xPos;
private double yPos;
private double velX;
private double velY;

public Ball(double x, double y, double Vx, double Vy){
  xPos = x;
  yPos = y;
  velX = Vx;
  velY = Vy;
}

public void setX(double x){
  this.xPos = x;
}

public void setY(double y){
  this.yPos = y;
}

public void setVelX(double Vx){
  this.velX = Vx;
}

public void setVelY(double Vy){
  this.velY = Vy;
}

public double getX(){
  return this.xPos;
}

public double getY(){
  return this.yPos;
}

public double getVelX(){
  return this.velX;
}

public double getVelY(){
  return this.velY;
}

public String toString(){
  return "( " + xPos + ", " + yPos + ", " + velX + ", " + velY + " )" ;
}

public static void main( String args[] ){

  System.out.println( "Creating a new ball..." );
  Ball ball1 = new Ball( 300, 300, 10, 5);
  System.out.println( "Your ball is :: " + ball1.toString() );
  System.out.println( "Updating the coordinates..." );
  ball1.setX(350);
  ball1.setY(-27);
  System.out.println( "Your ball is :: " + ball1.toString() );
  System.out.println( "Updating the velocities..." );
  ball1.setVelX(7);
  ball1.setVelY(6);
  System.out.println( "Your ball is :: " + ball1.toString() );
  System.out.println( "Updating the coordinates..." );
  ball1.setX(357);
  ball1.setY(-21);
  System.out.println( "Your ball is :: " + ball1.toString() );
}

}
