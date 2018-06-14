package assignment3;

import java.util.Arrays;

import javax.swing.text.Position.Bias;

public class Tester {

 public static void main(String[] args) {

  System.out.println(
    "DISCLAIMER : Please check your code on additional examples that you design yourself as this tester only tests your code on very few examples !");
  System.out.println();

  Building b1 = new Building(new OneBuilding("Building 1", 1980, 50, 2020, 10));
  OneBuilding ob2 = new OneBuilding("Building 2", 1980, 60, 2022, 10);
  OneBuilding ob3 = new OneBuilding("Building 3", 1980, 55, 2024, 10);
  OneBuilding ob4 = new OneBuilding("Building 4", 1960, 50, 2030, 10);
  OneBuilding ob5 = new OneBuilding("Building 5", 1950, 45, 2027, 10);
  OneBuilding ob6 = new OneBuilding("Building 6", 1960, 60, 2025, 10);
  OneBuilding ob7 = new OneBuilding("Building 7", 1970, 55, 2024, 10);
  OneBuilding ob8 = new OneBuilding("Building 8", 2000, 55, 2017, 10);
  OneBuilding ob9 = new OneBuilding("Building 9", 1990, 55, 2023, 11);
  OneBuilding ob10 = new OneBuilding("Building 10", 2000, 80, 2030, 10);
  OneBuilding ob11 = new OneBuilding("Building 11", 2010, 100, 2017, 10);
  Building b12 = new Building(new OneBuilding("Building 12", 1985, 10, 2023, 10));
  OneBuilding ob13 = new OneBuilding("Building 13", 1990, 10, 2024, 10);
  OneBuilding ob14 = new OneBuilding("Building 14", 1995, 10, 2022, 10);
  Building b15 = new Building(new OneBuilding("Building 15", 1990, 10, 2020, 10));
  OneBuilding ob16 = new OneBuilding("Building 16", 1975, 10, 2020, 10);
  OneBuilding ob17 = new OneBuilding("Building 17", 2001, 10,2025, 10);
  Building b18 = new Building(new OneBuilding("Building 18", 1995, 10, 2019, 10));
  OneBuilding ob19 = new OneBuilding("Building 19", 2011, 10, 2017, 10);
 

  // TESTING ADDBUILDING
  b1 = b1.addBuilding(ob2);
  b1 = b1.addBuilding(ob3);
  b1 = b1.addBuilding(ob4);
  b1 = b1.addBuilding(ob5);
  b1 = b1.addBuilding(ob6);
  b1 = b1.addBuilding(ob7);
  b1 = b1.addBuilding(ob8);
  b1 = b1.addBuilding(ob9);
  b1 = b1.addBuilding(ob10);
  b1 = b1.addBuilding(ob11);
  

  b12 = b12.addBuilding(ob13);
  b12 = b12.addBuilding(ob14);
  
  b15 = b15.addBuilding(ob16);
  b15 = b15.addBuilding(ob17);
  
  b18 = b18.addBuilding(ob19);
  
  


  /** uncomment the following line to test  */
  System.out.println(b1.toString());

  String sol1 = "Building 2(1980 , 60)\n" + "older than Building 2(1980 , 60) :\n" + "Building 6(1960 , 60)\n";
  sol1 += "older than Building 6(1960 , 60) :\n" + "Building 5(1950 , 45)\n";
  sol1 += "same age as Building 6(1960 , 60) :\n" + "Building 4(1960 , 50)\n" + "younger than Building 6(1960 , 60) :\n" + "Building 7(1970 , 55)\n";
  sol1 += "same age as Building 2(1980 , 60) :\n";
  sol1 += "Building 3(1980 , 55)\n" + "same age as Building 3(1980 , 55) :\n";
  sol1 += "Building 1(1980 , 50)\n" + "younger than Building 2(1980 , 60) :\n" + "Building 10(2000 , 80)\n";
  sol1 += "older than Building 10(2000 , 80) :\n" + "Building 9(1990 , 55)\n";
  
  sol1 += "same age as Building 10(2000 , 80) :\n" + "Building 8(2000 , 55)\n";
  sol1 += "younger than Building 10(2000 , 80) :\n" + "Building 11(2010 , 100)\n";
  
  /** uncomment the following line to test  */
  System.out.println(sol1);

  if (sol1.equals(b1.toString())) {
   System.out.println("AddBuilding seems to work, check it on more examples though");
  } 
  else {
   System.out.println("AddBuilding does not work");
  }

  // TESTING ADDBUILDINGS
  Building temp = b1;
  
  /** uncomment this line below for another test of addbuildings, the other will display not working */
  //b1 = b1.addBuildings(b12);
  
  
  //System.out.println(b1.toString()); 
   
  String sol3 = "Building 2(1980 , 60)\n" + "older than Building 2(1980 , 60) :\n" + "Building 6(1960 , 60)\n";
   sol3 += "older than Building 6(1960 , 60) :\n" + "Building 5(1950 , 45)\n";
   sol3 += "same age as Building 6(1960 , 60) :\n" + "Building 4(1960 , 50)\n" + "younger than Building 6(1960 , 60) :\n" + "Building 7(1970 , 55)\n";
   sol3 += "same age as Building 2(1980 , 60) :\n";
   sol3 += "Building 3(1980 , 55)\n" + "same age as Building 3(1980 , 55) :\n";
   sol3 += "Building 1(1980 , 50)\n" + "younger than Building 2(1980 , 60) :\n" + "Building 10(2000 , 80)\n";
   sol3 += "older than Building 10(2000 , 80) :\n" + "Building 9(1990 , 55)\n";
   sol3 += "older than Building 9(1990 , 55) :\n" + "Building 12(1985 , 10)\n";
   sol3 += "same age as Building 9(1990 , 55) :\n" + "Building 13(1990 , 10)\n";
   sol3 += "younger than Building 9(1990 , 55) :\n" + "Building 14(1995 , 10)\n";
   sol3 += "same age as Building 10(2000 , 80) :\n" + "Building 8(2000 , 55)\n";
   sol3 += "younger than Building 10(2000 , 80) :\n" + "Building 11(2010 , 100)\n";
  //System.out.println(sol3);
  if (sol3.equals(b1.toString())) {
   System.out.println("AddBuildings seems to work, check it on more examples though");
  } 
  else {
   System.out.println("AddBuildings does not work, go read line 101");
  }
  Building b4234 = b1;
  b4234 = b4234.addBuildings(b15);
  
  //System.out.println(b4234.toString()); 
   
  String sol3test2 = "Building 2(1980 , 60)\n" + "older than Building 2(1980 , 60) :\n" + "Building 6(1960 , 60)\n";
   sol3test2 += "older than Building 6(1960 , 60) :\n" + "Building 5(1950 , 45)\n";
   sol3test2 += "same age as Building 6(1960 , 60) :\n" + "Building 4(1960 , 50)\n" + "younger than Building 6(1960 , 60) :\n" + "Building 7(1970 , 55)\n";
   sol3test2 += "younger than Building 7(1970 , 55) :\n" + "Building 16(1975 , 10)\n";
   sol3test2 += "same age as Building 2(1980 , 60) :\n";
   sol3test2 += "Building 3(1980 , 55)\n" + "same age as Building 3(1980 , 55) :\n";
   sol3test2 += "Building 1(1980 , 50)\n" + "younger than Building 2(1980 , 60) :\n" + "Building 10(2000 , 80)\n";
   sol3test2 += "older than Building 10(2000 , 80) :\n" + "Building 9(1990 , 55)\n";
   sol3test2 += "same age as Building 9(1990 , 55) :\n" + "Building 15(1990 , 10)\n";
   sol3test2 += "same age as Building 10(2000 , 80) :\n" + "Building 8(2000 , 55)\n";
   sol3test2 += "younger than Building 10(2000 , 80) :\n" + "Building 11(2010 , 100)\n";
   sol3test2 += "older than Building 11(2010 , 100) :\n" + "Building 17(2001 , 10)\n";
   
  //System.out.println(sol3test2);
  
  if (sol3test2.equals(b4234.toString())) {
   System.out.println("AddBuildings seems to work, check it on more examples though");
  } else {
   System.out.println("AddBuildings does not work");
  }

  
  
  

  // TESTING REMOVEBUILDING
  b1 = b1.addBuilding(ob19);
  b1 = b1.removeBuilding(ob7);

  b1 = b1.removeBuilding(new OneBuilding("Building 3", 1980, 55, 2024, 10));
  b1 = b1.removeBuilding(new OneBuilding("Building 4", 1960, 50, 2024, 5)); // this OneBuilding cannot be removed
                     // as it is not in the tree (the
                     // fields do not correspond to ob4
                     // !)
  b1 = b1.removeBuilding(ob2);
  b1 = b1.removeBuilding(ob11);

  //System.out.println(b1.toString());
  
  String sol4 = "Building 1(1980 , 50)\n" + "older than Building 1(1980 , 50) :\n" + "Building 6(1960 , 60)\n";
  sol4 += "older than Building 6(1960 , 60) :\n" + "Building 5(1950 , 45)\n";
  sol4 += "same age as Building 6(1960 , 60) :\n" + "Building 4(1960 , 50)\n" + "younger than Building 6(1960 , 60) :\n";
  sol4 += "Building 16(1975 , 10)\n";
  sol4 += "younger than Building 1(1980 , 50) :\n" + "Building 10(2000 , 80)\n";
  sol4 += "older than Building 10(2000 , 80) :\n" + "Building 9(1990 , 55)\n";
  sol4 += "same age as Building 9(1990 , 55) :\n" + "Building 15(1990 , 10)\n";
  sol4 += "same age as Building 10(2000 , 80) :\n" + "Building 8(2000 , 55)\n";
  sol4 += "younger than Building 10(2000 , 80) :\n" + "Building 17(2001 , 10)\n";
  sol4 += "younger than Building 17(2001 , 10) :\n" + "Building 19(2011 , 10)\n";
  //System.out.println(sol4);
  if (sol4.equals(b1.toString())) {
   System.out.println("RemoveBuilding seems to work, check it on more examples though");
  } else {
   System.out.println("RemoveBuilding does not work");
  }

  // TESTING OLDEST

  
  if (b1.oldest() == 1950 && b1.younger.oldest() == 1990) {
   System.out.println("oldest seems to work, check it on more examples though");
  } else {
   System.out.println("oldest does not work");
  }

  // TESTING HIGHEST

  b1.addBuilding(ob11);
  if (b1.highest() == 100 && b1.older.same.highest() == 50 && b1.younger.highest() == 100) {
   System.out.println("highest seems to work, check it on more examples though");
  } else {
   System.out.println("highest does not work");
   System.out.println(b1.younger.highest());
  }

  // TESTING HIGHESTFROMYEAR

  if (b1.highestFromYear(1989) == null && b1.highestFromYear(1990).equals(ob9)
    && b1.highestFromYear(1960).name.equals("Building 6") && b1.highestFromYear(2010).equals(ob11)
    && b1.highestFromYear(1975).equals(ob16)) {
   System.out.println("highestFromYear seems to work, check it on more examples though");
  } else {
   System.out.println("highestFromYear does not work");
  }

  // TESTING NUMBERFROMYEARS

  if (b1.numberFromYears(1975, 1990) == 4 && b1.numberFromYears(1951, 2000) == 8
    && b1.numberFromYears(1980, 1979) == 0 && b1.numberFromYears(2010, 3000) == 2
    && b1.numberFromYears(1990, 2010) == 6 && b1.numberFromYears(1981, 1984) == 0
    && b1.numberFromYears(2005, 2010) == 1) {
   System.out.println("numberFromYears seems to work, check it on more examples though");
  } else {
   System.out.println("numberFromYears does not work");
   System.out.println(b1.numberFromYears(1975, 1990));
   System.out.println(b1.numberFromYears(1951, 2000));
   System.out.println(b1.numberFromYears(1980, 1979));
   System.out.println(b1.numberFromYears(2010, 3000));
   System.out.println(b1.numberFromYears(1990, 2010));
   System.out.println(b1.numberFromYears(1981, 1984));
  }

  // TESTING COSTPLANNING

 

  int[] costs = b1.costPlanning(3);
  int[] costsol = new int[] { 0, 0, 30 };

  int[] costs2 = b1.costPlanning(10);
  int[] costsol2 = new int[] { 0, 0, 30, 0, 0, 11, 0, 20, 0, 10 };

  int[] costs3 = b1.costPlanning(14);
  int[] costsol3 = new int[] { 0, 0, 30, 0, 0, 11, 0, 20, 0, 10, 0, 0, 20, 0 };

  int[] costs4 = b1.costPlanning(20);
  int[] costsol4 = new int[] {  0, 0, 30, 0, 0, 11, 0, 20, 0, 10, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0 };

  int[] costs5 = b1.younger.costPlanning(3);
  int[] costsol5 = new int[] { 0, 0, 10 };

  /* for debugging
  System.out.println(Arrays.toString(costs));
  System.out.println(Arrays.toString(costs2));
  System.out.println(Arrays.toString(costs3));
  System.out.println(Arrays.toString(costs4));
  System.out.println(Arrays.toString(costs5));*/
  
  if (costs.length != 7 && costs2.length != 8 && costs2.length != 10 && costs2.length != 2) {
   System.out.println("CostPlanning : incorrect size of the array");
  } else {
   if (Arrays.equals(costs, costsol) && Arrays.equals(costs2, costsol2) && Arrays.equals(costs3, costsol3)
     && Arrays.equals(costs4, costsol4) && Arrays.equals(costs5, costsol5)) {
    System.out.println("costPlanning seems to work, check it on more examples though");
   } else {
    System.out.println("costPlanning does not work");
   }
  }

  System.out.println();
  System.out.println(
    "DISCLAIMER : if the tester says that all your methods work, congrats ! \nPlease continue checking your code on examples that you design yourself as this tester only tests your code on very few examples !");

 }

}
