# ADA06_E07
# Algoritmos de Ordenamiento

## EQUIPO

* Ileana Gabriela Castillo Sánchez
* Endrick Alfredo Pool Flores

## DESCRIPCIÓN

Aplicación que implementa los algoritmos de ordenamiento Binary Insertion Sort, Merge Sort, Quick Sort y Radix Sort en un dataset en formato CSV cuyas columnas contienen atributos numéricos y alfanuméricos. El dataset será cargado a una lista doblemente ligada y el ordenamiento se efectuará de acuerdo a lo que indique el usuario: de menor a mayor (en orden alfabético) o de mayor a menor (en orden inverso al alfabético).

El programa registra las siguientes métricas de cada algoritmo:
* Tiempo de ejecución del algoritmo
* Número de comparaciones
* Número de intercambios
y genera un archivo de salida ("resumen.txt") con estas mismas para el análisis de las métricas.

También, al ejecutarse, el programa proporciona un archivo de salida CSV (datos ordenados) por cada algoritmo de ordenamiento:
* BinaryInsertionSort_ordenado.csv
* MergeSort_ordenado.csv
* QuickSort_ordenado.csv
* RadixSort_ordenado.csv

## CÓMO CLONAR ESTE REPOSITORIO

1. Elija la carpeta en donde desee clonar el repositorio. Por ejemplo, la de Documentos. Abra una terminal y ubíquese en la carpeta creada. Desde Windows puede ejecutar el siguiente comando para clonarlo en la carpeta "Documentos":
```
cd Documents
```
2. En la terminal, escriba lo siguiente:
```
git clone https://github.com/Ileana-Castillo/ADA06_E07
```
3. Así, el repositorio se clonará en la carpeta en la que se ha ubicado.

## COMPILAR Y EJECUTAR LA APLICACIÓN
1. Abra una terminal
2. Desde la terminal, ubíquese en la carpeta "ADA06_E07" (la cual es donde se encuentra el programa) con el comando:
```
cd Documents\ADA06_E07
```
3. Compile el programa con el comando:
```
javac *.java
```
4. Ejecute el programa con el comando:
```
java AlgoritmosOrdApp
```
