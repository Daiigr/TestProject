package Daiigr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileList{
    private File ListFile;
    private BufferedReader reader;
    private BufferedWriter writer;
    private String currentLine;
    private String FileName;
  

    public FileList(String FileName) throws Exception{
        this.FileName = FileName;
        try {
            ListFile = new File(FileName);
        } catch (Exception e) {

        }

        if(!ListFile.isFile()){
             ListFile.createNewFile();
         }        
    }

         

    public void AddItem(String id) throws IOException{
        writer = new BufferedWriter(new FileWriter(FileName,true));
        writer.newLine();
        writer.append(id);
       writer.close();

    
    }
    public void RemoveItem(String id) throws IOException{
        writer = new BufferedWriter(new FileWriter(FileName));
        reader = new BufferedReader(new FileReader(FileName));
     
        while((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(id)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }

       

    }
    public boolean doesExist(String id) throws IOException{
        try {
            while((currentLine = reader.readLine()) != null){
                if(currentLine == id){
                    return true;
                }
            }          
        } catch (Exception e) {
        }
        return false;


    }


    
}
