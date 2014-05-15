package omp.exemplos;

import jomp.runtime.OMP;

public class for_hello_normal {

	public static void main(String[] args) {
		
		int n = 3;
		int i, total = 0;
		int[][] matriz = new int[][]{{1, 2 ,3}, {4, 5, 6}, {7, 8, 9}};
		
		OMP.setNumThreads(2);
		//omp parallel
		{
			//omp for
			for(i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					System.out.println("Thread: " + OMP.getThreadNum() + "Índice: " + i + ", " + j);
					total += matriz[i][j];
				}
			}
		}
		System.out.println("Total: " + total);
	}
	
}
