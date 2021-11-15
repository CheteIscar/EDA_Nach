/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author jose.velez
 */
class Card {
    private HashSet<Integer> card[];

    public Card(){
        card = new HashSet[3];
        HashSet<Integer> aux = new HashSet<Integer>(5);
        for(int i=0; i<3; i++){
            card[i]= new HashSet<>();
            for(int j=0; j<5; j++){
                int n= (int) (Math.random()*90+1);
                while (!aux.add(n)){
                    n= (int) (Math.random()*90+1);
                }
                card[i].add(n);
            }
        }
    }

    public void removeFromCard(int num){
        for(int i=0; i<3; i++){
            card[i].remove(num);
            /**ALOMEJOR HAY QUE MIRAR SI CANTA LINEA*/
        }
    }

    public boolean checkLine(){
        boolean encontrado=false;
        int i=0;
        while(!encontrado&&i<3){
            encontrado=card[i].isEmpty();
            i++;
        }
        return encontrado;
    }

    public boolean checkBingo(){
        boolean encontrado=true;
        for(int i=0; i<3; i++){
            if (!card[i].isEmpty()) {
                encontrado = false;
                break;
            }
        }
        return encontrado;
    }
}
