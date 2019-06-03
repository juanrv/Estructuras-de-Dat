package com.ordenamiento.domain;

import java.util.ArrayList;


public class Merge {
	private static long comparaciones;
	private static long intercambios;
	private static ArrayList<String> intercambiosAreglo= new ArrayList<String>();
	private static String arregloString;
	public Merge(int arreglo[]) {
		intercambios = 0;
		comparaciones = 0;
		mergeSort(arreglo, arreglo.length);
	}

	public static void mergeSort(int[] a, int n) {
		if (n < 2)
			return;
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = a[i];
		}
		mergeSort(l, mid);
		mergeSort(r, n - mid);

		merge(a, l, r, mid, n - mid);
	}

	public static ArrayList<String> getIntercambiosAreglo() {
		return intercambiosAreglo;
	}

	public static void merge(int[] a, int[] l, int[] r, int left, int right) {

		int i = 0, j = 0, k = 0;

		while (i < left && j < right) {

			if (l[i] <= r[j]) {
				comparaciones++;
				a[k++] = l[i++];
				intercambios++;
				arregloString="";
				for (int x : a) {
					if(x==a[a.length-1]) {
						arregloString+=x;
						arregloString+="\n";
					}
					
					
					else {
						arregloString+=x;
						arregloString+="  ";
					}
				}
				intercambiosAreglo.add(arregloString);
			} else {
				comparaciones++;
				a[k++] = r[j++];
				intercambios++;
				arregloString="";
				for (int x : a) {
					if(x==a[a.length-1]) {
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

		while (i < left) {
			a[k++] = l[i++];
			intercambios++;
			arregloString="";
			for (int x : a) {
				if(x==a[a.length-1]) {
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

		while (j < right) {
			a[k++] = r[j++];
			intercambios++;
			arregloString="";
			for (int x : a) {
				if(x==a[a.length-1]) {
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
	

	public static long getComparaciones() {
		return comparaciones;
	}

	public static long getIntercambios() {
		return intercambios;
	}
}
