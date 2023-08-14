package optimalchoise;

//@author Bogdan

public class OptimalChoise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Criteria pret = new Criteria("pret",Type.LOW,"0.2","0.8");
        Criteria livrare = new Criteria("Livrare",Type.LOW,"0.4","0.6");
        Criteria calitate = new Criteria("calitate",Type.HIGH,"0","1");
        Criteria[] criteriaList = {pret, livrare,calitate};
        double[] variant1 = {10000,5,6};
        double[] variant2 = {15500,8,10};
        double[] variant3 = {12300,7,8};
        Variant V1 = new Variant("V1", variant1, new double[criteriaList.length]);
        Variant V2 = new Variant("V2", variant2, new double[criteriaList.length]);
        Variant V3 = new Variant("V3", variant3, new double[criteriaList.length]);
        Variant[] variantList = {V1,V2,V3};
        
        double[] buffer = new double[variantList.length];
        
        for(int j = 0; j < criteriaList.length; j++){
        for(int i = 0; i < variantList.length; i++){
            buffer[i] = variantList[i].values[j];
        }
       buffer= criteriaList[j].getUtilities(criteriaList[j].getProb(buffer));
       
       for(int i = 0; i < variantList.length; i++){
            variantList[i].utilities[j] = buffer[i];
        }}
        double[] sums = new double[variantList.length];
        for(int i = 0; i < variantList.length; i++){
        sums[i] = variantList[i].sum();
        }
       for(Variant v : variantList){
           for(int i = 0; i< criteriaList.length; i++){
           System.out.print(v.utilities[i]+" ");}
           System.out.println(" ");
       }
        System.out.println("Option " + (1+Variant.indexOfMax(sums)) + " is the optimal choise.");
    }
    
}
