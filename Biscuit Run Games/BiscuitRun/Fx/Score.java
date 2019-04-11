package BiscuitRun.Fx;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import BiscuitRun.Model.Player;
public class Score{
	
	private  ImageView backgroundImageView;
	private Player [] player;
    private Scene scene;
	private Button backButton;
	public Score(){
		
		Image backgroundImage= new Image("BiscuitRun/Fx/Image/score.jpg");
		backgroundImageView= new ImageView(backgroundImage);
		backgroundImageView.setFitHeight(600);
		backgroundImageView.setFitWidth(1000);
		backgroundImageView.setPreserveRatio(false);
		backgroundImageView.setSmooth(true);
        backgroundImageView.setCache(true);	
	
		  player=new Player[3];
		  player[0]=new Player();
		  player[1]=new Player();
		  player[2]=new Player();	
		  
	    System.arraycopy(MyStage.playerServiceObjet.getScore(),0,player,0,3);
		
		Text score1 = new Text();
		score1.setX(450.0);
		score1.setY(230.0);
		score1.setFill(Color.BLUE);
		score1.setFont(Font.font(null, FontWeight.BOLD, 32));
		score1.setText("1. "+player[0].getName()+"  "+player[0].getScore());
		
		Text score2 = new Text();
		score2.setX(450.0);
		score2.setY(300.0);
		score2.setFill(Color.BLUE);
		score2.setFont(Font.font(null, FontWeight.BOLD, 32));
		score2.setText("2. "+player[1].getName()+"  "+player[1].getScore());
	
		Text score3= new Text();

		score3.setX(450.0);
		score3.setY(370.0);
		score3.setFill(Color.BLUE);
		score3.setFont(Font.font(null, FontWeight.BOLD, 32));
		score3.setText("3. "+player[2].getName()+"  "+player[2].getScore());
    
	    //-----------Back button-------
		backButton = new Button("Back");
		backButton.setLayoutX(470);
        backButton.setLayoutY(500);
		backButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		//--------next level button action------
		backButton.setOnAction(
			e->{
				MyStage.changeScene(0);
			}
		);
		
		
	    Group highScoreGroup = new Group(backgroundImageView,score1,score2,score3,backButton);
	     scene = new Scene(highScoreGroup,MyStage.WIDTH,MyStage.HEIGHT) ;	
	}
	
	public Scene getScene(){
			return scene;
		}
	
}