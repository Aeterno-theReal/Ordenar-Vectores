import java.util.Scanner;

public class OrdenarVectores {

	static int pedirTamanoArray(Scanner teclado)
	{
		int t=0;
		
	//	do {
		System.out.print("Introduzca el tamaño del array que desea generar con números aleatorios [1-99]: ");
		t=teclado.nextInt();
		teclado.nextLine();
	//	if(t<1 || t>99)
	//		System.out.println("\n¡¡Error!!. El tamaño ha de estar entre 1 y 99.\n");
		
	//	}while(t<1 || t>99);
		return t;
	}
	
	static boolean orden(Scanner t)
	{
		boolean ordenacion=false;
		String opcion="";
		
		do {
		System.out.print("¿Desea ordenarlos en orden ascendente? [s-n]: ");
		opcion=t.nextLine();
		
		switch(opcion)
		{
			case "s":
				System.out.println("\nDe acuerdo, ordenamos de forma ascendente (de menor a mayor).\n");
				ordenacion=true;
				break;
			case "n":
				System.out.println("\nDe acuerdo, ordenamos de forma descendente (de mayor a menor).\n");
				break;
			default:
				System.out.println("\n¡¡Error!!, la opción escogida no es correcta, por favor, sólo introduzca 's' o 'n'.\n");
				break;
		}
		}while(!opcion.equals("s") && !opcion.equals("n"));
		
		return ordenacion;
	}
	
	static void llenarArrayAleatorio(int[] a)
	{
		boolean repetido=false;
		int generado=0;
		
		System.out.println("El vector que se ha generado de forma aleatoria es: ");
		for(int i=0; i<a.length; i++)
		{
		//	do {
				repetido=false;
				generado=(int)(Math.random()*100);
		//		for(int j=0; j<a.length; j++)
		//			if(generado==a[j])
		//				repetido=true;
		//	}while(repetido);
			a[i]=generado;
			System.out.print(a[i] + " | ");
		}
		System.out.println();
	}
	
	static void ordenarVectorBurbuja(int[] a, boolean ascendente)
	{
		int aux=Integer.MAX_VALUE;
		
		if(ascendente)
			for(int i=0; i<a.length-1; i++)
				for(int j=0; j<a.length-i-1; j++)
				{
					if(a[j]>a[j+1])
					{
						aux=a[j];
						a[j]=a[j+1];
						a[j+1]=aux;
					}
				}
		else
			for(int i=0; i<a.length-1; i++)
				for(int j=0; j<a.length-i-1; j++)
				{
					if(a[j]<a[j+1])
					{
						aux=a[j];
						a[j]=a[j+1];
						a[j+1]=aux;
					}
				}
	}
	
	static void  mostrarVector(int[] a)
	{
		System.out.println("\nEl vector resultante ordenado es: ");
		for(int i=0; i<a.length; i++)
			System.out.print(a[i] + " | ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado = new Scanner(System.in);
		
		boolean ascendente=false;
		int[] array;
		int tamano=0;
		
		tamano=pedirTamanoArray(teclado);
		
		array=new int[tamano];

		ascendente=orden(teclado);
		
		llenarArrayAleatorio(array);
		
		ordenarVectorBurbuja(array, ascendente);
		
		mostrarVector(array);
	}

}
