package emulation;

//import static emulation.IO.CM;
import practice.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class SearchERRPS  {
    double[][] pe, in;
    int i, j, co, strengh;
    int rp, cp, ri, ci;
    static String file = "Wrkmod.TXT";
    static String example = "Calibration.prc";
    static CalibrationMethods CM = new CalibrationMethods();
    static SetUp SU;
    
    
    public void setData(String pattern, String input) throws IOException {
        SU = new SetUp(file);
        this.pe = CM.ArraySetup(pattern); //22*3   
        this.in = CM.ArraySetup(input);
        
        this.rp = pe.length;
        this.cp = pe[0].length;
        this.ri = in.length;
        this.ci = in[0].length;
    }
    
    public void Compare(String input, String pattern) throws IOException, InterruptedException{
        setData(input, pattern);
        strengh = 0;
        int count = 0;
        for(i = 750; i < ri; i++){
            TimeUnit.MILLISECONDS.sleep(4);
            for(j = 0; j < ci-1; j++){
                if((in[i][j] > pe[j][1])||(in[i][j] < pe[j][2])){ 
                    ++strengh; 
                    if((co != i/250)&&(strengh > 100)){
                    this.co = i/250;    
                    System.out.println("pattern registered at " + co + "s with strengh " + strengh);
                    ++count;
                    }       
                }else{
                    strengh = 0;
                }
            }  
        }
        System.out.print(count);
    }
    
    
    
    
    public SearchERRPS(){
//        this.d = d;
    }
}
