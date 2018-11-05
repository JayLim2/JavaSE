package com.jaylim.ch01.task12;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;
import com.sun.org.apache.xerces.internal.impl.XMLErrorReporter;
import com.sun.org.apache.xerces.internal.impl.dtd.XMLDTDProcessor;
import com.sun.org.apache.xerces.internal.impl.msg.XMLMessageFormatter;
import com.sun.org.apache.xerces.internal.util.XMLSymbols;
import com.sun.org.apache.xerces.internal.xni.Augmentations;
import com.sun.org.apache.xerces.internal.xni.XMLString;
import com.sun.org.apache.xerces.internal.xni.XNIException;

public class Break {
    public static void main(String[] args) {

    }

    /*
    Кусок неведомого метода с меткой в break
     */
    public void attributeDecl(String elementName, String attributeName,
                              String type, String[] enumeration,
                              String defaultType, XMLString defaultValue,
                              XMLString nonNormalizedDefaultValue, Augmentations augs) throws XNIException {
        // ...
        if (type == XMLSymbols.fENUMERATIONSymbol || type == XMLSymbols.fNOTATIONSymbol) {
            outer:
            for (int i = 0; i < enumeration.length; ++i) {
                for (int j = i + 1; j < enumeration.length; ++j) {
                    if (enumeration[i].equals(enumeration[j])) {
                        // Only report the first uniqueness violation. There could be others,
                        // but additional overhead would be incurred tracking unique tokens
                        // that have already been encountered. -- mrglavas
                        Parser fErrorReporter;
                        /*fErrorReporter.reportError(XMLMessageFormatter.XML_DOMAIN,
                                type == XMLSymbols.fENUMERATIONSymbol
                                        ? "MSG_DISTINCT_TOKENS_IN_ENUMERATION"
                                        : "MSG_DISTINCT_NOTATION_IN_ENUMERATION",
                                new Object[]{elementName, enumeration[i], attributeName},
                                XMLErrorReporter.SEVERITY_ERROR);*/
                        break outer;
                    }
                }
            }
        }

        //...
    }

    /*
    ИСПРАВЛЕНИЕ С МЕТКОЙ
     */
    public void attributeDeclFIXED(String elementName, String attributeName,
                                   String type, String[] enumeration,
                                   String defaultType, XMLString defaultValue,
                                   XMLString nonNormalizedDefaultValue, Augmentations augs) throws XNIException {
        // ...
        if (type == XMLSymbols.fENUMERATIONSymbol || type == XMLSymbols.fNOTATIONSymbol) {
            for (int i = 0; i < enumeration.length; ++i) {
                for (int j = i + 1; j < enumeration.length; ++j) {
                    if (enumeration[i].equals(enumeration[j])) {
                        // Only report the first uniqueness violation. There could be others,
                        // but additional overhead would be incurred tracking unique tokens
                        // that have already been encountered. -- mrglavas
                        Parser fErrorReporter;
                        /*fErrorReporter.reportError(XMLMessageFormatter.XML_DOMAIN,
                                type == XMLSymbols.fENUMERATIONSymbol
                                        ? "MSG_DISTINCT_TOKENS_IN_ENUMERATION"
                                        : "MSG_DISTINCT_NOTATION_IN_ENUMERATION",
                                new Object[]{elementName, enumeration[i], attributeName},
                                XMLErrorReporter.SEVERITY_ERROR);*/

                        i = 0;
                        break;
                    }
                }
            }
        }

        //...
    }
}
