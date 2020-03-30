# Demo
|Integrantes|Código|
|-----------|-----------|
|Juan Felipe Herrera Poveda|20181020077|
|Juan Esteban Olaya García|20171020135|
|Juan Diego León Moreno|20171020157|

Se implementa State y Observer

# State

Se utiliza un estado Estado, un contexto EstadoPersonaje y tres estados concretos moribundo, herido y vigoroso; a partir del contexto se seleccionará un estado el cual cambiará el valor de daño del personaje.

![UML](https://github.com/EstebanOG/Demo_de_personajes_V3/blob/master/st.png)

# Observer

Se utiliza un sujeto subject, un Observador AlarmaPocima y un oberver colisionPocima; cada vez que el personaje haga colison con una pocima del juego, accederá al método de colisión para ejecutar el método Update() en la lista de observadores.

![UML](https://github.com/EstebanOG/Demo_de_personajes_V3/blob/master/o.png)
