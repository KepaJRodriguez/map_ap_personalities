package il.org.yadvashem.map_ap_personalities;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;

public class ParsePersonalitiesTable {

	public static List<Person> parsePersonalitiesTable(String tablename) throws IOException {

		List<Person> ehriPersonalities = new ArrayList<Person>();

		// read the table of vocabulary-export of ERHI
		CSVReader reader = new CSVReader(new FileReader(tablename));
		String[] nextLine;

		while ((nextLine = reader.readNext()) != null) {
			// nextLine[] is an array of values from the line

			if (nextLine[0].matches("ehri_pers-.*")) {
				Person person = new Person();
				List<String> aliases = new ArrayList<String>();
				List<String> dates = new ArrayList<String>();
				person.setID(nextLine[0]);
				person.setName(nextLine[1]);
				if (nextLine[3].length() > 1) {
					aliases = Arrays.asList(nextLine[3].split("\\|"));
				}
				person.setAliases(aliases);
				if (nextLine[3].length() > 1) {
					List<String> dates_row = Arrays.asList(nextLine[5].split("\n"));
					for (int i = 0; i < dates_row.size(); i++) {
						if (dates_row.get(i).length() > 0) {
							dates.add(dates_row.get(i));
						}
					}
				}
				person.setDates(dates);
			}
		}
		reader.close();
		return ehriPersonalities;
	}

}
