/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.HashSet;

/**
 *
 * @author jose.velez
 */
class Hype {
    private HashSet<Integer> balls;

    public Hype() {
        balls= new HashSet<>(90);
        for (int i=1; i<91; i++){
            balls.add(i);
        }
    }

    boolean hasNumbers() {
        return !balls.isEmpty();
    }

    int getNumber() {
        int n=0;
        while(!balls.remove(n)){
            n = ((int) (Math.random() * 90))+1;
        }
        return n;
    }
    
}
