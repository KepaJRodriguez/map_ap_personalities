package il.org.yadvashem.map_ap_personalities;

import java.util.HashMap;
import java.util.List;

public class ListMatches {

	public static HashMap<String, String> listMatches(List<AccessPoint> persAccessPoints,
			List<Person> ehriPersonalities, String option) {

		HashMap<String, String> matches = new HashMap<String, String>();

		for (int i = 0; i < persAccessPoints.size(); i++) {
			AccessPoint ap = persAccessPoints.get(i);
			for (int idx = 0; idx < ehriPersonalities.size(); idx++) {

				Person person = ehriPersonalities.get(idx);

				if (option.equals("complete")) {
					if (AssessMatch.assessMatchComplete(ap, person) == true) {
						matches.put(ap.getAPText(), person.getName());
						System.out.println(ap.getAPText() + "\t----\t" + person.getName());
					}
				}
				if (option.equals("names")) {
					if (AssessMatch.assessMachNameString(ap, person) == true) {
						matches.put(ap.getAPText(), person.getName());
						System.out.println(ap.getAPText() + "\t----\t" + person.getName());
					}
				}

			}

		}

		return matches;
	}

}
