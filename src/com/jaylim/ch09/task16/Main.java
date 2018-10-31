package com.jaylim.ch09.task16;

import javax.activation.ActivationDataFlavor;
import javax.activation.MimeType;
import javax.management.loading.MLet;
import javax.management.loading.PrivateMLet;
import java.awt.datatransfer.DataFlavor;

public class Main {
    public static void main(String[] args) {
        /*
        ActivationDataFlavor, DataFlavor, MimeType, MLet, PrivateMLet
         */
        ActivationDataFlavor activationDataFlavor;
        DataFlavor dataFlavor;
        MimeType mimeType;
        MLet mLet;
        PrivateMLet privateMLet;

        /* Ни в одном классе не использует при десериализации
        методы readResolve() и writeReplace()
        */
    }
}
