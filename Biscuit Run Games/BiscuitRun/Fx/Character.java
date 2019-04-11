package BiscuitRun.Fx;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.lang.Exception;
class Character implements Runnable{
	public Group characterGroup;
	private final Image [] characterImage;
	private ImageView characterMain;
	public boolean characterFlag,jumpFlag,legFlag;
	private Thread playerThread;
	private int runLoop,jumploop;

	public void run()
	{
		try{
		    Thread.sleep(200);
		}catch(Exception e){  }
		
		
		//loop for running sequency
		while(characterFlag)
		{
			
		try{
		    Thread.sleep(300);
		}catch(Exception e){  }
			
			if (runLoop==1) {
				characterMain.setImage( characterImage[runLoop] );
				runLoop++;
			}
			else if (runLoop==2){
				characterMain.setImage( characterImage[runLoop] );
				runLoop++;
			}
			else if (runLoop==3){
				characterMain.setImage( characterImage[runLoop] );
				runLoop++;
			}
			else{
				characterMain.setImage( characterImage[runLoop] );
				runLoop=1;
			}
			
			
			//-----------machanisom for jumping---------
			try{
				if(jumpFlag==true){
				double jumpY=characterMain.getTranslateY();
				characterMain.setTranslateY(jumpY-35);
				jumploop++;
				if(jumploop>3)
				{
					jumpFlag=false;
				}
				}
				if(jumpFlag==false && jumploop>0){
				fall();
				}
				if(jumploop==0)
					legFlag=true;
				
			}catch(Exception e){
				System.out.println("Jump problem");
			}
	
			
		}
    
	}
	
	Character()
	{
		legFlag=true;
		characterFlag=true;
		jumpFlag=false;
		runLoop=1;jumploop=0;
		//loading image
		characterImage=new Image [5];
		characterImage[0]=new Image("BiscuitRun/Fx/CharacterImage/a.png");
		characterImage[1]=new Image("BiscuitRun/Fx/CharacterImage/b.png");
		characterImage[2]=new Image("BiscuitRun/Fx/CharacterImage/c.png");
		characterImage[3]=new Image("BiscuitRun/Fx/CharacterImage/d.png");	
        characterImage[4]=new Image("BiscuitRun/Fx/CharacterImage/e.png");			
		
		//preparing image for view
		characterMain=new ImageView();
		characterMain.setImage(characterImage[0]);
		characterMain.setFitWidth(60d);
		characterMain.setFitHeight(125d);
		characterMain.setTranslateX(70d);
		characterMain.setTranslateY(332d);
		characterMain.setSmooth(true);
        characterMain.setCache(true);	
		//image group for scene
		characterGroup=new Group();
		characterGroup.getChildren().addAll(characterMain);	
	};
	
	//function for thread starting
	public void startCharacter(){
		playerThread=new Thread(this);
		playerThread.start();
	};
	
	public void jump()
	{
		if(jumploop==0)
		{
			jumpFlag=true;
			legFlag=false;
		}
	}
	
	public void fall()
	{
	double jumpY=characterMain.getTranslateY();
	characterMain.setTranslateY(jumpY+35);
	jumploop--;	
	}
}