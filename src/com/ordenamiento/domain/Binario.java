package com.ordenamiento.domain;

import javax.swing.JOptionPane;

public class Binario {
	public Binario(int[] vector, int nroABuscar) {
		int i=busquedaBinaria(vector, nroABuscar);
		if(i!=-1) {
			JOptionPane.showMessageDialog(null, "Se encontró el elemento "+nroABuscar+" en la posicion "+ i);
		}
		else {
			JOptionPane.showMessageDialog(null, "No se encontro el elemento");
		}
	}

	private int busquedaBinaria(int[] vector, int nro) {
		int n = vector.length;
		int centro, inferior = 0, superior = n - 1;
		while(inferior<=superior) {
			centro=(superior+inferior)/2;
			if(vector[centro]==nro) {
				return centro+1;
			}
			else if(nro<vector[centro]) {
				superior=centro-1;
			}
			else {
				inferior=centro+1;
			}
		}
		return -1;
	}

}
