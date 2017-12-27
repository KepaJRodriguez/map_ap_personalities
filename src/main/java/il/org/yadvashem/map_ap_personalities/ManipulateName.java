package il.org.yadvashem.map_ap_personalities;

public class ManipulateName {

	public static String rearrangeName(String name){
	
		String rearrangedName = "";
		String [] splitted = name.split(",");
		
		if (splitted.length ==2 ){
			rearrangedName = splitted[1] + " " + splitted[0];			
		}
		
		return rearrangedName;		
	}
	
	public static String simplifyName(String name){
		
		String simplifiedName = "";
		
		simplifiedName = name.replaceAll(" ", "").toLowerCase();
				
		return simplifiedName;
	}
	
}
