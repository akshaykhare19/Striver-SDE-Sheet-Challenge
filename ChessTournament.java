/*
 *  Chess Tournament
Difficulty: EASY
Avg. time to solve
20 min
Success Rate
80%
Problem Statement
Chess tournament is going to be organized in Ninjaland. There will be C chess players going to attend the tournament. All the players will be staying in a hotel. The hotel has N free rooms available for the players, where one player will choose one room to live in. The ith room is at position[i] in the hotel. All rooms are in distinct positions.
Focus level of a chess player is defined as the minimum distance between his room and the room of another player. The overall focus of a tournament is defined as the minimum focus level among all players. You as an organizer obviously want the overall focus as high as possible so you assign the rooms to players such that the overall focus is as high as possible.
For example,

let say we have 3 players and 5 rooms available and the rooms are at positions:  1 2 3 4 6
Here the optimal allocation is in rooms 1 3 6 and the overall focus level is 2.

Input format :

The first line of input contains a single integer T, representing the number of test cases or queries to be run. 

Then the T test cases follow.

The first line of each test case contains two positive integers N and C, which represent the number of rooms in the hotel and the number of chess players.

The next line contains N space-separated positive integers representing the position of available room in the hotel.

Output Format :

For each test case, print a single integer, representing the maximum overall focus of the tournament.

Print the output of each test case in a separate line.

Note:

You do not need to print anything. It has already been taken care of. Just implement the given function.

Constraint :

1 <= T <= 10
2 <= N <= 10 ^ 4
2 <= C <= N
1 <= positions[i] <= 10 ^ 9

Time Limit: 1 sec

Sample input 1 :

1
5 3
1 2 3 4 6

Sample output 1 :

2

Sample input 2 :

2
4 2
5 4 2 1
6 4
6 7 9 13 15 11

Sample output 2 :

4
2

Explanation for Sample Output 2:

In test case 1, 
we only have to allocate rooms to 2 players so we can assign rooms that are first and last which are 1 and 5, so our answer is 5 - 1 = 4.

In test case 2, 
there is no way by which we can allocate rooms such that every player will have the 3 or more as its least distance to other players. So the answer is 2 and one possible allocation of rooms is as follows.
    Player1 = 6
    Player2 = 9
    Player3 = 11
    Player4 = 13 


 */

import java.util.Arrays;

public class ChessTournament
{
    public static boolean canPlacePlayers(int pos[], int n, int c, int dist)
    {
        int lastPlacedPlayer = pos[0];
        int playersPlaced = 1;
        
        for(int i = 1; i < n; i++){
            if(pos[i]-lastPlacedPlayer>=dist){
                lastPlacedPlayer = pos[i];
                playersPlaced++;
            }
            if(playersPlaced==c) return true;
        }
        return false;
    }

    public static int chessTournament(int[] positions, int n,  int c) 
	{
        // Write your code here.
        Arrays.sort(positions);
        int low = 1;
        int high = positions[n-1]-positions[0];
        int res = 0;
        while(low<=high){
            int mid = (low+high)>>1;
            if(canPlacePlayers(positions, n, c, mid)){
                res = mid;
                low = mid+1;
            }
            else high = mid-1;
        }
        return res;
    }

    public static void main(String args[])
    {
        int n = 3;
        int a[] = {1,4,6};
        int c = 3;
        System.out.println(chessTournament(a, n, c));
    }
    
}
