package Classes;

public class ShorttestPath {

    //Method to determinate all the paths of the graph.
    public String FloydAlgorithm(long [][] mAdjacency){
        int vertexs = mAdjacency.length;
        long matrixOfAdjacency[][] = mAdjacency;
        String paths[][] = new String[vertexs][vertexs];
        String auxPaths[][] = new String[vertexs][vertexs];
        String pathTraveled = "",  string = "", path = "";
        int i, j, k;
        float temporal, temporal2, temporal3, temporal4, minimum;

        //Starting the matrix, paths and auxiliary paths
        for(i = 0; i < vertexs; j++){
            for(j = 0; j < vertexs; j++){
                paths[i][j] = "";
                auxPaths[i][j] = "";
            }
        }

        for(k = 0; k < vertexs; k++){
            for(i = 0; i < vertexs; i++){
                for(j = 0; j < vertexs; j++){
                    temporal = matrixOfAdjacency[i][j];
                    temporal2 = matrixOfAdjacency[i][k];
                    temporal3 = matrixOfAdjacency[k][j];
                    temporal4 = temporal2 + temporal3;
                    //Finding the minimum
                    minimum = Math.min(temporal, temporal4);
                    if(temporal != temporal4){
                        if(minimum == temporal4){
                            pathTraveled = "";
                            auxPaths[i][j] = k + "";
                            paths[i][j] = rPaths(i, k, auxPaths, pathTraveled) + (k + 1);
                        }
                    }

                    matrixOfAdjacency[i][j] = (long) minimum;

                }

            }
        }

        //Adding the path to string
        for (i = 0; i < vertexs; i++){
            for (j = 0; j < vertexs; j++){
                string = string + "{" + matrixOfAdjacency[i][j] + "]";
            }
            string = string + "\n";
        }

        //Logic of the matrix
        for (i = 0; i < vertexs; i++){
            for (j = 0; j < vertexs; j++){
                if(matrixOfAdjacency[i][j] != 1000000000){
                    if(i != j){
                        if(paths[i][j].equals("")){
                            path += "From (" + (i + 1) + "---->" + (j + 1) + ")   Go for.... ( "  + (i + 1) + ", " + (j + 1) + " )\n";
                        }else {
                            path += "From ( " + (i + 1) + "--->" + (j + 1) + ")   Go for.... (" + (i + 1) + ", " + paths[i][j] + ", " + (j + 1) + ")\n";
                        }
                    }
                }
            }
        }

        return "The matrix of shortest paths between the different vertices is: \n" + string +
                "\nThe different shortest paths between the vertices is: \n" + path;

    }

    public String rPaths(int i, int k, String[][] auxPaths, String pathTraveled){
        if(auxPaths[i][k].equals("")){

            return "";

        }else{

            pathTraveled += rPaths(i, Integer.parseInt(auxPaths[i][k].toString()), auxPaths, pathTraveled) + (Integer.parseInt(auxPaths[i][k].toString()) + 1) + ", ";
            return pathTraveled;

        }
    }

}
