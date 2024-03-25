package com.example.tgid.sistema;

import java.util.ArrayList;
import java.util.List;

import com.example.tgid.taxa.Taxa;

public class Sistema {
    
    
    public static boolean validarDocumento(String doc){
        return ValidarDoc.validarDoc(doc);
    }
}