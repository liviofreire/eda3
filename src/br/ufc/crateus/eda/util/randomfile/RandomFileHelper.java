package br.ufc.crateus.eda.util.randomfile;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class RandomFileHelper {
	public static byte[] read(String file, long position, int size) { 
		byte[] bytes = new byte[size]; 
		try { 
			RandomAccessFile fileStore = new RandomAccessFile(file, "r");  
			fileStore.seek(position);  
			fileStore.read(bytes); 
			fileStore.close(); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} 
		return bytes; 
	}

	public static void write(String file, long position, byte[] bytes) { 
		try { 
			RandomAccessFile fileStore = new RandomAccessFile(file, "rw");  
			fileStore.seek(position);  
			fileStore.write(bytes); 
			fileStore.close(); 
		} 
		catch (IOException e) { 
			e.printStackTrace(); 
		} 
	}
	
	public static long append(String file, byte[] bytes) {
		long position = -1; 
		try { 
			RandomAccessFile fileStore = new RandomAccessFile(file, "rw");
			position = fileStore.length();
			fileStore.seek(position); 
			fileStore.write(bytes); 
			fileStore.close(); 
		} 
		catch (IOException e) { 
			e.printStackTrace(); 
		} 
		return position;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
//		Estudante joao = new Estudante("12345", "João", "Silva", "2", "CC", "joao@ufc.br");
//		Estudante andre = new Estudante("45345", "André", "Cardoso", "5", "SI", "andre@ufc.br");
//		Estudante julia = new Estudante("78910", "Julia", "Moreira", "4", "EC", "julia@ufc.br");
//		Estudante carlos = new Estudante("38727", "Carlos", "Araújo", "4", "EM", "carlos@ufc.br");
//		Estudante paula = new Estudante("78727", "Paula", "Bonfim", "1", "EA", "carlos@ufc.br");
//		Estudante luisa = new Estudante("41201", "Luísa", "Pereira", "2", "CC", "luisa@ufc.br");
//		
//
//		Estudante[] estudantes = new Estudante[] {joao, andre, julia, carlos, paula, luisa}; 
//		append("/Users/disciplinas/Desktop/estudante.data", Estudante.toBytes(Arrays.asList(estudantes)));
		
//		append("/Users/disciplinas/Desktop/estudante.data", joao.toBytes());
//		append("/Users/disciplinas/Desktop/estudante.data", andre.toBytes());
//		append("/Users/disciplinas/Desktop/estudante.data", julia.toBytes());
//		append("/Users/disciplinas/Desktop/estudante.data", carlos.toBytes());
//		append("/Users/disciplinas/Desktop/estudante.data", paula.toBytes());
		
		// Recuperar o i-ésimo registro de um estudante
		int i = 0;
		Student e1 = Student.fromBytes(read("/Users/disciplinas/Desktop/estudante.data", 64 * i, 64));
		System.out.println(e1);
		
		Random r = new Random(10L);
		r.nextInt();
	}
}
