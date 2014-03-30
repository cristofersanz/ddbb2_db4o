javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/beans/Cliente.java -d ../bin
javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/beans/Cuenta.java -d ../bin
javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/beans/CAhorro.java -d ../bin
javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/beans/CCorriente.java -d ../bin
javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/beans/Oficina.java -d ../bin
javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/beans/Operacion.java -d ../bin
javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/beans/OperacionIR.java -d ../bin
javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/beans/OperacionTR.java -d ../bin

javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/persistencia/Contenedor.java -d ../bin

javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/crud/ClienteException.java -d ../bin
javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/crud/CuentaException.java -d ../bin
javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/crud/OficinaException.java -d ../bin
javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/crud/OperacionException.java -d ../bin
javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/crud/ClienteCRUD.java -d ../bin
javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/crud/CuentaCRUD.java -d ../bin
javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/crud/OficinaCRUD.java -d ../bin
javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/crud/OperacionCRUD.java -d ../bin

javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/pruebas/Datos.java -d ../bin
javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/pruebas/PruebaCoherencia.java -d ../bin
javac -cp "../lib/db4o.jar:../bin" ../src/bbdd2/p2/pruebas/PruebaQBE.java -d ../bin
