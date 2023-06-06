package com.reytian.sebastiancabrera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.reytian.sebastiancabrera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BtnReinitialiser.setOnClickListener {
            binding.Montant.text.clear()
            binding.resultat.text = ""
            binding.textViewList1.text = ""
            binding.textViewList2.text = ""
            binding.textViewList3.text = ""
            binding.textViewList4.text = ""
            binding.checkBox.isChecked = false
        }
    }

    //Conteur de conversion
    var compteur = 1

    fun ActionConvertir(view: View) {
        // Recuperer le montant saisi
        var montant = binding.Montant.text.toString().toDouble()
        // Recuperer le valeur de conversion du spinner De
        var de = binding.spinnerDe.selectedItem.toString()
        // Recuperer le valeur de conversion du spinner A
        var a = binding.spinnerA.selectedItem.toString()

        //Conversion de kilometre vers les autres
        if (de == "Kilomètre")
        {
            when(a)
            {
                "Mile" -> binding.resultat.text = (montant * 0.621371).toString()
                "Yard" -> binding.resultat.text = (montant * 1093.61).toString()
                "Pied" -> binding.resultat.text = (montant * 3280.84).toString()
                "Pouce" -> binding.resultat.text = (montant * 39370.1).toString()
            }
        }
        //Conversion de metre vers les autres
        else if (de == "Mètre")
        {
            when(a)
            {
                "Mile" -> binding.resultat.text = (montant * 0.000621371).toString()
                "Yard" -> binding.resultat.text = (montant * 1.09361).toString()
                "Pied" -> binding.resultat.text = (montant * 3.28084).toString()
                "Pouce" -> binding.resultat.text = (montant * 39.3701).toString()
            }
        }
        //Conversion de centimetre vers les autres
        else if (de == "Centimètre")
        {
            when(a)
            {
                "Mile" -> binding.resultat.text = (montant * 0.0000062137).toString()
                "Yard" -> binding.resultat.text = (montant * 0.0109361).toString()
                "Pied" -> binding.resultat.text = (montant * 0.0328084).toString()
                "Pouce" -> binding.resultat.text = (montant * 0.393701).toString()
            }
        }
        //Conversion de millimetre vers les autres
        else
        {
            when(a)
            {
                "Mile" -> binding.resultat.text = (montant * 0.00000062137).toString()
                "Yard" -> binding.resultat.text = (montant * 0.00109361).toString()
                "Pied" -> binding.resultat.text = (montant * 0.00328084).toString()
                "Pouce" -> binding.resultat.text = (montant * 0.0393701).toString()
            }
        }

        //si le checkbox est coche on ajouter le resultat dans la liste
        if (binding.checkBox.isChecked)
        {
            when(compteur)
            {
                1 -> binding.textViewList1.text = montant.toString() + " " + de + " = " + binding.resultat.text + " " + a
                2 -> binding.textViewList2.text = montant.toString() + " " + de + " = " + binding.resultat.text + " " + a
                3 -> binding.textViewList3.text = montant.toString() + " " + de + " = " + binding.resultat.text + " " + a
                4 -> binding.textViewList4.text = montant.toString() + " " + de + " = " + binding.resultat.text + " " + a
            }

            compteur++

            //si le compteur est plus grand que 4 on le remet a 1
            if(compteur > 4)
                compteur = 1
        }
    }
}