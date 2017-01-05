package com.zngsgw.ssh.controller.demo;

import java.io.FileOutputStream;
import java.io.IOException;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFTable {

    public static final String RESULT = "e:\\TableDemo3.pdf";
 
    public static void createPdf(String filename)
        throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        PdfPTable table = createTable1();
        document.add(table);
        table = createTable2();
        table.setSpacingBefore(5);
        table.setSpacingAfter(5);
        document.add(table);
        table = createTable3();
        document.add(table);
        table = createTable4();
        table.setSpacingBefore(5);
        table.setSpacingAfter(5);
        document.add(table);
        table = createTable5();
        document.add(table);
        table = createTable6();
        document.add(table);
        // step 5
        document.close();
    }
 
    /**setWidths()函数举例*/
    public static PdfPTable createTable1() throws DocumentException {
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(288 / 5.23f);
        table.setWidths(new int[]{2, 1, 1});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Table 1"));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        cell.setRowspan(2);
        table.addCell(cell);
        table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");
        return table;
    }
 
    /**setWidths()函数举例*/
    public static PdfPTable createTable2() throws DocumentException {
        PdfPTable table = new PdfPTable(3);
        table.setTotalWidth(288);
        table.setLockedWidth(true);
        table.setWidths(new float[]{2, 1, 1});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Table 2"));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        cell.setRowspan(2);
        table.addCell(cell);
        table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");
        return table;
    }
 
    /**合并单元格setColspan()函数举例*/
    public static PdfPTable createTable3() throws DocumentException {
        PdfPTable table = new PdfPTable(new float[]{ 2, 1, 1 });
        table.setWidthPercentage(85f);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Table 3"));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        cell.setRowspan(5);
        table.addCell(cell);
        table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");
        table.addCell("row 3; cell 1");
        table.addCell("row 3; cell 2");
        table.addCell("row 4; cell 1");
        table.addCell("row 4; cell 2");
        table.addCell("row 5; cell 1");
        table.addCell("row 5; cell 2");
        return table;
    }
 
    /**setWidthPercentage()方法举例*/
    public static PdfPTable createTable4() throws DocumentException {
        PdfPTable table = new PdfPTable(13);
        Rectangle rect = new Rectangle(523, 770);
        //rect表示PageSize页面的大小，主要用于检测各列宽度之各是否超过边界，如果超过，则按比例重新赋值
//        table.setWidthPercentage(new float[]{ 144, 72, 72 }, rect);
        PdfPCell cell=new PdfPCell();
//        cell = new PdfPCell(new Phrase("Table 4"));
        cell.setColspan(2);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Subject:"));
        cell.setRowspan(2);
        table.addCell(cell);
        table.addCell("YUWEN");
        table.addCell("SHUXUE");
        table.addCell("YINYU");
        table.addCell("ZHENGZHI");
        table.addCell("LISHI");
        table.addCell("DILI");
        table.addCell("WULI");
        table.addCell("HUAXUE");
        table.addCell("SHENGWU");
        table.addCell("KOUYU");
        table.addCell("ZONGHE");
        return table;
    }
 
    /**setTotalWidth()方法举例*/
    public static PdfPTable createTable5() throws DocumentException {
        PdfPTable table = new PdfPTable(3);
        table.setTotalWidth(new float[]{ 144, 72, 72 });
        table.setLockedWidth(true);
        PdfPCell cell=new PdfPCell();
//        cell = new PdfPCell(new Phrase("Table 5"));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Subject："));
        cell.setRowspan(2);
        table.addCell(cell);
        table.addCell("YUWEN");
        table.addCell("SHUXUE");
        for(int i=0;i<2;i++){
        	table.addCell("9"+i);
        }
        table.addCell("");
        table.addCell("");
        return table;
    }
    
    /**表格嵌套举例*/
    public static PdfPTable createTable6() throws DocumentException {
        PdfPTable table = new PdfPTable(3);
        table.setTotalWidth(new float[]{ 144, 72, 72 });
        table.setLockedWidth(true);
        
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Table 5"));
        cell.setColspan(3);
        cell.setBorderWidth(0);//设置表格的边框宽度为0
        table.addCell(cell);
        
        //加入嵌套表格
        PdfPTable celltable = new PdfPTable(2);
        celltable.addCell("qiantao11");
        celltable.addCell("qiantao12");
        
        cell = new PdfPCell(celltable);
        cell.setRowspan(2);
        cell.setBorderWidth(0);//设置表格的边框宽度为1
        cell.setPadding(0);//设置表格与上一个表格的填充为10
        table.addCell(cell);
        
        table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");
        return table;
    }
 
    public static void main(String[] args) throws IOException, DocumentException {
        PDFTable.createPdf(RESULT);
    }
}
