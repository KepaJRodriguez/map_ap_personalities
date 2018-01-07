package il.org.yadvashem.map_ap_personalities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import com.opencsv.CSVWriter;

public class PrintTable {

	
	public static void printTableOfMatches(String ap_table,
			HashMap<Integer, HashMap<AccessPoint, Person>> listMatches) throws IOException {

		String nameOutputFile = ap_table.replace(".csv", "") + "_matching.csv";

		CSVWriter writer = new CSVWriter(new FileWriter(nameOutputFile));

		String header = "Access point text#Source auth. list#Auth. file nr.#EHRI auth. Name#EHRI autht. list#EHRI auth. file";
		writer.writeNext(header.split("#"));

		for (int key : listMatches.keySet()) {
			for (AccessPoint key2 : listMatches.get(key).keySet()) {
				String row = key2.getAPText() + "#" + key2.getSource() + "#" + key2.getAuthFileNumber() + "#"
						+ listMatches.get(key).get(key2).getName() + "#" + "ehri_pers" + "#"
						+ listMatches.get(key).get(key2).getID();				
				writer.writeNext(row.split("#"));
			}
		}

		writer.close();
	}
	
}
