package BiscuitRun.Fx;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.lang.Exception;
import javafx.scene.shape.Circle;
import javafx.application.Platform;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
class Lebel3Scene implements Runnable{
	
	
		private final Image backgroundImage,flyingGhostImage;
		private ImageView backgroundImageView,flyingGhostImageView;
		private Group root;
		private Scene scene;
		private Rectangle plate1,plate2,plate3,plate4;
		private Thread plateThread;
		private boolean plateFlag;
		private Character player;
		public static int count;
		private Circle b1,b2,b3,b4,b5,b6,obstacle1,obstacle2;
		private Group playerGroup,plateGroup;
		private Text scoreText,massage;
		private Button nextLevelButton,backButton,tryAgainButton;
		private int levelScore;
		public void run()
		{
			double x=0,y=0,z=0,a=0,b=0,c=0,d=0,f=0,g=0,h=0,ob1=0,ob2=0,ghost=0;
			int count=0;
			while(count<3)
			{
				if(!plateFlag)
				{
					break;
				}
				
				//------plate movement---------
				x=plate1.getX();
				plate1.setX(x-10);
				
				y=plate2.getX();
				plate2.setX(y-10);
					
				plate2.setX(y-10);
				
				z=plate3.getX();
				plate3.setX(z-10);
				a=plate4.getX();
				plate4.setX(a-10);
				
				
				if(x<-200){
					plate1.setX(1000);
					count++;
				}
			    if(y<-200)
				plate2.setX(1000);
			    if(z<-200)
				plate3.setX(1000);
			    if(a<-200)
				{
				plate4 .setX(1000);
				}
				
				//-----obstacle movement-------
				 ob1=obstacle1.getCenterX();
				 obstacle1.setCenterX(ob1-10);
				
				 ob2=obstacle2.getCenterX();
				 obstacle2.setCenterX(ob2-10);
				 if(ob1<-200)
				 obstacle1.setCenterX(1010);
			    
				 if(ob2<-200)
				 obstacle2.setCenterX(1020);
				 
				//----------------------------biscuits---------------------
				 b=b1.getCenterX();
				 b1.setCenterX(b-10);
				
				 c=b2.getCenterX();
				 b2.setCenterX(c-10);
				 
				 d=b3.getCenterX();
				 b3.setCenterX(d-10);
				 
				 f=b4.getCenterX();
				 b4.setCenterX(f-10);
				
				 g=b5.getCenterX();
				 b5.setCenterX(g-10);
				 h=b6.getCenterX();
				 b6.setCenterX(h-10);
				 
				 
				 if(b1.isVisible() && playerGroup.intersects(b1.getBoundsInLocal()))
				{
					b1.setCenterX(1000);
					MyStage.SCORE+=10;
					levelScore++;
					Platform.runLater(() -> {
						scoreText.setText("Score: " + String.valueOf(MyStage.SCORE));
					});
				}
				if(b2.isVisible() && playerGroup.intersects(b2.getBoundsInLocal()))
				{
					b2.setCenterX(1000);
					MyStage.SCORE+=10;
					levelScore++;
					Platform.runLater(() -> {
						scoreText.setText("Score: " + String.valueOf(MyStage.SCORE));
					});
				}
				if(b3.isVisible() && playerGroup.intersects(b3.getBoundsInLocal()))
				{
					b3.setCenterX(1000);
					MyStage.SCORE+=10;
					levelScore++;
					Platform.runLater(() -> {
						scoreText.setText("Score: " + String.valueOf(MyStage.SCORE));
					});
				}
				if(b4.isVisible() && playerGroup.intersects(b4.getBoundsInLocal()))
				{
					b4.setCenterX(1000);
					MyStage.SCORE+=10;
					levelScore++;
					Platform.runLater(() -> {
						scoreText.setText("Score: " + String.valueOf(MyStage.SCORE));
					});
				}
				if(b5.isVisible() && playerGroup.intersects(b5.getBoundsInLocal()))
				{
					b5.setCenterX(1000);
					MyStage.SCORE+=10;
					levelScore++;
					Platform.runLater(() -> {
						scoreText.setText("Score: " + String.valueOf(MyStage.SCORE));
					});
				}
				if(b6.isVisible() && playerGroup.intersects(b6.getBoundsInLocal()))
				{
					b6.setCenterX(1000);
					MyStage.SCORE+=10;
					levelScore++;
					Platform.runLater(() -> {
						scoreText.setText("Score: " + String.valueOf(MyStage.SCORE));
					});
				}
				 
			   //------------------------checking if Player on plate or not----------------------------
			    if( ! plate1.intersects(playerGroup.getBoundsInLocal()) && ! plate2.intersects(playerGroup.getBoundsInLocal()) 
				&& ! plate3.intersects(playerGroup.getBoundsInLocal()) && ! plate4.intersects(playerGroup.getBoundsInLocal()) 	
				&& player.legFlag || obstacle1.intersects(playerGroup.getBoundsInLocal()) 
				|| obstacle2.intersects(playerGroup.getBoundsInLocal())
				){
					gameOver();
					break;
				}
				

			  //-------------------------Ghost movement------------------
				ghost=flyingGhostImageView.getTranslateX();
				flyingGhostImageView.setTranslateX(ghost-27d);
				
				if(ghost<-200)
				flyingGhostImageView.setTranslateX(1000);
				
				//-------------ghost mechanisom----------
				if(playerGroup.getBoundsInParent().intersects(flyingGhostImageView.getBoundsInParent()))
				{
					gameOver();
					break;
				}
			
				//----biscuit mechanisom----------
				if(b<-200)
				b1.setCenterX(1000);
			    
				if(c<-200)
				b2.setCenterX(1000);
				
				if(d<-200)
				b3.setCenterX(1000);
			    
				if(f<-200)
				b4.setCenterX(1000);
				
				if(g<-200)
				b5.setCenterX(1000);
				
				if(h<-200)
				b6.setCenterX(1000);
				
				
				//----------sleep----------
				try{
					Thread.sleep(150);
				}catch(Exception e){};
				

					
			}
			player.characterFlag=false;
			//----------after game over----------
			if(count==3)
			{
				massage.setText("WINNER");
				massage.setVisible(true);
				nextLevelButton.setVisible(true);
			}
			backButton.setVisible(true);
			tryAgainButton.setVisible(true);
			
		};
		
		
		
		
		//-------------------------------constructor----------------------------------
		Lebel3Scene(){
		//load Image
		// resizes the image to have Higt of 500 and width of 800
        // higher quality filtering method; this ImageView is also cached to
        // improve performance
		count=0;
		plateFlag=true;		
		//--------------------------Image and Image View----------------------
		//-----background Image----------
		backgroundImage= new Image("BiscuitRun/Fx/Image/level3BackgroundImage.jpg");
		backgroundImageView= new ImageView(backgroundImage);
		backgroundImageView.setFitHeight(MyStage.HEIGHT);
		backgroundImageView.setFitWidth(MyStage.WIDTH);
		backgroundImageView.setPreserveRatio(false);
		backgroundImageView.setSmooth(true);
        backgroundImageView.setCache(true);

		//-----------Ghost Image ----------

		//----------------------------------Flying Ghost Obstacle-----------------------------------
		flyingGhostImage=new Image("BiscuitRun/Fx/Image/ghost.png");
		flyingGhostImageView=new ImageView(flyingGhostImage);
		flyingGhostImageView.setFitWidth(55d);
		flyingGhostImageView.setFitHeight(50d);
		flyingGhostImageView.setTranslateX(950d);
		flyingGhostImageView.setTranslateY(390d);
		flyingGhostImageView.setSmooth(true);
        flyingGhostImageView.setCache(true);	
		//-------------------plate-----------------
		plate1=new Rectangle(0,450,245,40);
		plate1.setFill(Color.CHOCOLATE);
		plate2=new Rectangle(350,450,160,40);
		plate2.setFill(Color.CHOCOLATE);
		plate3=new Rectangle(640,450,190,40);
		plate3.setFill(Color.CHOCOLATE);
		plate4=new Rectangle(930,450,170,40);
		plate4.setFill(Color.CHOCOLATE);
		
		//----------------------BISCUIT----------------------------
		
		 b1= new Circle(380,254,10);
		b1.setFill(Color.PURPLE);
		
		b2= new Circle(590,334,10);
		b2.setFill(Color.PURPLE);
		 
		 b3= new Circle(710,324,10);
		b3.setFill(Color.PURPLE);
		
		b4= new Circle(860,364,10);
		b4.setFill(Color.PURPLE);
		
		b5= new Circle(1000,264,10);
		b5.setFill(Color.PURPLE);
		
		b6= new Circle(1180,294,10);
		b6.setFill(Color.PURPLE);
		

		//-------------Obastacle------------------
		obstacle1= new Circle(720,450,15);
		obstacle1.setFill(Color.WHITE);
		
		obstacle2= new Circle(1350,450,15);
		obstacle2.setFill(Color.WHITE);
	
		//----------score Text------------
		scoreText=new Text(800d,50d,"SCORE : "+String.valueOf(MyStage.SCORE));
		scoreText.setFont(new Font(25));
		//-----------game over Text--------------
		massage=new Text(330,300,"GAME OVER");
		massage.setFont(new Font(70));
		massage.setFill(Color.RED);
		massage.setVisible(false);
		
		
		//-----------High Score button-------
		nextLevelButton = new Button("High Score");
		nextLevelButton.setLayoutX(420);
        nextLevelButton.setLayoutY(350);
		nextLevelButton.setVisible(false);
		nextLevelButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		//--------next level button action------
		nextLevelButton.setOnAction(
			e->{
				MyStage.changeScene(4);
				
			}
		);
		
		//-----------Back button-------
		backButton = new Button("Back");
		backButton.setLayoutX(445);
        backButton.setLayoutY(400);
		backButton.setVisible(false);
		backButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		//--------next level button action------
		backButton.setOnAction(
			e->{
				MyStage.changeScene(0);
			}
		);
		
	    //-----------Try Again button-------
		tryAgainButton = new Button("Try Again");
		tryAgainButton.setLayoutX(420);
        tryAgainButton.setLayoutY(450);
		tryAgainButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		//--------next level button action------
		tryAgainButton.setOnAction(
			e->{
				MyStage.SCORE-=(levelScore*10);
				MyStage.changeScene(3);
			}
		);
		tryAgainButton.setVisible(false);
		
		
		//---------------------making player-----------------
		player=new Character();
		
        //-------------make group for background image----------------
		Group backgroundImageGroup= new Group();
		//group for plate
		plateGroup=new Group();
		//----------------------group for player-----------------------
		playerGroup=new Group();
		//----------------------biscuit group-----------------------
		Group biscuitGroup=new Group();

		
		//-------------------------adding actors in group------------------
		playerGroup.getChildren().addAll(player.characterGroup);
		plateGroup.getChildren().addAll(obstacle1,obstacle2,plate1,plate2,plate3,plate4);
		backgroundImageGroup.getChildren().addAll(backgroundImageView);
		biscuitGroup.getChildren().addAll(b1,b2,b3,b4,b5,b6,flyingGhostImageView);
		
		
		//---------------------------starting Thread------------------------
		plateThread = new Thread(this);
            plateThread.start();
		player.startCharacter();
		
		//---------------------------main group for scene----------------------
		root=new Group(backgroundImageGroup,plateGroup,biscuitGroup,playerGroup,scoreText,massage,nextLevelButton,backButton,tryAgainButton);	
		scene=new Scene(root,MyStage.WIDTH,MyStage.HEIGHT);	
		
		//---------------------taking input from keyboard--------------------------
		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
          if(key.getCode()==KeyCode.SPACE) {
			  if(plateGroup.intersects(playerGroup.getBoundsInLocal()))
			  player.jump();
      }
      });
	  
	  scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
          if(key.getCode()==KeyCode.S) {
		  plateFlag=false;
    	  player.characterFlag=false;	
      }
      });
		
		
		}
		
		public Scene getScene(){
			return scene;
		}
	public void gameOver()
	{
			player.fall();
			player.characterFlag=false;	
		    massage.setVisible(true);		
	}
}