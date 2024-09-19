package com.pawan.learning_app;

public class App {
  public static void main(String[] args) {
    System.out.println("Hello World!");
    
    int a = 10;
    int b = 3;
    
    Calculator cal = new Calculator();
    System.out.println(cal.divide(a, b));
  }
}
