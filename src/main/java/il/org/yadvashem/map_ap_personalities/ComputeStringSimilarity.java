package il.org.yadvashem.map_ap_personalities;

import java.util.List;

import info.debatty.java.stringsimilarity.JaroWinkler;

public class ComputeStringSimilarity {

	public static double computeStringSimilarity(AccessPoint ap, Person person) {
		
		double similarity = 0.0;

		JaroWinkler jw = new JaroWinkler();
		similarity = jw.similarity(ap.getAPText(), person.getName());

		List<String> aliases = person.getAliases();
		if (aliases.size() > 0) {
			for (int index = 0; index < aliases.size(); index++) {
				if (jw.similarity(ap.getAPText(), aliases.get(index)) > similarity) {
					similarity = jw.similarity(ap.getAPText(), aliases.get(index));
				}
			}
		}

		return similarity;
	}

}
