/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package similer;
import uk.ac.shef.wit.simmetrics.similaritymetrics.JaroWinkler;
/**
 *
 * @author Admin
 */
public class Simileraty {
    public double compareStrings(String stringA, String stringB) {
    JaroWinkler algorithm = new JaroWinkler();
    return algorithm.getSimilarity(stringA, stringB);
}
}
