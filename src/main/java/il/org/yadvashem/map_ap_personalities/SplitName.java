package il.org.yadvashem.map_ap_personalities;

public class SplitName {

	public static String splitName(String name){
	
		String rearrangedName = "";
		String [] splitted = name.split(",");
		
		if (splitted.length ==2 ){
			rearrangedName = splitted[1] + " " + splitted[0];			
		}
		
		return rearrangedName;
		
	}
	
}
