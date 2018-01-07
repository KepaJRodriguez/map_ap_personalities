package il.org.yadvashem.map_ap_personalities;

import java.util.List;

import info.debatty.java.stringsimilarity.JaroWinkler;

public class ComputeStringSimilarity {

	public static double computeStringSimilarity(AccessPoint ap, Person person) {
		
		double similarity = 0.0;

		JaroWinkler jw = new JaroWinkler();
		
		String simplified_name = ManipulateName.simplifyName(person.getName());
		String simplified_ap = ManipulateName.simplifyName(ap.getCleanedName());
		String inverted_ap = ManipulateName.rearrangeName(ManipulateName.simplifyName(ap.getCleanedName()));
		
		similarity = jw.similarity(simplified_ap, simplified_name);
		
		if (jw.similarity(inverted_ap, simplified_name) > similarity){
			similarity = jw.similarity(inverted_ap, simplified_name);
		}
		
		
		List<String> aliases = person.getAliases();
		if (aliases.size() > 0) {
			for (int index = 0; index < aliases.size(); index++) {
				String simplified_alias = ManipulateName.simplifyName(aliases.get(index));
				if (jw.similarity(ap.getCleanedName(), simplified_alias) > similarity) {
					similarity = jw.similarity(ap.getCleanedName(), simplified_alias);
				}
				if (jw.similarity(inverted_ap, simplified_alias) > similarity) {
					similarity = jw.similarity(inverted_ap, simplified_alias);
				}				
			}
		}
		return similarity;
	}

}
