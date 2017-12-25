package il.org.yadvashem.map_ap_personalities;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class ParseAccessPointsTable {

	public static List<AccessPoint> readAccessPointsTable(String tablename) throws IOException{
		List<AccessPoint> personAps = new ArrayList<AccessPoint>();
		
		List<String> namesofpeople = new ArrayList<String>();
		
		CSVReader reader = new CSVReader(new FileReader(tablename));
		String[] nextLine;

		while ((nextLine = reader.readNext()) != null) {
			AccessPoint personAP = new AccessPoint();
			personAP = ParseAccessPointString.parseAccessPointString(nextLine[0]);
			personAps.add(personAP);
			namesofpeople.add(nextLine[0]);
			
		}
		reader.close();
		return personAps;
	}
	
	
}
