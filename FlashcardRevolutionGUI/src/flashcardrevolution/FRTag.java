package flashcardrevolution;
import java.util.*;

public class FRTag {
	public static ArrayList<FRTag> tagsList = new ArrayList<FRTag>();
	
	String tagName;
         /**
	 * Creates a new FRTag object
	 * @author Jack Lindsey
	 * 
	 * @param name the {@link FRTag#tagName} of the FRTag
	 */
	public FRTag(String name)
	{
			tagName = name;
			tagsList.add(this);
			
		
	}
	/**
	 * Finds all of the appropriate {@link FRFlashcard}s in {@link FRMain#cards} with the appropriate {@link FRFlashcard#tags} 
	 * @author Jack Lindsey
	 * 
	 * @return {@link FRTag#getCardsWithTag.cardsWithTag}
	 */
	public ArrayList<FRFlashcard> getCardsWithTag()
	{
		ArrayList<FRFlashcard> cardsWithTag = new ArrayList<FRFlashcard>();
		for (FRFlashcard frf : FRMain.cards) 
		{
			for (String tag : frf.getTags())
			{
                                System.out.println(tag);
				if (tag.equals(tagName))
                                {
                                    
                                    cardsWithTag.add(frf);
                                    break;
                                }
			}
		}
		return cardsWithTag;
	}
	
	public double getWrongPercentage(ArrayList<FRFlashcard> cardList)
	{
		int totalWrong = 0;
		int totalAsked=0;
		for (FRFlashcard frf : cardList)
		{
			totalWrong += frf.getTimesWrong();
			totalAsked += frf.getTimesAsked();
		}
		double answer = 100 * (double)totalWrong / (double)totalAsked;
		return answer;
		
	}

}
