/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package similer;

/**
 *
 * @author Admin
 */
public class Main{

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
            
    String A="kakka barai hugak";
    String B="hugak kakka barai";
    String C="kakka barai hugak";
        Simileraty sim = new Simileraty();
       double probability1 = sim.compareStrings(A,B);
       double probability2 = sim.compareStrings(A,C);
        System.out.println(probability1);
        System.out.println(probability2);
        
    }
    
}
