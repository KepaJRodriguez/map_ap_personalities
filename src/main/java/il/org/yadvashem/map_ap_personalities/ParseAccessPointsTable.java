package il.org.yadvashem.map_ap_personalities;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class ParseAccessPointsTable {

	public static List<AccessPoint> readAccessPointsTable(String tablename) throws IOException{
		List<AccessPoint> personAp = new ArrayList<AccessPoint>();
		
		CSVReader reader = new CSVReader(new FileReader(tablename));
		String[] nextLine;

		while ((nextLine = reader.readNext()) != null) {
			AccessPoint personAP = new AccessPoint();
			personAP = ParseAccessPointString.parseAccessPointString(nextLine[0]);
			
		}
		reader.close();
		return personAp;
	}
	
	
}
