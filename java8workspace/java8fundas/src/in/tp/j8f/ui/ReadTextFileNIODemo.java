package in.tp.j8f.ui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadTextFileNIODemo {

	public static void main(String[] args) {
		try {
			Files.readAllLines(Paths.get("data/sometext.txt"))
			.stream().forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
