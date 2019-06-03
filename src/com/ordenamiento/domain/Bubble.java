package com.ordenamiento.domain;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Bubble {
	private static long intercambios;
	private static long comparaciones;
	private ArrayList<String> intercambiosAreglo= new ArrayList<String>();
	private String arregloString;
	private int verComparaciones;

	public  Bubble(int[] vector, int verComparaciones) {
		intercambios=0;
		comparaciones=0;
		this.verComparaciones= verComparaciones;		
		bubbleSort(vector);
	}

	private void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					comparaciones++;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					intercambios++;
					arregloString="";
					for (int k : arr) {
						if(k==arr[arr.length-1]) {
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
		if(this.verComparaciones==0) {
			JOptionPane.showMessageDialog(null, intercambiosAreglo);
		}
	}

	public static long getIntercambios() {
		return intercambios;
	}

	public static long getComparaciones() {
		return comparaciones;
	}
}
