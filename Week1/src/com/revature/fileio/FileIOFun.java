package com.revature.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileIOFun {
	public static void main(String[] args) {
		String fileName = "lines.txt";
		List<String> list = new ArrayList<>();
		
		try (Stream<String> st = Files.lines(Paths.get(fileName))) {
			list = st
					.filter(line -> !line.startsWith("Line2"))
					.map(String::toLowerCase)
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		list.forEach(System.out::println);
	}
}
