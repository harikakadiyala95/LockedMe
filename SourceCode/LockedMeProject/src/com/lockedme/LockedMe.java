package com.lockedme;

//Importing required imports for SourceCode 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMe
{
  //Assigning the folder path to the variable "myfolderpath"
	static final String myfolderpath="D:\\MyPhase1Project\\LockedMeFiles";
	
  public static void main(String[] args)
    {
	  int proceed=1;
	  //Initializing a do-while loop
	  do
	  {
	  //Variable declaration
	  Scanner obj=new Scanner(System.in);
	  int ch;
	  //Menu
	  displayMenu();
	  
	  //Reading choice from the user
	  System.out.println("\t\t\tEnter your choice:");
      ch=Integer.parseInt(obj.nextLine());
      
      //using switch case to read input from user.
      switch(ch)
      {
		      case 1:getAllFiles();
		      break;      
		      case 2:createFiles();
		      break;
		      case 3:deleteFiles();
		      break;
		      case 4:searchFiles();
		      break;
		      case 5:System.exit(0);
		      break;
		      default:System.out.println("Invalid option");
		      break; 
      }
    }while(proceed>0);
  }  
  
  /**
   * This method displays the menu of LockedMe.com,which allows the user to view,add,delete,search the files in the directory.
   * 
   */
	  public static void displayMenu()
	  {
	  System.out.println("$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$");
	  System.out.println("\t\t\tLockedMe.com");
	  System.out.println("$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$");
	  System.out.println("\t\t\t1.Display all files");
	  System.out.println("\t\t\t2.Add a new file");
	  System.out.println("\t\t\t3.Delete a file");
	  System.out.println("\t\t\t4.Search a file");
	  System.out.println("\t\t\t5.Exit");
	  System.out.println("$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$");
	  }  
	  
	  
  /**
   * This method will return the file names from the folder.
   **/
  public static void getAllFiles()
  {
	
	  //Getting all the file names from the folder using lists
	 List<String> fileNames=FileManager.getAllFiles(myfolderpath);
	 
	 //Checking whether the directory has files or not using if-else loop
	if(fileNames.size()==0)
		System.out.println("There are no files in the directory");
	else
	{
		System.out.println("Here is the list of all the files in the directory");
	
		//Printing all the file names present in the folder using forEach loop
		 for(String f:fileNames)
			 System.out.println(f);
  }
    }
  
  
  /**
   * This method will create a file or append content into the file specified
   */
  public static void createFiles()
  {
	  
	//Scanner declaration
		  Scanner obj=new Scanner(System.in);
		  
	//Variable declaration
	          String fileName;
		  int linesCount;
		  
	//Creating a string array for content
	          List<String> content=new ArrayList<String>();
		 
	//Read file name from user 
		  System.out.println("Enter file name");
		  fileName=obj.nextLine();
		  
	//Read number of lines from user
		  System.out.println("Enter how many lines you want to enter into the file");
		  linesCount=Integer.parseInt(obj.nextLine());
		  
	//read lines(content) from the user
		  for(int i=1;i<=linesCount;i++)
		  {
			  System.out.println("Enter line "+i+":");
			  content.add(obj.nextLine());
		  }
		  
	//save the content into the file
		  boolean isSaved=FileManager.createFiles(myfolderpath,fileName,content);

	//Checking if the content that we entered is saved into the file or not

		   if(isSaved)
			  System.out.println("File and data that you entered have been saved successfully");
		  else
			  System.out.println("Some error occured..please contact admin@harika.com");
		  
	    }
  
  
  /**
   *  This method will delete the file if it exists
   */
  public static void deleteFiles()
  {
	  
	  //Variable declaration
	  String fileName;
	  
	  //Initializing Scanner object
	  Scanner obj=new Scanner(System.in);
	  
	  //Reading file name from the user
	  System.out.println("Enter the file name to be deleted");
	  fileName=obj.nextLine();
	   
	  //Deleting the given file
	  boolean isDeleted=FileManager.deleteFiles(myfolderpath,fileName);
	  
	  //Checking whether the file is deleted or not
	  if(isDeleted)
		  System.out.println("File deleted successfully");
	  else
		  System.out.println("The file name you entered does not exist");
 	  
     }
  
  
  /**
   * This method will search the specified file from the folder 
   */
  public static void searchFiles()
  {
	
	  //Variable declaration
	  String fileName;
	  
	  //Initializing Scanner object
	  Scanner obj=new Scanner(System.in);
	  
	  //Reading file name from the user
	  System.out.println("Enter the file name to be searched");
	  fileName=obj.nextLine();
	   
	  //Deleting the given file
	  boolean isFound=FileManager.searchFiles(myfolderpath,fileName);
	  
	  //Checking whether the file is deleted or not
	  if(isFound)
		  System.out.println("File is present in the folder");
	  else
		  System.out.println("The file name you entered does not exist");
	
  }

}

