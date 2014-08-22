package main;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.List;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class ITextWritePdfFile {
	

	public void makePdf(String id){
		try {
			File file = new File(System.getProperty("user.home") + "/click_userId.pdf");
			FileOutputStream fileout = new FileOutputStream(file);
			Document document = new Document();
			PdfWriter.getInstance(document, fileout);
			document.addAuthor("Clickability");
			document.addTitle("Your selected ID's: ");

			document.open();

			Chunk chunk = new Chunk(new Date().toString());
			Font font = new Font(Font.COURIER);
			font.setStyle(Font.UNDERLINE);
			font.setStyle(Font.ITALIC);
			chunk.setFont(font);
			chunk.setBackground(Color.CYAN);
			document.add(chunk);

			Paragraph paragraph = new Paragraph();
			paragraph.add("*Your selected ID's:");
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);

			

			List list = new List(true, 15);
			list.add(id);
			document.add(list);

			document.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}