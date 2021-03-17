package view;

import java.util.concurrent.Semaphore;
import controller.ThreadsCarro;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int carro = 1; carro < 5; carro++){
		ThreadsCarro tCarro = new ThreadsCarro(carro, semaforo);
		tCarro.start();
		}
	}
}
