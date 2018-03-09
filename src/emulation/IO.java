/**Описание.
 * В данном файле значения Wrkmod[47006][22] будут подаваться в класс CheckErrps 
 * с периодичностью 250 рядов/секунда. Сравниваться с минимаксными значениями в
 * файле calibration.prc. Далее, в случае возникновения триггера, выводить 
 * информацию в консоль (triggered at x.xx s). Уведомления будут сравнены с 
 * графиком из программы mitsar.
 */
package emulation;
import java.io.*;
import java.util.*;
import java.lang.*;
import practice.*;


public class IO {
    static CalibrationMethods CM = new CalibrationMethods();
    
    static String file = "Wrkmod.TXT";
    static String minmax = "Calibration.prc";
    static SetUp SU;

    static SearchERRPS SE = new SearchERRPS();
    //static long begin = System.currentTimeMillis();
    
    public static void main(String args[]) throws IOException, InterruptedException {
        SU = new SetUp(file);
        SE.Compare("Calibration.prc", "Wrkmod.TXT");
    }
    
    public IO(String i2){
        this.file = i2;
    }
}

