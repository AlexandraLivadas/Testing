
public class BastaBuilding {

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
	  Building newBuilding = new Building(b);

	  //If the new building is older than this one.
	  if (b.yearOfConstruction < this.data.yearOfConstruction) {

	   if (this.older == null) {
	    this.older = newBuilding;
	   }
	   else 
	    this.older = this.older.addBuilding(b);
	  }

	  //If the new building is younger than this one.
	  else if (b.yearOfConstruction > this.data.yearOfConstruction) {
	   if (this.younger == null)
	    this.younger = newBuilding;
	   else 
	    this.younger = this.younger.addBuilding(b);
	  }


	  //If the new building is the same age as this one.
	  else {
	   //If the new building has a smaller(or equal) height than this one.
	   if (this.data.height >= b.height)
	   {
	    if (this.same == null)
	     this.same = newBuilding;
	    else
	     this.same = this.same.addBuilding(b);
	   }

	   /*If the new building has a taller height than this one
	   (and as a result is taller than any buildings in the chain below that might be the same age).*/
	   else {
	    //Swap the two buildings.

	    if (this.younger != null) {
	     newBuilding.younger = this.younger;
	     this.younger = null;
	    }

	    if (this.older != null) {
	     newBuilding.older = this.older;
	     this.older = null;
	    }

	    newBuilding.same = this;
	    return newBuilding;
	   }
	  }
	  return this;
	 }

	 public Building addBuildings (Building b){

	  Building newBuilding = this;
	  //First add b's root to the Building that calls this method.
	  if (b == null)
	   System.out.println("mistake!");
	  newBuilding = newBuilding.addBuilding(b.data);
	  //Then recursively add the oneBuildings younger than it.
	  if (b.younger != null)
	   newBuilding.addBuildings(b.younger);
	  //Then recursively add the buildings that are the same age as it.
	  if(b.same != null)
	   newBuilding.addBuildings(b.same);
	  //Then recursively add the buildings that are older than it.
	  if (b.older != null)
	   newBuilding.addBuildings(b.older);
	  return newBuilding; 
	 }

	 public Building removeBuilding (OneBuilding b){

	  //If the building we're trying to remove is the root.
	  if (this.data.equals(b)) {
	   //4 cases: 
	   //Case 1: If there's another building with the same age, that becomes the root.
	   if ( this.same != null) {
	    if (this.younger != null)
	     this.same = (this.same).addBuildings(this.younger);
	    if (this.older != null)
	     this.same = (this.same).addBuildings(this.older);
	    return this.same;
	   }
	   //Case 2: If there's no building of the same age, but there's one older, that becomes the root.
	   else if (this.older != null) {
	    //If there are younger buildings, attach them to the older building.
	    if (this.younger != null)
	    return (this.older.addBuildings(this.younger));
	    
	    //Otherwise, we simply return the older building.
	    else
	     return this.older;
	   }
	   /*Case 3: There are no older buildings, or buildings with the same age.
	   IF there is a younger building, it will become the root.*/
	   else if (this.younger != null)
	    return this.younger;

	   //Case 4: This building is the end of a node, therefore IT MUST BE ERADICATED.
	   else {
	    return null;
	   }
	  }
	  //If the building we're trying to remove isn't the root, let's find it!

	  //If the building we're trying to remove is younger than the root:
	  if (this.data.yearOfConstruction < b.yearOfConstruction && this.younger != null) {
	   this.younger = this.younger.removeBuilding(b);
	  }
	  //If the building we're trying to remove is the same age as the root:
	  if (this.data.yearOfConstruction == b.yearOfConstruction && this.same != null) {
	   this.same = this.same.removeBuilding(b);
	  }
	  //If the building we're trying to remove is older than the root:
	  if (this.data.yearOfConstruction > b.yearOfConstruction && this.older != null) {
	   this.older =  this.older.removeBuilding(b);
	  }
	  return this;
	 }

	 public int oldest(){

	  Building position = this;
	  int oldest = this.data.yearOfConstruction;
	  while ( position != null) {
	   oldest = position.data.yearOfConstruction;
	   position = position.older;
	  }
	  return oldest;

	 }

	 public int highest(){

	  int tallest = this.data.height;

	  //Traverse the rest of the tertiary tree to find out if there is a taller building.
	  if (this.older != null && tallest < this.older.highest() )
	   tallest = this.older.highest();
	  if (this.same != null && tallest < this.same.highest())
	   tallest = this.same.highest();
	  if (this.younger != null && tallest < this.younger.highest())
	   tallest = this.younger.highest();
	  return tallest; 
	 }

	 public OneBuilding highestFromYear (int year){


	  //If the oneBuilding is from the year, return it since it's at the top of the "same" list therefore is the highest.
	  if (this.data.yearOfConstruction == year) {
	   return this.data;
	  }
	  //If the year is not right, we'll have to find the oneBuilding if it exists.

	  //If the year is before the current building's year, we'll move to the older one.
	  else if(this.data.yearOfConstruction > year && this.older != null) {
	   return this.older.highestFromYear(year);
	  }

	  //If the year is after the current building's year, we'll move to the younger one.
	  else if(this.data.yearOfConstruction < year && this.younger != null) {
	   return this.younger.highestFromYear(year);
	  }
	  else 
	   return null;
	 }


	 public int numberFromYears (int yearMin, int yearMax){

	  int numberOfBuildings=0; //Initialize the numberOfBuildings.

	  if (yearMin>yearMax)
	   return 0;

	  //If this building is in the interval of years.
	  if (this.data.yearOfConstruction >= yearMin && this.data.yearOfConstruction <= yearMax)
	   numberOfBuildings++;

	  //Traverse the rest of the tertiary tree.
	  if(this.same != null)
	   numberOfBuildings+= this.same.numberFromYears(yearMin, yearMax);
	  if (this.younger != null)
	   numberOfBuildings+= this.younger.numberFromYears(yearMin, yearMax);
	  if (this.older!=null)
	   numberOfBuildings+= this.older.numberFromYears(yearMin, yearMax);

	  return numberOfBuildings;
	 }

	 public int[] costPlanning (int nbYears){


	  int[] totalCost = new int[nbYears];

	  //Set the total cost of each year using a recursive function
	  for( int i=0;i<nbYears;i++) {
	   totalCost[i] = this.costForRepairsInYear(2018+i);
	  }
	  return totalCost; 
	 }

	 public int costForRepairsInYear (int year){

	  //Initialize the cost to zero.
	  int cost = 0;
	  //If the year for repair is the current year, add the cost for repair to the cost.
	  if (this.data.yearForRepair == year) 
	   cost+=this.data.costForRepair;
	  //Traverse the tree to add the cost of every building below it.
	  if(this.older != null) 
	   cost+= this.older.costForRepairsInYear(year);
	  if (this.same != null) 
	   cost+= this.same.costForRepairsInYear(year);
	  if(this.younger != null) 
	   cost+= this.younger.costForRepairsInYear(year);  
	  return cost;
	 }



	}

}
