package com.ordenamiento.app;

import javax.swing.JOptionPane;

import com.ordenamiento.domain.*;

public class Aplication {
	public static void main(String[] args) {
		int opcion = JOptionPane.showOptionDialog(null, "Bienvenido al progarama\n ¿Qué quieres hacer?", "Programa", 0,
				JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Ordenar Vector", "Crear Arbol", "Salir" }, "Salir");
		switch (opcion) {
		case 0:
			ordenador();
			break;
		case 1:
			crearArbol();
			break;
		default:
			System.exit(0);
			break;
		}
	}

	public static void crearArbol() {
		try {
			Arbol arbol = new Arbol();
			crearArbolDatos(arbol);
			while(true) {
				verArbol(arbol);
			}

		} catch (NumberFormatException ex) {
			crearArbol();
		}
	}
	public static void crearArbolDatos(Arbol arbol) {
		try {
			boolean seguir = true;
			int opcion;
			do {
				opcion = JOptionPane.showOptionDialog(null, "¿Quieres añadir un dato al arbol?", "Arbol", 0,
						JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No" }, "Si");
				switch (opcion) {
				case 0:
					int valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor que quiere añadir"));
					arbol.insertar(valor);
					seguir = true;
					break;
				case 1:
					seguir = false;
					break;
				default:
					System.exit(0);
					break;
				}
			} while (seguir);
		}catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Solo puedes ingresar numeros ENTEROS");
			crearArbolDatos(arbol);
		}catch (Exception e) {
			crearArbol();
		}
	}
	public static void verArbol(Arbol arbol) {
		int opcion;
		try {
			opcion = JOptionPane.showOptionDialog(null, "¿Como quieres ver el arbol?", "Arbol", 0,
					JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Preorden", "Inorden", "Postorden", "Salir" },
					"Preorden");

			switch (opcion) {
			case 0:
				arbol.preOrder();
				JOptionPane.showMessageDialog(null, Arbol.getImprimir());
				Arbol.reiniciarImprimir();
				break;
			case 1:
				arbol.inOrder();
				JOptionPane.showMessageDialog(null, Arbol.getImprimir());
				Arbol.reiniciarImprimir();
				break;
			case 2:
				arbol.posOrder();
				JOptionPane.showMessageDialog(null, Arbol.getImprimir());
				Arbol.reiniciarImprimir();
				break;
			default:
				main(null);
				break;
			}
			opcion = JOptionPane.showOptionDialog(null, "¿Que quieres hacer con el arbol?", "Arbol", 0,
					JOptionPane.QUESTION_MESSAGE, null,
					new Object[] { "Buscar Dato", "Eliminar Dato", "Salir" },
					"Buscar Dato");
			int valor;
			switch (opcion) {
			case 0:
				valor= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor que quiere buscar"));
				if(arbol.buscar(valor).equals(null)) {
					JOptionPane.showMessageDialog(null, "No se encontro el dato en el arbol");
				}
				JOptionPane.showMessageDialog(null, "El dato "+valor+" se encuentra en el arbol");
				break;
			case 1:
				valor= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor que quiere eliminar"));
				arbol.eliminar(valor);
				break;
			default:
				System.exit(0);
				break;
			}
		}catch (NullPointerException en) {
			JOptionPane.showMessageDialog(null, "El dato no esta en el arbol");
			verArbol(arbol);
		}catch (Exception e) {
			verArbol(arbol);
		}
	}

	@SuppressWarnings("unused")
	public static void ordenador() {
		try {

			int tamañoVector = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del vector"));

			int[] arregloOriginal = new int[tamañoVector];
			for (int i = 0; i < arregloOriginal.length; i++) {
				arregloOriginal[i] = (int) (Math.random() * 1000);
			}

			do {
				String arregloSting = "";
				for (int i = 0; i < arregloOriginal.length; i++) {
					if (i == arregloOriginal.length - 1) {
						arregloSting += arregloOriginal[i];
					} else {
						arregloSting += arregloOriginal[i];
						arregloSting += " , ";
					}
				}
				int verComparaciones;
				JOptionPane.showMessageDialog(null, "Arreglo original: {" + arregloSting + "}");
				int[] arreglo = arregloOriginal.clone();
				int opcion = JOptionPane.showOptionDialog(null, "¿Con que metodo quiere ordenar el vector", "Ordenador",
						0, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Quick Sort", "Merge Sort",
								"Insertion Sort", "Bubble Sort", "Selection Sort", "Salir" },
						"Quick Sort");
				switch (opcion) {
				case 0:
					verComparaciones = JOptionPane.showOptionDialog(null,
							"¿Quieres ver los intercambios que hace el metodo?", "Ordenador", 0,
							JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No" }, "No");
					Quick quick = new Quick(arreglo);
					if (verComparaciones == 0) {
						JOptionPane.showMessageDialog(null, Quick.getIntercambiosAreglo());
					}
					arregloSting = "";
					for (int i = 0; i < arreglo.length; i++) {
						if (i == arreglo.length - 1) {
							arregloSting += arreglo[i];
						} else {
							arregloSting += arreglo[i];
							arregloSting += " , ";
						}
					}
					JOptionPane.showMessageDialog(null, "Arreglo ordenado: {" + arregloSting + "}");
					JOptionPane.showMessageDialog(null,
							"El metodo 'Quick Sort' realizo este numero de comparaciones: " + Quick.getComparaciones()
									+ " \n y este numero de intercambios: " + Quick.getIntercambios());
					break;
				case 1:
					verComparaciones = JOptionPane.showOptionDialog(null,
							"¿Quieres ver los intercambios que hace el metodo?, Advertencia, el Merge Sort funciona raro",
							"Ordenador", 0, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No" }, "No");
					Merge mergesort = new Merge(arreglo);
					if (verComparaciones == 0) {
						JOptionPane.showMessageDialog(null, Merge.getIntercambiosAreglo());
					}
					arregloSting = "";
					for (int i = 0; i < arreglo.length; i++) {
						if (i == arreglo.length - 1) {
							arregloSting += arreglo[i];
						} else {
							arregloSting += arreglo[i];
							arregloSting += " , ";
						}
					}
					JOptionPane.showMessageDialog(null, "Arreglo ordenado: {" + arregloSting + "}");
					JOptionPane.showMessageDialog(null,
							"El metodo 'Merge Sort' realizo este numero de comparaciones: " + Merge.getComparaciones()
									+ " \n y este numero de intercambios: " + Merge.getIntercambios());

					break;
				case 2:
					verComparaciones = JOptionPane.showOptionDialog(null,
							"¿Quieres ver los intercambios que hace el metodo?", "Ordenador", 0,
							JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No" }, "No");
					Insertion insert = new Insertion(arreglo, verComparaciones);
					arregloSting = "";
					for (int i = 0; i < arreglo.length; i++) {
						if (i == arreglo.length - 1) {
							arregloSting += arreglo[i];
						} else {
							arregloSting += arreglo[i];
							arregloSting += " , ";
						}
					}
					JOptionPane.showMessageDialog(null, "Arreglo ordenado: {" + arregloSting + "}");
					JOptionPane.showMessageDialog(null,
							"El metodo 'Insertion Sort' realizo este numero de comparaciones: "
									+ insert.getComparaciones() + " \n y este numero de intercambios: "
									+ insert.getIntercambios());

					break;
				case 3:
					verComparaciones = JOptionPane.showOptionDialog(null,
							"¿Quieres ver los intercambios que hace el metodo?", "Ordenador", 0,
							JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No" }, "No");
					Bubble burbuja = new Bubble(arreglo, verComparaciones);
					arregloSting = "";
					for (int i = 0; i < arreglo.length; i++) {
						if (i == arreglo.length - 1) {
							arregloSting += arreglo[i];
						} else {
							arregloSting += arreglo[i];
							arregloSting += " , ";
						}
					}
					JOptionPane.showMessageDialog(null, "Arreglo ordenado: {" + arregloSting + "}");
					JOptionPane.showMessageDialog(null,
							"El metodo 'Bubble Sort' realizo este numero de comparaciones: " + Bubble.getComparaciones()
									+ " \n y este numero de intercambios: " + Bubble.getIntercambios());

					break;
				case 4:
					verComparaciones = JOptionPane.showOptionDialog(null,
							"¿Quieres ver los intercambios que hace el metodo?", "Ordenador", 0,
							JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No" }, "No");
					Selection select = new Selection(arreglo, verComparaciones);
					arregloSting = "";
					for (int i = 0; i < arreglo.length; i++) {
						if (i == arreglo.length - 1) {
							arregloSting += arreglo[i];
						} else {
							arregloSting += arreglo[i];
							arregloSting += " , ";
						}
					}
					JOptionPane.showMessageDialog(null, "Arreglo ordenado: {" + arregloSting + "}");
					JOptionPane.showMessageDialog(null,
							"El metodo 'Selection Sort' realizo este numero de comparaciones: "
									+ Selection.getComparaciones() + " \n y este numero de intercambios: "
									+ Selection.getIntercambios());
					break;

				default:
					main(null);
					break;
				}
				opcion = JOptionPane.showOptionDialog(null,
						"¿Quieres buscar la posicion de un elemento en este vector? \n Cuidado!, el vector debe estar organizado de lo contrario esto no funcionara.",
						"Ordenador", 0, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No" }, "No");
				if (opcion == 0) {
					int valorBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor a buscar"));
					Binario bin = new Binario(arreglo, valorBuscar);
				}

			} while (true);

		} catch (NumberFormatException ex) {
			main(null);
		} catch (Exception e) {
			ordenador();
		}
	}

}
