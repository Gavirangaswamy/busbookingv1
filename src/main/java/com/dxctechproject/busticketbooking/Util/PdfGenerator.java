package com.dxctechproject.busticketbooking.Util ;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import com.dxctechproject.busticketbooking.Entity.Cancelled;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfGenerator {
	
	private Cancelled ticket;
	
	public PdfGenerator(Cancelled ticket) {
	super();
	this.ticket = ticket;
}

	public void generate(HttpServletResponse response) throws DocumentException, IOException {
		// Creating the Object of Document
		Document document = new Document();
		Rectangle rectangle  = new Rectangle(750, 300);
		document.setPageSize(rectangle);
		// Getting instance of PdfWriter
		PdfWriter.getInstance(document, response.getOutputStream());

		// Opening the created document to modify it
		document.open();	
		
		// Creating font
		// Setting font style and size
		Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA);
		fontTitle.setSize(22);
		fontTitle.setStyle(1);

		// Creating paragraph
		Paragraph paragraph = new Paragraph("TICKET", fontTitle);
		
		// Aligning the paragraph in document
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		
		Paragraph emptySpace = new Paragraph();
		emptySpace.add(new Paragraph("                             "));
		
		// Adding the created paragraph in document
		document.add(paragraph);
		
		document.add(emptySpace);
		document.add(emptySpace);
		
		
//		String ticketId = String.valueOf(ticket.getTicketId());
//		Paragraph p1 = new Paragraph();
//				p1.add("Ticket Id", ticketId);
		
		// Creating a table of 8 columns
		PdfPTable table = new PdfPTable(10);

		// Setting width of table, its columns and spacing
		table.setWidthPercentage(100f);
		table.setWidths(new int[] { 1,1,1,1,1,1,1,1,1,1});
		table.setSpacingBefore(1);
	

		table.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
		table.getRowspanHeight(1, 2);
		// Create Table Cells for table header
		PdfPCell cell = new PdfPCell();
		cell.setColspan(3);
		// Setting the background color and padding
		cell.setBackgroundColor(CMYKColor.WHITE);
		cell.setPadding(3);
		cell.setHorizontalAlignment(Element.ALIGN_UNDEFINED);
		cell.setBackgroundColor(CMYKColor.LIGHT_GRAY);
		cell.setBorderWidth(2);
		cell.setRowspan(3);
		
		PdfPCell cell2 = new PdfPCell();
		cell2.setColspan(2);
		// Setting the background color and padding
		cell2.setBackgroundColor(CMYKColor.WHITE);
		cell2.setPadding(3);
		cell2.setHorizontalAlignment(Element.ALIGN_UNDEFINED);
		cell2.setBackgroundColor(CMYKColor.WHITE);
		cell2.setBorderWidth(2);
		cell2.setRowspan(3);
		
		// Creating font
		// Setting font style and size
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(CMYKColor.BLACK);
		
		Currency rupee = Currency.getInstance(new Locale("en", "in"));
		NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
		String amount = dollarFormat.format(Double.parseDouble(ticket.getAmount()));
		
		// Adding headings in the created table cell/ header
		// Adding Cell to table
		cell.setPhrase(new Phrase("TICKET ID", font));
		table.addCell(cell);
		cell2.setPhrase(new Phrase(ticket.getTicketId(), font));
		table.addCell(cell2);
		cell.setPhrase(new Phrase("BUS NAME", font));
		table.addCell(cell);
		cell2.setPhrase(new Phrase(ticket.getBusName(), font));
		table.addCell(cell2);
		cell.setPhrase(new Phrase("BUS NO.", font));
		table.addCell(cell);
		cell2.setPhrase(new Phrase(ticket.getBusNumber(), font));
		table.addCell(cell2);
		cell.setPhrase(new Phrase("ROUTE", font));
		table.addCell(cell);
		cell2.setPhrase(new Phrase(ticket.getRouteName(), font));
		table.addCell(cell2);
		cell.setPhrase(new Phrase("ORIGIN", font));
		table.addCell(cell);
		cell2.setPhrase(new Phrase(ticket.getOrigin(), font));
		table.addCell(cell2);
		cell.setPhrase(new Phrase("DESTINATION", font));
		table.addCell(cell);
		cell2.setPhrase(new Phrase(ticket.getDestination(), font));
		table.addCell(cell2);
		cell.setPhrase(new Phrase("PASSENGERS", font));
		table.addCell(cell);
		cell2.setPhrase(new Phrase(ticket.getCount(), font));
		table.addCell(cell2);
		cell.setPhrase(new Phrase("SEAT NO.", font));
		table.addCell(cell);
		cell2.setPhrase(new Phrase(ticket.getSeats(), font));
		table.addCell(cell2);
		cell.setPhrase(new Phrase("JOURNEY DATE", font));
		table.addCell(cell);
		cell2.setPhrase(new Phrase(ticket.getTravelDate(), font));
		table.addCell(cell2);
		cell.setPhrase(new Phrase("DEPARTURE TIME", font));
		table.addCell(cell);
		cell2.setPhrase(new Phrase(ticket.getTravelTime(), font));
		table.addCell(cell2);
		cell.setPhrase(new Phrase("PRICE", font));
		table.addCell(cell);
		cell2.setPhrase(new Phrase(rupee.getSymbol()+amount, font));
		table.addCell(cell2);
		cell.setPhrase(new Phrase("BOOKED AT", font));
		table.addCell(cell);
		cell2.setPhrase(new Phrase(ticket.getCancelledAt().toString(), font));
		table.addCell(cell2);
		
		
		// Adding the created table to document
		document.add(table);

		// Closing the document
		document.close();
	}
	
	
}
