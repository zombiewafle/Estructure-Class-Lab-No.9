# Author: Javier Salazar
# Optional program of the Floyd Algorithm

#The import of the math library
from math import inf
from itertools import product


 
def floyd_warshall(n, edge):

    #Variables 
    rn = range(n)
    distance = [[inf] * n for i in rn]
    nxt  = [[0]   * n for i in rn]

    #The addition of ther vertices 
    for i in rn:
        distance[i][i] = 0

        
    for u, v, w in edge:
        distance[u-1][v-1] = w
        nxt[u-1][v-1] = v-1

     
    for k, i, j in product(rn, repeat=3):
        sum_of_distance_ik_kj = distance[i][k] + distance[k][j]
        if distance[i][j] > sum_ik_kj:
            distance[i][j] = sum_ik_kj
            nxt[i][j]  = nxt[i][k]

            
    print("pair     distance    path")

    
    for i, j in product(rn, repeat=2):
        if i != j:
            path = [i]
            while path[-1] != j:
                path.append(nxt[path[-1]][j])
            print("City" + "%d → City%d  %4d       %s" 
                  % (i + 1, j + 1, distance[i][j], 
                     ' → '.join(str(p + 1) for p in path)))

#Show the matrix with the pair, the distance with the path
if __name__ == '__main__':
    floyd_warshall(4, [[1, 3, -2], [2, 1, 4], [2, 3, 3], [3, 4, 2], [4, 2, -1]])
