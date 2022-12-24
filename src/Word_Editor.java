/*
* Siyanda Mvunyiswa
* Word Editor
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Word_Editor {

    // This constructor removes all duplicated letters and characters
    static String removeDoubles(char[] str, int n){
        int ind = 0;

        for(int i = 0; i < n;i++){
            int j;
            for(j = 0; j < i;j++){
                if(str[i] == str[j]){
                    break;
                }
            }

            if(j == i){
                str[ind++] = str[i];
            }
        }
        return String.valueOf(Arrays.copyOf(str, ind));
    }

    public static void main(String[] args)
    {
        try {
            String[] data1 = new String[280];
            String[] data2 = new String[280];
            String[] data3 = new String[280];

            // This reads in the data1.txt file for the data with words.
            File myData = new File("data1.txt");
            Scanner scan = new Scanner(myData);

            int i = 0;

            // Populates the data1 array
            while (scan.hasNextLine()) {
                data1[i] = scan.nextLine();
                i++;
            }

            // Removes all characters in the words and populates them into the new array data2
            for (i = 0; i < data1.length; i++) {
                if (data1[i] != null) {
                    data2[i] = data1[i].replaceAll("\\W+", "");
                    data2[i] = data2[i].replaceAll("\\d", "");
                }
            }

            // Calls the removeDoubles constructor to remove the duplicates and populates data3 array
            for(i = 0; i < data2.length;i++){
                if(data2[i] != null && !data2[i].equals("")){
                    char[] str = data2[i].toCharArray();
                    int n = str.length;
                    data3[i] = removeDoubles(str, n);
                }

            }

            // This populates the data2.txt file with the data that's in data3 array
            FileWriter data2file = new FileWriter("data2.txt");
            for(i = 0; i < data3.length;i++){
                if(data3[i] != null && !data3[i].equals("")){
                    data2file.write(data3[i]);
                    data2file.write("\n");
                }
            }

            data2file.close();

        } catch(IOException e){
            System.out.println("An error has occurred");
        }
    }
}
