
package optimalchoise;

// @author Bogdan

/**
 *
 * @author Bogdan
 */
 
public class Criteria {
    
    /**
     *
     */
    public String name;

    /**
     *
     */
    public Type type;

    /**
     *
     */
    public float[] importance = new float[2];

    
    Criteria(String name, Type type, String importanceLow, String importanceHigh){
        this.name = name;
        this.type = type;
        this.importance[0] = Float.parseFloat(importanceLow);
        this.importance[1] = Float.parseFloat(importanceHigh);
}

    /**
     *  Calculates the probabilities for the respective column
     * @param values
     * @return
     */
    public double[] getProb(double[] values){       
        double[] probabilities = new double[values.length];
        int max = indexOfMax(values);
        int min = indexOfMin(values);
        
        if(this.type.equals(Type.LOW)){
            probabilities[max] = importance[0];
            probabilities[min] = importance[1];
            
            for(int i = 0; i < values.length; i++){
                if(i == max) continue;
                if(i == min) continue;
                
                probabilities[i] = 1 - (values[i]-values[min])/(values[max]-values[min]);
            }
            
        }
        
        if(this.type.equals(Type.HIGH)){
            probabilities[max] = importance[1];
            probabilities[min] = importance[0];
            
            for(int i = 0; i < values.length; i++){
                if(i == max) continue;
                if(i == min) continue;
                
                probabilities[i] = 1 - (values[i]-values[max])/(values[min]-values[max]);
            }
        }
        return probabilities;
}

    /**
     * Calculate the utilities based on the probabilities, and the importance limitis
     * @param prob
     * @return
     */
    public double[] getUtilities(double[] prob){
        double[] utilities = new double[prob.length];
        for(int i = 0; i < prob.length; i++){
                utilities[i] = (prob[i] * importance[1] + (1 - prob[i]) * importance[0]);
            }
        return utilities;
    }
    private int indexOfMax(double[] values){
        int index = 0;
        for(int i = 0; i < values.length; i++){
            index = values[i] > values[index] ? i : index;
        }
        return index;
    }

     private int indexOfMin(double[] values){
        int index = 0;
        for(int i = 0; i < values.length; i++){
            index = values[i] < values[index] ? i : index;
        }
        return index;
    }
}