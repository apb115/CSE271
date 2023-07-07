import java.io.File;
import java.util.Scanner;

public class Tester {
	
	private static int records = 0;
	private static int[] id;
	private static String[] name;
	private static int[] age;
	private static String[] gender;
	
	public static void main(String[] args) {
		
		loadFile("Week-01_Dataset-01.txt");
		
		printGenderReport();
		
		
		printByAgeCutoff(80);
		
		System.out.println();
		
		printAverageAge();
		
		
	}

	private static void printAverageAge() {
		
		int total = 0;
		
		for(int i = 0; i < records; i++)
			total += age[i];
		
		System.out.println("Average Age");
		System.out.println("===========");
		System.out.printf("Avg: %6.1f\n", (double)total/records);
		
	}

	private static void printGenderReport() {
		
		int m, f, p;
		m=f=p=0;
		for(int i = 0; i < records; i++) {
			if(gender[i].equals("Male")) m++;
			else if (gender[i].equals("Female")) f++;
			else if (gender[i].equals("Private")) p++;
		}
		
		System.out.println("Gender Report");
		System.out.println("=============");
		System.out.printf("Males: %6d\n", m);
		System.out.printf("Females: %4d\n", f);
		System.out.printf("Private: %4d\n", p);
		System.out.println("-------------");
		System.out.printf("Total: %,6d\n", m+f+p);
		
	}

	private static void printByAgeCutoff(int cutoff) {
		
		int count = 0;
		for(int i = 0; i < records; i++)
			if(age[i] >= cutoff) count++;
		
		System.out.println("Age Cutoff Count");
		System.out.println("================");
		System.out.printf("Total: %,9d\n", count);
		
		
	}

	private static void loadFile(String fileName) {
		
		id = new int[1000];
		name = new String[1000];
		age = new int[1000];
		gender = new String[1000];
		
		String[] parts;
		try(Scanner fin = new Scanner(new File(fileName))) {
			fin.nextLine();
			while(fin.hasNextLine()) {
				parts = fin.nextLine().split("\t");
				id[records] = Integer.parseInt(parts[0]);
				name[records] = parts[1];
				age[records] = Integer.parseInt(parts[2]);
				gender[records] = parts[3];
				records++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
