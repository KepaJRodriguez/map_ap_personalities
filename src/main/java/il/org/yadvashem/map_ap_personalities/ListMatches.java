package il.org.yadvashem.map_ap_personalities;

import java.util.HashMap;
import java.util.List;

public class ListMatches {

	public static HashMap<Integer, HashMap<AccessPoint, Person>> listMatches(List<AccessPoint> persAccessPoints,
			List<Person> ehriPersonalities, String option) {

		HashMap<Integer, HashMap<AccessPoint, Person>> matches = new HashMap<Integer, HashMap<AccessPoint, Person>>();
		int match_number = 0;
		for (int i = 0; i < persAccessPoints.size(); i++) {
			AccessPoint ap = persAccessPoints.get(i);
			for (int idx = 0; idx < ehriPersonalities.size(); idx++) {

				Person person = ehriPersonalities.get(idx);

				if (option.equals("complete")) {
					if (AssessMatch.assessMatchComplete(ap, person) == true) {
						match_number++;
						HashMap<AccessPoint,Person> match = new HashMap<AccessPoint,Person>();
						match.put(ap, person);
						matches.put(match_number, match);
					}
				}
				if (option.equals("names")) {
					if (AssessMatch.assessMachNameString(ap, person) == true) {
						match_number++;
						HashMap<AccessPoint,Person> match = new HashMap<AccessPoint,Person>();
						match.put(ap, person);
						matches.put(match_number, match);
					}
				}

			}

		}

		return matches;
	}

}
