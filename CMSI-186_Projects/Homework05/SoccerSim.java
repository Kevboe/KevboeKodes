/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  Use Ball to create a soccer sim
 *  @author       :  Kevin Patterson
 *  Date written  :  2017-03-30
 *  Description   :  This class provides a bunch of methods which may be useful for the soccerSim
                     for homework 05
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-03-27  K. Patterson  Initial writing
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

/*
Array to hold the different balls which will be instantiated
ask for help?
Need to be able to tell the difference between ball 1 and ball 2
for collision()
*/

public class SoccerSim{

private static final double FRICTION_CONSTANT = .99;
private double mins;
private double secs;
private double hours;
private double totalSecs;
private Ball[] ballArray;
private int ballCount;
private boolean collision;
private boolean movementPossible;

//private ball x, y, vx, vy variables
//check that all of the args are correct

public SoccerSim( String[] args ){
  mins = 0;
  secs = 0;
  hours = 0;
  totalSecs = 0;
  stop = false;
  if( args%4 != 0 ){
    throw new IllegalArgumentException( "You have input an incorrect number of arguments." );
  }
  ballCount = args/4;
  ballArray = new Ball[Math.floor(args/4)];
  for( int i = 0; i < ballArray.length(); i++){
    ballArray[i] = new Ball( 0, 0, 0, 0);
  }

  for( int x = 0; x < args.length(); x + 4 ){
  //Setting each variable of each Ball in the ballArray
    ballArray[x/4].setX( Double.parseDouble( arg[x] ) );
    ballArray[x/4].setY( Double.parseDouble( arg[x + 1] ) );
    ballArray[x/4].setVelX( Double.parseDouble( arg[x + 2] ) );
    ballArray[x/4].setVelY( Double.parseDouble( arg[x + 3] ) );
  }
}

public void move(){
  double moveX = ball.getVelX();
  double moveY = ball.getVelY();
  ball.setX( (ball.getX() + moveX );
  ball.setY( (ball.get.getY() + moveY ) );
  totalSecs += 1;
  collision();
  if
}

public void friction(){
  ball.setVelX( (ball.getVelX() * FRICTION_CONSTANT) );
  ball.setVelY( (ball.getVelY() * FRICTION_CONSTANT) );
  if( ball.getVelX() < (1/12){
    ball.setVeX(0);
  }
  if( ball.getVelY() < (1/12){
    ball.setVelY(0);
  }
}

public collision(){
  //psuedo code until i can get the proper instantiation as well as define which 2 collided
  //Think I should use a this call and a ball so it would look like
  // ball.collision(ball2) and return true or false, but I'm not sure
  double betweenX = ball.getX() - ball2.getX();
  double betweenY = ball.getY() - ball2.getY()
  double betweenPts = Math.sqrt( Math.pow( betweenX, 2) + Math.pow( betweenY, 2) );
  if( betweenPts <= (8.9/12) ){
    collision = true;
  }
}

public static void main( String Args[] ){
  while( collision == false || movementPossible == true ){
    int ballStopped = ballArray.length();
    SoccerSim.collision();
    for(int x = 0; x < ballArray.length(); x++){
      ballArray[x].move();
      ballArray[x].friction();
      if(ballArray[x].getVelX == 0 && ballArray[x].getVelY == 0){
        
      }
    }
  }
}

}
