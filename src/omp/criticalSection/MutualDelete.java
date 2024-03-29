package omp.criticalSection;

import jomp.runtime.OMP;

public class MutualDelete {

	public static void main(String[] args) {
		int i, x = 0;
		int n = 10;
		
		OMP.setNumThreads(2);
		//omp parallel private(i)
		{
			//omp sections
			{
				//omp section
				{
					for(i = 0; i < n; i++){
						//omp critical
						{
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println("Thread number: "+ OMP.getThreadNum() + ", executando opera��o +");
							x = x + 1;
						}
					}
				}
				//omp section
				{
					for(i = 0; i < n; i++){
						//omp critical
						{
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println("Thread number: "+ OMP.getThreadNum() + ", executando opera��o -");
							x = x - 1;
						}
					}
				}
			}
		}
		System.out.println("Resultado: " + x);
	}
	
}
