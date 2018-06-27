package calibration;
import java.io.*;
import java.util.*;


public class CalibrationMethods {
    int i, j;
    Scanner file;
    double mx, mn;
    double[][] data, min, max;
    double[][] amm;
    
    //открытие и закрытие файла
    public void fOpen(String name) throws IOException{
        this.file = new Scanner (new File(name));
    }
    public void fClose(Scanner var) throws IOException{
    var.close();
    }
    public void nij(){
        i = 0;
        j = 0;
    }
    public void nv(){
        mx = -999999999999.f;
        mn = 999999999999.f;
    }
    
    //работа с входным массивом
    public int CountRows(String name) throws IOException{
        i = 0;
        fOpen(name);
        while(file.hasNextLine()){
            ++i;
            file.nextLine();   
        }
        fClose(file);
        return i;
    }
    
    public int Countdoubles(String name) throws IOException{
        j = 0;
        fOpen(name);
        while(file.hasNextDouble()){
            ++j;
            file.nextDouble();
        }
        fClose(file);
        return j;
    }
   
    public int CountCols(String name) throws IOException{
        i = CountRows(name);
        j = Countdoubles(name);
        int r = j/i;
        return(r);
    }
    
    public double[][] ArraySetup(String name) throws IOException{
        int row = CountRows(name);
        int col = CountCols(name);
        fOpen(name);
        data = new double[row][col];
        for(i = 0; i < row; i++){
            for(j = 0; j< col; j++){
                data[i][j] = file.nextDouble();
            }
        }
        fClose(file);
        return data; 
    }
    
    
    
    public void ArrayPrint(double[][] arr){
        int row;
        row = arr.length;
        for(i = 0; i<row; i++){
            ArrayPrint(arr[i]);
            System.out.println(' ');
        }
       }

    public void ArrayPrint(double[] arr){
//        int row;
//        row = arr.length;    
//        for(i = 0; i<row; i++){         
//            System.out.print(arr[i] + "  ");         
//            System.out.println(' ');
//        }
        System.out.println(Arrays.asList(arr));
    }
//    double[][] = CountMax(data[i][j]){находим среднее максимальное значение за каждые 0,2 с (50 рядов) для каждого датчика}
    public double[][] CountMinimax(double[][] var, String act){
        nij();
        //i, r - raws, j, c - cols
        int mr;
        
        double[][] in;
        in = var;
        int raw = in.length;
        int datch = in[0].length;
        mr = raw/50;
        max = new double[mr][datch];
        min = new double[mr][datch];
        
        double[][] res;
        mx = Double.MIN_VALUE;
        mn = Double.MAX_VALUE;
         //датчики 
        for(i = 0; i<datch; i++){    
          for(j = 0; j<raw; j++){
             mx = (in[j][i] > mx) ? in[j][i] : mx;
             mn = (in[j][i] < mn) ? in[j][i] : mn; 
             if((j+1)%50==0){
                 
                  max[j/50][i] = mx;
                  min[j/50][i] = mn;
                  nv();
             } 
          }         
        }
        res = ("max".equals(act))?  max:  min;        
        return res;
    }

    public double[][] AvMinMax(double in1[][], double in2[][]){

        int raw = in1.length;
        int datch = in1[0].length;
        double counter = 0;
        amm = new double[datch][4];
        
        for(i = 0; i<datch; i++){    
            for(j = 750; j<raw; j++){
                amm[i][1] += in1[j][i];
                ++counter; 
            }
            amm[i][0] = i+1;
            amm[i][1] /= (raw-750); 
            }
        for(i = 0; i<datch; i++){    
            for(j = 750; j<raw; j++){
                amm[i][2] += in2[j][i];
                ++counter; 
            }
            amm[i][2] /= (raw-750); 
            }
        
        
        return amm;
    
    }

    public void fOut(double[][] arr, String destination) throws IOException {
        int row, col;
        StringBuilder sb = new StringBuilder();
        char a = 0x0a;
        FileWriter o = new FileWriter(destination);
        row = arr.length;
        col = arr[1].length;
        for(i = 0; i<row; i++){
            for (j = 0; j<col; j++){
                final String s = Double.toString(arr[i][j]);
                o.write(s);
                o.write(' ');
               
            }
            o.write(System.lineSeparator());
        }
        o.close();
       }
    
    public void Check(double[][] amm){
        /**
         * data[ряды(j)][датчики(i)] и amm[датчики][минимаксы и 0,1]
         */
        double av = 0;
        for(i = 0; i < amm.length; i++){
            for(j = 3000; j < data.length; j++){
              av += data[j][i];
              
            }
            av = Math.abs(av/data.length);
            if((av > Math.abs(amm[i][1]))||(av < Math.abs(amm[i][2]))){
                amm[i][3] = av;
            } else {
                amm[i][3] = av;
            }
            av = 0;
        }
        
        
        
    }
}

