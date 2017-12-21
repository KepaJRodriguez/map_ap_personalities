package il.org.yadvashem.map_ap_personalities;

import java.util.ArrayList;
import java.util.List;

public class AccessPoint {

	private String ap_text = "";
	private List<String> dates = new ArrayList<String>();
	private List<String> parts_of_name = new ArrayList<String>();
	
	
    public void setAPText( String ap_text ){
        this.ap_text = ap_text;
    }
    
    public void setDates( List<String> dates ){
        this.dates = dates;
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
    
}
