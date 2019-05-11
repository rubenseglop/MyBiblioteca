====== Programación de móviles con Android ======

===== ¿Qué es Android =====

Actualmente cuando se habla de //Android// se hace tanto para referirse al Sistema Operativo que viene instalado en nuestros móviles como para hablar del framework que se utilizar para crear las aplicaciones. Conviene por tanto distinguir claramente entre //Android// que será el Sistema Operativo y //Android SDK// que es el framework ó SDK (Software Development Kit) utilizado para desarrollar las aplicaciones que funciona sobre dicho S.O.

Si miramos más al detalle, //Android// realmente es un Sistema Operativo //Linux// al que se le ha añadido una capa extra de software (con una JVM, Java Virtual Machine) que incluye desde aplicaciones (como la aplicación de Contactos, aplicación Teléfono, . . .), motores de Bases de Datos (//SQLite//) y otros motores para navegación web, renderizado 3D (//OpenGL//) y demás software. Más adelante se puede ver un esquema que muestra la estructura completa del Sistema Operativo y se puede observar con más detalle todo lo que incluye.

Por otro lado, //Android SDK// es un framework de desarrollo centrado en la creación de aplicaciones para dispositivos móviles. También cuenta con todas las herramientas necesarias para ensamblar la aplicación e incluso para probarla con un emulador integrado. Decimos que es un (Software Development Kit) puesto que es la forma genérica de llamar a un conjunto de librerías y herramientas destinados a construir un determinado tipo de aplicaciones.

Puesto que los frameworks o SDKs no incluyen el IDE con el que el programador debe escribir el código, en los últimos años, Google desarrolló //Android Studio//,un IDE completo para su uso con el framework.

=== Android Studio ===

**Android Studio** es el IDE //oficial// para desarrollar aplicaciones para Android. En los inicios del framework, la única manera de desarrollar aplicaciones fue utilizar un plugin que se instalaba con el IDE [[http://www.eclipse.org|Eclipse]] pero hace unos años Google comenzó el desarrollo de //Android Studio// utilizando como base el IDE IntelliJ IDEA. Actualmente //Android Studio// es un IDE muy maduro ya que se encuentra en su versión 2.X y cuenta con todas las herramientas necesarias (Editor de código, multitud de asistentes, emulador, . . .).

