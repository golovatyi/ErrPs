/**
 * В данном пакете 2 файла: SetUp(выполняемый) и Methods
 * Алгоритм в виде блок схемы и псевдокода описан в I части практики
 * Среда разработки - NetBeans IDE 8.1
 * Время выполнения калибровки: около 11,81 секунды. 
 */

package practice;
import java.io.*;
import java.util.*;
import java.lang.*;


public class SetUp {
    /**
     * Данный метод прогоняет выполнение программы в соответствие
     * с БЛОК-СХЕМОЙ 
     * "throws IOException" - захватчик исключений работы с файлом.
     * @param args
     * @throws java.io.IOException
     */
    
    static String file = "Wrkmod.TXT";;
    static String example = "Calibration.prc";;
    
    
    public static void main(String args[]) throws IOException {
        double begin = System.nanoTime(); //начало исполнения
        /**исходный массив, массив максимальных и минимальных значений 
         * соответственно объявлены ниже:
         */
        
        
        double[][] data, max, min;
        CalibrationMethods m = new CalibrationMethods(); //инстанс класса Methods
        data = m.ArraySetup(file); //записываем файл в массив
        max = m.CountMinimax(data, "max"); // вычисляем максимумы на интервалах 
        min = m.CountMinimax(data, "min"); // вычисляем минимумы на интервалах
        m.AvMinMax(max, min);
        m.Check(m.amm);
        
        double end = System.nanoTime();
        System.out.println((end-begin)/1000000000.0 + "sec");
        m.fOut(m.amm, example);
    }
     
    public SetUp(String i1){
            
            SetUp.file = i1;
            //SetUp.example = i2;
        }
}   
    

        

    
    
    
    


