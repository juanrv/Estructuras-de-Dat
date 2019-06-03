package com.ordenamiento.domain;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Selection {
	private static long intercambios;
	private static long comparaciones;
	private ArrayList<String> intercambiosAreglo= new ArrayList<String>();
	private String arregloString;
	private int verComparaciones;
	public Selection(int[] vector, int verComparaciones) {
		intercambios = 0;
		comparaciones = 0;
		this.verComparaciones= verComparaciones;
		sort(vector);
	}

	private void sort(int arr[]) {
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[min_idx]) {
					min_idx = j;
					intercambios++;
					comparaciones++;
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

			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
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
