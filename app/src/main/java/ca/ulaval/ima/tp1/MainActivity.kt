package ca.ulaval.ima.tp1

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val urlUni = "https://www.google.ca/maps/place/Laval+University/@46.7817499,-71.2773227,16z/data=!3m1!4b1!4m6!3m5!1s0x4cb896c469ff32f9:0x15feb853bd2f8247!8m2!3d46.7817463!4d-71.2747424!16zL20vMDF6aDNf?entry=ttu&g_ep=EgoyMDI1MDIwNC4wIKXMDSoASAFQAw%3D%3D"

        val urlDep = "https://www.fsg.ulaval.ca/departements/departement-de-genie-electrique-et-de-genie-informatique"


        val date = Calendar.getInstance()
        date.set(Calendar.YEAR, 2002)
        date.set(Calendar.MONTH, 6)
        date.set(Calendar.DAY_OF_MONTH, 7)
        val monProfil = Profil(nom = "Lavigne", prenom = "Raphael", dateDeNaissance = date, idul ="RALAV72")

        val boutonMap = findViewById<Button>(R.id.boutonMap)
        boutonMap.setOnClickListener {
            val intent = Intent(this, PageUni:: class.java)
            intent.putExtra("url", urlUni )
            startActivity(intent)
        }

        val boutonDep = findViewById<Button>(R.id.boutonDep)
        boutonDep.setOnClickListener {
            val intent = Intent(this, PageDepart:: class.java)
            intent.putExtra("url", urlDep )
            startActivity(intent)
        }

        val boutonProfil = findViewById<Button>(R.id.boutonProfil)
        boutonProfil.setOnClickListener {
            val intent = Intent(this, PageProfil:: class.java)
            intent.putExtra("url", monProfil )
            startActivity(intent)
        }







    }



}

data class Profil(val nom: String?, val prenom: String?, val dateDeNaissance: Calendar, val idul: String?): Parcelable {

    constructor(parcel: Parcel) : this(
        nom = parcel.readString() ?: "",
        prenom = parcel.readString() ?: "",
        dateDeNaissance = Calendar.getInstance().apply {
            timeInMillis = parcel.readLong()
        },
        idul = parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nom)
        parcel.writeString(prenom)
        parcel.writeLong(dateDeNaissance.timeInMillis)
        parcel.writeString(idul)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Profil> {
        override fun createFromParcel(parcel: Parcel): Profil {
            return Profil(parcel)
        }

        override fun newArray(size: Int): Array<Profil?> {
            return arrayOfNulls(size)
        }
    }
}