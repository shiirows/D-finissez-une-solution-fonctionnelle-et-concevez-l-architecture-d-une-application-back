package projetcar.mazoyer.alexandre.projetThree.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.stream.Stream;

import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {

	private final Path root = Paths.get("uploads");

	@Override
	public void init() {

		try {
			Files.createDirectories(root);
		} catch (Exception e) {

			throw new RuntimeException("Could not initialize folder for upload!");
		}
	}

	private String generateUid() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public String save(MultipartFile file) {
		try {

			String filename;
			String extension = FilenameUtils.getExtension(file.getOriginalFilename()).toLowerCase();
			filename = generateUid() + "." + extension;
			Files.copy(file.getInputStream(), this.root.resolve(filename));

			return filename;

		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
	}

	@Override
	public Resource load(String filename) {

		try {

			Path file = root.resolve(filename);
			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() || resource.isReadable()) {

				return resource;
			} else {
				throw new RuntimeException("Could not read the file!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}

//suprime l'image
	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(root.toFile());
	}

	// suprime un groupe d'images
	@Override
	public void delete(String filename) {

		Path files = root.resolve(filename);
		try {
			FileSystemUtils.deleteRecursively(files);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Stream<Path> loadAll() {

		try {
			return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
		} catch (IOException e) {
			throw new RuntimeException("Could not load the files!");
		}
	}
}