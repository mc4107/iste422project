import java.io.*;
import java.util.*;     //for ArrayList
import javax.swing.*;   //for JOptionPane

public abstract class ConvertFileParser{
   protected BufferedReader br;
   protected ArrayList alTables = new ArrayList<EdgeTable>();
   protected ArrayList alFields = new ArrayList<EdgeField>();
   public static final String DELIM = "|";
   
   public EdgeTable[] getEdgeTables() {
      return (EdgeTable[])alTables.toArray(new EdgeTable[alTables.size()]);
   }
   
   public EdgeField[] getEdgeFields() {
      return (EdgeField[])alFields.toArray(new EdgeField[alFields.size()]);
   }
   
   public abstract void parseFile() throws IOException;
     
   public void openFile(File inputFile, String firstLineId) {
      System.out.println("open " + inputFile.getName() + ", firstLine: " + firstLineId);
      try {
         br = new BufferedReader(new FileReader(inputFile));
         //test if file type is correct
         if (br.readLine().trim().startsWith(firstLineId)) {
            this.parseFile(); //parse the file
            br.close();
         } 
         else { //the file chosen is something else
            JOptionPane.showMessageDialog(null, "Unrecognized/incorrect file format");
         }
      } // try
      catch (FileNotFoundException fnfe) {
         System.out.println("Cannot find \"" + inputFile.getName() + "\".");
         System.exit(0);
      }
      catch (IOException ioe) {
         System.out.println(ioe);
         System.exit(0);
      }
   } // openFile()
   
}