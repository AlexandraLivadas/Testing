package assignment3;

public class Building {

 OneBuilding data;
 Building older;
 Building same;
 Building younger;
 
 public Building(OneBuilding data){
  this.data = data;
  this.older = null;
  this.same = null;
  this.younger = null;
 }
 
 public String toString(){
  String result = this.data.toString() + "\n";
  if (this.older != null){
   result += "older than " + this.data.toString() + " :\n";
   result += this.older.toString();
  }
  if (this.same != null){
   result += "same age as " + this.data.toString() + " :\n";
   result += this.same.toString();
  }
  if (this.younger != null){
   result += "younger than " + this.data.toString() + " :\n";
   result += this.younger.toString();
  }
  return result;
 }
 
 public Building addBuilding (OneBuilding b){
   Building newB = new Building(b);
   
  //B is older than building
  if (b.yearOfConstruction < this.data.yearOfConstruction){
    
   //If there are no older buildings yet, newB becomes older building
   if (this.older == null) {
    this.older = newB;
   }
   
   //if there is already an older building, perform addBuilding on that older building
   else 
    this.older = this.older.addBuilding(b);
  }
  
  //B is younger than building
  else if (b.yearOfConstruction > this.data.yearOfConstruction){
   //If there are no younger buildings yet, newB becomes younger building
   if (this.younger == null) {
    this.younger = newB;
   }
   //if there is already a younger building, perform addBuilding on younger building
   else 
    this.younger = this.younger.addBuilding(b);
  }
  
  //B is the same
  else if (b.yearOfConstruction == this.data.yearOfConstruction){
    
   //If the height is equal to or less than this.height
   if (b.height <= this.data.height) {
    
    //If there is no same building with a lower height, set newB to this value
    if (this.same == null) {
     this.same = newB;
    }
    
    //else, perform addBuilding to this lower height but same year value
    else
     this.same.addBuilding(b);
   }
   
   //If the height is greater than, i.e. newB must become new root, everything shifted
   else {
     
     //Does this have a younger building? Then, you have to move the younger to Building newB
     if (this.younger != null){
       newB.younger = this.younger;
       this.younger = null;
   }
     //same concept as above for if this has an older building
     if (this.older != null){
       newB.older = this.older;
       this.older = null;
   }
     //if the newB becomes the new root, you have to return the newB, instead of this
     newB.same = this;
     return newB;
  }
 } 
  return this; 
 }
 
 public Building addBuildings (Building b){
   
   //Adding b (the root) to the building that called the method
   this.addBuilding(b.data);
   
   //Recursively adding the building's younger than b to this
   if (b.younger != null)
     this.addBuildings(b.younger);
   
   //Recursively adding the building's older than b to this
   if (b.older != null)
     this.addBuildings(b.older);
   
   //Recursively adding the building's the same as b to this
   if (b.same != null)
     this.addBuildings(b.same);
   
   return this; 
 }
 
 public Building removeBuilding (OneBuilding b){
   //If b is the root of this:
   if (this.data.equals(b)){

     //If there is a "same" building, that will become the root
     if (this.same != null){
       
       //In which case, you must set all of b's younger and older buildings to the "same building"'s younger and older buildings
       if (this.younger != null)
         this.same = this.same.addBuildings(this.younger);
      
       if (this.older != null)
         this.same = this.same.addBuildings(this.older);
       
       return this.same;
     }
     
     //If there is no "same" building and there is one "older", the "older" becomes the root
     else if (this.older != null){
       
       //If there are younger buildings, must be attached to older building:
       if (this.younger != null)
         return this.older.addBuildings(this.younger);
       
       else
         return this.older;
     }
     
     //If there are no "same" or "older" buildings, but there are "younger" ones, the "younger" building becomes root
     else if (this.younger != null){
       return this.younger;
     }
     
     //If the root to be removed has no children, the entire building database will simply dissapear, so return null
     else
       return null;
   }
   
   //Now, if the building to be removed is not the root, we must find it first
   
   //If the building is younger than the root:
   if (this.data.yearOfConstruction < b.yearOfConstruction && this.younger != null){
     this. younger = this.younger.removeBuilding(b);
   }
   //If the building is older than the root:
   else if (this.data.yearOfConstruction > b.yearOfConstruction && this.older != null){
     this.older = this.older.removeBuilding(b);
   }
   //If the building is the same age as the root:
   else if (this.data.yearOfConstruction == b.yearOfConstruction && this.same != null){
     this.same = this.same.removeBuilding(b);
   }
   
   return this; 
 }
 
 public int oldest(){
   int year = this.data.yearOfConstruction;
   
   //Recursively go through the older buildings of the root until you reach the oldest
   //The oldest is when this.older has no older building associated with it
   if (this.older != null)
     year = this.older.oldest(); 
   
   return year;
 }
 
 public int highest(){
   int height = this.data.height;
   
   //First check that you haven't reached a leaf
   if (this != null){
     
     //Recursively go through younger branch to find highest building
     if (this.younger != null && height < this.younger.highest())
       height = this.younger.highest();
     
     //Recursively go through older branch to find highest building
     if (this.older != null && height < this.older.highest())
       height = this.older.highest();
     
     //Recursively go through same branch to find highest branch
     if (this.same != null && height < this.same.highest())
       height = this.same.highest();
   }
   
   return height;
 }
 
 public OneBuilding highestFromYear (int year){
  //The first instance of a building from that year will be the tallest because the tree is organized highest to lowest
   
   //If the root has the same year, then it should be the highest from that year
   if (this.data.yearOfConstruction == year)
     return this.data;
   
   //Else, if the year is older, recursively go through older branch to find the first building instance of that year
   else if (year < this.data.yearOfConstruction && this.older != null)
     return this.older.highestFromYear(year);
   
   //Else, if the year is younger, recursively go through younger branch
   else if (year > this.data.yearOfConstruction && this.younger != null)
     return this.younger.highestFromYear(year);

   return null;
 }
 
 public int numberFromYears (int yearMin, int yearMax){
   int numOfBuildings = 0;
   
   if (yearMin > yearMax)
     return 0;
   
   //Add to numOfBuildings if the current building is within the two years
   if (this.data.yearOfConstruction >= yearMin && this.data.yearOfConstruction <= yearMax)
     numOfBuildings++;
   
   //Go through rest of the tree and recursively add to the numOfBuildings
   if (this.younger != null)
     numOfBuildings += this.younger.numberFromYears(yearMin, yearMax);
   if (this.older != null)
     numOfBuildings += this.older.numberFromYears(yearMin, yearMax);
   if (this.same != null)
     numOfBuildings += this.same.numberFromYears(yearMin, yearMax);
   
  return numOfBuildings;
 }
 
 public int[] costPlanning (int nbYears){
   int[] costPlan = new int[nbYears];
   
   for (int i = 0; i < nbYears; i++){
     costPlan[i] += costPlanningForYear(2018+i);
   }
   
  return costPlan;
 }
 
 public int costPlanningForYear (int year){
   int cost = 0;
   
   if (this.data.yearForRepair == year)
     cost += this.data.costForRepair;
   
   if (this.older != null)
     cost += this.older.costPlanningForYear(year);
   if (this.younger != null)
     cost += this.younger.costPlanningForYear(year);
   if (this.same != null)
     cost += this.same.costPlanningForYear(year);
   
   return cost;
 }

 
}
