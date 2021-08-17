package com.lockedme;

//required imports for SourceCode
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager
{
	/**
	 * This method will return the file names from the folder.
	 * @param myfolderpath
	 * @return List<String>
	 */
		public static List<String> getAllFiles(String myfolderpath)
		{
				//Creating File Object
				File f1=new File(myfolderpath);
				
				//Getting all the files into FileArray
				File[] listOfFiles=f1.listFiles();
				
				//Declare a list to store file names
				List<String> fileNames=new ArrayList<String>();
				
				for(File f:listOfFiles)
					fileNames.add(f.getName());
				
				//returns the list
				return fileNames;
		
	}
	
	   /**
	    * This method will create a file or append content into the file specified
	    * @param myfolderpath
	    * @param filename
	    * @param content
	    * @return boolean
	    */
	
	   public static boolean createFiles(String myfolderpath,String filename,List<String> content)
	   {
		 
			   //Initializing try,catch blocks to handle Exceptions 
			   try
			   {
					   //Creating file object
					   File f1=new File(myfolderpath,filename);
					   
					   //Initializing FileWriter
					   FileWriter fw=new FileWriter(f1);
					   
					   //Using forEach loop to write content into the file
					   for(var s:content)
					   {
						   fw.write(s+"\n");
					   }
					   //Closing FileWriter
					   fw.close();
					   return true;
				   
			      }
			   //Catch block handles Exceptions if any
			   catch(Exception Ex)
			   {
				       return false;
				}
			   
	     }
	   
	   /**
	    * This method will delete the file if it exists
	    * @param myfolderpath
	    * @param fileName
	    * @return
	    */
	   public static boolean deleteFiles(String myfolderpath,String fileName)
	   {
			   //Adding folder path with file name and creating file object
				  File file=new File(myfolderpath+"\\"+fileName);
					   
					   //Initializing try,catch blocks to handle Exceptions	  
						  try
						  {
								  if(file.delete())
									  return true;
								  else
									  return false;
						  }
						  //Catch block handles Exceptions if any
						  catch(Exception Ex)
						  {
							        return false;
						  }
		  }
	   
	   /**
	    * This method will search the specified file from the folder 
	    * @param myfolderpath
	    * @param fileName
	    * @return
	    */
	   public static boolean searchFiles(String myfolderpath,String fileName)
	 {
					   //Adding folder path with file name and creating file object
						  File file=new File(myfolderpath+"\\"+fileName);
						
						//Checking Whether the file exists or not using if-else loop    
						 
						  if(file.exists())
							  return true;
						  else
							  return false;
		  }
}


