package il.org.yadvashem.map_ap_personalities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kepa
 * 
 * Object of type person to store the content of EHRI person authority files
 *
 */


public class Person {

	private String identifier = "";
	private String name = "";
	private List<String> dates = new ArrayList<String>();
	private List<String> aliases = new ArrayList<String>();
	
    public void setID( String identifier ){
        this.identifier = identifier;
    }
    
    public void setName( String name ){
        this.name = name;
    }
    
    public void setDates( List<String> dates ){
        this.dates = dates;
    }
    
    public void setAliases( List<String> aliases ){
        this.aliases = aliases;
    }
    
    public String getID(){
        return this.identifier;
    }
    
    public String getName(){
        return this.name;
    }
    
    public List<String> getDates(){
        return this.dates;
    }
    
    public List<String> getAliases(){
        return this.aliases;
    }
}
