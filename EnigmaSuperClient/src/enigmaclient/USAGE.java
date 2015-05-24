/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enigmaclient;

import valkyrie.enigma.enigmaplus.service.controller.Simileraty;

/**
 *
 * @author heshanjayasinghe
 */

public class USAGE {

public static void main(String[] args) {
  String A="how to create java class";
    String B="create class use java";
    String C="java class";
    String D="create java class";
        Simileraty sim = new Simileraty();
       double probability1 = sim.compareStrings(A,B);
       double probability2 = sim.compareStrings(A,C);
       double probability3 = sim.compareStrings(A,D);
        System.out.println(probability1);
        System.out.println(probability2);
        System.out.println(probability3);
}
}