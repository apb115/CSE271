import java.io.File;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester02 {

	public static ArrayList<Person> people = new ArrayList<>();
	
	public static void main(String[] args) {
		
		loadFile("Week-01_Dataset-01.txt");
		
		printGenderReport();
		
		
		printByAgeCutoff(80);
		
		System.out.println();
		
		printAverageAge();
				
	}
	
private static void printAverageAge() {
		
		int total = 0;
		
		for(Person x : people)
			total += x.getAge();
		
		System.out.println("Average Age");
		System.out.println("===========");
		System.out.printf("Avg: %6.1f\n", (double)total/people.size());
		
	}

	private static void printGenderReport() {
		
		int m, f, p;
		m=f=p=0;
		for(Person x : people) {
			if(x.getGender().equals("Male")) m++;
			else if (x.getGender().equals("Female")) f++;
			else if (x.getGender().equals("Private")) p++;
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
		for(Person x : people)
			if(x.getAge() >= cutoff) count++;
		
		System.out.println("Age Cutoff Count");
		System.out.println("================");
		System.out.printf("Total: %,9d\n", count);
		
		
	}

	private static void loadFile(String fileName) {
		
		
		String[] parts;
		try(Scanner fin = new Scanner(new File(fileName))) {
			fin.nextLine();
			while(fin.hasNextLine()) {
				parts = fin.nextLine().split("\t");
				Person p = new Person();
				p.setId(Integer.parseInt(parts[0]));
				p.setName(parts[1]);
				p.setAge(Integer.parseInt(parts[2]));
				p.setGender(parts[3]);
				people.add(p);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
