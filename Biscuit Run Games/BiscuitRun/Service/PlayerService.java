package BiscuitRun.Service;
import BiscuitRun.Model.Player;
import BiscuitRun.Data.DataBase;
public class PlayerService
{
	private DataBase playerDataBase;
	private Player [] player;
	public PlayerService()
	{
		playerDataBase=new DataBase();
		  player=new Player[3];
		  player[0]=new Player();
		  player[1]=new Player();
		  player[2]=new Player();		
		System.arraycopy(playerDataBase.getPlayer(),0,player,0,3);
	}
	
	//-----check for new high score-----
	public void checkNewHighScore(String name,int score)
	{
		boolean change=false;//check if new score comes
		for(int i=0;i<3;i++)
		{
			if(player[i].getScore()<score)
			{
				String tempName=player[i].getName();
				int tempScore=player[i].getScore();
				player[i].setName(name);
				player[i].setScore(score);
				name=tempName;
				score=tempScore;
				change=true;
			}
		}
		if(change){
			playerDataBase.setPlayer(player);
		}
	}
	
	
	
	public Player [] getScore(){
		return player;
	}
	
	
}