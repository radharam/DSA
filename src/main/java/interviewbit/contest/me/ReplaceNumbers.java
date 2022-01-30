package src.main.java.interviewbit.contest.me;

public class ReplaceNumbers {

    public int[] solve(int[] A, int[][] B) {
        return replaceNumbers(A, B);
    }

    public int[] replaceNumbers(int[] A, int[][] B){
        int auxillaryArraySize = 51;
        int[] auxillaryArray = new int[auxillaryArraySize];
        int len = A.length;

        int q_len = B.length;

        for(int i = 0; i < auxillaryArraySize; i++){
            auxillaryArray[i] = i;
        }

        for(int i = 0; i < q_len; i++){
            for(int k = 0; k < auxillaryArraySize; k++){
                if(auxillaryArray[k] == B[i][0])
                    auxillaryArray[k] = B[i][1];
            }
        }

        for(int i = 0; i < len; i++){
            A[i] = auxillaryArray[A[i]];
        }

        return A;
    }

}

