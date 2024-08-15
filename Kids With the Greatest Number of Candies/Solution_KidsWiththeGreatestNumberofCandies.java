import java.util.ArrayList;
import java.util.List;

class Solution_KidsWiththeGreatestNumberofCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        int theGreatest = 0;
        int theNewGreatest = 0;
        List<Boolean> result =new ArrayList<Boolean>();
        for(int i = 0; i<candies.length; i++){
            if(candies[i]>theGreatest){
                theGreatest = candies[i]; 
            }
        }
        for(int j = 0; j<candies.length; j++){
            candies[j] = candies[j] + extraCandies;
            if(candies[j] >= theGreatest){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        System.out.println(result);
        return result;
    }


    public static void main (String[] args){
        int [] candies = {2,3,5,1,3};
        int extraCandies = 3;

        Solution_KidsWiththeGreatestNumberofCandies objectSolution = new Solution_KidsWiththeGreatestNumberofCandies();
        objectSolution.kidsWithCandies(candies, extraCandies);

    }
}