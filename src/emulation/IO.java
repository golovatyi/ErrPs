/**Описание.
 * В данном файле значения Wrkmod[47006][22] будут подаваться в класс CheckErrps 
 * с периодичностью 250 рядов/секунда. Сравниваться с минимаксными значениями в
 * файле calibration.prc. Далее, в случае возникновения триггера, выводить 
 * информацию в консоль (triggered at x.xx s). Уведомления будут сравнены с 
 * графиком из программы mitsar.
 */
package emulation;
import calibration.SetUp;
import calibration.CalibrationMethods;
import java.io.*;


public class IO {
    static CalibrationMethods CM = new CalibrationMethods();
    
    static String file = "Wrkmod.TXT";
    static String minmax = "Calibration.prc";
    static SetUp SU;

    static SearchERRPS SE = new SearchERRPS();

    
    public static void launchEmulation() {
        try {
            SU = new SetUp(file);
            SE.Compare("Calibration.prc", "Wrkmod.TXT");
        } catch (InterruptedException e) {
            System.err.println("something went wrong: " + e);
        } catch (IOException e) {
            System.err.printf("One of the files, either %s or %s not found",
                    file, minmax);
        }   
    }
   
    public IO(String i2){
        this.file = i2;
    }
    public IO() {
        
    }
}

