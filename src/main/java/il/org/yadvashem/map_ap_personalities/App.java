package il.org.yadvashem.map_ap_personalities;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String ehriTable = args [0];
       String apTable = args[1];
        
       
        List<Person> ehriPersonalities = ParsePersonalitiesTable.parsePersonalitiesTable(ehriTable);
        System.out.println(ehriPersonalities.size());
        List<AccessPoint> persAccessPoints = ParseAccessPointsTable.readAccessPointsTable(apTable);
        //ComputeSimilarity.findSimilars(persAccessPoints, ehriPersonalities);
        
        
    }
}
