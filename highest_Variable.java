import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class highest_Variable{
   

    public static void main(String[] args) {
        
        Map<String,Integer> nametopercentage = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the map");
        int n = sc.nextInt();
        for(int i =0;i<n;i++)
        {
            System.out.println("enter the Name :");
            String name = sc.next();
            System.out.println("enter percentage:");
            int percentage = sc.nextInt();
            nametopercentage.put(name,percentage);
        }

        int maxpercentage = -1;
        String namemax = null;
          for(Map.Entry<String,Integer> entry : nametopercentage.entrySet())
          {
              if(entry.getValue() > maxpercentage)
              {
                maxpercentage= entry.getValue();
                namemax= entry.getKey();
              }
          }

          System.out.println("The greatest percentage is : "+maxpercentage+"and name of "+namemax);

    }
}
