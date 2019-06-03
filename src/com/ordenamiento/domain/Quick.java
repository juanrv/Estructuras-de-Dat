package com.ordenamiento.domain;

import java.util.ArrayList;

public class Quick {
	private static long intercambios;
	private static long comparaciones;
	private static ArrayList<String> intercambiosAreglo= new ArrayList<String>();
	private static String arregloString;

	public Quick(int A[]) {
		intercambios = 0;
		comparaciones = 0;
		quicksort(A, 0, A.length - 1);
	}

	public static void quicksort(int A[], int izq, int der) {

		int pivote = A[izq];
		int i = izq;
		int j = der;
		int aux;

		while (i < j) {
			while (A[i] <= pivote && i < j) {
				i++;
				comparaciones++;
			}
			while (A[j] > pivote) {
				j--;
				comparaciones++;
			}
			if (i < j) {
				aux = A[i];
				A[i] = A[j];
				A[j] = aux;
				intercambios++;
				arregloString="";
				for (int x : A) {
					if(x==A[A.length-1]) {
						arregloString+=x;
						arregloString+="\n";
					}
					
					
					else {
						arregloString+=x;
						arregloString+="  ";
					}
				}
				intercambiosAreglo.add(arregloString);
			}
		}
		A[izq] = A[j];
		intercambios++;
		arregloString="";
		for (int x : A) {
			if(x==A[A.length-1]) {
				arregloString+=x;
				arregloString+="\n";
			}
			
			
			else {
				arregloString+=x;
				arregloString+="  ";
			}
		}
		intercambiosAreglo.add(arregloString);
		A[j] = pivote;
		intercambios++;
		arregloString="";
		for (int x : A) {
			if(x==A[A.length-1]) {
				arregloString+=x;
				arregloString+="\n";
			}
			
			
			else {
				arregloString+=x;
				arregloString+="  ";
			}
		}
		intercambiosAreglo.add(arregloString);
		if (izq < j - 1)
			quicksort(A, izq, j - 1);
		if (j + 1 < der)
			quicksort(A, j + 1, der);
	}

	public static ArrayList<String> getIntercambiosAreglo() {
		return intercambiosAreglo;
	}

	public static long getIntercambios() {
		return intercambios;
	}

	public static long getComparaciones() {
		return comparaciones;
	}
}
