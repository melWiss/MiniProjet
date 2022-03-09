package com.elwiss.miniprojet

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.elwiss.miniprojet.databinding.ActivityMainBinding
import com.elwiss.miniprojet.models.UnsplashPhoto

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var cache:List<UnsplashPhoto> = emptyList()

        //vertical list
        binding.mainRecyclerView.setHasFixedSize(true)
        binding.mainRecyclerView.itemAnimator = null
        binding.mainRecyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        //horizontal list
        binding.listRecyclerView.setHasFixedSize(true)
        binding.listRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)



        val model: HorizontalViewModel =
            ViewModelProviders.of(this).get(HorizontalViewModel::class.java)

        val modelVertical: VerticalViewModel =
            ViewModelProviders.of(this).get(VerticalViewModel::class.java)


        //
        model.getHeroes()?.observe(this,
            { heroList ->
                cache = heroList
                var heroesAdapter =
                    HeroesAdapter(
                        unsplashPhotos = heroList as List<UnsplashPhoto>,
                        this@MainActivity
                    )
                binding.listRecyclerView.adapter = heroesAdapter
                heroesAdapter.itemClickListener = { position, name ->
                    val intent = Intent(this, PictureActivity::class.java).apply {
                        putExtra("Data", name)
                    }
                    startActivity(intent)
                }
            })



        modelVertical.getHeroes()?.observe(this,
            { heroList ->
                var verticalAdapter =
                    VerticalAdapter(
                        unsplashPhotos = heroList as List<UnsplashPhoto>,
                        this@MainActivity
                    )


                binding.mainRecyclerView.adapter = verticalAdapter
                verticalAdapter.itemClickListener = { position, photo, name,smallDesc,longDesc,createAt,updateAt ->
                   /* Toast.makeText(this, "position: $position - name: $name", Toast.LENGTH_SHORT)
                        .show()*/

                    val intent = Intent(this, DetailActivity::class.java).apply {
                        putExtra("Data0", photo,)
                        putExtra("Data1", name,)
                        putExtra("Data2", smallDesc,)
                        putExtra("Data3", longDesc,)
                        putExtra("Data4", createAt,)
                        putExtra("Data5", updateAt,)
                    }
                    startActivity(intent)
                }
            })

        binding.textInputEditText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(count > 0){
                    val banana = cache.filter { unsplashPhoto ->
                        unsplashPhoto.description?.contains(s.toString()) == true
                    }
                    modelVertical.setHeroes(banana)
                    //Log.d("SEARCH",banana.toString())

                }else{
                    modelVertical.setHeroes(cache)
                        //Log.d("SEARCH",cache.toString())
                }
            }

        })
    }

}