package com.app.ruben.mybiblioteca

import android.net.Uri
import android.os.Bundle
import android.os.StrictMode
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.app.ruben.mybiblioteca.catalogo.CatalogoReciclerView
import com.app.ruben.mybiblioteca.lectores.LectoresReciclerView
import com.app.ruben.mybiblioteca.prestamo.PrestamoReciclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, CatalogoReciclerView.OnFragmentInteractionListener, LectoresReciclerView.OnFragmentInteractionListener, PrestamoReciclerView.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        setSupportActionBar(toolbar)

        /*fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

   /* override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }*/

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            /*R.id.nav_camera -> {
                // Handle the camera action

            }*/
            R.id.nav_gallery -> {
                cargarFragmentCatalogo()
            }
            R.id.nav_lectores -> {
                cargarFragmentLectores()


            }
            R.id.nav_manage -> {
            cargarFragmentPrestamos()

            }
            /*R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }*/
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun cargarFragmentCatalogo() {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_main, CatalogoReciclerView.newInstance("a", "b"), "rageComicList")
            .commit()
    }

    fun cargarFragmentLectores() {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_main, LectoresReciclerView.newInstance("a", "b"), "rageComicList")
            .commit()
    }
    fun cargarFragmentPrestamos() {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_main, PrestamoReciclerView.newInstance("a", "b"), "rageComicList")
            .commit()
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
