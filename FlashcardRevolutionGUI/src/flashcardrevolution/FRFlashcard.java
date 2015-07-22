/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcardrevolution;
import java.util.*;

/**
 *The methods and constructors contained in this class creates a new Flashcard, and then contains the appropriate public getters and setters
 * @author Deager and Jack Lindsey
 */

public class FRFlashcard
{
	private int timesWrong;
	private int timesAsked;
	private double wrongPercentage;
	private String question;
	private String answer;
	private ArrayList <String> tags = new ArrayList<String>();
        /**
 * Creates a new {@link FRFlashcard}
 * @author Vince Cozza (aka Deager4)
 * 
 * @param quest The {@link FRFlashcard#question} for the {@link FRFlashcard}
 * @param ans The {@link FRFLashcard#answer} for the {@link FRFlashcard}
 * @param tag The {@link FRFlashcard#tags} for the {@link FRFlashcard}
 */
	public FRFlashcard(String quest /*question*/, String ans /*answer*/, String tag /*list of tags for this flashcard*/)
	{
		question = quest;
		answer = ans;
		StringTokenizer a = new StringTokenizer(tag, ",");
		int numOfTokens = a.countTokens();
		for(int count = 0; count < numOfTokens; count++)
		{
			tags.add(a.nextToken());
		}
	}
	/**
	 * The Public getter for the {@link #question} of the current {@link FRFlashcard}
	 * @author Vince Cozza (aka Deager4)
	 * 
	 * @return {@link FRFlashcard#question}
	 */
	public String getQuestion()
	{
		return this.question;
	}
	
	/**
	 * The public getter for the {@link #answer} of the current {@link FRFlashcard}
	 * @author Vince Cozza (aka Deager4)
	 * 
	 * @return {@link FRFlashcard#answer}
	 */
	public String getAnswer()
	{
		return this.answer;
	}
	
	/**
	 * The public getter for the ArrayList {@link #tags} of the current {@link FRFlashcard}
	 * @author Vince Cozza (aka Deager4)
	 * 
	 * @return {@link FRFlashcard#tags}
	 */
	public ArrayList<String> getTags()
	{
		return this.tags;
	}
	
	/**
	 * The public getter for the {@link FRFlashcard#timesAsked} value of the current {@link FRFlashcard}
	 * @author Vince Cozza (aka Deager4)
	 * 
	 * @return {@link FRFlashcard#timesAsked}
	 */
	public int getTimesAsked()
	{
		return this.timesAsked;
	}
	
	/**
	 * The public setter for the {@link FRFlashcard#timesAsked} value of the current {@link FRFlashcard}
	 * @author Vince Cozza (aka Deager4)
	 * 
	 * @param input The desired value for the {@link FRFlashcard#timesAsked} value of the current {@link FRFlashcard}
	 */
	public void setTimesAsked(int input)
	{
		this.timesAsked = input;
	}
	
	/**
	 * The public getter for the {@link FRFlashcard#timesWrong} value of the current {@link FRFlashcard}
	 * @author Vince Cozza (aka Deager4)
	 * 
	 * @return {@link FRFlashcard#timesWrong}
	 */
	public int getTimesWrong()
	{
		return this.timesWrong;
	}
	
	/**
	 * The public setter for the {@link FRFlashcard#timesWrong} value of the current {@link FRFlashcard}
	 * @author Vince Cozza (aka Deager4)
	 * 
	 * @param input The desired value of the {@link FRFlashcard#timesWrong} value
	 */
	public void setTimesWrong(int input)
	{
		this.timesWrong = input;
	}
	
	/**
	 * Calculates and returns the %wrong value for the current {@link FRFlashcard}
	 * @author Vince Cozza (aka Deager4)
	 * 
	 * @return {@link FRFlashcard#wrongPercentage}
	 */
	public double getWrongPercentage()
	{
		wrongPercentage = ((double)timesWrong)/((double)timesAsked)*100;
		return wrongPercentage;
	}
	
}
