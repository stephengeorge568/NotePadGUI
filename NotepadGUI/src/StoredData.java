import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class StoredData 
{
	private String savedText;
	private File file;
	
	/**
	 * Constructor for StoredData
	 */
	public StoredData()
	{
		file = new File("stored_data.txt");
		setSavedText(scanText());
	}

	/**
	 * Scans the text within File file, parsing each line of text and storing it to String savedText.
	 * @return the text in File file.
	 */
	public String scanText()
	{
		String temp = "";
		Scanner scan;
		try {
			scan = new Scanner(file);
			
			while(scan.hasNextLine())
			{
				
				temp += scan.nextLine();
				temp += "\n";
			}
			scan.close();
			return temp;
		} catch (FileNotFoundException e) {
			System.out.println("scanText() - FNFE");
			return temp;
			
		}
		
	}
	
	/**
	 * Writes the value of input to the File file .txt.
	 * @param input - the new saved String value to be stored in "stored_data.txt".
	 */
	public void writeText(String input)
	{
		PrintWriter print;
		try {
			print = new PrintWriter(file);
			print.print(input);
			print.close();
		} catch (FileNotFoundException e1) {
			System.out.println("writeText() - FNFE");
		}
	}
	
	
	//Getters and Setters
	
	public String getSavedText() 
	{
		return savedText;
	}

	public void setSavedText(String savedText) 
	{
		this.savedText = savedText;
	}

	
	
	
	
	
	
	
	
	
	
}
