package il.org.yadvashem.map_ap_personalities;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of parts of an access point for partial matching
 * @author kepa
 *
 */


public class AccessPoint {

	private String ap_text = "";
	private List<String> dates = new ArrayList<String>();
	private List<String> parts_of_name = new ArrayList<String>();
	private String cleanedName = "";
	
    public void setAPText( String ap_text ){
        this.ap_text = ap_text;
    }
    
    public void setDates( List<String> dates ){
        this.dates = dates;
    }
    
    public void setCleanedName(String cleanedName){
    	this.cleanedName = cleanedName;
    }
    
    public void setPartsOfName( List<String> parts_of_name ){
        this.parts_of_name = parts_of_name;
    }
    
    public String getAPText(){
        return this.ap_text;
    }
    
    public List<String> getDates(){
        return this.dates;
    }
    
    public List<String> getPartsOfName(){
        return this.parts_of_name;
    }
    
    public String getCleanedName(){
    	return this.cleanedName;
    }
    
}
