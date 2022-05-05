# compiladorPaez👩‍💻
un analizador lexico y sintactico sin jflex
se guarda en un arreglo despues de un ":" para luego ser analizados por el metodo matches
```java
            if(Arreglo[i].contains("texto ")){
                   if(Arreglo[i].matches("[\\s]*texto [a-zA-Z]*[0-9]* = '[a-zA-Z|0-9|\\s]*'")){
                                txt_salida.append("declaracion correcta del texto perfect \n");
                                textobien = true;
                                }else{
                                txt_errores.append("no has declarado bien el valor:  "+Arreglo[i].replaceAll("\n","")+"\n");
                                textobien = false;
                   }
            }
   ```


![por_si_acaso](pantallaprin.png)