Para aprender a manejar esta herramienta, que será con la que desarrollemos aplicaciones durante el curso, puedes encontrar el {{apuntes:paas_-_ee1_-_rev_2.0.pdf|Manual de Android Studio}} de [[http://www.sgoliver.net|sgoliver]] en la sección [[extra:referencias]]

{{ youtube>Rdq48idTA9w }}
\\
{{ youtube>f4_qqeHlF-4 }}
===== Estructura de Android =====

==== Estructura del Sistema Operativo ====

{{ estructura_android.png |Estructura Android}}
==== Ciclo de vida de una aplicación =====

{{ activity_lifecycle.png |Ciclo de vida Android}}

==== Estructura de una aplicación ====

<figure>
{{ android_project.png }}
<caption>Estructura de un proyecto</caption></figure>

  * **libs** Carpeta con librerías externas añadidas de forma //manual// por el programador (conviene añadirlas utilizando el fichero de configuración de //gradle//)
  * **src** Carpeta que contiene el código //Java// de la aplicación. Se debe organizar (y es muy importante) utilizando las mismas reglas que cualquier aplicación //Java// en cuanto a la estructura y nombrado de paquetes
  * **res** Dentro de esta carpeta se almacena todo aquello que forma parte del proyecto que no sea código //Java// (imágenes, layouts, textos, . . .)
  * **res->drawable-xxxx** En esta carpetas se almacenan las imágenes e iconos que se vayan a utilizar en la aplicación. Se deben organizar por resolución puesto que es //Android// quién decide que resolución procede en función de las características del móvil que ejecuta nuestra aplicación
  * **res->layout** Contiene los diseños de las pantallas de nuestra aplicación. Hay que tener en cuenta que el framework nos va a obligar a programar separando lógica (código) de presentación (pantallas)
  * **res->menu** Contiene los ficheros XML que definen los menús que aparezcan en las diferentes pantallas de nuestra aplicación
  * **res->values** Contiene los ficheros XML con los textos de la aplicación en el idioma por defecto
  * **res->values-en** Contiene los ficheros XML con los textos de la aplicación en otro idioma (en este caso inglés->**en**glish)
  * **AndroidManifest.xml** Es un fichero XML que permite configurar ciertos aspectos importantes de la aplicación
  * **build.gradle** Es el fichero de configuración de //gradle// para nuestro proyecto de aplicación //Android//

=== Código de la aplicación ===

El código de la aplicación debe ser empaquetado siguiendo la misma jerarquía y nombrado de paquetes que indican las [[http://docs.oracle.com/javase/tutorial/java/package/namingpkgs.html|convenciones de código de Java]] para ello. Además, conviene seguir una serie de reglas que recomienda //Android// en su [[http://source.android.com/source/code-style.html|Guía de estilo para contribuidores]]

Es especialmente importante seguir las reglas para el nombrado de paquetes y que además está coincida con la que se especifica al inicio del proyecto y que quedará registrada en el fichero de manifiesto ''AndroidManifest.xml'' (que veremos más adelante). En caso contrario es muy posible que el proyecto no se pueda ensamblar y, por tanto, no funcionará.

=== Recursos de imagen (drawable) ===

=== Recursos de layout (layouts) ===

Aqui se almacenan los ficheros que contienen los layouts (diseños) de la aplicación. Lo más habitual será encontrar un layout por cada ''Activity'' que se haya creado, pero al igual que necesitaremos crear clases Java que no estén asociadas con ninguna pantalla, también podemos encontrar layouts que no estén vinculados con ninguna Activity porque sean parte de otros layouts más complejos. Por ejemplo, en una Activity podremos diseñar un layout que sea una lista de elementos, que a su vez serán otro layout. De esa forma podremos diseñar el aspecto de cada uno de los elementos y luego listar tantos elementos como haya en una lista, utilizando el mismo layout para cada uno de ellos.

=== Recursos de idioma (values) ===

Aquí se almacenan los ficheros que contienen todos los textos de la aplicación. El objetivo es separar totalmente el código de la aplicación del texto con la finalidad de simplificar la internacionalización de la misma. De esa manera, cuando se quiera traducir la aplicación a un nuevo idioma bastará con crear el fichero correspondiente con los textos en dicho idioma y no será necesario realizar ningún cambio en el código.

Por defecto, en la carpeta ''values'' nos encontraremos con los ficheros en el idioma por defecto. En nuestro caso sería el español.

=== Fichero de textos === 

El fichero principal que encontramos en esta carpeta ''values'' es ''strings.xml'', que contiene todos los textos de la aplicación acompañados de una cadena que funciona de identificador, para poder hacer referencia a cada cadena desde el código.

<code xml>
<resources>
  <string name="app_name">Agenda</string>
  <string name="action_settings">Settings</string>
  <string name="title_activity_nuevo_contacto">Nuevo Contacto</string>
  <string name="title_activity_preferencias">Preferencias</string>
  <string name="acerca_de_title">Acerca de Agendroid v2</string>
    
  <string name="menu_nuevo_contacto_label">Nuevo Contacto</string>
  <string name="menu_preferencias_label">Preferencias</string>
    
  <string name="nombre_label">Nombre</string>
  <string name="apellidos_label">Apellidos</string>
  <string name="telefono_label">Teléfono</string>
  <string name="movil_label">Móvil</string>
  <string name="fax_label">Fax</string>
  <string name="favorito_label">Favorito</string>
  <string name="btaceptar_label">Aceptar</string>
  <string name="btcancelar_label">Cerrar</string>
  <string name="btimagen_label">Imagen</string>
  <string name="tvsindatos_label">No hay contactos</string>
  <string name="menu_acerca_de_label">Acerca de</string>
   
  <string name="nuevo_contacto_message">Contacto Añadido</string>
  <string name="esta_seguro_message">¿Está seguro?</string>
  <string name="acerca_de_message">Agendroid v2\nAgenda para Android\n(c) 2013 Santiago Faci</string>
    
  <string name="llamar_telefono_item">Llamar a casa</string>
  <string name="llamar_movil_item">Llamar al móvil</string>
  <string name="eliminar_item">Eliminar</string>
</resources>
</code>

Así, en el caso de que queramos traducir esta aplicación al inglés, sólo tenemos que hacer una copia de este fichero, moverlo a una carpeta ''values-en'' y traducir los textos, dejando intacta la cadena identificadora de cada uno de ellos. De esa forma, cuando hagamos referencia a una cadena, será Android quién decida en que idioma escribirla dependiendo del idioma que el usuario tenga configurado en su dispositivo móvil.

<file xml strings.xml>
<resources>
  <string name="app_name">Contacts</string>
  <string name="action_settings">Settings</string>
  <string name="title_activity_nuevo_contacto">New Contact</string>
  <string name="title_activity_preferencias">Preferences</string>
  <string name="acerca_de_title">About Agendroid v2</string>
    
  <string name="menu_nuevo_contacto_label">New Contact</string>
  <string name="menu_preferencias_label">Preferences</string>
    
  <string name="nombre_label">Name</string>
  <string name="apellidos_label">Last name</string>
  <string name="telefono_label">Phone</string>
  <string name="movil_label">Mobile</string>
  <string name="fax_label">Fax</string>
  <string name="favorito_label">Favorite</string>
  <string name="btaceptar_label">Accept</string>
  <string name="btcancelar_label">Close</string>
  <string name="menu_acerca_de_label">About</string>
    
  <string name="nuevo_contacto_message">Contact Added</string>
  <string name="esta_seguro_message">Are you sure?</string>
  <string name="acerca_de_message">Agendroid v2\nAndroid Contacts App\n(c) 2013 Santiago Faci</string>
    
  <string name="btimagen_label">Image</string>
    
  <string name="tvsindatos_label">No data</string>
    
  <string name="llamar_telefono_item">Call Home</string>
  <string name="llamar_movil_item">Call Mobile</string>
  <string name="eliminar_item">Delete</string>
</resources>
</file>

Así, si queremos desde el código, mostrar un mensaje con alguno de estos textos en una ''TextView'', podemos hacerlo de la siguiente forma:

<code java>
. . .
ViewText vtMensaje;
. . .
vtMensaje.setText(getResources().getString(R.string.nuevo_contacto_message));
. . .
</code>

También podremos, donde se admita un ''int'' indicando el identificador de la cadena (por ejemplo para mostrar mensajes emergentes con ''Toast''), usar las cadenas de la siguiente forma:

<code java>
Toas.makeText(this, R.string.nuevo_contacto_message, Toast.LENGTH_SHORT).show();
</code>

=== Arrays de textos ===

También se pueden crear //arrays// de datos que luego pueden ser usados desde el código de la aplicación. El siguiente lo almacenaríamos en la carpeta ''values'' puesto que esta en español. Para traducirlo procederíamos de la misma forma que hemos hecho para traducir los textos de la aplicación

<file xml datos.xml>
<resources>
  <string-array name="datos">
    <item>Nombre</item>
    <item>Apellidos</item>
  </string-array>
</resources>
</file>

Fichero traducido y almacenado en ''values-en''

<file xml datos.xml>
<resources>
  <string-array name="datos">
    <item>Name</item>
    <item>Lastname</item>
 </string-array>
</resources>
</file>

=== Fichero de manifiesto AndroidManifest.xml ===

A continuación se muestra como ejemplo un fichero ''AndroidManifest.xml'' de una aplicación de ejemplo. A continuación se explicarán cada una de las partes que lo forman

<code xml>
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
  package="org.sfaci.guiarestaurantes" >

  <application
    android:allowBackup="true"
    android:icon="@drawable/ic_launcher"
    android:label="@string/app_name"
    android:theme="@style/AppTheme" >

    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <uses-permission android:name="com.google.android.providers.gsf.permission.READ_GSERVICES"/>

    <activity
          android:name=".ListadoRestaurantes"
          android:label="@string/app_name" >
          <intent-filter>
              <action android:name="android.intent.action.MAIN" />

              <category android:name="android.intent.category.LAUNCHER" />
          </intent-filter>
    </activity>
    <activity
          android:name=".Mapa"
          android:label="@string/title_activity_mapa" >
    </activity>

      <meta-data
          android:name="com.google.android.maps.v2.API_KEY"
          android:value="AIzaSyB2JUyHKX1WCg9Jj-rLDW6HicSs_6_lvac"/>
  </application>
</manifest>
</code>

  * ''package'' Con este parámetro indicamos el paquete base de nuestra aplicación
  * ''<uses-permission>'' Pueden aparecer tantas líneas como permisos sea necesario activar en la aplicación. Los permisos permiten que la aplicación haga uso de determinadas características del móvil de las que debe ser notificado el usuario a la hora de instalarla, tales como el uso de Internet, acceso al GPS, acceso a la tarjeta de memoria y otras
  * ''<activity>...</activity>'' Cada una de estas etiquetas indica la existencia de una Activity. Se añaden de forma automática cuando se crea la Activity desde el IDE
  * ''<intent-filter> . . . android.intent.action.MAIN . . . </intent-filter>'' Estas 4 líneas se colocan dentro de las etiquetas de la //Activity// que queremos marcar como //Activity// principal que será la primera que se lance cuando se ejecute la aplicación
  * ''<meta-data . . . />'' En este caso utilizamos esta etiqueta para indicar información adicional como el //API KEY// de Google Maps para utilizar los mapas en la aplicación
===== Hello World! =====

==== Estructura de un proyecto de ejemplo ====

===== Componentes Android =====

==== Componentes UI ====

=== Layouts ===

Los layouts permiten distribuir todos los componentes que forma la GUI de una Activity en la pantalla. Principalmente usaremos dos:

  * **LinearLayout (Horizontal|Vertical)** Permiten distribuir todos los componentes en vertical (uno debajo de otro) o en horizontal (una a la derecha del anterior). Aunque parecen muy básicos combinándolos se pueden crear estructuras complejas puesto que, por ejemplo, un layout horizontal se puede colocar como elemento dentro de uno vertical y realizar GUIs algo más complejas

<figure>
{{ linearlayout.png }}
<caption>LinearLayout</caption></figure>

<figure>
{{ linear_layout_vertical_horizontal.png }}
<caption>LinearLayouts combinados (horizontal y vertical)</caption></figure>

  * **RelativeLayout**

<figure>
{{ relative_layout.png }}
<caption>RelativeLayout</caption></figure>

=== TextView ===

<figure>
{{ textview.jpg }}
<caption>Etiqueta de texto</caption>
</figure>

=== EditText ===

<figure>
{{ edittext.jpg }}
<caption>Caja de texto</caption>
</figure>

=== Button ===

<figure>
{{ button.jpg }}
<caption>Button</caption></figure>

=== Spinner ===

Un ''Spinner'' es lo que se conoce como lista desplegable. Físicamente se muestra siempre compactada ocupando una sola línea pero al pinchar en ella se despliegan en forma de lista todos los elementos que contiene.

<figure>
{{ spinner.png }}
<caption>Spinner</caption></figure>

En cuanto al funcionamiento interno, es muy similar a un ''ListView'' por lo que conviene estudiar el siguiente apartado si se quiere trabajar con un ''Spinner'', tanto para listar contenido simple como para crear un ''Adapter'' propio y configurar un //Layout// para cada elemento de la lista.

=== ListView ===

Es un componente que permite crear una lista de elementos más o menos compleja, muy similar a ''Spinner'' pero en este caso, la lista se muestra expandida pudiendo ocupar incluso toda la pantalla del dispositivo.

Para el caso más sencillo de ''ListView'' tendremos que disponer de una serie de datos simples para mostrar, por ejemplo una lista de cadenas de texto, números o similar

<code java>
. . .
List<String> lista = new ArrayList<>();
lista.add("Primer elemento");
lista.add("Segundo elemento");
. . .
ListView lvLista = (ListView) findViewById(R.id.lvLista);
ArrayAdapter<String> adapter = new ArrayAdapter<>(
                               this, android.R.layout.simple_list_item_1, lista);
lvLista.setAdapter(adapter);
. . .
</code>

En este caso nos quedaría una lista como la de la siguiente captura:

<figure>
{{ listview1.png }}
<caption>ListView simple (simple_list_item1 layout)</caption></figure>

Si necesitamos alguna presentación más compleja, necesitaremos crearnos un layout personalizado y además implementar la clase que se asociará con dicho layout para indicarle a Android como queremos rellenarlo.

Para este caso podemos tener un listado de objetos más complejos (por ejemplo, de objetos de nuestra aplicación cuya clase hemos creado nosotros).

Suponemos que tenemos una clase donde guardamos información sobre personas: cadenas de texto, fechas, números y una imagen

<file java Amigo.java>
public class Amigo {

  private String nombreApellidos;
  private String email;
  private String telefonoFijo;
  private String telefonoMovil;
  private Bitmap foto;
  private Date fechaNacimiento;
  private float deudas;
  
  // Constructores, getters y setters
  . . .
  . . .
</file>

Definiremos también el ''layout'' para representar a cada persona con la siguiente estructura:

{{ fila.png }}

Y su representación en XML:

<file xml fila.xml>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
  android:orientation="horizontal" android:layout_width="match_parent"
  android:layout_height="match_parent">

  <ImageView
    android:layout_width="80dp"
    android:layout_height="80dp"
    android:id="@+id/ivFoto"
    android:src="@mipmap/ic_launcher" />

  <LinearLayout
    android:orientation="vertical"
    android:layout_width="wrap_content"
    android:layout_height="match_parent">

    <TextView
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:textAppearance="?android:attr/textAppearanceLarge"
      android:id="@+id/tvNombreApellidos" />

    <TextView
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:textAppearance="?android:attr/textAppearanceSmall"
      android:id="@+id/tvTelefonoMovil" />

    <TextView
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:textAppearance="?android:attr/textAppearanceSmall"
      android:id="@+id/tvTelefonoFijo" />
  </LinearLayout>
</LinearLayout>
</file>

Así, tendremos que crear un adaptador personalizado para indicar a Android como queremos representar a cada elemento (persona) en la lista (teniendo en cuenta que se pintará la misma imagen para cada uno de ellos):

<code java>
public class AmigoAdapter extends BaseAdapter {

  private Context context;
  private ArrayList<Amigo> listaAmigos;
  private LayoutInflater inflater;

  public AmigoAdapter(Activity context, ArrayList<Amigo> listaAmigos) {
    this.context = context;
    this.listaAmigos = listaAmigos;
    inflater = LayoutInflater.from(context);
  }

  static class ViewHolder {
    ImageView foto;
    TextView nombreApellidos;
    TextView movil;
    TextView fijo;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    ViewHolder holder = null;

    // Si la View es null se crea de nuevo
    if (convertView == null) {
      convertView = inflater.inflate(R.layout.fila, null);

      holder = new ViewHolder();
      holder.foto = (ImageView) convertView.findViewById(R.id.ivFoto);
      holder.nombreApellidos = (TextView) convertView.findViewById(R.id.tvNombreApellidos);
      holder.fijo = (TextView) convertView.findViewById(R.id.tvTelefonoFijo);
      holder.movil = (TextView) convertView.findViewById(R.id.tvTelefonoMovil);

      convertView.setTag(holder);
    }
    /*
     * En caso de que la View no sea null se reutilizará con los
     * nuevos valores
     */
    else {
      holder = (ViewHolder) convertView.getTag();
    }

    Amigo amigo = listaAmigos.get(position);
    holder.foto.setImageBitmap(amigo.getFoto());
    holder.nombreApellidos.setText(amigo.getNombreApellidos());
    holder.fijo.setText(amigo.getTelefonoFijo());
    holder.movil.setText(amigo.getTelefonoMovil());

    return convertView;
  }

  @Override
  public int getCount() {
    return listaAmigos.size();
  }

  @Override
  public Object getItem(int posicion) {
    return listaAmigos.get(posicion);
  }

  @Override
  public long getItemId(int posicion) {
    return posicion;
  }

}
</code>

Y por último tendremos que asociar la lista donde están los datos (Amigos) con la ''ListView'' utilizando para ello el adapter que hemos creado

<code java>
. . .
ArrayList<Amigo> listaAmigos = new ArrayList<>();
. . .
AmigoAdapter adaptador = new AmigoAdapter(this, listaAmigos);
ListView lvLista = (ListView) findViewById(R.id.lvLista);
lvLista.setAdapter(adaptador);
. . .
</code>

Si queremos que la vista del ''ListView'' se actualice a medida que haya cambios en la lista (en el ''ArrayList'') tendremos que actualizar el //adaptador//

<code java>
. . .
// Actualiza la vista del ListView
adaptador.notifyDataSetChanged();
. . .
</code>

Quedaría algo parecido a lo que muestra la siguiente captura donde se puede ver que, para cada elemento de la lista, se muestra un layout más o menos complejo con una foto y tres datos (nombre y apellidos, teléfono fijo y teléfono móvil) tal y como se había diseñado en el layout de cada fila anteriormente:

<figure>
{{ listview2.png }}
<caption>ListView con layout personalizado (Custom Layout)</caption></figure>

<figure>
{{ listview3.png }}
<caption>ListView con layour personalizado II (Custom Layout)</caption></figure>

  * [[https://www.youtube.com/watch?v=9a_18EogMKk|Trabajar con ListView I]] (Videotutorial)
  * [[https://www.youtube.com/watch?v=Z9KkQWeCxz0|Trabajar con ListView II]] (Videotutorial)
  * [[https://www.youtube.com/watch?v=M52SNrSJVVg|Trabajar con ListView III]] (Videotutorial)

=== RadioButton ===

<figure>
{{ radiobutton.png }}
<caption>RadioButton</caption></figure>

=== CheckBox ===

<figure>
{{ checkbox.png }}
<caption>Checkbox</caption></figure>

==== Otros componentes ====

=== ActionBar ===

La ''ActionBar'' es la barra superior que encontramos en todas las ''Activities'' de Android. Permite mostrar un texto indicando normalmente la ''Activity'' o aplicación que estamos mostrando y una serie de iconos con las acciones que podemos realizar en dicha ''Activity''. Estas acciones suelen cambiar dependiendo de donde nos encontramos dentro de una misma app. Este elemento es la sustitución (a partir de Android 4) del antiguo botón de opciones del que disponían los móviles Android hace un tiempo y que mostraba en la parte superior las opciones a realizar cuando el usuario estaba en una ''Activity'' determinada. Entonces se carecía de ''ActionBar''. Es por tanto importante tener en cuenta que, si ejecutamos una aplicación en un móvil anterior a Android 4, todas las opciones que incorporemos a esta ''ActionBar'' se mostrarán como menú de opciones cuando pulsemos en dicho botón.

Lo más habitual será encontrar dos o tres iconos para realizar las tareas más habituales y un icono que mostrará un menú con el resto de opciones posibles.

Así, para implementar una ''ActionBar'' como la que se muestra en la imagen anterior tenemos que llevar a cabo los siguientes pasos:
  * Diseñar el menú como un fichero XML en ''res->menu''
  * Indicar en el código de la ''Activity'' donde queramos mostrarlo, que éste se tiene que //inflar//, sobreescribiendo para ello el método ''onCreateOptionsMenu''
  * Sobreescribir el método ''onOptionsItemSelected'' para indicar qué hacer para cada una de las opciones de la ''ActionBar''

<figure>
{{actionbar1.png }}
{{ actionbar2.png}}
<caption>ActionBar</caption></figure>

Definimos el menú como un fichero XML con las opciones que queremos

<code xml main.xml>
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android" >
  <item
    android:id="@+id/menu_nuevo_contacto"
    android:icon="@drawable/ic_menu_add"
    app:showAsAction="always"
    android:title="@string/menu_nuevo_contacto_label">
  </item>
  <item
    android:id="@+id/menu_preferencias"
    android:icon="@drawable/ic_menu_preferences"
    app:showAsAction="always"
    android:title="@string/menu_preferencias_label">
  </item>
  <item
    android:icon="@drawable/ic_menu_moreoverflow_normal_holo_light"
    app:showAsAction="always">
    <menu>
      <item
        android:id="@+id/menu_acerca_de"
	android:icon="@drawable/ic_about"
	app:showAsAction="always"
	android:title="@string/menu_acerca_de_label">
      </item>
  </menu>
</item>
</menu>
</code>

Para cada elemento de la ''ActionBar'' podemos indicar, al menos, lo siguiente:
  * ''android:icon'' El icono que queremos que se muestre (de la carpeta ''res->drawable'')
  * ''android:showAsAction'' Con el valor ''always'' indicamos que queremos que se muestre en cualquier caso (se puede modificar)
  * ''android:title'' El texto que queremos que aparezca si no está disponible el icono asociado
  * El último elemento de la ''ActionBar'' es a su vez un menú desplegable con el resto de opciones que no caben directamente en la ''ActionBar''

Hay que indicar en el método ''onCreateOptionsMenu'' de la ''Activity'' donde queremos la ''ActionBar'' que ésta se debe //inflar//

<code java>
. . .
public boolean onCreateOptionsMenu(Menu menu) {
  // Inflate the menu; this adds items to the action bar if it is present.
  getMenuInflater().inflate(R.menu.main, menu);
  return true;
}
. . .
</code>

A continuación, tendremos que implementar qué queremos hacer para cada una de las opciones del menú de la ''ActionBar''

<code java>
. . .
@Override
public boolean onOptionsItemSelected(MenuItem item) {

  switch (item.getItemId()) {
    case R.id.menu_nuevo_contacto:
      // hacer algo
      return true;
    case R.id.menu_preferencias:
      // hacer algo
      return true;
    case R.id.menu_acerca_de:
      // hacer algo
      return true;
    default:
      return super.onOptionsItemSelected(item);
  }
}
. . .
</code>

Además, también podemos, en tiempo de ejecución, realizar algunas acciones sobre la ''ActionBar''

<code java>
. . .
ActionBar actionBar = getActionBar();
// Muestra la ActionBar
actionBar.show();
// Oculta la ActionBar
actionBar.hide();
// Cambiar el texto
actionBar.setSubtitle("Mi ActionBar");
actionBar.setTitle("Mi App");
. . .
</code>

{{ youtube>3CPCI4boc8o }}

=== Menú contextual ===

En Android los menús contextuales aparecen cuando el usuario realiza una pulsación prolongada en alguna parte de la pantalla. Entonces se activa (si así se ha dispuesto) un menú asociado a dicho elemento que muestra opciones para realizar sobre dicho elemento.

Para llevar a cabo la implementación de un menú contextual en Android hay que llevar a cabo los siguientes pasos:
  - Diseñar el layout de dicho menú y colocarlo en el apartado correspondiente de la carpeta de recursos (''res'')
  - Indicar que el elemento de la GUI tiene asociado un menú contextual (en este caso un ''ListView'')
  - Sobreescribir el método heredado ''onCreateContextMenu'' para forzar que dicho menú aparezca. Si tenemos varios menús contextuales tendremos que //inflar// un menú diferente para cada ''View''
  - Sobrescribir el método ''onContextItemSelected'' donde indicaremos qué hacer para cada elemento del menú contextual (según los //ids// que se hayan indicado en el menú))

<figure>
{{ contextmenu.png }}
<caption>Context Menu</caption></figure>

Diseñamos el menú en XML en ''res->menu''

<file xml menu_context_listado.xml>
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
  <item android:id="@+id/action_fijo"
    android:title="@string/lb_llamar_fijo"/>
  <item android:id="@+id/action_movil"
    android:title="@string/lb_llamar_movil"/>
  <item android:id="@+id/action_editar"
    android:title="@string/lb_editar"/>
  <item android:id="@+id/action_eliminar"
    android:title="@string/lb_eliminar"/>
  <item android:id="@+id/action_email"
    android:title="@string/lb_enviar_email"/>
  <item android:id="@+id/action_detalles"
    android:title="@string/lb_ver_detalles"/>
</menu>
</file>

Registramos que la ''ListView'' tiene asociado un menú contextual

<code java>
. . .
ListView lvLista = (ListView) findViewById(R.id.lvLista);
// Registra el menú contextual a la lista de elementos
registerForContextMenu(lvLista);
. . .
</code>

Sobreescribimos los métodos para indicar qué menú hay que //inflar// y qué hacer para cada una de las opciones de dicho menú

<code java>
. . .
. . .
@Override
public void onCreateContextMenu(ContextMenu menu, View v,
                                ContextMenu.ContextMenuInfo menuInfo) {
  super.onCreateContextMenu(menu, v, menuInfo);
  getMenuInflater().inflate(R.menu.menu_context_listado, menu);
}

@Override
public boolean onContextItemSelected(MenuItem item) {

  AdapterContextMenuInfo info =
        (AdapterContextMenuInfo) item.getMenuInfo();
  final int itemSeleccionado = info.position;

  switch (item.getItemId()) {
    case R.id.action_fijo:
      // hacer algo
      return true;
    case R.id.action_movil:
      // hacer algo
      return true;
    case R.id.action_editar:
      // hacer algo
      return true;
    case R.id.action_eliminar:
      // hacer algo
      return true;
    case R.id.action_email:
      // hacer algo
      return true;
    case R.id.action_detalles:
      // hacer algo
      return true;
    default:
      return super.onContextItemSelected(item);
  }
}
. . .
. . .
</code>

{{ youtube>1JOU7qi3sA0 }}

=== Diálogos ===

Los diálogos son ventanas emergentes que aparecen cuando el usuario debe seleccionar una acción antes de seguir con la ejecución de la aplicación. Se tratan siempre de ventana modales por lo que bloquean el flujo de ejecución de la aplicación hasta que el usuario selecciona qué hacer.

A continuación se muestra una imagen de un diálogo clásico de respuesta Si/No y el código correspondiente para tratar las dos posibles opciones que el usuario puede seleccionar

<figure>
{{ dialog.png }}
<caption>Dialog (Yes/No)</caption></figure>

<code java>
. . .
AlertDialog.Builder builder = new AlertDialog.Builder(this);
builder.setMessage(R.string.lb_esta_seguro)
       .setPositiveButton(R.string.lb_si,
         new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
             // Qué hacer si el usuario pulsa "Si"
           }})
       .setNegativeButton(R.string.lb_no,
         new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
             // Qué hacer si el usuario pulsa "No"
             // En este caso se cierra directamente el diálogo y no se hace nada más
             dialog.dismiss();
           }});
builder.create().show();
. . .
</code>

==== Mensajes emergentes ====

Es posible mostrar pequeños mensajes emergentes de corta duración con la clase ''Toast'' ((https://developer.android.com/reference/android/widget/Toast.html))
El funcionamiento básico de estos mensajes se muestra a continuación, pero se pueden configurar con más detalle en [[https://developer.android.com/guide/topics/ui/notifiers/toasts.html|la guía de Android sobre Toasts]]

<figure>
{{ toast.png }}
<caption>Toast por defecto | Toast personalizado</caption>
</figure>

<code java>
. . .
Toast.makeText(this, R.string.cadena_de_texto, Toast.LENGHT_LONG).show();
. . .
Toast.makeText(this, R.string.cadena_de_texto, Toast.LENGHT_SHORT).show();
. . .
</code> 

==== Notificaciones ====

Las notificaciones son mensaje emergentes que aparecen en la pantalla de notificaciones del móvil. Sirve para mostrar información y también como forma rápida de acceso a la aplicación que emite dicha notificación, pudiendo acceder al contenido directamente.

<figure>
{{ notification.png?400 }}
<caption>Notificaciones</caption>
</figure>

En el siguiente ejemplo de código se puede ver como construir una Notificación con un título, un texto, un icono y una Activiy asociada a la que el usuario accederá si pulsa en la notificación

<code java>
. . .
NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(MainActivity.this)
  .setContentTitle("Titulo de la notificación")
  .setContentText("Esto es el texto de la notificación")
  .setSmallIcon(R.drawable.default_marker)
  .setContentIntent(PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(),
                    new Intent(MainActivity.this, MapActivity.class), 0));

NotificationManager nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
nManager.notify(0, nBuilder.build());
. . .
</code>

((https://developer.android.com/guide/topics/ui/notifiers/notifications.html))
===== Comunicación entre Activities =====

En algunas ocasiones necesitaremos pasar información entre dos //Activities//, por ejemplo, cuando en un ''ListView'' pinchemos sobre algún elemento que queramos ver en el mapa. Este mapa estará en otra ''Activity'' a la que tendremos que pasar la localización (y quizás otra información) del elemento que queremos mostrar. Esa otra ''Activity'' tendrá que recuperar dicha información para pintarla en el mapa.

Asi, para algo parecido al ejemplo anterior, en la ''Activity'' origen, justo cuando creemos el ''Intent'' que permite invocarla, tendremos que incluir además los datos que necesitemos que la otra ''Activity'' reciba:

<code java>
. . .
// Crea el Intent que lanzará la nueva Activity
Intent intentMapa = new Intent(this, ActivityMapa.class);
// Añadimos la información que llegará a la Activity destino
// Si sólo queremos lanzarla podemos omitir estas líneas
intentMapa.putExtra("nombre", nombreLugar);
intentMapa.putExtra("latitud", latitud);
intentMapa.putExtra("longitud", longitud);
// Lanza la nueva Activity
startActivity(intentMapa);
. . .              
</code>

Así, si hemos enviado información desde otra ''Activity'', en el destino la recogeremos también a través del objeto ''Intent'' dentro del método del evento ''onCreate'', que es cuando se crea ésta:

<code java>
public class MapaActivity . . .

public void onCreate(. . .)
. . .
Intent intent = getIntent();
String nombreLugar = intent.getStringExtra("nombre");
// El segundo parámetro permite indicar qué valor se asignará por defecto
float latitud = intent.getFloatExtra("latitud", -1);
float longitud = intent.getFloatExtra("longitud", -1);
/* Ahora ya tenemos toda la información que necesitamos para hacer lo que sea
 * con ella
 */
. . .
</code>

<figure>
{{ intent_activities.png }}
<caption>Comunicar dos activities</caption></figure>

{{ youtube>ASZZ_td4qKE }}
===== Gestión de preferencias =====

Para la gestión de preferencias se debe diseñar un //layout// específico para crear la pantalla desde donde el usuario podrá configurar los diferentes aspectos que se preparen. En el ejemplo siguiente se puede ver una pantalla de preferencias con diferentes elementos para configurar 3 aspectos de una aplicación:

<file xml preferencias.xml>
<PreferenceScreen
  xmlns:android="http://schemas.android.com/apk/res/android">
  <PreferenceCategory android:title="Personal">
    <CheckBoxPreference
      android:key="opcion_ver_favoritos"
      android:title="Sólo favoritos"
      android:summary="Ver sólo a los contactos favoritos" />
    <EditTextPreference
      android:key="opcion_nombre"
      android:title="Tu nombre"
      android:summary="Cómo quieres que tus contactos te vean"
      android:dialogTitle="Introduce un valor" />
  </PreferenceCategory>
  <PreferenceCategory android:title="Agenda">
    <ListPreference
      android:key="opcion_datos"
      android:title="Mostrar Contactos"
      android:summary="Cómo identificar a los contactos"
      android:dialogTitle="Por nombre o apellidos"
      android:entries="@array/datos"
      android:entryValues="@array/datos" />
  </PreferenceCategory>
</PreferenceScreen>
</file>

<figure>
{{ preferences.png?400 }}
<caption>Activity de preferencias</caption></figure>

En el caso de que se usen ''array'' de datos, éstos deben figurar también como ficheros //XML// dentro de la carpeta ''xml''

<file xml datos.xml>
<?xml version="1.0" encoding="utf-8"?>
<resources>
  <string-array name="datos">
    <item>Nombre</item>
    <item>Apellidos</item>
  </string-array>
</resources>
</file>

También existe un tipo de ''Activity'' específica para la gestión de preferencias. Así, utilizando esa Activity podremos cargar el layout de preferencias que hemos preparado anteriormente.

<code java>
public class Preferencias extends PreferenceActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    addPreferencesFromResource(R.layout.preferencias);
  }
}
</code>

Hasta ahí hemos conseguido preparar la ''Activity'' de preferencias desde donde el usuario podrá configurar la aplicación. Todos los cambios que éste realice en esa ''Activity'' se almacenarán de forma automática (no hay que programar nada) como preferencias de la aplicación. Nos corresponde a nosotros programar el qué hacer en función de las preferencias que haya escogido o configurado el usuario. Así, para acceder al estado de las mismas utilizaremos la clase ''SharedPreferences'' que nos permitirá acceder a cada una de las preferencias por su nombre (''android:key'') estableciendo en cada caso un valor por defecto en caso de que el usuario no hubiera establecido ningún valor para la misma

<code java>
. . .
SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(this);
boolean verFavoritos = preferencias.getBoolean("opcion_ver_favoritos", false);
. . .
</code>



===== Acceso a Bases de Datos =====

El acceso a Bases de Datos está integrado con el API de //Android// por lo que resulta muy sencillo. Además, como ya se ha visto en la estructura de este framework, se incluye con el mismo el motor de almacenamiento //SQLite//, que será el que se emplee para almacenar información dentro del dispositivo móvil. Si se quiere almacenar información fuera del teléfono (que tendrá que ser accedida vía Servicio Web, por ejemplo) se podrán utilizar otros motores puesto que son otros equipos quienes tendrán que gestionar el acceso a los datos.

SQLite es un motor extremadamente ligero, muy apto para entornos donde el rendimiento y las prestaciones son limitadas:

  * Apenas una unos pocos MBytes
  * Ideal para pequeñas Bases de Datos (hasta 1GByte aprox.)
  * Perfecto para dispositivos pequeños donde las prestaciones son limitadas
  * No necesita de instalación. En el caso de Android incluso viene ya de serie con el framework por lo que podremos acceder a las Bases de Datos directamente desde la propia API
  * Se puede utilizar ''SQL'' para comunicarse con él o bien la API si no vamos a hacer algo muy complicado

=== Acceso a Bases de Datos ===

En //Android//, para acceder a una Base de Datos, debemos crearnos una clase que herede de la clase auxiliar ''SQLiteOpenHelper'' (incluida en el framework) de forma que tendremos que implementar allí todos los métodos que permitan acceder a los datos para insertar, consultar, eliminar o cualquier otra operación. Además, en esta clase de deben incluir las sentencias que permitan crear o actualizar la Base de Datos de forma que el framework pueda realizar estas operaciones cuando sea necesario.

A continuación se muestra la estructura más básica que deberá tener una clase que acceda a una Base de Datos, que en este caso sólo contiene una tabla llamada //eventos//

Primero, suponemos una clase de ''Constantes'' (creada, por ejemplo, dentro de un paquete ''util'' en el proyecto). Luego podremos usarlas (importándolas estáticamente) para referirnos a los nombres de tablas o campos de la Base de Datos que hayamos creado. Para el campo ''id'' de la tabla usaremos la constante ''_ID'' que ya viene definida con Android en la clase ''android.provider.BaseColumns''.

<code java com.sfaci.aplicacion.util.Constantes>
public class Constantes {
  public static final String BASE_DATOS = "mibasededatos.db";
  public static final String TABLA_EVENTOS = "eventos";
  public static final String NOMBRE = "nombre";
  public static final String DESCRIPCION = "descripcion";
  public static final String DIRECCION = "direccion";
  public static final String PRECIO = "precio";
  public static final String FECHA = "fecha";
  public static final String AFORO = "aforo";
  public static final String IMAGEN = "imagen";
  . . .
}
</code>

Ahora comenzamos con la clase que se encargará de gestionar la Base de Datos:

<code java>
package com.sfaci.aplicacion.db;

import static android.provider.BaseColumns._ID;
import static com.sfaci.aplicacion.util.Constantes.BASE_DATOS;
. . .
. . .

public class Database extends SQLiteOpenHelper {

  private static final int VERSION = 1;

  public Database(Context contexto) {
      super(contexto, BASE_DATOS, null, VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
      db.execSQL("CREATE TABLE " + TABLA_EVENTOS + "(" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
      + NOMBRE + " TEXT, " + DESCRIPCION + " TEXT, " + DIRECCION + " TEXT, "
      + PRECIO + " REAL, " + FECHA + " TEXT, " + AFORO + " INT, " 
      + IMAGEN " BLOB)");
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("DROP TABLE IF EXISTS " + TABLA_EVENTOS);
      onCreate(db);
  }
</code>

  * Las constantes ''BASE_DATOS'' y ''VERSION'' nos indican nombre y version en la que se encuentra la Base de Datos
  * El método ''onCreate'' se ejecutará automáticamente cuando sea necesario crear la Base de Datos por primera vez
  * El método ''onUpgrade'' se ejecutará cuando sea necesario actualizar la Base de Datos, por ejemplo, cuando la aplicación se actualice y haya que modificar la estructura de la misma

A partir de esta estructura, tendremos que añadir, libremente, tantos métodos como formas de acceso a la Base de Datos queramos tener. Para los casos siguientes supondremos que tenemos una clase ''Evento'' con la siguiente estructura:

<code java>
public class Evento {
  private long id;
  private String nombre;
  private String descripcion;
  private String direccion;
  private float precio;
  private Date fecha;
  private int aforo;
  private Bitmap imagen;
}
</code>

=== Registrar datos ===

<code java>
public void nuevoEvento(Evento evento) {

  SQLiteDatabase db = getWritableDatabase();

  ContentValues values = new ContentValues();
  values.put(NOMBRE, evento.getNombre());
  values.put(DESCRIPCION, evento.getDescripcion());
  values.put(DIRECCION, evento.getDireccion());
  values.put(PRECIO, evento.getPrecio());
  values.put(FECHA, Util.formatearFecha(evento.getFecha()));
  values.put(AFORO, evento.getAforo());
  values.put(IMAGEN, Util.getBytes(evento.getImagen()));

  db.insertOrThrow(TABLA_EVENTOS, null, values);
  db.close();

  // Tambien se pueden lanzar sentencia SQL directamente
  // String[] argumentos = new String[]{arg1, arg2, arg3};
  //db.execSQL("INSERT INTO . . . . ? ? ?", argumentos);
}
</code>

Para registrar datos es posible utilizando la clase ''ContentValues'' asignando valores a los diferentes campos de la tabla o bien componer la sentencia ''INSERT INTO'' correspondiente directamente en //SQL// (parte comentada)

=== Borrar datos ===

<code java>
public void eliminarEvento(Evento evento) {

  SQLiteDatabase db = getWritableDatabase();

  String[] argumentos = new String[]{String.valueOf(evento.getId())};
  db.delete(TABLA_EVENTOS, "id = ?", argumentos);
  db.close();

  // Tambien se pueden lanzar sentencia SQL
  // String[] argumentos = new String[]{arg1, arg2, arg3};
  //db.execSQL("DELETE FROM . . . . ? ? ?", argumentos);
}
</code>

De forma similar, para eliminar datos es posible utilizando la clase ''ContentValues'' asignando valores a los diferentes campos de la tabla y más adelante indicar mediante el campo clave ''id'' (u otro) cuál es el evento que se debe eliminar o bien componer la sentencia ''DELETE'' correspondiente directamente en //SQL// (parte comentada)

=== Modificar datos ===

<code java>
public void modificarEvento(Evento evento) {

  SQLiteDatabase db = getWritableDatabase();

  ContentValues values = new ContentValues();
  values.put(NOMBRE, evento.getNombre());
  values.put(DESCRIPCION, evento.getDescripcion());
  values.put(DIRECCION, evento.getDireccion());
  values.put(PRECIO, evento.getPrecio());
  values.put(FECHA, Util.formatearFecha(evento.getFecha()));
  values.put(AFORO, evento.getAforo());
  values.put(IMAGEN, Util.getBytes(evento.getImagen()));

  String[] argumentos = new String[]{String.valueOf(evento.getId())};
  db.update(TABLA_EVENTOS, values, "id = ?", argumentos);
  db.close();

  // Tambien se pueden lanzar sentencia SQL
  // String[] argumentos = new String[]{arg1, arg2, arg3};
  //db.execSQL("UPDATE " + TABLA_EVENTOS + " SET . . . ? ? ?", argumentos);
}
</code>

De forma similar, para modificar datos es posible utilizando la clase ''ContentValues'' asignando valores a los diferentes campos de la tabla y más adelante indicar mediante el campo clave ''id'' (u otro) cuál es el evento que se debe modificar o bien componer la sentencia ''UPDATE'' correspondiente directamente en //SQL// (parte comentada).

=== Consultar datos ===

Para la parte de consulta de datos, tendremos que tener en cuenta que en esta clase no podremos listar los datos puesto que no estamos en ninguna Activity que son las encargadas de presentar la información en pantalla. Así, lo que haremos será extraer los datos de la Base de Datos y devolverlos, de forma que sea la clase que invoque a este método la encargada de listarlos de la forma que convenga en un ''ListView'', ''Spinner'' o cualquier otra ''View''.

<code java>
public ArrayList<Evento> getEventos() {

  final String[] SELECT = {_ID, NOMBRE, DESCRIPCION, DIRECCION, PRECIO,
                          FECHA, AFORO, IMAGEN};
  final String ORDER_BY = "fecha";
  SQLiteDatabase db = getReadableDatabase();
  Cursor cursor = db.query(TABLA_EVENTOS, SELECT, null, null, null, null, 
    ORDER_BY);

  ArrayList<Evento> listaEventos = new ArrayList<Evento>();
  Evento evento = null;
  while (cursor.moveToNext()) {
    evento = new Evento();
    evento.setId(cursor.getLong(0));
    evento.setNombre(cursor.getString(1));
    evento.setDescripcion(cursor.getString(2));
    evento.setDireccion(cursor.getString(3));
    evento.setPrecio(cursor.getFloat(4));
    try {
      evento.setFecha(Util.parsearFecha(cursor.getString(5)));
    } catch (ParseException pe) {
      // Si no se puede leer la fecha se coloca la de hoy por defecto
      evento.setFecha(new Date(System.currentTimeMillis()));
    }
    evento.setAforo(cursor.getInt(6));
    evento.setImagen(Util.getBitmap(cursor.getBlob(7)));

    listaEventos.add(evento);
  }
  cursor.close();
  db.close();

  return listaEventos;

  // Tambien se pueden lanzar sentencia SQL
  // String[] argumentos = new String[]{arg1, arg2, arg3};
  //db.rawQuery("SELECT " + NOMBRE + ", " + DESCRIPCION + " . . . WHERE . . . ? ? ?", argumentos);
}
</code>

==== Almacenar imágenes en Base de Datos ====

Merece especial atención este caso, puesto que almacenar imágenes en una Base de Datos SQLite no es una tarea trivial.
Lo primero será buscar la manera de que el usuario pueda asignar una imagen de su dispositivo móvil a algún objeto de la aplicación. Para eso, podremos disponer de un botón o similar para lanzar la galería/cámara del móvil y que de esa manera dicho usuario pueda incorporar las imágenes a la aplicación.

El siguiente fragmento de código permite cargar la galería del dispositivo de forma que el usuario pueda seleccionar una imagen (o hacer una foto con la cámara). Dicha imagen se asignará a algún elemento de la pantalla para luego poder trabajar con ella para incorporarla a la Base de Datos al dar de alta (por ejemplo) la información. Este código no hará saltar la galería, sino que debe ser lanzado según se indica más adelante.

En este caso, podríamos utilizar una vista ''ImageView'' ((https://developer.android.com/reference/android/widget/ImageView.html)) para mostrar la imagen seleccionada por el usuario. Además, sobre esa vista podemos asignar un ''ClickListener'' para lanzar la galería/cámara cuando el usuario pulse sobre la foto para cambiarla.

<figure>
{{ imageview1.png?300 }}
<caption>Formulario para dar de alta y elegir imagen</caption>
</figure>

<code java>
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

if ((requestCode == RESULTADO_CARGA_IMAGEN) && (resultCode == RESULT_OK) 
   && (data != null)) {
  // Obtiene el Uri de la imagen seleccionada por el usuario
  Uri imagenSeleccionada = data.getData();
  String[] ruta = {MediaStore.Images.Media.DATA };

  // Realiza una consulta a la galería de imágenes solicitando la imagen seleccionada
  Cursor cursor = getContentResolver().query(imagenSeleccionada, ruta, null, null, null);
  cursor.moveToFirst();

  // Obtiene la ruta a la imagen
  int indice = cursor.getColumnIndex(ruta[0]);
  String picturePath = cursor.getString(indice);
  cursor.close();

  // Carga la imagen en una vista ImageView que se encuentra en 
  // en layout de la Activity actual
  ImageView imageView = (ImageView) findViewById(R.id.ivImagen);
  imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
  }
}
. . .
</code>

Ahora, tendremos que asociar el siguiente código a algún botón o elemento con el que usuario tenga que interactuar para hacer saltar la galería según el fragmento de código anterior.

<code java>
. . .
private int RESULTADO_CARGA_IMAGEN = 1;
. . .
// Lanza la galería/cámara de fotos del dispositivo
Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
startActivityForResult(intent, RESULTADO_CARGA_IMAGEN);
. . .
</code>

Y en el Manifest de nuestra aplicación, permiso para acceder al almacenamiento externo del dispositivo

<code xml>
. . .
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />

<application . . .
. . .
. . .
</code>

<figure>
{{ imageview2.png?300 }}
<caption>Galería/Cámara</caption>
</figure>

Suponemos que la clase cuyos objetos queremos almacenar en la Base de Datos, tiene declarado un atributo para almacenar la imagen con la clase ''Bitmap'' ((https://developer.android.com/reference/android/graphics/Bitmap.html))

<code java>
public class Evento {
  . . .
  private Bitmap imagen;
  . . .
}
</code>

Así, para obtener la imagen del ''ImageView'' (es donde la hemos dejado al seleccionarla de la galería en los pasos anteriores) y pasarla a ''Bitmap'', tendremos que hacerlo como a continuación: 

<code java>
Evento evento = new Evento();
. . .
evento.setImagen(((BitmapDrawable) ivImagen.getDrawable()).getBitmap());

Database db = new Database(this);
db.nuevoEvento(evento);
. . .
</code>

Y una vez en la clase donde gestionamos la Base de Datos, tendremos que pasar ese objeto ''Bitmap'' a un //array// de //bytes// para que pueda ser almacenada en la columna que le corresponda (columna que habrá sido definida como de tipo ''BLOB'' ((https://es.wikipedia.org/wiki/Binary_large_object)) en la sentencia ''CREATE TABLE'' correspondiente)

<code java>
public class DataBase extends SQLiteOpenHelper {
  public void nuevoEvento(Evento evento) {
    SQLiteDatabase db = getWritableDatabase();

    ContentValues values = new ContentValues();
    . . .
    values.put(IMAGEN_EVENTO, Util.getBytes(evento.getImagen()));
    . . .
  }
}
</code>

En el caso de que queramos leerla, tendremos que convertir ese //array// de //bytes// de nuevo a un objeto ''Bitmap''

<code java>
public class DataBase extends SQLiteOpenHelper {
  . . .
  public ArrayList<Evento> obtenerEventos() {
    SQLiteDatabase db = getReadableDatabase();
    Cursor cursor = db.query(TABLA_EVENTOS, SELECT_CURSOR, null, null, 
      null, null, ORDER_BY);

    ArrayList<Evento> listaEventos = new ArrayList<Evento>();
    Evento evento = null;
    while (cursor.moveToNext()) {
      evento = new Evento();
      . . .
      evento.setImagen(Util.getBitmap(cursor.getBlob(7)));

      listaEventos.add(evento);
    }
    db.close();

    return listaEventos;
  }
}
. . .
</code>

Y para terminar se muestran los dos métodos implementados para la conversión de una imagen ''Bitmap'' a //array// de //bytes// y al contrario, que podemos tener en una clase ''Util'' para su uso donde convenga

<code java>
public class Util {
. . .
  /**
   * Convierte un Bitmap en un array de bytes
   * @param bitmap
   * @return
   */
   public static byte[] getBytes(Bitmap bitmap) {
     ByteArrayOutputStream bos = new ByteArrayOutputStream();
     bitmap.compress(Bitmap.CompressFormat.PNG, 0, bos);
     return bos.toByteArray();
   }

  /**
   * Convierte un array de bytes en un objeto Bitmap
   * @param bytes
   * @return
   */
   public static Bitmap getBitmap(byte[] bytes) {

     return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
   }
. . .
}
</code>
===== Acceder a la red =====

Uno de los mayores atractivos de los dispositivos móviles es el acceso a Internet para recuperar y tratar información de cualquier tipo. Prácticamente todas las aplicaciones permiten comunicar los dispositivos entre sí o con Internet. Para ello, siempre tendremos que contar con una aplicación servidor que permita la comunicación entre los diferentes dispositivos. Dicho servidor, normalmente, hará disponible la información mediante diferentes mecanismos como //APIs// o bien a través del formato //JSON//, que es un formato de intercambio de información que en los últimos años ha ganado mucha popularidad para la comunicación asíncrona de información, desplazando en cierta manera al formato //XML// que se venía usando ampliamente hasta entonces.

<figure>
{{ json-rest.png }}
<caption>Petición/Respuesta JSON-REST</caption></figure>


==== Formato JSON ====

<code java>
{
  "firstName": "John",
  "lastName": "Smith",
  "isAlive": true,
  "age": 25,
  "address": {
    "streetAddress": "21 2nd Street",
    "city": "New York",
    "state": "NY",
    "postalCode": "10021-3100"
  },
  "phoneNumbers": [
    {
      "type": "home",
      "number": "212 555-1234"
    },
    {
      "type": "office",
      "number": "646 555-4567"
    },
    {
      "type": "mobile",
      "number": "123 456-7890"
    }
  ],
  "children": [],
  "spouse": null
}
</code>
==== Tareas asíncronas: AsyncTask ====

Las tareas asíncronas (''AsynTask'') permiten ejecutar código en segundo plano de forma que mientras se ejecute dicha tarea no se bloquea la GUI para el usuario y éste puede seguir interactuando con ella o simplemente visualizar el avance o progreso de la misma.

El funcionamiento de ''AsyncTask'' es el mismo que el de la clase ''SwingWorker'' que ya traía el API de Java

<code java>
private class TareaDescargaDatos extends AsyncTask<String, Void, Void> {

  /*
   * En este método se debe escribir el código de la tarea que se desea
   * realizar en segundo plano.
   * Hay que tener en cuenta que Android no nos permitirá acceder a 
   * ningún componente de la GUI desde este método
   */
  @Override
  protected Void doInBackground(String... params) {

    return null;
  }

  /*
   * Este método se ejecuta cuando se cancela la tarea
   * Permite interactuar con la GUI
   */
  @Override
  protected void onCancelled() {
    super.onCancelled();
  }
  
  /*
   * Este método se ejecuta a medida que avanza la tarea
   * Permite, por ejemplo, actualizar parte de la GUI para
   * que el usuario pueda ver el avance de la misma
   */
  @Override
  protected void onProgressUpdate(Void... progreso) {
    super.onProgressUpdate(progreso);
  }

  /*
   * Este método se ejecuta automáticamente cuando la tarea
   * termina (cuando termina el método ''doInBackground'')
   * Permite interactuar con la GUI con lo que podemos comunicar
   * al usuario la finalización de la tarea o mensajes de error
   * si proceden
   */ 
  @Override
  protected void onPostExecute(Void resultado) {
    super.onPostExecute(resultado);
  }
}
</code>

==== Acceder a contenido en la red ====

En el caso concreto de que queramos acceder a contenido en la red es muy probable que éste nos venga preparado en formato //JSON// como hemos visto anteriormente. Además, hay que tener en cuenta que //Android// nos obliga a implementar en un //AsyncTask// cualquier fragmento de código que establezca alguna conexión con Internet (de esa manera se realiza en segundo plano y no bloquea el interfaz de usuario). Así, una vez visto la estructura de un fichero //JSON// y la de una tarea asíncrona, nos queda ver como unir ambos conceptos para preparar una //Activity// capaz de conectarse a Internet, acceder a un fichero //JSON// y //parsearlo// para extraer la información que nos interesa y poderla mostrar al usuario de la forma más cómoda posible.

Como ejemplo, vamos a ver la implementación necesaria para crear una //Activity// que se descargue la información sobre los Monumentos de Zaragoza del [[https://www.zaragoza.es/ciudad/risp/buscar_Risp?&content_type=Excel|Catálogo de Datos]] de la página web del Ayuntamiento.

Para ello, en la clase Constantes se ha creado una constante que contiene el valor de la URL que nos devuelve los datos en formato //JSON//

<code java>
public class Constantes {
. . .
  public final static String URL = "http://www.zaragoza.es/georref/json/hilo/verconsulta_Piezas?georss_tag_1=-&georss_materiales=-&georss_tematica=-&georss_barrio=-&georss_epoca=-";
. . .
}
</code>

En el diseño de la //Activity// hemos preparado una ''ListView'' donde se listará el contenido una vez parseado desde la //AsyncTask// (explicado más adelante)). En este caso se omite la implementación del //Adapter// tal y como corresponda en función de la información que se quiera mostrar y cómo se quiera hacer. Contamos con que la clase ''MonumentoAdapter'' contiene dicha implementación

<code java>
@Override
protected void onCreate(Bundle savedInstanceState) {
  listaMonumentos = new ArrayList<Monumento>();
  adapter = new MonumentoAdapter(this, R.layout.monumento_item, listaMonumentos);
  ListView lvMonumentos = (ListView) findViewById(R.id.lvMonumentos);
  lvMonumentos.setAdapter(adapter);
}
</code>

Así, la tarea asíncrona será la encargada de, con la URL que recibirá como parámetro en el momento de su ejecución (más abajo), cargar el //JSON// como una cadena de texto para luego parsearlo y poblar la ''ListView'' a medida que progrese su ejecución

<code java>
private class TareaDescarga extends AsyncTask<String, Void, Void> {

  private boolean error = false;
  private ProgressDialog dialog;

 /**
  * Método que ejecuta la tarea en segundo plano
  * @param params
  * @return
  */
  @Override
  protected Void doInBackground(String... params) {

    String url = params[0];
    InputStream is = null;
    String resultado = null;
    JSONObject json = null;
    JSONArray jsonArray = null;

    try {
      // Conecta con la URL y obtenemos el fichero con los datos
      URL url = new URL(Constantes.URL);
      HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
      // Lee el fichero de datos y genera una cadena de texto como resultado
      BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
      StringBuilder sb = new StringBuilder();
      String linea = null;

      while ((linea = br.readLine()) != null)
        sb.append(linea + "\n");
        
      conexion.disconnect();
      br.close();
      resultado = sb.toString();

      json = new JSONObject(resultado);
      jsonArray = json.getJSONArray("features");

      String titulo = null;
      String link = null;
      String coordenadas = null;
      Monumento monumento = null;
      for (int i = 0; i < jsonArray.length(); i++) {
        titulo = jsonArray.getJSONObject(i).getJSONObject("properties").getString("title");
        link = jsonArray.getJSONObject(i).getJSONObject("properties").getString("link");
        coordenadas = jsonArray.getJSONObject(i).getJSONObject("geometry").getString("coordinates");
        coordenadas = coordenadas.substring(1, coordenadas.length() - 1);
        String latlong[] = coordenadas.split(",");

        monumento = new Monumento();
        monumento.setTitulo(titulo);
        monumento.setLink(link);
        monumento.setLatitud(Float.parseFloat(latlong[0]));
        monumento.setLongitud(Float.parseFloat(latlong[1]));
        listaMonumentos.add(monumento);
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
      error = true;
    } catch (JSONException jse) {
      jse.printStackTrace();
      error = true;
    }

    return null;
  }

 /**
  * Método que se ejecuta si la tarea es cancelada antes de terminar
  */
  @Override
  protected void onCancelled() {
    super.onCancelled();
    adapter.clear();
    listaMonumentos = new ArrayList<Monumento>();
  }

 /**
  * Método que se ejecuta durante el progreso de la tarea
  * @param progreso
  */
  @Override
  protected void onProgressUpdate(Void... progreso) {
    super.onProgressUpdate(progreso);
    adapter.notifyDataSetChanged();
  }

 /**
  * Método ejecutado automáticamente justo antes de lanzar la tarea en segundo plano
  */
  @Override
  protected void onPreExecute() {
    super.onPreExecute();

    dialog = new ProgressDialog(ListadoMonumentos.this);
    dialog.setTitle(R.string.mensaje_cargando);
    dialog.show();
  }

 /**
  * Método ejecutado automáticamente justo después de terminar la parte en segundo plano
  * Es la parte donde podemos interactuar con el UI para notificar lo sucedido al usuario
  * @param resultado
  */
  @Override
  protected void onPostExecute(Void resultado) {
    super.onPostExecute(resultado);

    if (error) {
      Toast.makeText(getApplicationContext(), 
        getResources().getString(R.string.mensaje_error), Toast.LENGTH_SHORT).show();
      return;
    }

    if (dialog != null)
      dialog.dismiss();

      adapter.notifyDataSetChanged();
  }
}
</code>

Y finalmente, se lanza la tarea. En este caso la lanzamos desde el método ''onResume'' de forma que se ejecutará cada vez que la //Activity// vuelva del segundo plano (para asi actualizarla) y también cuando la //Activity// se cargue por primera vez (ver ciclo de vida de una Activity)).

<code java>
private void cargarListaMonumentos() {

  TareaDescarga tarea = new TareaDescarga();
  tarea.execute(Constants.URL);
}

@Override
protected void onResume() {
  super.onResume();

  cargarListaMonumentos();
}
</code>
===== Mapas y ubicaciones =====

==== Utilizar el mapa de Google Maps ====

<figure>
{{ googlemaps.png?300 }}
<caption>Mapa de Google Maps</caption></figure>

Para trabajar con los mapas de //Google Maps// lo primero que necesitamos es definir el layout de la Activity donde mostraremos el mapa. Tendremos que definir, al menos, el fragmento donde se incrustará el mapa tal y como se puede ver a continuación:

<file xml activity_mapa.xml>
<fragment xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/map"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    class="com.google.android.gms.maps.MapFragment"/>
</file>

Más adelante, en la ''Activity'' que esté asociada con el layout que acabamos de crear, tendremos que inicializar el sistema de mapas. También podemos obtener la referencia al componente del mapa para más adelante trabajar con él, aunque no es necesario hacerlo si sólo se quiere mostrar el mapa (aunque no es habitual que sólo queramos hacer eso)

<code java>
public class Mapa extends Activity {

  private GoogleMap mapa;

  private double latitud;
  private double longitud;
  private String nombre;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mapa);

    // Inicializa el sistema de mapas de Google
    try {
      MapsInitializer.initialize(this);
    } catch (Exception e) {
      e.printStackTrace();
    }

    // Obtiene una referencia al objeto que permite "manejar" el mapa
    mapa = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
  }
}
</code>

==== Marcar ubicaciones en el mapa de Google Maps ====

Para los ejemplos de estos apuntes se han utilizado datos geolocalizados del [[http://www.zaragoza.es/ciudad/risp/buscar_Risp|catálogo de datos abiertos del Ayuntamiento de Zaragoza]]. En este catálogo las coordenadas vienen en formato [[https://es.wikipedia.org/wiki/Sistema_de_coordenadas_universal_transversal_de_Mercator|UTM]] y éstas tienen que transformarse al sistema que se usa en Google Maps. Por eso, a través de la librería [[http://www.jstott.com/jcoord/|jcoord]] se transforman de UTM al sistema utilizado en Google Maps con el siguiente método que podemos implementar en nuestra clase ''Utils'' junto al resto de métodos de utilidad que tengamos en nuestro proyecto.

<file java Util.java>
public class Util {

  /**
   * Transforma las coordenadas del sistema UTM que 
   * el ayuntamiento utiliza
   * al sistema LatLng que es con lo que trabaja Google Maps
   * Hay que tener en cuenta que hace falta la librería jcoord 
   * que viene con el proyecto
   * @param este
   * @param oeste
   * @param zonaLat
   * @param zonaLong
   * @return
   */
  public static LatLng DeUMTSaLatLng(double latitud, double longitud) {

    UTMRef utm = new UTMRef(latitud, longitud, 'N', 30);

    return utm.toLatLng();
  }
}
</file>

Así, si queremos marcar ubicaciones en un mapa //Google Maps// podemos enviarle a la ''Activity'' donde se pinta el mapa las coordenadas de una ubicación a través del ''Intent'' ([[http://multimedia.codeandcoke.com/apuntes:android#comunicacion_entre_activities|Comunicación entre Activities]]) y, una vez cargadas, utilizando la propia //API// podemos añadir una marca (''addMarker(MarkerOptions)'') en el mapa.

<code java>
public class Mapa extends Activity {
  private double latitud;
  private double longitud;
  private String nombre; 
  . . .
  @Override
  public void onCreate(Bundle savedInstanceState) {
    . . .
    // Recoge los datos enviados por la Activity que la invoca
    Intent i = getIntent();
    latitud = i.getFloatExtra("latitud", 0);
    longitud = i.getFloatExtra("longitud", 0);
    nombre = i.getStringExtra("nombre");

    // Transforma las coordenadas al sistema LatLng y las almacena
    uk.me.jstott.jcoord.LatLng ubicacion = 
      Util.DeUMTSaLatLng(latitud, longitud);
    latitud = ubicacion.getLat();
    longitud = ubicacion.getLng();
    . . .
  }

  @Override
  public void onResume() {
    super.onResume();

    ubicarRestaurante();
  }

  /**
   * Marca el restaurante elegido en el mapa
   */
  private void ubicarRestaurante() {

    // Obtiene una vista de cámara
    CameraUpdate camara =
      CameraUpdateFactory.newLatLng(new LatLng(latitud, longitud));

    // Coloca la vista del mapa sobre la posición del restaurante
    // y activa el zoom para verlo de cerca
    mapa.moveCamera(camara);
    mapa.animateCamera(CameraUpdateFactory.zoomTo(17.0f));

    // Añade una marca en la posición del restaurante con el nombre de éste
    mapa.addMarker(new MarkerOptions()
      .position(new LatLng(latitud, longitud))
      .title(nombre));
  }
}
</code>

{{ youtube>L5JpDSpxhfE }}
\\
{{ youtube>xHYRgHyWWUw }}

==== Utilizar los mapas con la librería Mapbox ====

<figure>
{{ mapbox.png }}
<caption>Mapa de la librería Mapbox</caption></figure>

Mapbox es [[http://wiki.openstreetmap.org/wiki/Android|uno de tantos SDKs]] que permite trabajar con los mapas de [[http://www.openstreetmap.org|OpenStreetMap]]. Se puede utilizar como alternativa al servicio de mapas de Google Maps.
Lo primero que tenemos que hacer, para poder utilizar la librería //Mapbox// es añadir, al fichero ''build.gradle (Module:app)'' las líneas que se indican a continuación. Así, tras la sincronización de //Gradle// podremos utilizar las clases de dicha librería. 

<code java>
repositories {
  mavenCentral()
}
dependencies {
  . . .
  compile('com.mapbox.mapboxsdk:mapbox-android-sdk:4.1.1@aar') {
    transitive = true
  }
}
</code>

El siguiente paso, en el layout de la Activity donde queramos que aparezca el mapa, tendremos que añadir el código XML que permite insertar el componente donde se dibujará el mapa. En este caso, hemos dejado predefinidas las coordenadas de la ciudad de Zaragoza y un nivel de zoom de 12. En cualquier caso son parámetros que luego desde el código pueden ser modificados e incluso el usuario haciendo uso de la pantalla podrá modificar a su gusto.

<file xml activity_main.xml>
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:tools="http://schemas.android.com/tools"
  android:layout_width="match_parent"
  android:layout_height="match_parent"
  xmlns:mapbox="http://schemas.android.com/apk/res-auto"
  android:paddingBottom="@dimen/activity_vertical_margin"
  android:paddingLeft="@dimen/activity_horizontal_margin"
  android:paddingRight="@dimen/activity_horizontal_margin"
  android:paddingTop="@dimen/activity_vertical_margin"
  tools:context="sfaci.com.ejemplomapbox.MainActivity">

  <com.mapbox.mapboxsdk.maps.MapView
    android:id="@+id/mapaView"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    mapbox:center_latitude="41.656287"
    mapbox:center_longitude="-0.876538"
    mapbox:zoom="12"
    mapbox:style_url="@string/style_mapbox_streets">
  </com.mapbox.mapboxsdk.maps.MapView>
</RelativeLayout>
</file>

En cuanto al código Java, necesitaremos inicializar la librería con la llamada ''MapboxAccountManager.start()'' pasando como parámetro el //token// que nos hayan asignado previa creación de una cuenta de usuario en [[http://www.mapbox.com|la página web de Mapbox]], y más adelante cargar el layout donde se dibujará el mapa.

<file java MainActivity.java>
public class MainActivity extends Activity {

  MapView mapaView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    MapboxAccountManager.start(this, "Pon aqui tu token");
  
    setContentView(R.layout.activity_main);
    mapaView = (MapView) findViewById(R.id.mapaView);
    mapaView.onCreate(savedInstanceState);
  }
}
</file>

Y, por último, antes de poder lanzar la aplicación, tendremos que habilitar una serie de permisos necesarios para poder trabajar con el mapa. Hay que tener en cuenta que los mapas se obtiene en línea desde Internet y que será habitual acceder a la ubicación del dispositivo también.
Además, tenemos que habilitar el servicio de telemetría de la librería //Mapbox//.
Todos estos cambios se deben realizar en el fichero ''AndroidManifest.xml'' de nuestra aplicación.

<code xml>
. . .
<manifest . . .
. . .
  <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
  <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
  <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
  <uses-permission android:name="android.permission.INTERNET" />
  <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
  . . .
  <application . . .
    . . .
    <service android:name="com.mapbox.mapboxsdk.telemetry.TelemetryService" />
    . . .
  </application>
. . .
</manifest>
. . .
</code>

{{ youtube>BkdAksPHiF8 }}

==== Marcar ubicaciones en un mapa Mapbox ====

Antes de marcar las ubicaciones en el mapa utilizando esta librería tendremos que tener en cuenta en que formato se encuentran éstas. Ya he comentado cómo convertirlas en el caso de que se traten de coordenadas extraídas del catálogo de datos abiertos del ayuntamiento de Zaragoza en el apartado de [[http://multimedia.codeandcoke.com/apuntes:android#marcar_ubicaciones_en_el_mapa_de_google_maps|Cómo marcar ubicaciones con Google Maps]]. Las consideraciones sobre la conversión de coordenadas son las mismas aunque el código para marcar la ubicación en el mapa difiere ligeramente y lo pasaré a explicar aqui.

Así, suponiendo que tenemos las coordenadas de un punto en las variables ''latitud'' y ''longitud'', para añadir un //marker// al mapa tendremos que añadir el siguiente fragmento de código. El //marker// se añadirá tan pronto como el mapa esté listo (''onMapReady'')

<code java>
. . .
mapaView.getMapAsync(new OnMapReadyCallback() {
  @Override
  public void onMapReady(MapboxMap mapboxMap) {
    mapboxMap.addMarker(new MarkerOptions()
             .position(new LatLng(latitud, longitud))
             .title(nombre)
             .snippet(descripcion));
  }
});
. . .
</code>

<figure>
{{ marker.png }}
<caption>Marker en un mapa Mapbox</caption></figure>

Y si además queremos posicionarnos directamente en esa posición y, opcionalmente, acercar la cámara, podemos hacerlo como sigue, añadiendo el código dentro del método ''onMapReady'', tal y como hemos hecho para añadir el //marker//

<code java>
. . .
CameraPosition position = new CameraPosition.Builder()
  .target(new LatLng(latitud, longitud)) // Fija la posición
  .zoom(17) // Fija el nivel de zoom
  .tilt(30) // Fija la inclinación de la cámara
  .build();

mapboxMap.animateCamera(CameraUpdateFactory
  .newCameraPosition(position), 7000);
. . .                  
</code>

==== Ubicaciones y GPS con Mapbox ====

En el siguiente ejemplo se muestra como, utilizando el GPS, podemos acceder a la ubicación actual del usuario. En este caso se calcula su ubicación y se moviliza la cámara del mapa para posicionarnos en ella. Hay que tener en cuenta que puesto en los ejemplos anteriores ya hemos añadido los permisos necesarios para trabajar con el GPS no lo tendremos que hacer ahora. En caso de que no se haya hecho habrá que añadir los permisos en el ''AndroidManifest.xml''

<code xml>
. . .
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
. . .
</code>

Lo primero será crear un botón flotante (''FloatingActionButton'') en el layout del mapa de forma que el usuario pueda pulsarlo cuando quiera conocer y acceder a su posición en el mapa

<code xml>
. . .
<android.support.design.widget.FloatingActionButton
  android:id="@+id/btUbicacion"
  android:layout_width="wrap_content"
  android:layout_height="wrap_content"
  android:layout_gravity="end|bottom"
  android:layout_margin="16dp"
  tools:ignore="VectorDrawableCompat"/>
. . .
</code>

A continuación, en la ''Activity'' del mapa tendremos que añadir el código necesario para hacer funcionar el GPS y acceder a la posición del usuario

<code java>
public class MapActivity extends AppCompatActivity {
  private MapView mapaView;
  private MapboxMap mapa;
  private FloatingActionButton btUbicacion;
  private LocationServices servicioUbicacion;
   
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    . . .
    mapaView.getMapAsync(new OnMapReadyCallback() {
      @Override
      public void onMapReady(MapboxMap mapboxMap) {
        mapa = mapboxMap;
        . . .
      }
    });
    
    . . .  
    ubicarUsuario();
  }
   
  // Obtiene y enfoca a la ubicación del usuario
  private void ubicarUsuario() {

    servicioUbicacion = LocationServices.getLocationServices(this);

    btUbicacion = (FloatingActionButton) findViewById(R.id.btUbicacion);
    btUbicacion.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (mapa != null) {
          Location lastLocation = servicioUbicacion.getLastLocation();
          if (lastLocation != null)
            mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lastLocation), 16));

          // Resalta la posición del usuario en el mapa
          mapa.setMyLocationEnabled(true);
        }
      }
    });
  }
}
</code>

<figure>
{{ gps.png?400 }}
<caption>Ubicación del usuario en un mapa Mapbox</caption></figure>

También existe la posibilidad de implementar un ''LocationListener'' de forma que podemos actuar ante cualquier cambio de ubicación. Por ejemplo, podríamos ir almacenando las ubicaciones por las que el usuario pasa de forma que luego pudieramos almacenar la ruta para mostrarla más adelante.

<code java>
. . .
servicioUbicacion.addLocationListener(new LocationListener() {
  @Override
  public void onLocationChanged(Location location) {
    // Qué hacer cuando la ubicación del usuario cambie
    // El parámetro location siempre contiene la nueva ubicación del usuario                 
  }
});
. . .
</code>

==== Cálculo de rutas con Mapbox ====

<figure>
{{ rutas.png?400 }}
<caption>Ruta entre dos puntos en un mapa Mapbox</caption></figure>

Utilizando los servicios de Android de //Mapbox// se pueden calcular las rutas y distancias entre dos puntos dados sobre el mapa, para posteriormente pintarla.

Para ello, lo primero que tenemos que hacer es añadir la correspondiente librería en el ''build.gradle'' de nuestra //app//, tal y como ya hicimos con la API de Android antes de empezar a trabajar con la librería //Mapbox//. En este caso se trata de acceder a la API específica para el cálculo de rutas.

<code java>
. . .
dependencies {
  . . .
  compile ('com.mapbox.mapboxsdk:mapbox-android-services:1.3.1@aar'){
    transitive=true
  }
}
. . .
</code>

Y a continuación, dos métodos, ''obtenerRuta(Location location1, Location location2)'' para hacer el cálculo de la ruta entre dos puntos dados, utilizando como punto de partida dos objetos ''Location'' que identifican la longitud y la latitud de los mismos. Con el primero de los métodos obtendremos el objeto ''ruta'' (de la clase ''DirectionsRoute'') que más adelante utilizaremos como punto de partida para pintar la línea que defina la ruta calculada, con el método ''pintarRuta(DirectionsRoute ruta)'' a partir de los puntos que la forman.

<code java>
. . .
// Calcula la ruta entre el marker y la posición del usuario
private void obtenerRuta(Location markerLocation, Location userLocation) throws ServicesException {

  Position posicionMarker = Position.fromCoordinates(markerLocation.getLongitude(), markerLocation.getLatitude());
  Position posicionUsuario = Position.fromCoordinates(userLocation.getLongitude(), userLocation.getLatitude());

  // Obtiene la dirección entre los dos puntos
  MapboxDirections direccion = new MapboxDirections.Builder()
    .setOrigin(posicionMarker)
    .setDestination(posicionUsuario)
    .setProfile(DirectionsCriteria.PROFILE_CYCLING)
    .setAccessToken(MapboxAccountManager.getInstance().getAccessToken())
    .build();

  direccion.enqueueCall(new Callback<DirectionsResponse>() {
    @Override
    public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {

      ruta = response.body().getRoutes().get(0);
      Toast.makeText(MapActivity.this, "Distancia: " + ruta.getDistance() + " metros", Toast.LENGTH_SHORT).show();

      pintarRuta(ruta);
    }

    @Override
    public void onFailure(Call<DirectionsResponse> call, Throwable throwable) {
      // Qué hacer en caso de que falle el cálculo de la ruta
    }
  });
}

// Pinta la ruta sobre el mapa
private void pintarRuta(DirectionsRoute ruta) {

  // Recoge los puntos de la ruta
  LineString lineString = LineString.fromPolyline(ruta.getGeometry(), Constants.OSRM_PRECISION_V5);
  List<Position> coordenadas = lineString.getCoordinates();
  LatLng[] puntos = new LatLng[coordenadas.size()];
  for (int i = 0; i < coordenadas.size(); i++) {
    puntos[i] = new LatLng(coordenadas.get(i).getLatitude(), coordenadas.get(i).getLongitude());
  }

  // Pinta los puntos en el mapa
  mapa.addPolyline(new PolylineOptions()
    .add(puntos)
    .color(Color.parseColor("#009688"))
    .width(5));

  // Resalta la posición del usuario si no lo estaba ya
  if (!mapa.isMyLocationEnabled())
    mapa.setMyLocationEnabled(true);
}
. . .
</code>
===== Creación de Servicios Web =====

<figure>
{{ spring-logo.png }}
<caption>Framework Spring</caption></figure>

[[http://www.spring.io|Spring]] es un framework de Java para el desarrollo de aplicaciones web. En nuestro caso, lo que queremos construir es una pequeña aplicación web que nos permita disponer de servicios web para comunicar nuestra aplicación móvil hecha en Android con una Base de Datos y que podamos, si asi lo queremos, proporcionar algo de lógica en el lado servidor cuando sea necesario. Para eso utilizaremos //Spring Boot// que es una parte de este framework que facilita bastante el trabajo para casos como el que a nosotros nos interesa.

Para eso, lo primero que haremos será utilizar el [[https://start.spring.io/|Spring Initializr]] para preparar el proyecto inicial sobre el que luego diseñaremos nuestra pequeña aplicación web. Para ello podemos seguir el videotutorial que aparece al final de este apartado.

Una vez tengamos creado el proyecto inicial, podemos empezar a trabajar en él para tener nuestro servidor. En este caso se trata de crear un servidor que tendrá los servicios web necesarios para que los usuarios de una aplicación Android puedan registrar sus opiniones en nuestra Base de Datos. Así, otros usuarios podrán visualizarlas en sus terminales.

==== Configuración del servidor ====

Lo primero de todo será editar el fichero de configuración del proyecto para personalizarlo a nuestro caso:

<file java application.properties>
# Configuración para el acceso a la Base de Datos
spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.hibernate.globally_quoted_identifiers=true
# Puerto donde escucha el servidor una vez se inicie
server.port=${port:8082}

# Datos de conexion con la base de datos MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/opiniones
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driverClassName=com.mysql.jdbc.Driver
</file>

Sobre el fichero ''build.gradle'' tendremos que realizar algunos cambios:

<file java build.gradle>
. . .
apply plugin: 'java'
apply plugin: 'idea'
apply plugin: 'spring-boot'
apply plugin: 'war'

jar {
  baseName = 'eventoserver'
  version = '0.0.1'
}

repositories {
  mavenCentral()
}

dependencies {
  compile('org.springframework.boot:spring-boot-starter-web')
  compile('org.springframework.boot:spring-boot-starter-data-jpa')
  compile('mysql:mysql-connector-java:5.1.16')
  providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
}

configurations {
  providedRuntime
}
</file>

Ahora, modificaremos la clase principal ''Application''. De esta forma podremos iniciar nuestro servidor directamente desde la consola de IntelliJ o bien contenida dentro de un servidor de aplicaciones como //Tomcat//, aunque no lo haremos así en este caso.

Conviene prestar atención a los comentarios que he dejado en esta clase, donde se explica cómo lanzar la aplicación servidor una vez que este lista.

<file java Application.java>
/**
 * Clase que lanza la aplicación
 *
 * Cómo compilar/ejecutar la aplicación:
 *  - Si se hacen cambios en el build.gradle conviene ejecutar (desde la terminal):
 *      - ./gradlew idea
 *      - ./gradlew build
 *  - Una vez compilado se pueden ejecutar por dos vias
 *      - ./gradlew bootRun
 *      - También se puede ejecutar el jar (con java -jar) que se genera en la carpeta 'build/libs' según el fichero 'build.gradle'
 *
 *  El proyecto parte de un proyecto base creado con la herramienta Spring Initializr,
 *  disponible en https://start.spring.io/. Conviene seleccionar ya de inicio las dependencias de Web, JPA y MySQL
 *  De todas formas se pueden añadir luego a gradle y sincronizar el proyecto como se indica más arriba
 *
 * @author Santiago Faci
 * @version curso 2015-2016
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(applicationClass);
  }

  private static Class<Application> applicationClass = Application.class;
}
</file>

==== Definir la Base de Datos ====

Hay que tener en cuenta que //Spring// utiliza por debajo el frame de //Hibernate// para trabajar con la Base de Datos. Eso nos va a permitir trabajar con nuestras clases Java directamente sobre la Base de Datos, ya que será //Hibernate// quién realizará el mapeo entre el objeto Java (y sus atributos) y la tabla de MySQL (y sus columnas) a la hora de realizar consultas, inserciones, modificaciones o borrados.

A continuación se muestra el script ''SQL'' que creará la tabla de la base de datos que usaremos para este ejemplo. Y más adelante la clase Java que se utilizará para hacer el mapeo con dicha tabla.

<file sql opiniones.sql>
CREATE DATABASE IF NOT EXISTS opiniones;
USE opiniones;

CREATE TABLE IF NOT EXISTS opiniones (
  id INT UNSIGNED PRIMARY KEY,
  titulo VARCHAR(50) NOT NULL,
  texto VARCHAR(50),
  fecha DATETIME,
  puntuacion INT UNSIGNED
);
</file>

Así, simplemente tenemos que crear la clase con los atributos y métodos que queramos y añadir las anotaciones que orientarán a //Hibernate// para saber a qué tabla corresponden los objetos de la clase y a qué columnas sus atributos.

<code java>
/**
 * Opinion que los usuarios tienen sobre un monumento
 * Se deben definir las anotaciones que indican la tabla y columnas a las que
 * representa esta clase y sus atributos
 *
 * @author Santiago Faci
 * @version curso 2015-2016
 */
@Entity
@Table(name = "opiniones")
public class Opinion {

  @Id
  @GeneratedValue
  private int id;
  @Column
  private String titulo;
  @Column
  private String texto;
  @Column
  private Date fecha;
  @Column
  private int puntuacion;

  // Constructor
  // Getters y Setters
  . . .
}
</code>

==== El Acceso a la Base de Datos ====

Ahora creamos la ''interface'' donde se definirán los métodos que permitirán acceder a la Base de Datos. En este caso nos basta con definir las cabeceras de los mismos, puesto que se trata de una ''interface''. Será el framework el que se encargue de su implementación. En este caso hemos definido métodos para obtener todas las puntuaciones y otro para obtener las que tengan una puntuación determinada. Además, podremos contar con que tenemos las operaciones que nos permiten registrar/modificar (''save'') y eliminar (''delete'') información de la Base de Datos.

<code java>
/**
 * Clase que hace de interfaz con la Base de Datos
 * Al heredar de CrudRepository se asumen una serie de operaciones
 * para registrar o eliminar contenido (save/delete)
 * Se pueden añadir operaciones ya preparadas como las que hay de ejemplo ya hechas
 *
 * @author Santiago Faci
 * @version curso 2015-2016
 */
public interface OpinionRepository extends CrudRepository<Opinion, Integer> {

  List<Opinion> findAll();
  List<Opinion> findByPuntuacion(int puntuacion);
}
</code>

==== Implementación del Controller ====

Por último, crearemos la clase que hará de ''Controller'' de la aplicación. En ella introduciremos los métodos con las operaciones que queremos que nuestros usuarios puedan realizar, programaremos la lógica que necesitemos y accederemos a los datos a través del ''OpinionRepository'' que hemos creado en el paso anterior.

En este caso hemos creado tres operaciones:

  * getOpiniones(): Devuelve todas las opiniones de la base de datos
  * getOpiniones(int puntuacion): Devuelve las opiniones que tienen una determinada puntuacion
  * addOpinion(String titulo, String texto, int puntuacion): Registra una nueva opinión en la base de datos

Cada una de las operaciones tienen una URL de mapeo que nos permite acceder a las mismas desde cualquier cliente (navegador, aplicación Java, aplicación Android). Por ejemplo, si quisieramos obtener todas las opiniones que tienen una determinada puntuación utilizaríamos la siguiente URL: http://localhost:8082/opiniones_puntuacion?puntuacion=4 (cambiando ''localhost'' por la IP o nombre del servidor que corresponda en cada caso). Más adelante se verá cómo hacerlo desde una aplicación Android pero es posible probar nuestro servidor accediendo a estas URLs directamente desde el navegador, de forma que podamos comprobar que todo funciona correctamente antes de seguir.

  * http://localhost:8082/opiniones_puntuacion
  * http://localhost:8082/opiniones_puntuacion?puntuacion=4
  * http://localhost:8082/add_opinion?titulo=eltitulo&texto=eltexto&puntuacion=10

<code java>
/**
 * Controlador para las opiniones
 * Contendrá todos los métodos que realicen operaciones sobre opiniones de los usuarios
 *
 * @author Santiago Faci
 * @version curso 2015-2016
 */
@RestController
public class OpinionController {

  @Autowired
  private OpinionRepository repository;

  /**
   * Obtiene todas las opiniones de los usuarios
   * @return
   */
  @RequestMapping("/opiniones")
  public List<Opinion> getOpiniones() {

    List<Opinion> listaOpiniones = repository.findAll();
    return listaOpiniones;
  }

  /**
   * Obtiene todas las opiniones con una puntuacion determinada
   * @param puntuacion
   * @return
   */
  @RequestMapping("/opiniones_puntuacion")
  public List<Opinion> getOpiniones(int puntuacion) {

    List<Opinion> listaOpiniones = repository.findByPuntuacion(puntuacion);
    return listaOpiniones;
  }

  /**
   * Registra una nueva opinión en la Base de Datos
   * @param titulo
   * @param texto
   * @param puntuacion
   */
  @RequestMapping("/add_opinion")
  public void addOpinion(@RequestParam(value = "titulo", defaultValue = "nada") String titulo,
                         @RequestParam(value = "texto" , defaultValue = "nada mas") String texto,
                         @RequestParam(value = "puntuacion", defaultValue = "-1") int puntuacion) {

    Opinion opinion = new Opinion();
    opinion.setTitulo(titulo);
    opinion.setTexto(texto);
    opinion.setFecha(new Date(System.currentTimeMillis()));
    opinion.setPuntuacion(puntuacion);

    repository.save(opinion);
  }
}
</code>

==== Ejecución del servidor ====

Una vez terminado todo, para lanzar el servidor tenemos dos opciones:
  * Desde el propio IDE, ejecutando ''./gradlew bootRun'' (o bien ''gradlew bootRun'' si estamos en Windows)
  * Utilizando el jar que podemos generar con el comando ''./gradlew jar build'' (''gradlew jar build'' en Windows) y ejecutarlo con el comando ''java -jar''. El ''.jar'' generado lo podremos encontrar en la carpeta ''build/libs''

==== Lado cliente (Lado Android) ====

Desde el lado cliente (aplicación Android en nuestro caso), podremos acceder a los servicios web mediante la URL que hayamos definido de la siguiente forma, y siempre dentro de una ''AsyncTask'':

  * Para obtener todas las opiniones de la Base de Datos en el servidor:

<code java>
. . .
private List<Opinion> listaOpiniones = new ArrayList<>();
private final String URL_SERVIDOR = "http://192.168.0.5:8082";
. . .
RestTemplate restTemplate = new RestTemplate();
restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
Opinion[] opinionesArray = restTemplate.getForObject(URL_SERVIDOR + "/opiniones", Opinion[].class);
listaOpiniones.addAll(Arrays.asList(opinionesArray));
. . .
</code>

  * O bien para registrar una nueva opinión en el servidor desde nuestro dispositivo móvil:

<code java>
. . .
RestTemplate restTemplate = new RestTemplate();
restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
restTemplate.getForObject(URL_SERVIDOR + "/add_opinion?titulo=" + titulo + "&texto=" + texto + 
  "&puntuacion=" + puntuacion, Void.class);
. . .
</code>

Aunque antes de poder utilizar las llamadas a los métodos que permiten invocar los servicios web de nuestro servidor, tendremos que añadir un par de dependencias a nuestro ''build.gradle (Module: app)''

<code java>
. . .
android {
  . . .
  packagingOptions {
    exclude "META-INF/notice.txt"
    exclude "META-INF/license.txt"
    exclude "META-INF/LICENSE"
    exclude "META-INF/NOTICE"
  }
  . . .
}
. . .
dependencies {
  . . .
  compile 'org.springframework.android:spring-android-rest-template:2.0.0.M3'
  compile 'com.fasterxml.jackson.core:jackson-databind:2.3.2'
  . . .
}
. . .
</code>

{{ youtube>TBIzVT5dHC4 }}
\\

----
===== Ejercicios =====

{{ ejercicio.png?75}}

  - Realiza una aplicación que sirva para que el usuario tenga una lista actualizada de tareas pendientes de ser realizadas. De cada tarea sólo se almacenará un texto que la describa. La tarea se añadirá automáticamente a una lista de tareas pendientes que el usuario visualizará en la misma ''Activity''. Desde esa lista, mediante un menú contextual, el usuario podrá eliminar o bien marcarla como "Hecha", en cuyo caso irá a parar a otra lista de tareas realizadas. El usuario también dispondrá de dos botones que permitirán visualizar las tareas pendientes o las ya realizadas en el ''ListView'' {{ recordatorios.png?250 }}\\ \\
  - Añade soporte para español e inglés a la aplicación anterior\\ \\
  - Realiza una aplicación con 3 opciones (tal y como se muestra en el diseño adjunto). El usuario podrá crear su propio horario introduciendo para cada asignatura los días y horas en las que se imparte, podrá consultar el horario completo para un día dado y también tendrá acceso rápido a consultar qué asignatura se está impartiendo ahora mismo (según hora y fecha del móvil de dicho usuario) {{ mihorario.png?400 }}\\
  - Realiza la siguiente aplicación para mantener un listado de eventos con soporte para español e inglés {{ eventos.png?400 }}
  - Realiza una aplicación que liste todas las farmacias de Zaragoza utilizando para ello los [[http://www.zaragoza.es/georref/json/hilo/farmacias_Equipamiento|datos abiertos que proporciona el Ayuntamiento de Zaragoza]]. En la lista se mostrará un icono (el mismo para todas), el nombre y el teléfono. Cuando el usuario seleccione una de las farmacias la aplicación cargará otra ''Activity'' donde se mostrará un mapa marcando la ubicación de dicha farmacia

----

===== Proyectos de ejemplo =====

Todos los proyectos de ejemplo se pueden encontrar en el [[https://github.com/codeandcoke/android|repositorio android de GitHub]].

Todos los ejercicios que vayamos haciendo en clase se pueden encontrar en el [[https://github.com/codeandcoke/android-ejercicios|repositorio android-ejercicios de GitHub]]

  * [[https://bitbucket.org/sfaci/android/src/1725b260596557393304e23d74994dc93a9f7388/Android_Controles/?at=master|Android_Controles]] Ejemplo de diferentes controles gráficos
  * [[https://bitbucket.org/sfaci/android|Listado completo de proyectos]]
  * [[https://bitbucket.org/sfaci/android/src/1725b260596557393304e23d74994dc93a9f7388/Android_Listas3/?at=master|Android_Listas3]] Ejemplo con Listas
  * [[https://bitbucket.org/sfaci/android/src/1725b260596557393304e23d74994dc93a9f7388/Android_Listas4/?at=master|Android_Listas4]] Ejemplo con Listas
  * [[https://bitbucket.org/sfaci/android/src/1725b260596557393304e23d74994dc93a9f7388/Android_Listas6/?at=master|Android_Listas6]] Ejemplo con Listas
  * [[https://bitbucket.org/sfaci/android/src/1725b260596557393304e23d74994dc93a9f7388/Android_Listas7/?at=master|Android_Listas7]] Ejemplo con Listas
  * [[https://bitbucket.org/sfaci/android/src/1725b260596557393304e23d74994dc93a9f7388/Android_ComunicarActivities/?at=master|Android_ComunicarActivities]] Cómo comunicar dos Activities
  * [[https://bitbucket.org/sfaci/android/src/1725b260596557393304e23d74994dc93a9f7388/Android_Tabs/?at=master|Android_Tabs]] Ejemplo con Tabs
  * [[https://bitbucket.org/sfaci/android/src/1725b260596557393304e23d74994dc93a9f7388/Agendroid_v3/?at=master|Agendroid]] Ejemplo de Agenda de contactos
  * [[https://bitbucket.org/sfaci/android/src/1725b260596557393304e23d74994dc93a9f7388/Android_BBBDD/?at=master|Android_BBDD]] Ejemplo sencillo con Bases de Datos
  * [[https://bitbucket.org/sfaci/android/src/1725b260596557393304e23d74994dc93a9f7388/Android_Mapas/?at=master|Android_Mapas]] Ejemplo de uso de mapas
  * [[https://bitbucket.org/sfaci/android/src/1725b260596557393304e23d74994dc93a9f7388/Android_Mapas2/?at=master|Android_Mapas2]] Ejemplo de uso de mapas
  * [[https://bitbucket.org/sfaci/android/src/1725b260596557393304e23d74994dc93a9f7388/Android_WS_Tarea/?at=master|Android_WS]] Ejemplo de uso de datos en formato JSON
  * [[https://bitbucket.org/sfaci/android/src/1725b260596557393304e23d74994dc93a9f7388/GuiaGasolineras2016/?at=master|GuiaGasolineras2016]] Aplicación guía de gasolineras de Zaragoza
  * [[https://bitbucket.org/sfaci/android/src/1725b260596557393304e23d74994dc93a9f7388/GuiaRestaurantes2016/?at=master|GuiaRestaurantes2016]] Aplicación guía de restaurantes de Zaragoza
  * [[https://bitbucket.org/sfaci/eventosapp|EventosApp]] Aplicación móvil para la gestión de eventos
  * [[https://bitbucket.org/sfaci/eventoserver|EventoServer]] Aplicación servidor para la gestión de eventos

===== Práctica 1.1 =====

=== Objetivos ===

Desarrollar una aplicación para un dispositivo móvil Android.

=== Herramientas Necesarias ===

  * Android Studio
  * IntelliJ IDEA (para la implementación del servidor)
  * Pencil (para el prototipado de las pantallas)

=== Enunciado ===

Debes diseñar e implementar una aplicación para dispositivo móvil Android que cumpla, al menos, con los requisitos que se indican como mínimos. Hay que tener en cuenta que la aplicación se deberá poder lanzar sobre móviles cuyo SDK sea cualquier de la rama 5.X.X (o en adelante) de Android.

El tema de la aplicación debe ser escogido por el alumno, que lo tendrá que notificar al menos con dos semanas de antelación a la entrega de la práctica. En ese momento se debe presentar un documento donde se describa la aplicación a desarrollar, las funcionalidades  de las que dispondrá (cómo máximo) y un prototipo que permita mostrar la apariencia de la misma.

=== Requisitos Mínimos (1 pto cada uno) ===

  * La aplicación contará con, al menos, 4 Activities o Fragments, utilizando controles ''ImageView'', ''TextView'', ''Button'', ''CheckBox'' y ''ListView'' para presentar la información en pantalla y se hará, como mínimo, en dos idiomas.
  * Se deberán usar Bases de Datos para almacenar información. El usuario deberá ser capaz de registrar, modificar y visualizar en un ''ListView'' esa información con un adaptador personalizado y un menú contextual desde donde será posible ejecutar algunas de estas operaciones necesarias (modificar, por ejemplo).
  * La aplicación contará con un menú de opciones o ''ActionBar'' desde donde se podrá acceder a las acciones que el usuario pueda realizar en cada ''Activity''. También dispondrá de un diálogo con la información de ''Acerca de''.
  * Añadir alguna función que interactúe con otras aplicaciones del dispositivo
  * Diseñar para alguna ''Activity'' varios layouts según el tamaño o la posición de la pantalla

=== Otras funcionalidades (1 pto cada una) ===

  * Utilizar en diferentes ''Activity'', Listviews con diferentes adaptadores y Layouts para visualizar otra información
  * Gestionar el proyecto utilizando las herramientas proporcionadas por //GitHub// o //BitBucket//, registrando al menos 10 //issues// reales y su resolución. Añadir también una Wiki con las instrucciones de la aplicación y la puesta en marcha del servidor
  * Usar imágenes como atributos de algún objeto
  * Añadir la opción de eliminar objetos de la lista
  * Utilizar diálogos siempre que sea necesario

=== Observaciones ===

Para la entrega se creará un repositorio con el código del proyecto y una descarga que permita acceder directamente al APK de una versión instalable de la aplicación.

===== Práctica 1.2 =====

=== Objetivos ===

Desarrollar una aplicación para un dispositivo móvil Android.

=== Herramientas Necesarias ===

  * Android Studio
  * IntelliJ IDEA (para la implementación del servidor)
  * Spring Boot
  * Pencil (para el prototipado de las pantallas)

=== Enunciado ===

Sobre la aplicación desarrollada para la práctica 1.1, se deberán añadir nuevas funcionalidades.

=== Requisitos Mínimos (1 pto cada uno) ===

  * Añadir otras 4 Activities a la aplicación
  * Se mostrará información útil para la aplicación en un mapa (con Google Maps o MapBox), de forma que pueda interactuarse con él para llevar alguna acción de utilidad para la aplicación.
  * Utilizar y generar datos en la aplicación disponibles a través de un servidor (implementado con ''Spring'') que ofrecerá un Servicio Web (JSON, XML, . . .).
  * Añadir un menú de preferencias con al menos 3 opciones que modifiquen el comportamiento de la aplicación. Este menú de preferencias estará accesible en todo momento desde el ''ActionBar''.
  * Utilizar el GPS del dispositivo para realizar alguna función sobre el mapa de la aplicación.

=== Otras funcionalidades (1 pto cada una) ===

  * Diseñar algún servicio que interactúe con el usuario mediante notificaciones del sistema.
  * Añadir alguna función que interactúe con otras aplicaciones del dispositivo
  * Presentar la aplicación utilizando pestañas
  * Permitir que en la aplicación puedan interactuar, de alguna manera, diferentes usuarios desde sus propios dispositivos
  * Utilizar en diferentes ''Activity'', Listviews con diferentes adaptadores y Layouts para visualizar otra información
  * Gestionar el proyecto utilizando las herramientas proporcionadas por //GitHub// o //BitBucket//, registrando al menos 10 //issues// reales y su resolución. Añadir también una Wiki con las instrucciones de la aplicación y la puesta en marcha del servidor

=== Observaciones ===

Para la entrega se creará un repositorio con el código del proyecto y una descarga que permita acceder directamente al APK de una versión instalable de la aplicación.

----

(c) 2016-2018 Santiago Faci
