/*Hi there!

I’d like to invite you to explore my Notion page where I’ve shared a detailed explanation 
and solution for the coding problem "447. Number of Boomerangs." It's a great resource if 
you're interested in algorithm challenges or want to see how this problem is approached in Java. 
Feel free to check it out and let me know what you think!

Visit my Notion page here: 
https://www.notion.so/447-Number-of-Boomerangs-5b29e432b1324ae9bd52518d4d5638c9?pvs=4

Looking forward to your feedback!*/

/*You are given n points in the plane that are all distinct, where 
points[i] = [xi, yi]. A boomerang is a tuple of points (i, j, k) 
such that the distance between i and j equals the distance between i and k 
(the order of the tuple matters). Return the number of boomerangs.**/

/* Example 1:

Input: points = [[0,0],[1,0],[2,0]]
Output: 2
Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]].
Example 2:

Input: points = [[1,1],[2,2],[3,3]]
Output: 2
Example 3:

Input: points = [[1,1]]
Output: 0
 

Constraints:

n == points.length
1 <= n <= 500
points[i].length == 2
-10^4 <= xi, yi <= 10^4
All the points are unique.*/



/*First aprouch.
Solution To the Problem:
To solve the Number of Boomerangs problem in Java, we can utilize nested loops and calculate 
the distance between each pair of points in the array. We will use a HashMap to store the
distances and their frequencies. The steps to solve the problem are as follows:

1.- Initialize a variable, say "numberOfBoomerangs," to keep track of the total count of boomerangs.
2.- Iterate through each point in the array and consider it as the pivot point.
3.- For each pivot point, initialize an empty HashMap to store the distances and their frequencies.
4.- Iterate through the remaining points in the array and calculate the distance 
    between the pivot point and each point.
5.- Store the distances and their frequencies in the HashMap.
6.- For each distance in the HashMap, calculate the number of boomerang arrangements, we can help us with the
    The formula for permutation of n objects for r selection of objects is given by: P(n,r) = n!/(n-r)!.
    We can work more in this formula and we can get a easy formula = n*(n-1)
7.- Increment the "numberOfBoomerangs" variable by the product of the frequencies of distances 
    (freq) and (freq - 1) for each distance.
8.- Return the final count.

Resumen: 
Below is the Java implementation of the Number of Boomerangs problem:
For every points[i], we capture the number of points equidistant from points[i]. 
Now for this i, we have to calculate all possible permutations of (n, k) from these equidistant points.
Total number of permutations of size 2 from n different points is P(n, 2) = n!/(n-2)! = n * (n-1).

Performance:
Time complexity:  O(n^2)
Space complexity: O(n)*/

import java.util.HashMap;
class Solution_numberOfBoomerangs{
    public int numberOfBoomerangs(int[][] points) {
        int numberOfBoomerangs = 0;
        for(int[] pivotPoint : points){
            HashMap<Integer,Integer>frequencyDistancesMap = new HashMap<Integer,Integer>();
            for(int[] auxiliarPoint : points){
                //comparando dos puntos(arreglos int[])
                if(pivotPoint == auxiliarPoint){ continue;}
                //distance = distance squared
                int distance = getDistance(pivotPoint, auxiliarPoint);
                frequencyDistancesMap.put(distance, frequencyDistancesMap.getOrDefault(distance,0)+1);                
            }
            //obtener y recorrer el mapa con las frecuencias de las distancias una a una y 
            //calcular las permutaciones disponibles con la formula definida de nPr=(n!)/(n-r)!
            for(int equidistantPoints:frequencyDistancesMap.values() ){
                numberOfBoomerangs = numberOfBoomerangs +  (equidistantPoints*(equidistantPoints-1) );
            }
            frequencyDistancesMap.clear();
        }
        return numberOfBoomerangs;
    }

    //aplicando el teorema de pitagoras y usanso unidades elevadas al cuadrado
    //para evitar manejar raicez cuadradas "a^2 = b^2 + c^2"
    public int getDistance(int[] pointA, int[]pointB){
        return ((pointB[0] - pointA[0])*(pointB[0] - pointA[0])) + ((pointB[1] - pointA[1])*(pointB[1] - pointA[1]));
    }

    //metodo principal
    public static void main(String[] args) {
        // Definimos un conjunto de puntos (arreglos de coordenadas x, y)
        int[][] points = {
            {0, 0},
            {1, 0},
            {5, 5},
            {0, 5},
            {1, 8},
            {2, 9}
        };

        // Crear una instancia de la clase Solution
        Solution_numberOfBoomerangs objectSolution = new Solution_numberOfBoomerangs();

        // Llamar al método numberOfBoomerangs y almacenar el resultado
        int result = objectSolution.numberOfBoomerangs(points);

        // Imprimir el resultado
        System.out.println("El número de boomerangs es: " + result);
    }
}