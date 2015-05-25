import io.korhner.asciimg.image.AsciiImageConverter;
import io.korhner.asciimg.image.AsciiImgCache;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;


public class Test {
	
	private static final String sourceDirectory = "C:\\Users\\kratos\\Desktop\\img";
	
	private static final String targetDirectory = "C:\\Users\\kratos\\Desktop\\img-copy\\";

	public static void main(String[] args) throws IOException {
		
		File sourceDiretoryFile = new File(sourceDirectory);
		
		File[] imgFiles = sourceDiretoryFile.listFiles();
		
		for(File imgFile : imgFiles){
//			File inputFile = new File("a.jpg");
			String targetFile = targetDirectory +"target" +imgFile.getName() ;
			BufferedImage input = ImageIO.read(imgFile);
			Font font = new Font("Courier", Font.PLAIN, 6);

			AsciiImgCache cache = AsciiImgCache.create(font);
			AsciiImageConverter imgConverter = new AsciiImageConverter(cache);
			BufferedImage output = imgConverter.convertImage(input);
			File outputfile = new File(targetFile);
			ImageIO.write(output, "png", outputfile);
		}
		
		
		

	}
}
