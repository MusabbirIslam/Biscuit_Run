package BiscuitRun.Data;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import BiscuitRun.Model.Player;
public class DataBase
{
	private Statement stmt;
	private Connection con;
	private Player [] player;
	
	public DataBase(){
		
	   try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","tiger");
			stmt= con.createStatement();
		  }
	
	  catch(Exception e)
		  {
				System.out.println("---------Something gone wrong-------------");
				System.out.println(e.getMessage());
		  }
		  
		  player=new Player[3];
		  player[0]=new Player();
		  player[1]=new Player();
		  player[2]=new Player();
		  getFromDatabase();
	
	}
	
	public void getFromDatabase()
	{
		  try{
			ResultSet rs=stmt.executeQuery("Select name,score from biscuit_Run order by score desc");
		   
		   
		   for(int i=0;rs.next();i++)
		   {
			  player[i].setName(rs.getString(1));
			  player[i].setScore(rs.getInt(2));
		   }
			}
			
		  catch(Exception e)
			{
			 System.out.println("Error in Database getFromDatabase function");
			}
	}
	
	private void insertNewData()
	{
		for(int i=0;i<3;i++)
		{
			try{
			String query= "update biscuit_run set score="+player[i].getScore()+",name='"+player[i].getName()+"' where position="+(i+1);
			stmt.executeQuery(query);
			}
			catch(Exception e)
			{
			 System.out.println("Error in Database insertNewData function"+e.getMessage());
			}
			
		}
	}
	
	public Player [] getPlayer(){
		return player;
	}
	
	public void setPlayer(Player [] a){
		System.arraycopy(a,0,player,0,3);
		insertNewData();
	}
	
}