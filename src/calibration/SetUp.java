/**
 * В данном пакете 2 файла: SetUp(выполняемый) и Methods
 * Алгоритм в виде блок схемы и псевдокода описан в I части практики
 * Среда разработки - NetBeans IDE 8.1
 * Время выполнения калибровки: около 11,81 секунды. 
 */

package calibration;
import java.io.*;


public class SetUp {
    /**
     * Выполнение калибровки
     * @param args
     * @throws java.io.IOException
     */
    
    static String file = "Wrkmod.TXT";
    static String example = "Calibration.prc";
    
    
    public static void calibrate() throws IOException {
        double[][] data, max, min;
        CalibrationMethods m = new CalibrationMethods(); 
        data = m.ArraySetup(file); //записываем файл в массив
        max = m.CountMinimax(data, "max"); // вычисляем максимумы на интервалах 
        min = m.CountMinimax(data, "min"); // вычисляем минимумы на интервалах
        m.AvMinMax(max, min);
        m.Check(m.amm);
        m.fOut(m.amm, example);
    }
     
    public SetUp(String i1) throws IOException{
        this.file = i1;
    }
    
    public SetUp(){};
}   
    

        

    
    
    
    


