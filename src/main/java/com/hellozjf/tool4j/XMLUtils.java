package com.hellozjf.tool4j;

import java.io.StringReader;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.io.SAXValidator;
import org.xml.sax.SAXException;

public class XMLUtils {
    
    public static boolean isValid(String xmlString) {
        SAXReader reader = new SAXReader();
        StringReader stringReader = new StringReader(xmlString);
        Document document = null;
        try {
            document = reader.read(stringReader);
        } catch (DocumentException e1) {
            e1.printStackTrace();
            return false;
        }
        SAXValidator validator = new SAXValidator();
        try {
            validator.validate(document);
            return true;
        } catch (SAXException e) {
            return false;
        }
    }

    private XMLUtils() {
    }
}
