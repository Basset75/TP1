package ca.ulaval.ima.tp1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class PageProfil : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_profil)


        val profil = intent.getParcelableExtra<Profil>("url")
        val prenom = profil?.prenom
        val nom = profil?.nom
        val dateDeNaissance = profil?.dateDeNaissance
        val idul = profil?.idul

        val prenomView = findViewById<TextView>(R.id.textViewPrenom)
        val nomView = findViewById<TextView>(R.id.textViewNom)
        val dateDeNaissanceView = findViewById<TextView>(R.id.textViewDateNaissance)
        val idulView = findViewById<TextView>(R.id.textViewIdul)


        val jour = dateDeNaissance?.get(Calendar.DAY_OF_MONTH).toString()
        val mois = dateDeNaissance?.get(Calendar.MONTH).toString()
        val année = dateDeNaissance?.get(Calendar.YEAR).toString()

        prenomView.text = "Prénom: " + prenom
        nomView.text = "Nom: " + nom
        dateDeNaissanceView.text = "Date de Naissance: " + jour + "-" + mois + "-" + année
        idulView.text = "Idul: " + idul




    }
}