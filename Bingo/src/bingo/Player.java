/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import utils.NumberGetter;

/**
 *
 * @author jose.velez
 */
class Player {

    private Card [] cards;
    public Player() {
        NumberGetter n = new NumberGetter();
        int numCards = n.getNumber("Number of cards:");
        cards = new Card[numCards];
        for (int i = 0; i < numCards; i++) {
            cards[i] = new Card();
            
        }
    }

    void removeNumber(int number) {
        for(int i=0; i< cards.length;i++){
            cards[i].removeFromCard(number);
            /**lo mismo hay que ver si tiene bingo*/
        }
    }

    boolean hasLine() {
        boolean encontrado = false;
        int i=0;
        while(!encontrado && i< cards.length){
            encontrado=cards[i].checkLine();
            i++;
        }
        return encontrado;
    }

    boolean hasBingo() {
        boolean encontrado = false;
        int i=0;
        while(!encontrado && i< cards.length){
            encontrado=cards[i].checkBingo();
            i++;
        }
        return encontrado;
    }
    
}
