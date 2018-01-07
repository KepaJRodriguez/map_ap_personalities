package il.org.yadvashem.map_ap_personalities;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) throws IOException {

		if (args.length != 3) {
			System.out.println(
					"\nPlease give to the tool the parameters mode, table of EHRI vocabulary items\n and table of extracteda access points");
			System.out.println("$map_ap_personalities.jar [\"names|complete\"] ehriTable accessPointTable\n");

		} else {
			String mode = args[0];
			String ehriTable = args[1];
			String apTable = args[2];
			
			List<Person> ehriPersonalities = ParsePersonalitiesTable.parsePersonalitiesTable(ehriTable);
			//System.out.println(ehriPersonalities.size());
			List<AccessPoint> persAccessPoints = ParseAccessPointsTable.readAccessPointsTable(apTable);
			//HashMap<Integer, HashMap<AccessPoint, Person>> listMatches = ListMatches.listMatches(persAccessPoints, ehriPersonalities, mode);
			
			//System.out.println(persAccessPoints.size());
			if (mode.equals("names") || mode.equals("complete")) {
				HashMap<Integer, HashMap<AccessPoint, Person>> listMatches = ListMatches.listMatches(persAccessPoints, ehriPersonalities, mode);
				PrintTable.printTableOfMatches(apTable, listMatches);
			} else {
				System.out.println(
						"Please give to the tool the parameters mode, table of EHRI vocabulary items\n and table of extracteda access points");
				System.out.println("$map_ap_personalities.jar [\"names|complete\"] ehriTable accessPointTable");
			}
		}
	}
}
