/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorpdf;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Gaba
 */
public class Raporty {
    public static final String FONT = "resources/fonts/open-sans.regular.ttf";
    public static final String FONTB = "resources/fonts/open-sans.bold.ttf";
//
//    protected static Font font10;
//    protected static Font font10b;
//    protected static Font font12;
//    protected static Font font12b;
//    protected static Font font14;
//    protected static Font font14b;
    public static ResultSet rs;
    public static Document document;
    static PdfWriter writer;
    
    
//    
//     public Raporty() throws DocumentException, IOException {
//        BaseFont bf = BaseFont.createFont(FONT, BaseFont.WINANSI, BaseFont.EMBEDDED);
//        BaseFont bfb = BaseFont.createFont(FONTB, BaseFont.WINANSI, BaseFont.EMBEDDED);
//        font10 = new Font(bf, 10);
//        font10b = new Font(bfb, 10);
//        font12 = new Font(bf, 12);
//        font12b = new Font(bfb, 12);
//        font14 = new Font(bf, 14);
//        font14b = new Font(bfb, 14);
//    }
     
       public static ResultSet executeDefaultQuery() throws ClassNotFoundException, SQLException {
        String query = ("Select CONCAT(imie_s,\" \",nazwisko_s)"
                + " as student,CONCAT(imie_p,\" \",nazwisko_p) as prowadzacy ,ocena,"
                + " nazwa_przedmiotu from oceny,pracownicy,przedmioty,studenci where oceny.id_przedmiotu=przedmioty.id_przedmiotu"
                + " and oceny.id_studenta=studenci.id_studenta and oceny.id_pracownika=pracownicy.id_pracownika;");
        
 try {
            ConnectionClass base = new ConnectionClass();
            Connection conn;
            conn = base.getConnection();
            rs = conn.createStatement().executeQuery(query);
        } catch (SQLException sqle) {
            System.out.println("problem z zapytaniem" + query);
        }
 
        return rs;
    }

  public static void savePdf() throws DocumentException, IOException {
        document = new Document(PageSize.A4);
        String nazwaRaportu = "raport " + LocalDate.now();
        nazwaRaportu = nazwaRaportu + ".pdf";
        System.out.println(nazwaRaportu);
        try {
            if(!Files.exists(Paths.get("raports"))){
                Files.createDirectory(Paths.get("raports"));
            }
            writer = PdfWriter.getInstance(document, new FileOutputStream("raports/" + nazwaRaportu));
            writer.setPdfVersion(PdfWriter.VERSION_1_7);
        } catch (FileNotFoundException e) {
            System.out.println("Proces nie może uzyskać dostępu do pliku,- używany przez inny proces-");
        }
    }
  
  public static int howManyColumns(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnc = rsmd.getColumnCount();
        return columnc;
    }
    public static int howManyRecords(ResultSet rs) throws SQLException{
        int rownum = 0;
        rs.first();
        while (rs.next()) {
            rownum += 1;
        }
        rs.first();
        return rownum;
    }
        public static Document setDocumentInfo(Document d,String autor,String title,String language,String creator){
        document.addAuthor(autor);
        document.addCreationDate();
        document.addTitle(title+" "+LocalDate.now());
        document.addLanguage(language);
        document.addCreator(creator);
        return d;
    }
          public static PdfPTable setInfoTable(PdfPCell column1,PdfPCell column2){
        PdfPTable tabInfo= new PdfPTable(2);
        tabInfo.setWidthPercentage(100);
        tabInfo.addCell(column1);
        tabInfo.addCell(column2);
        
        return tabInfo;
        
        
    } 
        public static PdfPCell setInfoCell(String firstBold,String secondLine,String thirdLine){
        PdfPCell cell= new PdfPCell();
        cell.setBorderColor(BaseColor.WHITE);
        cell.addElement(new Paragraph(firstBold));
        cell.addElement(new Paragraph(secondLine));
        cell.addElement(new Paragraph(thirdLine));
        return cell;
    }
    public static PdfPTable setItemTable() throws SQLException{
        PdfPTable iTable = new PdfPTable(howManyColumns(rs));
        iTable.setWidthPercentage(100);
        iTable.setSpacingAfter(10);
        iTable.setSpacingBefore(10);  
        iTable=(setItemTableInfo(iTable));
        iTable=(setItemRecords(rs,iTable));
        return iTable;
        
        //font12b
    } public static PdfPTable setItemTableInfo(PdfPTable infoRecord) throws SQLException{
        infoRecord.addCell(new Paragraph("Imie i nazwisko studenta"));
        infoRecord.addCell(new Paragraph("Imie i nazwisko prowadzącego"));
        infoRecord.addCell(new Paragraph("Ocena"));
        infoRecord.addCell(new Paragraph("Przedmiot"));

        return infoRecord;
    }
    
     public static PdfPTable setItemRecords(ResultSet rs,PdfPTable p) throws SQLException{
            int j=howManyRecords(rs);
        for (int i = 0; i < j+1 ; i++) {
            p.addCell("" + rs.getString(1));
            p.addCell("" + rs.getString(2));
            p.addCell("" + rs.getString(3));
            p.addCell("" + rs.getString(4));         
            rs.next();
        }
        return p;
    }
 public static PdfPTable setHeaderTab() throws BadElementException, IOException{
        Paragraph p;
      PdfPTable headerTab = new PdfPTable(2);  
      PdfPCell cell = new PdfPCell();
      headerTab.setWidthPercentage(100);
      Image img = Image.getInstance("resources/images/ur.png");
        img.scaleAbsolute(new Rectangle(50, 50));
        cell.setImage(img);
        cell.setBorderColor(BaseColor.WHITE);
        headerTab.addCell(cell);
        cell = new PdfPCell();
        cell.setBorderColor(BaseColor.WHITE);
        p = new Paragraph("Rzeszów");
        p.setAlignment(Element.ALIGN_RIGHT);
        cell.addElement(p);
        p = new Paragraph("" + LocalDate.now());
        p.setAlignment(Element.ALIGN_RIGHT);
        cell.addElement(p);
        headerTab.addCell(cell);
        return headerTab;
    }


 public static void createDefaultDocument(ResultSet rs) throws BadElementException, IOException, DocumentException, SQLException, ClassNotFoundException  {
      
        document=setDocumentInfo(document,"wu","raport ocen z dnia ","pl-PL","WUAdmin");

        document.open();
        document.add(setHeaderTab());
        document.add(setInfoTable(setInfoCell("Nadawca", "Grupa", "Numer 3"),setInfoCell("Odbiorca","UR", "Sp.z o.o.")));
        document.add(setItemTable());
        document.close();
    }
    public static void main(String[] args) {
        
    }
}


  
   