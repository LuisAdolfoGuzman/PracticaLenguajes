
package com.mycompany.practicalenguajes;

public class Palabra {
    String texto;
    Tipo tipo;
    public Palabra(String texto, Tipo tipo){
        this.texto = texto;
        this.tipo = tipo;
    }
    public Palabra EvaluarIdentificador(String texto, Palabra palabra){
        int largo = texto.length();
        int error = 0, digitoPresente = 0, caracterPresente = 0;
        char caracter;
        String letra;
        String[] numeros = {"1","2","3","4","5","6","7","8","9","0"};
        String[] caracteres = {"(", ")", ";", ".", ":", "[", "]", "+", "-", "*", "/", ",", "="};
        char caracterPrueba;
        String caracterPrueba1;
        caracterPrueba = texto.charAt(0);
        caracterPrueba1 = Character.toString(caracterPrueba);
        //COMPRUEBA SI EXISTE ALGUN NUMERO AL INICIO DE LA CADENA
        for (int x = 0; x < 10; x++){
            if (caracterPrueba1.equals(numeros[x])){
                digitoPresente = digitoPresente + 1;
            }
        }
        //EVALUA SI PUEDE SER UNA CADENA O UN NUMERO Y LA TRATA COMO TAL
        if (digitoPresente == 1){
            //ES NUMERO
            digitoPresente = 0;
            //IDENTIFICAR SI ES UN NUMERO O ES ERROR
            for (int x = 0; x < largo; x++){
                caracter = texto.charAt(x);
                letra = Character.toString(caracter);
                if (letra.equals(".")){
                    digitoPresente = digitoPresente + 1;
                }
                for (int y = 0; y < 10; y++){
                    if (letra.equals(numeros[y])){
                        digitoPresente = digitoPresente + 1;
                    }
                } 
            }
            //EVALUA SI TODOS LOS CARACTERES SON ACEPTABLES PARA UN NÚMERO
            if (digitoPresente == largo){
                palabra.tipo = Tipo.ENTERO;
                int cantidadPuntos = 0;
                //EVALUA SI PUEDE SER DECIMAL, QUEDA COMO ENTERO O ES ERROR
                for (int x = 0; x < largo; x++){
                    caracter = texto.charAt(x);
                    letra = Character.toString(caracter);
                    if (letra.equals(".")){
                        cantidadPuntos = cantidadPuntos +1;
                    }
                }
                if (cantidadPuntos == 1){
                    palabra.tipo = Tipo.DECIMAL;
                }
                if (cantidadPuntos > 1){
                    palabra.tipo = Tipo.ERROR;
                }
            }
            else{//CONDICIONAL PARA UN ERROR NUMERICO SI EXISTE NUMERO AL INICIO
                palabra.tipo = Tipo.ERROR;
            }
        }//FIN CONDICIONAL NUMERO AL INICIO
        else{//INICIO CONDICIONAL CADENA
            //ES CADENA
            for (int i = 0; i < largo; i++){//CONDICIONAL PARA BUSCAR CARACTERES
                caracter = texto.charAt(i);
                letra = Character.toString(caracter);
                for (int a = 0; a < 13; a++){
                    if (letra.equals(caracteres[a])){
                        caracterPresente = caracterPresente + 1;
                    }
                }
            }//FIN CONDICIONAL PARA BUSCAR CARACTERES
            if (caracterPresente == largo){//EVALUA SI LA CADENA ES DE PUROS CARACTERES
                palabra.tipo = Tipo.CARACTER;
                return palabra;

            }//FIN CONDICIONAL CADENA-CARACTERES
            for (int x = 0; x < largo; x++){//CICLO QUE EVALUA IDENTIFICADORES
                caracter = texto.charAt(x);
                letra = Character.toString(caracter);
                if (letra.equals("a") || letra.equals("A") || letra.equals("b") || letra.equals("B") ||
                    letra.equals("c") || letra.equals("C") || letra.equals("d") || letra.equals("D") ||
                    letra.equals("e") || letra.equals("E") || letra.equals("f") || letra.equals("F") ||
                    letra.equals("g") || letra.equals("G") || letra.equals("h") || letra.equals("H") ||
                    letra.equals("i") || letra.equals("I") || letra.equals("j") || letra.equals("J") ||
                    letra.equals("k") || letra.equals("K") || letra.equals("l") || letra.equals("L") ||
                    letra.equals("m") || letra.equals("M") || letra.equals("n") || letra.equals("N") ||
                    letra.equals("ñ") || letra.equals("Ñ") || letra.equals("o") || letra.equals("O") ||
                    letra.equals("p") || letra.equals("P") || letra.equals("q") || letra.equals("Q") ||
                    letra.equals("r") || letra.equals("R") || letra.equals("s") || letra.equals("S") ||
                    letra.equals("t") || letra.equals("T") || letra.equals("u") || letra.equals("U") ||
                    letra.equals("v") || letra.equals("V") || letra.equals("w") || letra.equals("W") ||
                    letra.equals("x") || letra.equals("X") || letra.equals("y") || letra.equals("Y") ||
                    letra.equals("z") || letra.equals("Z") || letra.equals("(") || letra.equals(")") ||
                    letra.equals("{") || letra.equals("}") || letra.equals("[") || letra.equals("]") ||
                    letra.equals(";") || letra.equals(":") || letra.equals(".") || letra.equals("+") ||
                    letra.equals("-") || letra.equals("*") || letra.equals("/") || letra.equals(",") ||
                    letra.equals("1") || letra.equals("2") || letra.equals("3") || letra.equals("4") ||
                    letra.equals("5") || letra.equals("6") || letra.equals("7") || letra.equals("8") ||
                    letra.equals("9") || letra.equals("0") || letra.equals("=")){
                }
                else{
                    error = error + 1;
                }
                if (error != 0){
                    palabra.tipo = Tipo.ERROR;
                }
                else{
                    palabra.tipo = Tipo.IDENTIFICADOR;
                }  
            }//FINAL FOR EVALUA IDENTIFICADORES 
        }//FINAL CONDICIONAL CADENA
        return palabra;
    }
}
