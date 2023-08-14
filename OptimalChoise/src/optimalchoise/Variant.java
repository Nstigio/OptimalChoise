
package optimalchoise;

/**
 *
 * @author Bogdan
 */
public class Variant {
 
    public String name;

    public double[] values;

    public double[] utilities;
    
    Variant(String name, double[] values,double[] util){
        this.name = name;
        this.values = values;
        this.utilities = util;
    }

    public static double[] getCollum(Variant[] list, int index){
        double[] column = new double[list.length];
        for(int i = 0; i < list.length; i++){
            column[i] = list[i].values[index];
        }
        
        return column;
    } 
    
    public double sum(){
        double sum = 0;
        for(double d : utilities){
            sum += d;
        }
        return sum;
    }

    public static int indexOfMax(double[] values){
        int index = 0;
        for(int i = 0; i < values.length; i++){
            index = values[i] > values[index] ? i : index;
        }
        return index;
    }
}
