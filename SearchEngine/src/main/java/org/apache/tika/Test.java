package org.apache.tika;

/**
 * Created by yuyufeng on 2017/6/27.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;

import org.xml.sax.SAXException;

public class Test {

    public static void main(final String[] args) throws IOException,SAXException, TikaException {

        //Assume sample.txt is in your current directory
        File file = new File("d://test.doc");
        //parse method parameters
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream inputstream = new FileInputStream(file);
        ParseContext context = new ParseContext();

        //parsing the file
        parser.parse(inputstream, handler, metadata, context);
        System.out.println("File content : " + handler.toString());
    }
}