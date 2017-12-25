package il.org.yadvashem.map_ap_personalities;

public class AssessMatch {

	public static boolean assessMachNameString(AccessPoint ap, Person person){
		boolean isMatch = false;
	
		double stringSimilarity = ComputeStringSimilarity.computeStringSimilarity(ap, person);
		if (stringSimilarity >= .95) {
			isMatch = true;
		}
		
		return isMatch;
	}
	
	public static boolean assessMatchComplete(AccessPoint ap, Person person) {

		boolean isMatch = false;
		
		double stringSimilarity = ComputeStringSimilarity.computeStringSimilarity(ap, person);
		String datesAgreement = CompareDates.compareYears(ap, person);
		
		if (stringSimilarity >= .95) {
			if (!datesAgreement.equals("NEGATIVE")) {
				isMatch = true;
			}
		} else {
			if (stringSimilarity >= .90) {
				if (datesAgreement.equals("TOTAL") || datesAgreement.equals("PARTIAL")) {
					isMatch = true;
				}
			} else {
				if (stringSimilarity >= .85) {
					if (!datesAgreement.equals("TOTAL")) {
						isMatch = true;
					}
				}
			}
		}
		return isMatch;
	}

}
