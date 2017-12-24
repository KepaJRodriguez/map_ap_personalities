package il.org.yadvashem.map_ap_personalities;

public class AssessMatch {

	public static boolean assessMatch(AccessPoint ap, Person person){
		
		boolean isMatch = false;
		
		double stringSimilarity = ComputeStringSimilarity.computeStringSimilarity(ap, person); 
		String datesAgreement = CompareDates.compareYears(ap, person);
		
		if (stringSimilarity >= .95 && !datesAgreement.equals("NEGATIVE")){
			isMatch = true;
		} else {
			if (stringSimilarity >= .90 && (datesAgreement.equals("TOTAL") || datesAgreement.equals("PARTIAL") )){
				isMatch = true;
			} else {
				if (stringSimilarity >= .85 && !datesAgreement.equals("TOTAL")){
					isMatch = true;
				}
			}			
		}		
		return isMatch;
	}
	
	
}
