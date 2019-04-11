package BiscuitRun.Fx;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.application.Platform;
import BiscuitRun.Service.PlayerService;

public class MyStage extends Application{

		public final static double WIDTH=1000;
		public final static double HEIGHT=600;	
		public static int SCORE;
		private static Scene scene;
		private static Stage stage;
		private static Lebel1Scene lebel1SceneObject;
		private static Lebel2Scene lebel2SceneObject;
		private static Lebel3Scene lebel3SceneObject;
		private static String name;
		public static PlayerService playerServiceObjet;
		private static Score scoreObject;
		//------------------------start method--------------------------
	 public void start(Stage myStage){
		stage=myStage;
		SCORE=0;
		playerServiceObjet=new PlayerService();
		ImageView backgroundImageView;
	    Image backgroundImage= new Image("BiscuitRun/Fx/Image/startImage.jpg");
		backgroundImageView= new ImageView(backgroundImage);
		backgroundImageView.setFitHeight(600);
		backgroundImageView.setFitWidth(1000);
		backgroundImageView.setPreserveRatio(false);
		backgroundImageView.setSmooth(true);
        backgroundImageView.setCache(true);	
		

		//--------taking input for name----------
		TextField nameField=new TextField();
		nameField.setTranslateX(90d);
		nameField.setTranslateY(260d);
		nameField.setStyle("-fx-font-weight: bold;");
		
		//---------lebel for text massage----------
		Label l1=new Label("ENTER YOUR NAME");
		l1.setTranslateX(90d);
		l1.setTranslateY(240d);
        l1.setFont(new Font("Arial", 30));
		l1.setTextFill(Color.web("#0076a3"));
	    l1.setStyle("-fx-font-weight: bold;");
		//---------------------------All Button---------------------
		
		
		//-----------play button-------
		Button playButton = new Button("PLAY");
		playButton.setLayoutX(450);
        playButton.setLayoutY(260);
		playButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		//--------Play button action------
		playButton.setOnAction(
			e->{
				changeScene(1);
			}
		);
		
		//---------high score button---------
	    Button highScoreButton = new Button("HIGH SCORE");
		highScoreButton.setLayoutX(410);
        highScoreButton.setLayoutY(330);
	    highScoreButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");		
		//--------High button action------
		highScoreButton.setOnAction(
			e->{
			    changeScene(4);
			}
		);
		
		//----Quit Button--------
		Button quitButton= new Button("QUIT");
		quitButton.setLayoutX(450);
        quitButton.setLayoutY(400);
	    quitButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		//--------Quit button action------
		quitButton.setOnAction(
			e->{
				Platform.exit();
			}
		);
		
		//------ok button------
		Button okButton=new Button("OK");
		okButton.setTranslateX(90d);
		okButton.setTranslateY(280d);
	    okButton.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		
		//---------VBox for name and ok button------
		VBox v1=new VBox();
		v1.getChildren().addAll(l1,nameField,okButton);
		
		//-----------Group for name and ok button---------
		Group nameGroup = new Group(backgroundImageView,v1);
		//-----------group for play high quit button--------
        Group buttonGroup = new Group(playButton,highScoreButton,quitButton);
		buttonGroup.setVisible(false);
		//--------ok button action------
		okButton.setOnAction(
			e->{
			
				name=nameField.getText();
				v1.setVisible(false);
				buttonGroup.setVisible(true);
			}
		);
   
         Group root=new Group(nameGroup,buttonGroup);  
	     scene = new Scene(root,WIDTH,HEIGHT) ;
	     stage.setScene(scene) ;
	     stage.show() ;
	}
	
	
	public static void changeScene(int choise){
		if(choise==0)
		{
			SCORE=0;
			stage.setScene(scene) ;	
			stage.show() ;
		}
		else if(choise==1)
		{
			lebel1SceneObject=new Lebel1Scene();
			stage.setScene(lebel1SceneObject.getScene()) ;	
			stage.show() ;			
		}
		else if(choise==2)
		{
			lebel2SceneObject=new Lebel2Scene();
			stage.setScene(lebel2SceneObject.getScene()) ;	
			stage.show() ;			
		}
		else if(choise==3)
		{
			lebel3SceneObject=new Lebel3Scene();
			stage.setScene(lebel3SceneObject.getScene()) ;	
			stage.show() ;			
		}
		else if(choise==4)
		{
			scoreObject=new Score();
			stage.setScene(scoreObject.getScene()) ;	
			stage.show() ;			
		}
		
		
	}
	
	public static void sendScore()
	{
		playerServiceObjet.checkNewHighScore(name,SCORE);
	}
	
}