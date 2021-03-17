package controller;

import java.util.concurrent.Semaphore;

public class ThreadsCarro extends Thread {
	private int carro;
	private Semaphore semaforo;

	public ThreadsCarro(int carro, Semaphore semaforo) {
		this.carro = carro;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run(){
		aguardando();
		try {
			semaforo.acquire();
			passando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void aguardando() {
		System.out.println("Carro #" + carro + " está indo na direção " + direcao(carro));
		if(carro > 2){
			try {
				sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void passando() {
		System.out.println("Carro #" + carro + " está atravessando o cruzamento");
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Carro #" + carro + " atravessou o cruzamento");
	}
	
	private String direcao(int carro) {
		switch(carro){
		case 1:
			return "Leste-Oeste";
		case 2:
			return "Oeste-Leste";
		case 3:
			return "Norte-Sul";
		case 4:
			return "Sul-Norte";		
		}
		return null;

	}
	
}
