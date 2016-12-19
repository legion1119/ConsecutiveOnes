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
            //cycle through the decimal until the binary is reached
            return decToBin(binary, x);
        }
    }
    
    public static int consecutive(String binary)
    {
        int max = 0;
        int consecutive = 0;
        for (int i = 0; i < binary.length(); i++)
        {
            //calculates the maximum number of consecutive ones in the  given
        	//binary 
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
        int n;
        String binary = "";
        //Retrieve input from user
        System.out.print("Enter number you wish to be converted to binary: ");
        n = input.nextInt();
        binary = decToBin(binary, n);//calls method to convert decimal to binary
        System.out.println(n + " converted to binary is " + binary + ".");
        System.out.print("The maximum number of consecutive ones in this binary is ");
        System.out.print(consecutive(binary));
    }
}