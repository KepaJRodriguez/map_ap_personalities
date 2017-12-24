package il.org.yadvashem.map_ap_personalities;

import java.util.HashMap;
import java.util.List;

import info.debatty.java.stringsimilarity.JaroWinkler;

public class ComputeStringSimilarity {

	// Maybe decompose it in different classes
	// One for string similarity
	// Second one for less similarity but common dates
	// Third one for inclusion of fragments
	
	public static HashMap<String, String> findSimilars(List<String> accessPoints, List<Person> personalitiesEHRI){
		HashMap<String, String> similars = new HashMap<String,String>();
		
		JaroWinkler jw = new JaroWinkler();
		
		for (int i = 0; i < accessPoints.size(); i++){
			double similarity = 0.0;
			
			for (int idx=0; idx<personalitiesEHRI.size(); idx++){
				similarity = jw.similarity(accessPoints.get(i), personalitiesEHRI.get(idx).getName());
				
				List<String> aliases = personalitiesEHRI.get(idx).getAliases();
				if (aliases.size() > 0){
					for (int index=0; index<aliases.size(); index++){
						if (jw.similarity(accessPoints.get(i), aliases.get(index)) > similarity){
							similarity = jw.similarity(accessPoints.get(i), aliases.get(index));
						}
					}
				}
				
				if (similarity >= 0.95){
					System.out.println(accessPoints.get(i) + "\t---\t" + personalitiesEHRI.get(idx).getName() ); 
				}
			}
			
		}
		
		return similars;
	}
	
}
