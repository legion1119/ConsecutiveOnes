/*
 * converts decimal to binary and then calculates amount of consecutive
 * ones in the binary
 */
import java.io.*;
import java.util.*;



public class ConsecutiveOnes 
{
    public static String decToBin(String binary, int x)
    {
        if (x == 0)
        {
            return binary;
        }
        else
        {
            int remainder;
                  
            remainder = x%2;
            binary = remainder + binary;
            x = x/2;
            
            return decToBin(binary, x);
        }
       
    }
    
    public static int consecutive(String binary)
    {
        int max = 0;
        int consecutive = 0;
        for (int i = 0; i < binary.length(); i++)
        {
            
            if (binary.charAt(i) == '1')
            {
                consecutive++;    
                if (consecutive > max)
                {
                    max = consecutive;
                }
            }
            else
            {  
                consecutive = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String binary = "";
        
        binary = decToBin(binary, n);
        System.out.println(consecutive(binary));        
    }
}