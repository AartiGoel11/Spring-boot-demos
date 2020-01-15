package in.tp.j8f.ui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

public class DirStrucutre {

	public static void main(String[] args) {
		
		Path path = Paths.get("f:/iiht");

		if(Files.exists(path) && Files.isDirectory(path)) {
			iterate(path, System.out::println);
		}else {
			System.out.println("No Such Directory Found");
		}
	}

	public static void iterate(Path p,Consumer<Path> doThen) {
		if(Files.isDirectory(p)) {
			doThen.accept(p);
			try {
				Files.list(p).forEach((subP)->{iterate(subP,doThen);});
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
