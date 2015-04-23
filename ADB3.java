import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class ADB3{
  ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
  ArrayList<HashSet<String>> dataSet = new ArrayList<HashSet<String>>();
  public static void main(String[] args) {
 
	ADB3 obj = new ADB3();
	obj.getData();
 
  }
 
  public void getData(){
	String csvFile = "newYork.csv";
	BufferedReader br = null;
	try {
		br = new BufferedReader(new FileReader(csvFile));
		String line = br.readLine();
		for(int i=0;i<line.split(",").length-1;i++){
			dataSet.add(new HashSet<String>());
		}
		while ((line = br.readLine()) != null) {
			String[] currLine = line.split(",");
			ArrayList<String> curr = new ArrayList<String>();
			for(int i=0;i<currLine.length-1;i++){
				curr.add(currLine[i]);
				dataSet.get(i).add(currLine[i]);
			}
			data.add(curr);
		}
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	for(ArrayList<String> a : data){
		System.out.println(a);
	}
	for(HashSet<String> a: dataSet){
		System.out.println(a);
	}
  }
 
}