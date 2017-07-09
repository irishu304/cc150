//6.7 The Apocalypse
double runNFamilies(int n) {
	int boys = 0;
	int girls = 0;
	for (int i = 0; i < n; i++) {
		int[] genders = runOneFamily();
		girls += genders[0];
		boys += genders[1];
	}
	return girls / (double) (girls + boys);
}
 int[] runOneFamily() {
 	Random random = new Random();
 	int boys = 0;
 	int girls = 0;
 	while (girls == 0) { //until get one girl
 		if (random.nextBoolean()) { //randomly return true/false
 			girls += 1;
 		} else {
 			boys += 1;
 		}
 	}
 	int[] genders = {girls, boys};
 	return genders;
 }
 //if run this with large n, you should get very close to 0.5

 //6.8 Egg Drop Problem
 int breakPoint = ...;
 int countDrops = 0;
 boolean drop(int floor) { //if not break
 	countDrops++;
 	return floor >= breakPoint;
 }

 int findBreakPoint(int floors) {
 	int interval = 14;
 	int previousFloor = 0;
 	int egg1 = interval;

 	while (!drop(egg1) && egg1 <= floors) { 
 		previousFloor = egg1;
 		interval -= 1;
 		egg1 += interval;
 	} //drop egg1 at decreasing intervals
 	int egg2 = previousFloor + 1;
 	while (egg2 < egg1 && egg2 <= floors && !drop(egg2)) {
 		egg2 += 1;
 	} //drop egg2 at 1 unit increment

 	//if not break, in last round egg2 = floors + 1, return -1
 	return egg2 > floor ? -1 : egg2;
 }
















