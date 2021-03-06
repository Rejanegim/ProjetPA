package unice.miage.m1.projet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.security.SecureClassLoader;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class MyClassLoader extends SecureClassLoader implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7169761967649553847L;
	private ArrayList<File> path = new ArrayList<File>();

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] b = null;
		try {
			b = loadClassData(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.defineClass(name, b, 0, b.length);
	}

	private byte[] loadClassData(String name) throws ClassNotFoundException, IOException {
		// TODO A COMPLETER
		String nameFile = name.replace(".", File.separator);
		nameFile = nameFile + ".class";
		byte[] byt = null;
		for (int i = 0; i < path.size(); i++) {
			if (path.get(i).isDirectory()) {
				File fi = new File(path.get(i), nameFile);// obtenir le chemin//
															// // absolue
				byt = Files.readAllBytes(fi.toPath());
			} else {
				///// pour charger les zip et les jar
				ZipFile zip = new ZipFile(path.get(i).getAbsolutePath());
				ZipEntry entry = zip.getEntry(name);
				if (entry == null)
					continue;
				InputStream is = zip.getInputStream(entry);
				byt = new byte[(int) entry.getSize()];
				is.read(byt);
				return byt;
			}
		}

		return byt;
	}

	public ArrayList<File> getPath() {
		return path;
	}

	public void setPath(File path) {
		this.path.add(path);
	}

}
