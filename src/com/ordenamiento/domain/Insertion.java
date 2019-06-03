package com.ordenamiento.domain;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Insertion {
	private long intercambios = 0;
	private long comparaciones = 0;
	private ArrayList<String> intercambiosAreglo= new ArrayList<String>();
	private String arregloString;
	private int verComparaciones;
	public Insertion(int arreglo[], int verComparaciones) {
		int n = arreglo.length;
		this.verComparaciones= verComparaciones;
		for (int i = 1; i < n; ++i) {
			int key = arreglo[i];
			int j = i - 1;
			do {
				comparaciones++;
				arreglo[j + 1] = arreglo[j];
				intercambios++;
				j = j - 1;
				arregloString="";
				for (int k : arreglo) {
					if(k==arreglo[arreglo.length-1]) {
						arregloString+=k;
						arregloString+="\n";
					}
					
					
					else {
						arregloString+=k;
						arregloString+="  ";
					}
				}
				intercambiosAreglo.add(arregloString);
				
			}
			while (j >= 0 && arreglo[j] > key);
			arreglo[j + 1] = key;
			intercambios++;
			arregloString="";
			for (int k : arreglo) {
				if(k==arreglo[arreglo.length-1]) {
					arregloString+=k;
					arregloString+="\n";
				}
				
				
				else {
					arregloString+=k;
					arregloString+="  ";
				}
			}
			intercambiosAreglo.add(arregloString);
			
		}
		imprimirCambiosArreglos();
	}
	private void imprimirCambiosArreglos() {
		if(verComparaciones==0) {
			JOptionPane.showMessageDialog(null, intercambiosAreglo);
		}
	}

	public long getIntercambios() {
		return intercambios;
	}

	public long getComparaciones() {
		return comparaciones;
	}

}
