package flashcardrevolution;
import java.util.*;
public class FRStats
{
	public static FRFlashcard topTenQuestionsWrong[] = new FRFlashcard[10];
	public static FRTag topTenTagsWrong[] = new FRTag[10];
	public static String topTenTags[] = new String[10];
        
        	/**
	 * Returns all of the stats as a big long string to be printed in the stats screen.
         * Finds top ten missed questions and top ten missed tags.
	 * @author Jack Lindsey
	 */
	public static String getStat()
                
	{
		String outputString = "<html>";  //java allows for html coded strings, which lets you do multiline swing labels
                
                if (FRMain.cards.size()==0){
			outputString += "There are no stats to display.</html>";
		}
		else
		{
		
			outputString += "Top Ten Missed Questions (Note that only ten will be displayed even in the case of ties at the bottom):<br>";
			Collections.sort(FRMain.cards, new Comparator<FRFlashcard>(){
				public int compare(FRFlashcard first, FRFlashcard second) //sorts questions based on answer accuracy percentage
				{
					Double firstRightPercentage = 1 - first.getWrongPercentage();
					Double secondRightPercentage = 1 - second.getWrongPercentage();
					return firstRightPercentage.compareTo(secondRightPercentage);
				}
			});
			for (int i = 0; i < 10; i++)
			{
				topTenQuestionsWrong[i] = FRMain.cards.get(i);
				outputString += topTenQuestionsWrong[i].getQuestion() + " - Percentage Wrong: " + topTenQuestionsWrong[i].getWrongPercentage() + "%<br>";
				if (i==FRMain.cards.size()-1)
				{
					break;
				}
			}
			outputString +="<br>";
			outputString += "Top Ten Missed Tags: (Note that only ten will be displayed even in the case of ties at the bottom)<br>";
			for (FRFlashcard frf : FRMain.cards) 
			{
				for (int i  = 0; i<frf.getTags().size(); i++) //finds all tags in the Universe
				{
					boolean addNew = true;
					for (FRTag theTag : FRTag.tagsList)
					{
						if (frf.getTags().get(i).equals(theTag.tagName))
						{
							addNew = false;
						}
					}
					if (addNew)
					{
						new FRTag(frf.getTags().get(i));
					}
				}
			}
			Collections.sort(FRTag.tagsList, new Comparator<FRTag>() { //sorts tags based on cumulative corrects and incorrects of the cards 
                                                                                   //with those tags
				public int compare(FRTag first, FRTag second)
				{
					Double firstRightPercentage = 1 - first.getWrongPercentage(first.getCardsWithTag());
					Double secondRightPercentage = 1 - second.getWrongPercentage(second.getCardsWithTag());
					return firstRightPercentage.compareTo(secondRightPercentage);


				}
			});
			for (int i = 0; i < 10; i++)
			{
				topTenTagsWrong[i] = FRTag.tagsList.get(i);
				outputString += topTenTagsWrong[i].tagName + " - Percentage Wrong: " + topTenTagsWrong[i].getWrongPercentage(topTenTagsWrong[i].getCardsWithTag()) + "%<br>";
				if (i==FRTag.tagsList.size()-1)
				{
					break;
				}
			}
		}
			
		return outputString;
	}
		
}

