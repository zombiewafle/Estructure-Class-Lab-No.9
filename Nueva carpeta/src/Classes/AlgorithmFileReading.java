package Classes;

public class AlgorithmFileReading {

    public int[][] matrix(String data){
        data = "guategrafo.txt";
        String[] rows = data.trim().split(";");

        int numberOfRows = rows.length;
        int numeroOfColumns = rows[0].trim().split(" ").length;

        int[][] result = new int[numberOfRows][numeroOfColumns];

        for(int i = 0; i < rows.length; i++){
            String[] elements = rows[i].trim().split(" ");

            for (int j = 0; j < elements.length; j++){
                result[i][j] = Integer.valueOf(elements[j]);
            }
        }
        return result;
    }


}
