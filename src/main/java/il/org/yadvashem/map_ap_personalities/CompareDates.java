package il.org.yadvashem.map_ap_personalities;

public class CompareDates {

	public static String compareYears(AccessPoint ap, Person per) {

		String agreement = "";

		if (ap.getDates().size() == 0 || per.getDates().size() == 0) {
			agreement = "IRRELEVANT";
		} else {
			if (ap.getDates().size() == 2 && per.getDates().size() == 2) {
				int coincidence = 0;
				for (int i = 1; i < ap.getDates().size(); i++) {
					if (per.getDates().contains(ap.getDates().get(i))) {
						coincidence++;
					}
				}
				if (coincidence == 2) {
					agreement = "TOTAL";
				} else {
					if (coincidence == 1) {
						agreement = "PARTIAL";
					} else {
						agreement = "NEGATIVE";
					}
				}
			} else {
				if (ap.getDates().size() == 1 || per.getDates().size() == 1) {
					int coincidence = 0;
					for (int i = 1; i < ap.getDates().size(); i++) {
						if (per.getDates().contains(ap.getDates().get(i))) {
							coincidence++;
						}
					}
					if (coincidence > 0) {
						if (ap.getDates().size() == 1 && per.getDates().size() == 1) {
							agreement = "TOTAL";
						} else {
							agreement = "PARTIAL";
						}
					} else {
						agreement = "NEGATIVE";
					}
				}

			}

		}

		return agreement;
	}

}
