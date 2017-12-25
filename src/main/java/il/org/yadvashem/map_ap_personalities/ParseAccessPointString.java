package il.org.yadvashem.map_ap_personalities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseAccessPointString {

	public static AccessPoint parseAccessPointString(String apstring) {

		AccessPoint ap = new AccessPoint();

		List<String> years = new ArrayList<String>();
		List<String> fragments = new ArrayList<String>();

		String apstring_normalized = apstring.replace(",", " ").replace("-", " ").replace("(", " ").replace(")", " ")
				.replace("*", " ").replace(".", " ").replace("/", " ");
		String[] ap_splitted = apstring_normalized.split(" ");
		String ap_string_without_date = apstring.replace(",", " ").replace("-", " ").replace("(", " ").replace(")", " ")
				.replace("*", "").replace(".", " ").replace("/", "").replaceAll("\\d", "").replaceAll("\\s{2,}", " ").trim();;
		
		for (int i = 0; i < ap_splitted.length; i++) {
			Pattern pattern_year = Pattern.compile("(\\d{4})");
			Pattern pattern_fragment = Pattern.compile("([a-zA-Z]+)");
			Matcher matcher_year = pattern_year.matcher(ap_splitted[i]);
			Matcher matcher_fragment = pattern_fragment.matcher(ap_splitted[i]);
			if (matcher_year.find()) {
				years.add(matcher_year.group(1));
			} else {
				if (matcher_fragment.find()) {
					String nameFragment = matcher_fragment.group(1);
					if (nameFragment.length() > 2) {
						fragments.add(matcher_fragment.group(1));
					}
				}
			}

		}

		ap.setAPText(apstring);
		ap.setDates(years);
		ap.setPartsOfName(fragments);
		ap.setCleanedName(ap_string_without_date);

		return ap;
	}

}
