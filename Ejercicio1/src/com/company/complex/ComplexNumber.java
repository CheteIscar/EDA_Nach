/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.complex;
/**
 *
 * @author mayte
 */

public class ComplexNumber {

    private double real, imaginary;

    ComplexNumber(double a, double b){
        this.real=a;
        this.imaginary=b;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }


    public ComplexNumber add (ComplexNumber c){
        this.real=+c.getReal();
        this.imaginary=+c.getImaginary();
        return this;
    }


    public ComplexNumber subtract (ComplexNumber c){
        this.real=-c.getReal();
        this.imaginary=-c.getImaginary();
        return this;
    }

    /**
     * Returns multiplication of c and the ComplexNumber
     *
     * @param c
     *        multiplying
     * @return
     *          this * c2
     */
    public ComplexNumber multiply (ComplexNumber c){
        double r=this.real*c.getReal()-this.imaginary*c.getImaginary();
        double i=this.imaginary*c.getReal()+this.real*c.getImaginary();
        return new ComplexNumber(r,i);
    }

    /**
     * Returns the division of the ComplexNumber by c
     *
     * @param c
     *        divider
     * @return
     *        this / c
     */
   /* public ComplexNumber division (ComplexNumber c){

    }*/

    /**
     * Returns the conjugate of the ComplexNumber
     *
     * @return
     *        a - ib
     */
    public ComplexNumber conjugate (){
        return new ComplexNumber(this.real, -this.imaginary);
    }

    /**
     * Returns the module of the ComplexNumber
     *
     * @return
     *      sqrt (a² + b²)
     */
    public double module (){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }
}
